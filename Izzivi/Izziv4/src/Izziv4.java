public class Izziv4 {
    public static void main(String[] args) throws CollectionException {

        ArrayPQ ap = new ArrayPQ();
        ArrayHeapPQ ah = new ArrayHeapPQ();
        LinkedHeapPQ lh = new LinkedHeapPQ();
        int randomNuber;
        int max = 1000;
        int min = 1;
        long timeAp = 0;
        long timeAh = 0;
        long timeLh = 0;
        long startAp;
        long startAh;
        long startLh;
        for (int i = 0; i < 1000; i++) {
            randomNuber = (int) ((Math.random() * ((max - min) + 1)) + min);
            startAp = System.currentTimeMillis();
            ap.enqueue(randomNuber);
            timeAp += System.currentTimeMillis() - startAp;

            startAh = System.currentTimeMillis();
            ah.enqueue(randomNuber);
            timeAh += System.currentTimeMillis() - startAh;

            startLh = System.currentTimeMillis();
            lh.enqueue(randomNuber);
            timeLh += System.currentTimeMillis() - startLh;
        }
        for (int i = 0; i < 500; i++) {
            randomNuber = (int) ((Math.random() * ((max - min) + 1)) + min);
            startAp = System.currentTimeMillis();
            ap.dequeue();
            timeAp += System.currentTimeMillis() - startAp;

            startAh = System.currentTimeMillis();
            ah.dequeue();
            timeAh += System.currentTimeMillis() - startAh;

            startLh = System.currentTimeMillis();
            lh.dequeue();
            timeLh += System.currentTimeMillis() - startLh;


            startAp = System.currentTimeMillis();
            ap.enqueue(randomNuber);
            timeAp += System.currentTimeMillis() - startAp;

            startAh = System.currentTimeMillis();
            ah.enqueue(randomNuber);
            timeAh += System.currentTimeMillis() - startAh;

            startLh = System.currentTimeMillis();
            lh.enqueue(randomNuber);
            timeLh += System.currentTimeMillis() - startLh;


            startAp = System.currentTimeMillis();
            ap.front();
            timeAp += System.currentTimeMillis() - startAp;

            startAh = System.currentTimeMillis();
            ah.front();
            timeAh += System.currentTimeMillis() - startAh;

            startLh = System.currentTimeMillis();
            lh.front();
            timeLh += System.currentTimeMillis() - startLh;


        }

        System.out.println("Objekti: Integer");
        System.out.println("Operacije: 1000 enqueue + 500 (dequeue+enqueue+front)");
        System.out.println("Implementacija                  Čas [ms]               Premikov              Primerjav");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("Neurejeno polje  (64,2x)         ");
        System.out.printf("%-22d", timeAp);
        System.out.printf("%-22d", ap.getMoveCounter());
        System.out.printf("%-22d\n", ap.getCompareCounter());
        System.out.print("Implicitna koplica  (64,2x)      ");
        System.out.printf("%-22d", timeAh);
        System.out.printf("%-22d", ah.getMoveCounter());
        System.out.printf("%-22d\n", ah.getCompareCounter());
        System.out.print("Eksplicitna kopica               ");
        System.out.printf("%-22d", timeLh);
        System.out.printf("%-22d", lh.getMoveCounter());
        System.out.printf("%-22d\n", lh.getCompareCounter());


    }
}
