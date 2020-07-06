public class Izziv2 {


    static int[] generateTable(int n) {
        int tab[] = new int[n];
        for (int i = 0; i < n; i++) {
            tab[i] = i + 1;
        }
        return tab;
    }


    static int findLinear(int[] a, int v) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == v) {
                return i;
            }
        }
        return -1;
    }

    public static int findBinary(int[] a, int l, int r, int v) {
        if (l > r) {
            return -1;
        } else {
            int m = (l + r) / 2;
            if (v < a[m]) {
                return findBinary(a, 0, m, v);
            } else if (v > a[m]) {
                return findBinary(a, m, r, v);
            }
            return m;
        }


    }

    static long timeLinear(int n) {
        int[] tab = generateTable(n);
        long startTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            int v = (int) (Math.random() * (n - 1)) + 1;
            findLinear(tab, v);
        }
        long executionTime = System.nanoTime() - startTime;
        return executionTime / 1000;
    }

    static long timeBinary(int n) {
        int[] tab = generateTable(n);
        long startTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            int v = (int) (Math.random() * (n - 1)) + 1;
            findBinary(tab, 0, tab.length - 1, v);
        }
        long executionTime = System.nanoTime() - startTime;
        return executionTime / 1000;
    }


    public static void main(String[] args) {
        System.out.println("   n       |    linearno  |   dvojisko  |");
        System.out.println("-----------+--------------+--------------");
        for (int n = 100000; n <= 1000000; n += 10000) {
            System.out.printf("%10d", n);
            System.out.print(" | ");
            System.out.printf("%12d", timeLinear(n));
            System.out.print(" | ");
            System.out.printf("%12d\n", timeBinary(n));
        }

    }


}
