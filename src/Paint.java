public class Paint extends Material {

    private static double limit = 0.02;
    private int noOfCoats;
    private double noOfSqMPerLiter;

    public Paint(String name, double price, int noOfCoats, double noOfSqMPerLiter) throws IllegalArgumentException {
        super(name, price);
        if(noOfCoats <= 0 || noOfSqMPerLiter <= 0) throw new IllegalArgumentException();
        this.noOfCoats = noOfCoats;
        this.noOfSqMPerLiter = noOfSqMPerLiter;
    }

    public int getNoOfCoats() {
        return this.noOfCoats;
    }

    public double getNoOfSqMPerLiter() {
        return this.noOfSqMPerLiter;
    }


    @Override
    public int getMaterialReq(Surface s) throws NullPointerException {
        if(s == null) throw new NullPointerException();
        double innacNumberOfBuckets = 2 * s.getArea() * this.getNoOfCoats() / noOfSqMPerLiter;
        double tolerance = Math.abs(Math.round(innacNumberOfBuckets) - innacNumberOfBuckets);
        double fixedTolerance = round(tolerance, 2);
        if(fixedTolerance <= this.limit) {
            //System.out.println((int)(innacNumberOfBuckets));
            return (int)(innacNumberOfBuckets);
        } else {
            //System.out.println((int)(innacNumberOfBuckets) + 1);
            return (int)(innacNumberOfBuckets) + 1;
        }

    }
}
