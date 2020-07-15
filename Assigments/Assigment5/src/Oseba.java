public class Oseba implements Comparable<Oseba> {
    private final static String[] IMENA = {"Ana", "Bor", "Cvetka", "Dusan", "Miha", "Janez",
            "Tilen", "Igor", "Matic", "Lojze", "Matjaz", "Primoz", "Sandi", "Gregor", "Matija", "Benjamin"};
    private final static String[] PRIIMKI = {"Arh", "Buh", "Cah", "Duh", "Novak", "Rojc", "Zver", "Volk", "Kovac",
            "Peternelj", "Skok", "Novak", "Kovaceviv", "Lozej", "Tavcar", "Prelec"};
    private static int atr = 0;
    private static int smer = 1;
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


    static void bubblesort(Oseba[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%s ", a[i].toString());
        }
        System.out.println();
        int lastSwap = a.length - 1;
        boolean swaped = false;
        int size = a.length - 1;
        for (int i = 0; i < size; i++) {
            for (int j = size; j > i; j--) {
                if (a[j - 1].compareTo(a[j]) * smer > 0) {
                    Oseba temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    lastSwap = j - 1;
                    swaped = true;
                }
            }
            if (swaped) {
                swaped = false;
                for (int z = 0; z < a.length; z++) {
                    System.out.printf("%s ", a[z].toString());
                    if (z == lastSwap) {
                        System.out.printf("%s ", "|");
                    }
                }
                System.out.println();
            }


        }

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
