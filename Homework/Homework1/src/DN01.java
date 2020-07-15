import java.util.Scanner;

interface Sequence<T> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";

    T get(int i) throws CollectionException;

    void add(T x) throws CollectionException;
}


interface Collection {
    static final String ERR_MSG_EMPTY = "Collection is empty.";
    static final String ERR_MSG_FULL = "Collection is full.";

    boolean isEmpty();

    boolean isFull();

    int size();

    String toString();
}


interface Stack<T> extends Collection {
    T top() throws CollectionException;

    void push(T x) throws CollectionException;

    T pop() throws CollectionException;

    void echo() throws CollectionException;

    void dup() throws CollectionException;

    void dup2() throws CollectionException;

    void swap() throws CollectionException;

    void print() throws CollectionException;


}

class CollectionException extends Exception {

    CollectionException(String msg) {
        super(msg);
    }
}

@SuppressWarnings("unchecked")
class ArrayDeque<T> implements Stack<T>, Sequence<T> {
    private static final int DEFAULT_CAPACITY = 64;
    private T[] a;
    private int front, back, size;


    ArrayDeque() {

        a = (T[]) (new Object[DEFAULT_CAPACITY]);
        front = 0;
        back = 0;
        size = 0;

    }


    @Override
    public T get(int i) throws CollectionException {
        if (i < 0 || i >= size) {
            throw new CollectionException(ERR_MSG_INDEX);
        }


        return a[index(i)];

    }

    @Override
    public void add(T x) throws CollectionException {
        push(x);
    }

    @Override
    public T top() throws CollectionException {
        if (isEmpty()) {
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        return a[back];

    }

    @Override
    public void push(T x) throws CollectionException {
        if (isFull()) {
            throw new CollectionException(ERR_MSG_FULL);
        }
        if (!isEmpty())
            back = next(back);
        else
            back = 0;
        a[back] = x;
        size++;

    }

    @Override
    public T pop() throws CollectionException {
        if (isEmpty()) {
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        T o = a[back];
        a[back] = null;
        back = prev(back);
        size--;
        return o;


    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == DEFAULT_CAPACITY;
    }

    @Override
    public int size() {
        return size;
    }

    private int next(int i) {

        return (i + 1) % DEFAULT_CAPACITY;

    }

    private int prev(int i) {
        return (DEFAULT_CAPACITY + i - 1) % DEFAULT_CAPACITY;

    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size > 0)
            sb.append(a[front].toString());
        for (int i = 0; i < size - 1; i++) {
            sb.append(", ").append(a[next(front + i)]);

        }
        sb.append("]");
        return sb.toString();
    }

    public void print() {

        if (size > 0)
            System.out.print(a[front].toString());
        for (int i = 0; i < size - 1; i++) {
            System.out.print(" " + a[next(front + i)]);

        }
        System.out.println();
    }

    private int index(int i) {

        return (front + i) % DEFAULT_CAPACITY;

    }

    public void echo() throws CollectionException {
        if (isEmpty()) {
            System.out.println();
        } else {
            System.out.println(top());
        }

    }

    public void dup() throws CollectionException {
        push(top());
    }

    public void dup2() throws CollectionException {
        push(a[prev(back)]);
        push(a[prev(back)]);
    }

    public void swap() throws CollectionException {
        T prvi = pop();
        T drugi = pop();
        push(prvi);
        push(drugi);
    }


}


public class DN01 {


    private static boolean condition = false;

    private static Sequence<Stack<String>> seqOfStacks;

    private static Stack<String> stackZero;

    private static boolean writeOnStack = false;

    private static int numberOfStack = 0;
    private static int numberofWritten = 0;
    private static int whichStack = 0;


    private static void run(int number) throws CollectionException {
        Stack<String> chosenStack = seqOfStacks.get(number);

        String[] array = new String[chosenStack.size()];
        int counter = 0;
        while (!chosenStack.isEmpty()) {
            array[counter++] = chosenStack.pop();
        }

        for (int i = array.length - 1; i >= 0; i--) {
            chosenStack.push(array[i]);
            command(array[i]);
        }

    }


