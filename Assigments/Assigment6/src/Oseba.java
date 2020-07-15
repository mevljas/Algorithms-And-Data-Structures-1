public class Oseba implements Comparable<Oseba> {
    private final static String[] IMENA = {"Ana", "Bor", "Cvetka", "Dusan", "Miha", "Janez",
            "Tilen", "Igor", "Matic", "Lojze", "Matjaz", "Primoz", "Sandi", "Gregor", "Matija", "Benjamin"};
    private final static String[] PRIIMKI = {"Arh", "Buh", "Cah", "Duh", "Novak", "Rojc", "Zver", "Volk", "Kovac",
            "Peternelj", "Skok", "Novak", "Kovaceviv", "Lozej", "Tavcar", "Prelec"};
    private static int atr = 0;
    private static int smer = 1;
    private static int primerjave = 0;
    private static int premiki = 0;
    private String ime, priimek;
    private int letoR;


    Oseba() {
        this.ime = IMENA[(int) (Math.random() * (IMENA.length))];
        this.priimek = PRIIMKI[(int) (Math.random() * (PRIIMKI.length))];
        this.letoR = (int) (Math.random() * ((2019 - 1910) + 1)) + 1910;
    }

    Oseba(String ime, String priimek, int letoR) {
        this.ime = ime;
        this.priimek = priimek;
        this.letoR = letoR;
    }


    public static int getAtr() {
        return atr;
    }

    public static void setAtr(int atr) {
        Oseba.atr = atr;
    }

    public static int getSmer() {
        return smer;
    }

    public static void setSmer(int smer) {
        Oseba.smer = smer;
    }

    public static void quickSort(LinkedSequence<Oseba> a, int left, int right, int v) throws CollectionException {
        if (left >= right)
            return;
        if (right - left < v) {
            inesrtionSort(a, left, right);
            return;
        }
        int r = partition(a, left, right);
        quickSort(a, left, r - 1, v);
        quickSort(a, r + 1, right, v);

    }

    static int partition(LinkedSequence<Oseba> a, int left, int right) throws CollectionException {
        Oseba p = a.get(left);
        int l = left, r = right + 1;
        while (true) {
            do {
                l++;
            } while (a.get(l).compareTo(p) * smer < 0 && l < right);
            do {
                r--;
            } while (a.get(r).compareTo(p) * smer > 0);
            if (l >= r) {
                break;
            }
            swap(a, l, r);
        }
        swap(a, left, r);
        return r;
    }

    static void swap(LinkedSequence<Oseba> a, int l, int r) throws CollectionException {
        Oseba temp = a.get(l);
        a.set(l, a.get(r));
        a.set(r, temp);
    }

    static void inesrtionSort(LinkedSequence<Oseba> a, int left, int right) throws CollectionException {
        for (int i = left + 1; i <= right; i++) {
            Oseba k = a.get(i);
            int j = i;
            while (j > left && a.get(j - 1).compareTo(k) * smer > 0) {
                a.set(j, a.get(j - 1));
                j--;
            }
            a.set(j, k);
        }
    }

    public static int getPrimerjave() {
        return primerjave;
    }

    public static int getPremiki() {
        return premiki;
    }
    public static void incrementPremiki() {
        premiki++;
    }

    public static void resetrirajPremikeInPrimerjave() {
        premiki = 0;
        primerjave = 0;
    }

    @Override
    public String toString() {
        switch (atr) {
            case 0:
                return this.ime;
            case 1:
                return this.priimek;
            case 2:
                return Integer.toString(this.letoR);
            default:
                return this.priimek;
        }

    }

    @Override
    public int compareTo(Oseba o) {
        primerjave++;
        switch (atr) {
            case 0:
                return this.ime.compareTo(o.ime);
            case 1:
                return this.priimek.compareTo(o.priimek);
            case 2:
                Integer leto1 = this.letoR;
                Integer leto2 = o.letoR;
                return leto1.compareTo(leto2);
            default:
                return this.ime.compareTo(o.ime);
        }
    }

    public String getIme() {
        return ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public int getLetoR() {
        return letoR;
    }
}
