public class LinkedHeapPQ<T extends Comparable> implements PriorityQueue<T> {
    private Node first;
    private int size = 0;
    private int moveCounter = 0;
    private int compareCounter = 0;

    public LinkedHeapPQ() {
    }


    @Override
    public T front() {
        System.out.println(first.item);
        return (T) first.item;
    }

    @Override
    public void enqueue(T x) {
        if (first == null) {
            this.first = new Node();
            first.item = x;
            moveCounter++;
        } else {
            Node newNode = getBinaryPosition( size + 1);
            newNode.item = x;
            moveCounter++;

            if (newNode.parent != null) {
                compareCounter++;
                while (newNode.item.compareTo(newNode.parent.item) > 0) {
                    swap(newNode, newNode.parent);
                    newNode = newNode.parent;
                    if (newNode.parent == null)
                        break;
                    compareCounter++;
                }
            }

        }
        size++;
    }


    @Override
    public T dequeue() throws CollectionException {
        Node lastNode = getBinaryPosition( size);
        T popped = (T) first.item;
        moveCounter++;
        first.item = lastNode.item;
        moveCounter++;
        size--;
        maxHeapify(first);
        return popped;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }



    private boolean isLeaf(Node element) {
        return (element.right == null && element.left == null);
    }

    private void swap(Node first, Node second) {
        T tmp;
        tmp = (T) first.item;
        first.item = second.item;
        second.item = tmp;
        moveCounter += 3;
    }

    private void maxHeapify(Node node) {
        if (isLeaf(node))
            return;


        if (node.left != null) {

            compareCounter++;

            if (node.item.compareTo(node.left.item) < 0) {

                swap(node, node.left);
                maxHeapify(node.left);
            }
        } else if (node.right != null) {

            compareCounter++;

            if (node.item.compareTo(node.right.item) < 0) {

                swap(node, node.right);
                maxHeapify(node.right);
            }
        }

    }


    public int getMoveCounter() {
        return moveCounter;
    }

    public int getCompareCounter() {
        return compareCounter;
    }

    Node getBinaryPosition(int size){
        String bin = Integer.toBinaryString(size);
        bin = bin.substring(1);
        Node newNode = first;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '0') {
                if (newNode.left == null) {
                    newNode.left = new Node();
                    newNode.left.parent = newNode;
                }
                newNode = newNode.left;
            } else if (bin.charAt(i) == '1') {
                if (newNode.right == null) {
                    newNode.right = new Node();
                    newNode.right.parent = newNode;
                }
                newNode = newNode.right;
            }
        }
        return newNode;
    }
}
