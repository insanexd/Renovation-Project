public class Flooring extends Material {

    private static double limit = 0.02;
    private double widthOfFloor;

    public Flooring(String name, double price, double width) throws IllegalArgumentException {
        super(name, price);
        if(width  <= 0 ) throw new IllegalArgumentException();
        this.widthOfFloor = width;

    }

    public double getWidth() {
        return this.widthOfFloor;
    }

    @Override
    public int getMaterialReq(Surface s) {
        double innacNumberOfPanels = s.getArea() / this.widthOfFloor;
        double tolerance = Math.abs(Math.round(innacNumberOfPanels) - innacNumberOfPanels);
        double fixedTolerance = round(tolerance, 2);

        if(fixedTolerance < this.limit) {
            //System.out.println((int) innacNumberOfPanels);
            return (int) innacNumberOfPanels;
        } else {
           //System.out.println((int) innacNumberOfPanels +1);
            return (int) (innacNumberOfPanels + 1);
        }

    }

}
