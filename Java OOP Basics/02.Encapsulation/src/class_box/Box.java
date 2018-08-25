package class_box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    private double getLength() {
        return this.length;
    }

    private double getWidth() {
        return this.width;
    }

    private double getHeight() {
        return this.height;
    }

    public double calculateSurfaceArea() {
        return (2 * this.getLength() * this.getWidth()) + this.calculateLateralSurfaceArea();
    }

    public double calculateLateralSurfaceArea() {
        return (2 * this.getLength() * this.getHeight()) + (2 * this.getWidth() * this.getHeight());
    }

    public double calculateVolume() {
        return this.getLength() * this.getWidth() * this.getHeight();
    }

}
