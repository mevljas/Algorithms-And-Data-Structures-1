import java.util.Scanner;

public class Naloga2 {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            MyArray array = new MyArray();
            array.setMode(in.next());
            array.setSortMethod(in.next());
            array.setDirection(in.next());
            while (in.hasNext()) {
                array.add(in.nextInt());
            }

            array.sort();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyArray {
    private static int DEFAULT_CAPACITY = 64;
    private static int moves = 0;
    private static int comparisons = 0;
    private static int lineCount = 0;
    private int[] array;
    private int size = 0;
    private int mode;
    private int sortMethod;
    private boolean direction;
    private int lastSwap = size - 1;
    private int last;
    private boolean rekCount = true;


    public MyArray() {
        this.array = new int[DEFAULT_CAPACITY];
    }

    public MyArray(int size) {
        DEFAULT_CAPACITY = size;
        this.array = new int[DEFAULT_CAPACITY];
    }

    static void printMovesComaprisons() {
        if (lineCount++ < 2) {
            System.out.print(moves + " " + comparisons + " | ");
        } else {
            System.out.print(moves + " " + comparisons + " ");
        }
    }

    public void add(int x) {
        if (size == array.length) {
            resize();
        }
        this.array[size++] = x;
    }

    public void set(int i, int x) {
        array[i] = x;
    }

    public int get(int i) {
        return array[i];
    }


    private void resize() {
        int[] array2 = new int[array.length * 2];
        System.arraycopy(array, 0, array2, 0, array.length);
        this.array = array2;
    }


    public void setMode(String mode) {
        if (mode.equals("trace")) {
            this.mode = 0;
        } else if (mode.equals("count")) {
            this.mode = 1;
        }
    }

    public void setMode(int mode) {
        this.mode = mode;
    }


    public void setSortMethod(String sortMethod) {
        switch (sortMethod) {
            case "insert ":
                this.sortMethod = 0;
                break;
            case "select":
                this.sortMethod = 1;
                break;
            case "bubble":
                this.sortMethod = 2;
                break;
            case "heap":
                this.sortMethod = 3;
                break;
            case "merge":
                this.sortMethod = 4;
                break;
            case "quick":
                this.sortMethod = 5;
                break;
            case "radix":
                this.sortMethod = 6;
                break;
            case "bucket":
                this.sortMethod = 7;
                break;
        }

    }

    public void setSortMethod(int sortMethod) {
        this.sortMethod = sortMethod;
    }

    public void setDirection(String direction) {
        if (direction.equals("up")) {
            this.direction = true;
        } else if (direction.equals("down")) {
            this.direction = false;
        }
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public void sort() {
        if (mode == 0) {
            for (int i = 0; i < size - 1; i++) {
                System.out.printf("%s ", array[i]);
            }
            System.out.printf("%s", array[size - 1]);
            System.out.println();
        }
        switch (sortMethod) {
            case 0:
                insertionSort();
                break;
            case 1:
                selectionSort();
                break;
            case 2:
                bubblesort();
                break;
            case 3:
                heapSort();
                break;
            case 4:
                mergeSort();
                if (mode == 1) {
                    printMovesComaprisons();
                }
                break;
            case 5:
                quickSort(0, size - 1);
                if (mode == 0) {
                    printPath();
                } else if (mode == 1) {
                    printMovesComaprisons();
                }
                break;
            case 6:
                radixsort();
                break;
            case 7:
                bucketSort();
                break;
        }
        if (mode == 1 && rekCount) {
            rekCount = false;
            resetMovesComparisions();
            sort();
            direction = !direction;
            resetMovesComparisions();
            sort();
        }
    }

    private void printPath() {
        print();
    }

    private void print() {
        System.out.printf("%s ", array[0]);
        if (0 == lastSwap) {
            System.out.printf("%s ", "|");
        }
        for (int i = 1; i < size - 1; i++) {
            System.out.printf("%s ", array[i]);
            if (i == lastSwap) {
                System.out.printf("%s ", "|");
            }
        }
        System.out.printf("%s", array[size - 1]);
        if (size - 1 == lastSwap) {
            System.out.printf("%s ", " |");
        }
        System.out.println();
    }

    private void resetMovesComparisions() {
        moves = 0;
        comparisons = 0;
    }

    public void insertionSort() {
        lastSwap = size;
        for (int i = 1; i <= size - 1; i++) {
            int k = array[i];
            moves++;
            int j = i;


            while (j > 0) {

                comparisons++;
                if (((direction && array[j - 1] > k) || (!direction && array[j - 1] < k))) {
                    array[j] = array[j - 1];
                    moves++;
                    j--;
                } else {
                    break;
                }

            }
            lastSwap = i;
            array[j] = k;
            moves++;
            if (mode == 0) {
                printPath();
            }


        }
        if (mode == 1) {
            printMovesComaprisons();
        }
    }

    private void swap(int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
        moves += 3;
    }

    private void selectionSort() {
        lastSwap = size - 1;
        for (int i = 0; i <= size - 2; i++) {
            int m = i;
            for (int j = i + 1; j <= size - 1; j++) {
                comparisons++;
                if ((direction && array[j] < array[m]) || (!direction && array[j] > array[m])) {
                    m = j;
                }
                lastSwap = i;
            }
            swap(i, m);
            if (mode == 0) {
                printPath();
            }
        }
        if (mode == 1) {
            printMovesComaprisons();
        }
    }

    private void printBubble() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%s ", array[i]);
            if (i == lastSwap) {
                System.out.printf("%s ", "|");
            }
        }
        System.out.println();
    }

