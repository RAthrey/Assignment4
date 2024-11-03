public class Plot extends Object {
    private int x;
    private int y;
    private int width;
    private int depth;
    public Plot() {
        this.x = 0;      
        this.y = 0;     
        this.width = 1;   
        this.depth = 1;   
    }
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }
    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
    public boolean encompasses(Plot plot) {
        return (this.x <= plot.getX() && 
                this.y <= plot.getY() && 
                (this.x + this.width) >= (plot.getX() + plot.getWidth()) && 
                (this.y + this.depth) >= (plot.getY() + plot.getDepth()));
    }
    public boolean overlaps(Plot plot) {
        return (this.x < (plot.getX() + plot.getWidth()) &&
                (this.x + this.width) > plot.getX() &&
                this.y < (plot.getY() + plot.getDepth()) &&
                (this.y + this.depth) > plot.getY());
    }
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
