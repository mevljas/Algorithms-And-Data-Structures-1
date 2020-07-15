class ArrayDeque<T> implements Deque<T>, Stack<T>, Sequence<T> {
    private static final int DEFAULT_CAPACITY = 64;
    private T[] a;
    private int front, back, size;


    public ArrayDeque() {

        a = (T[]) (new Object[DEFAULT_CAPACITY]);
        front = 0;
        back = 0;
        size = 0;

    }


    @Override
    public T front() throws CollectionException {
        if (isEmpty()) {
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        return a[front];
    }

    @Override
    public T back() throws CollectionException {
        return top();
    }

    @Override
    public void enqueue(T x) throws CollectionException {
        push(x);
    }

    @Override
    public void enqueueFront(T x) throws CollectionException {
        if (!isEmpty())
            front = prev(front);
        a[front] = x;
        size++;
    }

    @Override
    public T dequeue() throws CollectionException {
        T x = a[front];
        a[front] = null;
        front = next(front);
        size--;
        return x;
    }

    @Override
    public T dequeueBack() throws CollectionException {
        return pop();
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

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        if (size > 0)
            sb.append(a[front].toString());
        for (int i = 0; i < size - 1; i++) {
            sb.append(", " + a[next(front + i)]);

        }
        sb.append("]");
        return sb.toString();
    }

    private int index(int i) {

        return (front + i) % DEFAULT_CAPACITY;

    }


}