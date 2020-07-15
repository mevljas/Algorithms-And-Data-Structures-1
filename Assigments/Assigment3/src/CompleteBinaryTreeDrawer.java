import java.awt.*;

class CompleteBinaryTreeDrawer {
    private int size;
    private int[] x;
    private int[] y;


    CompleteBinaryTreeDrawer(int size) {
        this.size = size;
        this.x = new int[size];
        this.y = new int[size];
        traverse(0, 0, 0);
    }


    private int traverse(int i, int Xi, int Yi) {
        if (2 * i + 1 < size)
            Xi = traverse(2 * i + 1, Xi, Yi + 1);
        x[i] = Xi;
        y[i] = Yi;
        if (2 * i + 2 < size)
            Xi = traverse(2 * i + 2, Xi + 1, Yi + 1);
        return Xi + 1;
    }

    private void drawNode(int i) {
        //nariši i-to vozlišče na ustreznem položaju
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.filledEllipse(x[i], y[i], size / 80, 0.2);
    }

    private void drawEdgeToParent(int i) {
        StdDraw.setPenColor(Color.black);
        int parent = (i - 1) / 2;
        StdDraw.line(x[i], y[i], x[parent], y[parent]);
    }

    void drawLevelOrder() {
        for (int i = 0; i < x.length; i++) {
            drawEdgeToParent(i);
            drawNode(i);
        }
    }

    void drawPreorder(int i) {
        drawEdgeToParent(i);
        drawNode(i);
        if (2 * i + 1 < size)
            drawPreorder(2 * i + 1);    //levo
        if (2 * i + 2 < size)
            drawPreorder(2 * i + 2);        //desni
    }

    void drawInorder(int i) {

        if (2 * i + 1 < size)
            drawInorder(2 * i + 1);    //levo
        drawEdgeToParent(i);
        drawNode(i);
        if (2 * i + 2 < size)
            drawInorder(2 * i + 2);        //desni
    }


    void drawPostorder(int i) {
        if (2 * i + 1 < size)
            drawPostorder(2 * i + 1);    //levo
        if (2 * i + 2 < size)
            drawPostorder(2 * i + 2);        //desni
        drawEdgeToParent(i);
        drawNode(i);
    }

    //popravi izris
    void fixDraw() {
        for (int i = 0; i < x.length; i++) {
            drawNode(i);
        }
    }

}
