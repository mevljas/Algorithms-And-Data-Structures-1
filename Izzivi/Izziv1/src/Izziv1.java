public class Izziv1 {
    public static void main(String[] args) {
        try {
            Stack<String> s = new ArrayDeque<>();
            Deque<String> d = new ArrayDeque<>();
            Sequence<String> z = new ArrayDeque<>();
            s.push("ABC");
            s.push("DEF");
            s.push("GHI");
            System.out.print("Stack: ");
            while (!s.isEmpty()) {
                System.out.print(s.top() + " ");
                d.enqueueFront(s.pop());
            }
            System.out.print("\ncDeque: ");
            while (!d.isEmpty()) {
                System.out.print(d.back() + " ");
                z.add(d.dequeueBack());
            }
            System.out.print("\nSequence: ");
            for (int i = 0; i < z.size(); i++) {
                System.out.print((i + 1) + "." + z.get(i) + " ");
            }


            System.out.println("");
            System.out.println("");

            s = new ArrayDeque<>();
            System.out.println("Stack: ");
            System.out.println("Empty: " + s.isEmpty());
            s.push("1");
            s.push("2");
            s.push("3");
            System.out.println("Empty: " + s.isEmpty());
            System.out.println(s);
            System.out.println("Top: " + s.top());
            s.pop();
            System.out.println(s);

            System.out.println();

            d = new ArrayDeque<>();
            System.out.println("cDeque: ");
            System.out.println("Empty: " + d.isEmpty());
            d.enqueue("1");
            d.enqueue("2");
            d.enqueueFront("3");
            System.out.println(d);
            System.out.println("Empty: " + d.isEmpty());
            System.out.println("Front: " + d.front());
            System.out.println("Back: " + d.back());
            System.out.println("DequeueBack: " + d.dequeueBack());
            System.out.println("Dequeue: " + d.dequeue());
            System.out.println(d);

            System.out.println();

            z = new ArrayDeque<>();
            System.out.println("cDeque: ");
            System.out.println("Empty: " + z.isEmpty());
            z.add("1");
            z.add("2");
            z.add("3");
            System.out.println(z);
            System.out.println("Empty: " + z.isEmpty());
            System.out.println("Get: " + z.get(1));
            System.out.println(z);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
