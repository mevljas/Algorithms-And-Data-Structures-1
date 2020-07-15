import java.util.Scanner;

public class Izziv6 {
    public static void main(String[] args) throws CollectionException {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Vnesi velikost n.");
            int n = in.nextInt();
            LinkedSequence<Oseba> z1 = new LinkedSequence<>();
            for (int i = 0; i < n; i++) {
                z1.insert(0, new Oseba());
            }
            while (true) {
                LinkedSequence<Oseba> z2 = new LinkedSequence<>();
                for (int i = 0; i < n; i++) {
                    z2.insert(0, z1.get(i));
                }
                System.out.println();
                System.out.println("Vnesi  atribut. ( 0, 1  ali 2)");
                Oseba.setAtr(in.nextInt());
                System.out.println();
                System.out.println("Vnesi smer. ( -1 ali 1)");
                Oseba.setSmer(in.nextInt());
                System.out.println();
                for (int i = 0; i < n; i++) {
                    System.out.print(z2.get(i).getIme() + " ");
                    System.out.print(z2.get(i).getPriimek() + " ");
                    System.out.println(z2.get(i).getLetoR() + " ");
                }
                System.out.println();
                System.out.println("Vnesi velikost v (za preklop na navadno vstavljanje)");
                int v = in.nextInt();
                System.out.println();
                Oseba.resetrirajPremikeInPrimerjave();
                Oseba.quickSort(z2, 0, z2.count() - 1, v);
                System.out.println();
                for (int i = 0; i < n; i++) {
                    System.out.print(z2.get(i).getIme() + " ");
                    System.out.print(z2.get(i).getPriimek() + " ");
                    System.out.println(z2.get(i).getLetoR() + " ");
                }
                System.out.println();
                System.out.println("Premiki: " + Oseba.getPremiki());
                System.out.println("Primerjave: " + Oseba.getPrimerjave());
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