    public void bubblesort() {

        for (int i = 0; i < size - 1; i++) {
            lastSwap = size - 2;
            for (int j = size - 1; j > i; j--) {
                comparisons++;
                if ((direction && array[j] < array[j - 1]) || (!direction && array[j] > array[j - 1])) {
                    swap(j, j - 1);
                    lastSwap = j - 1;
                }

            }
            i = lastSwap;


            if (mode == 0) {
                printBubble();
            }

        }
        if (mode == 1) {
            printMovesComaprisons();
        }


    }

    private void printHeap() {
        print();
    }

    private void heapSort() {
        last = size - 1;
        //zgradi kopico

        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
        lastSwap = size - 1;
        if (mode == 0) {
            printHeap();
        }
        //urejanje
        while (last >= 1) {
            swap(0, last);
            last -= 1;
            siftDown(0);
            lastSwap = last;
            if (mode == 0) {
                printHeap();
            }
        }
        if (mode == 1) {
            printMovesComaprisons();
        }


    }

    private void siftDown(int p) {
        int c = 2 * p + 1;
        while (c <= last) {
            if (c + 1 <= last) {
                comparisons++;
                if ((direction && array[c + 1] > array[c]) ||
                        (!direction && array[c + 1] < array[c])) {
                    c += 1;
                }
            }

            comparisons++;
            if ((direction && array[p] >= array[c]) || (!direction && array[p] <= array[c])) {
                break;
            }
            swap(p, c);
            p = c;
            c = 2 * p + 1;
        }
    }

    private void mergeSort() {
        if (size <= 1) {
            return;
        }
        int m = (size - 1) / 2;
        MyArray left = new MyArray(m + 1);
        for (int i = 0; i <= m; i++) {
            left.add(get(i));
            moves++;
        }
        left.setSortMethod(this.sortMethod);
        left.setMode(this.mode);
        left.setDirection(this.direction);


        MyArray right = new MyArray(size - m - 1);
        for (int i = m + 1; i < size; i++) {
            right.add(get(i));
            moves++;
        }
        right.setSortMethod(this.sortMethod);
        right.setMode(this.mode);
        right.setDirection(this.direction);

        if (mode == 0) {
            left.printMerge();
            System.out.print("| ");
            right.printMerge();
            System.out.println();
        }


        left.mergeSort();
        right.mergeSort();
        merge(left, right, m, size - m - 1);
        if (mode == 0) {
            printPath();
        }
    }

