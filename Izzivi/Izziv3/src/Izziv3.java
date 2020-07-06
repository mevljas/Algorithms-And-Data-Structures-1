public class Izziv3 {

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        StdDraw.setCanvasSize(1000, 600);
        StdDraw.setXscale(-1, size );
        StdDraw.setYscale((int) (Math.log(size + 1) / Math.log(2)) + 1, -1);
        CompleteBinaryTreeDrawer ctd = new CompleteBinaryTreeDrawer(size);

        ctd.drawLevelOrder();
        ctd.fixDraw();

//        ctd.drawPreorder(0);
//        ctd.fixDraw();
//
//        ctd.drawInorder(0);
//        ctd.fixDraw();
//
//        ctd.drawPostorder(0);
//        ctd.fixDraw();

    }
}