    private static void command(String command) throws CollectionException {

        int number;
        int temp;
        int temp2;
        String temp3;


        if (!(command.contains("?") && !condition)) {
            command = command.replace("?", "");
            switch (command) {
                case "echo":
                    stackZero.echo();
                    break;
                case "pop":
                    stackZero.pop();
                    break;
                case "dup":
                    stackZero.dup();
                    break;
                case "dup2":
                    stackZero.dup2();
                    break;
                case "swap":
                    stackZero.swap();
                    break;
                case "char":
                    stackZero.push((char) Integer.parseInt(stackZero.pop()) + "");
                    break;
                case "even":
                    if (Integer.parseInt(stackZero.pop()) % 2 == 0) {
                        stackZero.push("1");
                    } else {
                        stackZero.push("0");
                    }
                    break;
                case "odd":
                    if (Integer.parseInt(stackZero.pop()) % 2 != 0) {
                        stackZero.push("1");
                    } else {
                        stackZero.push("0");
                    }
                    break;
                case "!":
                    int n = Integer.parseInt(stackZero.pop());
                    int result = 1;

                    for (int i = 1; i <= n; i++) {
                        result = result * i;
                    }
                    stackZero.push(result + "");
                    break;
                case "len":
                    stackZero.push(stackZero.pop().length() + "");
                    break;
                case "<>":
                    if (Integer.parseInt(stackZero.pop()) != Integer.parseInt(stackZero.pop())) {
                        stackZero.push(1 + "");
                    } else {
                        stackZero.push(0 + "");
                    }
                    break;
                case "<":
                    temp = Integer.parseInt(stackZero.pop());
                    if (Integer.parseInt(stackZero.pop()) < temp) {
                        stackZero.push(1 + "");
                    } else {
                        stackZero.push(0 + "");
                    }
                    break;
                case "<=":
                    temp = Integer.parseInt(stackZero.pop());
                    if (Integer.parseInt(stackZero.pop()) <= temp) {
                        stackZero.push(1 + "");
                    } else {
                        stackZero.push(0 + "");
                    }
                    break;
                case "==":
                    if (Integer.parseInt(stackZero.pop()) == Integer.parseInt(stackZero.pop())) {
                        stackZero.push(1 + "");
                    } else {
                        stackZero.push(0 + "");
                    }
                    break;
                case ">":
                    temp = Integer.parseInt(stackZero.pop());
                    if (Integer.parseInt(stackZero.pop()) > temp) {
                        stackZero.push(1 + "");
                    } else {
                        stackZero.push(0 + "");
                    }
                    break;
                case ">=":
                    temp = Integer.parseInt(stackZero.pop());
                    if (Integer.parseInt(stackZero.pop()) >= temp) {
                        stackZero.push(1 + "");
                    } else {
                        stackZero.push(0 + "");
                    }
                    break;
                case "+":
                    stackZero.push(Integer.parseInt(stackZero.pop()) + Integer.parseInt(stackZero.pop()) + "");
                    break;
                case "-":
                    temp = Integer.parseInt(stackZero.pop());
                    stackZero.push(Integer.parseInt(stackZero.pop()) - temp + "");
                    break;
                case "*":
                    stackZero.push(Integer.parseInt(stackZero.pop()) * Integer.parseInt(stackZero.pop()) + "");
                    break;
                case "/":
                    temp = Integer.parseInt(stackZero.pop());
                    temp2 = Integer.parseInt(stackZero.pop());
                    if (temp == 0 || temp2 == 0) {
                        stackZero.push(0 + "");
                        break;
                    }
                    stackZero.push(temp2 / temp + "");
                    break;
                case "%":
                    temp = Integer.parseInt(stackZero.pop());
                    stackZero.push(Integer.parseInt(stackZero.pop()) % temp + "");
                    break;
                case ".":
                    temp3 = stackZero.pop();
                    stackZero.push(stackZero.pop() + temp3);
                    break;
                case "rnd":
                    int max = Integer.parseInt(stackZero.pop());
                    int min = Integer.parseInt(stackZero.pop());
                    stackZero.push((int) (Math.random() * ((max - min) + 1)) + min + "");
                    break;
                case "then":
                    condition = Integer.parseInt(stackZero.pop()) != 0;
                    break;
                case "else":
                    condition = !condition;
                    break;

                case "print":
                    seqOfStacks.get(Integer.parseInt(stackZero.pop())).print();
                    break;

                case "clear":
                    number = Integer.parseInt(stackZero.pop());
                    while (!seqOfStacks.get(number).isEmpty()) {
                        seqOfStacks.get(number).pop();
                    }
                    break;
                case "run":
                    run(Integer.parseInt(stackZero.pop()));
                    break;

                case "loop":
                    number = Integer.parseInt(stackZero.pop());
                    int numberOfTimes = Integer.parseInt(stackZero.pop());

                    for (int j = 1; j <= numberOfTimes; j++) {
                        run(number);
                    }
                    break;

                case "fun":
                    whichStack = Integer.parseInt(stackZero.pop());
                    numberOfStack = Integer.parseInt(stackZero.pop());
                    numberofWritten = 0;
                    writeOnStack = true;
                    break;

                case "move":
                    number = Integer.parseInt(stackZero.pop());
                    int times = Integer.parseInt(stackZero.pop());

                    for (int i = 1; i <= times; i++) {
                        seqOfStacks.get(number).push(stackZero.pop());
                    }
                    break;

                case "reverse":
                    number = Integer.parseInt(stackZero.pop());
                    Stack<String> stack = seqOfStacks.get(number);

                    String[] array = new String[stack.size()];
                    int counter = 0;
                    while (!stack.isEmpty()) {
                        array[counter++] = stack.pop();
                    }

                    for (int i = 0; i < counter; i++) {
                        stack.push(array[i]);
                    }
                    break;

                default:
                    stackZero.push(command);
            }
        }
    }


    public static void main(String[] args) {
        try {

            Scanner sc1, sc2;
            String line, command;
            sc1 = new Scanner(System.in);
            while (sc1.hasNextLine()) {

                seqOfStacks = new ArrayDeque<>();
                for (int i = 0; i < 42; i++) {
                    seqOfStacks.add(new ArrayDeque<>());
                }
                stackZero = seqOfStacks.get(0);

                condition = false;

                line = sc1.nextLine();
                sc2 = new Scanner(line);
                while (sc2.hasNext()) {
                    command = sc2.next();
                    if (command.equals(""))
                        continue;
                    if (writeOnStack) {
                        if (numberofWritten != numberOfStack) {
                            seqOfStacks.get(whichStack).push(command);
                            numberofWritten++;
                        } else {
                            writeOnStack = false;
                            command(command);
                        }
                    } else {
                        command(command);
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }
}