    private void merge(MyArray left, MyArray right, int k, int l) {

        int i = 0, j = 0, t = 0;
        while (i <= k && j < l) {
            comparisons++;
            if ((direction && left.get(i) <= right.get(j)) || (!direction && left.get(i) >= right.get(j))) {
                set(t++, left.get(i++));
            } else {
                set(t++, right.get(j++));
            }
            moves++;

        }
        while (i <= k) {
            set(t++, left.get(i++));
            moves++;
        }
        while (j < l) {
            set(t++, right.get(j++));
            moves++;
        }


    }

    private void printMerge() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private void printQuick(int left, int right, int r) {
        for (int i = left; i <= right; i++) {
            if (i == r) {
                System.out.printf("%s ", "|");
                System.out.printf("%s ", array[i]);
                System.out.printf("%s ", "|");
            } else {
                System.out.printf("%s ", array[i]);
            }

        }
        System.out.println();
    }

    private void quickSort(int left, int right) {
        if (left >= right)
            return;
        int r = partition(left, right);
        if (mode == 0) {
            printQuick(left, right, r);

        }
        quickSort(left, r - 1);
        quickSort(r + 1, right);

    }

    int partition(int left, int right) {
        int p = get(left);
        int l = left, r = right + 1;
        while (true) {
            do {
                l++;
                comparisons++;
            } while ((direction && get(l) < p && l < right) || (!direction && get(l) > p && l < right));
            do {
                r--;
                comparisons++;
            } while ((direction && get(r) > p) || (!direction && get(r) < p));
            if (l >= r) {
                break;
            }
            swap(l, r);
        }
        swap(left, r);
        moves++;
        return r;
    }

    void radixsort() {
        int m = findMax();

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(exp);
            if (mode == 0) {
                printPath();
            }

        }

        if (mode == 1) {
            printMovesComaprisons();
        }
    }

    void countSort(int exp) {
        int[] output = new int[size];
        int i;
        int[] count = new int[10];

        for (i = 0; i < size; i++) {
            if (direction) {
                count[(array[i] / exp) % 10]++;
            } else {
                count[9 - array[i] / exp % 10]++;
            }

            moves++;
            comparisons++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = size - 1; i >= 0; i--) {
            comparisons++;
            if (direction) {
                output[count[(array[i] / exp) % 10] - 1] = array[i];
                count[(array[i] / exp) % 10]--;
            } else {
                output[count[9 - array[i] / exp % 10] - 1] = array[i];
                count[9 - array[i] / exp % 10]--;
            }

        }


        for (i = 0; i < size; i++) {
            array[i] = output[i];
            moves++;
        }

    }

    private int findMax() {
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            m = Math.max(array[i], m);
        }
        return m;
    }

    private int findMin() {
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            m = Math.min(array[i], m);
        }
        return m;
    }

    void printBucket(MyArray[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i].printMerge();
            if (i < buckets.length - 1) {
                System.out.print("| ");
            }
        }
        System.out.println();
    }

    void bucketSort() {
        int k = size / 2;
        MyArray[] buckets = new MyArray[k];


        for (int i = 0; i < k; i++) {
            buckets[i] = new MyArray();

        }

        double max = findMax();
        double min = findMin();
        double v = (max - min + 1) / k;

        for (int i = 0; i < size; i++) {

            int bucketIndex = (int) Math.floor((array[i] - min) / v);
            if (direction) {
                buckets[bucketIndex].add(array[i]);
            } else {
                buckets[(k - 1) - bucketIndex].add(array[i]);
            }
            comparisons++;
            moves++;
            array[i] = 0;

        }
        if (mode == 0) {
            printBucket(buckets);

        }

        for (int i = 0; i < size; i++) {
            array[i] = 0;
        }
        int[] counters = new int[buckets.length];


        int previus = 0;
        for (int i = 0; i < buckets.length; i++) {
            counters[i] += previus;
            for (int j = 0; j < buckets[i].size; j++) {
                counters[i]++;
            }
            previus = counters[i];
        }


        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size; j++) {
                if (i == 0) {
                    array[j] = buckets[i].get(j);
                } else {
                    array[counters[i - 1] + j] = buckets[i].get(j);
                }
                moves++;

            }
        }


        insertionSort();


    }


}

