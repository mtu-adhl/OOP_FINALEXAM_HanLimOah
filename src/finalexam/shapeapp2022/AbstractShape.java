package finalexam.shapeapp2022;

public abstract class AbstractShape {
    private int topLeftX;
    private int topLeftY;
    private int bottomRightX;
    private int bottomRightY;

    public AbstractShape(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        setTopLeftX(topLeftX);
        setTopLeftY(topLeftY);
        setBottomRightX(bottomRightX);
        setBottomRightY(bottomRightY);
    }

    @Override
    public String toString() {
        return String.format("Top-left coordinates: (%d,%d)\n", getTopLeftX(), getTopLeftY()) +
                String.format("Bottom-right coordinates: (%d,%d)\n", getBottomRightX(), getBottomRightY()) +
                "Width: " + getWidth() + "\n" +
                "Height: " + getHeight() + "\n";
    }

    public int getWidth() {
        return Math.abs(topLeftX-bottomRightX);
    }

    public int getHeight() {
        return Math.abs(topLeftY-bottomRightY);
    }

    public abstract String getType();

    public int getTopLeftX() {
        return topLeftX;
    }

    public void setTopLeftX(int topLeftX) {
        this.topLeftX = topLeftX;
    }

    public int getTopLeftY() {
        return topLeftY;
    }

    public void setTopLeftY(int topLeftY) {
        this.topLeftY = topLeftY;
    }

    public int getBottomRightX() {
        return bottomRightX;
    }

    public void setBottomRightX(int bottomRightX) {
        this.bottomRightX = bottomRightX;
    }

    public int getBottomRightY() {
        return bottomRightY;
    }

    public void setBottomRightY(int bottomRightY) {
        this.bottomRightY = bottomRightY;
    }
}
