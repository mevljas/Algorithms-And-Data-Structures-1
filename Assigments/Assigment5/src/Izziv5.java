import java.util.Scanner;

public class Izziv5 {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Vnesi velikost n.");
            int n = in.nextInt();
            Oseba[] t = new Oseba[n];
            Oseba[] tt = new Oseba[n];
            for (int i = 0; i < n; i++) {
                tt[i] = new Oseba();
            }
            while (true) {
                for (int i = 0; i < n; i++) {
                    t[i] = tt[i];
                    System.out.print(t[i].getIme() + " ");
                    System.out.print(t[i].getPriimek() + " ");
                    System.out.println(t[i].getLetoR() + " ");
                }
                System.out.println();
                System.out.println("Vnesi  atribut. ( 0, 1  ali 2)");
                Oseba.setAtr(in.nextInt());
                System.out.println();
                System.out.println("Vnesi smer. ( -1 ali 1)");
                Oseba.setSmer(in.nextInt());
                System.out.println();
                Oseba.bubblesort(t);
                System.out.println();
                System.out.println("Za izhod napišite 'izhod', za ponovitev pa karkoli drugega.");
                if (in.next().equals("izhod"))
                    break;
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
