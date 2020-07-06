public class ArrayHeapPQ<T extends Comparable> implements PriorityQueue<T> {
    private static final int DEFAULT_CAPACITY = 64;
    private T[] array;
    private int size = 0;
    private int moveCounter = 0;
    private int compareCounter = 0;

    public ArrayHeapPQ() {
        this.array = (T[]) (new Comparable[DEFAULT_CAPACITY]);
    }


    @Override
    public T front() {
        System.out.println(array[0]);
        return array[0];
    }

    @Override
    public void enqueue(T x) {
        if (size == array.length) {
            resize();
        }
        array[size++] = x;
        moveCounter++;
        int currentPos = size - 1;
        compareCounter++;
        while (array[currentPos].compareTo(array[parent(currentPos)]) > 0) {
            swap(currentPos, parent(currentPos));
            currentPos = parent(currentPos);
            compareCounter++;
        }
    }


    @Override
    public T dequeue() {
        T popped = array[0];
        array[0] = array[--size];
        moveCounter++;
        moveCounter++;
        maxHeapify(0);
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

    private void resize() {
        T[] array2 = (T[]) (new Comparable[array.length * 2]);
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
            moveCounter++;
        }
        this.array = array2;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    private void swap(int child, int parent) {
        T tmp;
        tmp = array[child];
        array[child] = array[parent];
        array[parent] = tmp;
        moveCounter += 3;

    }

    private void maxHeapify(int position) {
        if (isLeaf(position))
            return;

        compareCounter++;
        if (array[position].compareTo(array[leftChild(position)]) < 0) {

            swap(position, leftChild(position));
            maxHeapify(leftChild(position));
        } else {
            compareCounter++;
            if (array[position].compareTo(array[rightChild(position)]) < 0) {

                swap(position, rightChild(position));
                maxHeapify(rightChild(position));
            }


        }

    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public int getCompareCounter() {
        return compareCounter;
    }
}
