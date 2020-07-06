public class LinkedSequence<T extends Comparable> implements ComparableSequence<T> {
    private Node first, last;
    private int size = 0;


    @Override
    public T get(int i) throws CollectionException {
        if (i >= size)
            throw new CollectionException("Napacen index");
        Node n = first;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        return n.value;
    }

    @Override
    public T set(int i, T x) throws CollectionException {
        if (i >= size)
            throw new CollectionException("Napacen index");
        Node n = first;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        n.value = x;
        Oseba.incrementPremiki();
        return x;
    }

    @Override
    public void insert(int i, T x) throws CollectionException {
        if (i > size)
            throw new CollectionException("Napacen index");

        if (i == 0 && size == 0) {
            Node node = new Node(x, null, null);
            first = node;
            last = node;
        } else {
            if (i == 0) {
                Node temp = first;
                first = new Node(x, null, temp);
            } else if (i == size) {
                last.next = new Node(x, last, null);
                last = last.next;
            } else {
                Node n = first;
                for (int j = 0; j < i - 1; j++) {
                    n = n.next;
                }
                n.next = new Node(x, n, null);
                if (i == size) {
                    last = n.next;
                }

            }


        }
        size++;
    }

    @Override
    public T delete(int i) throws CollectionException {
        if (i > size)
            throw new CollectionException("Napacen index");
        T temp;

        if (i == 0) {
            temp = first.value;
            first = first.next;
        } else if (i == size - 1) {
            temp = last.value;
            last.prev.next = null;
        } else {
            Node n = first;
            for (int j = 0; j < i - 1; j++) {
                n = n.next;
            }

            temp = n.next.value;
            n.next = n.next.next;
            n.next.prev = n;
        }
        size--;
        return temp;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int count() {
        return size;
    }

    class Node {
        T value;
        Node next, prev;

        Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }


}
