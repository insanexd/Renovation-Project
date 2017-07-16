public abstract class Material {

    private String name;
    private double price;

    public Material(String name, double price) throws NullPointerException, IllegalArgumentException {
        if(name == null) throw new NullPointerException();
        if(name == "" || price <= 0) throw new IllegalArgumentException();
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return this.name;
    }

    public double getPricePerUnit() {
        return this.price;
    }

    public abstract int getMaterialReq(Surface s) throws NullPointerException;

    public double getPriceOfASurface(Surface s) throws NullPointerException {
        if (s == null) throw new NullPointerException();
        return s.getArea() * this.price / s.getWidth();
    }
    public static double round(double value, int places) throws IllegalArgumentException {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
