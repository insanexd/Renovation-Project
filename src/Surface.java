import java.util.HashMap;
import java.util.Map;

public class Surface extends RenovationObject {

    private double length;
    private double width;
    private Material selectedMaterial;

    public Surface(double length, double width) throws IllegalArgumentException {
        if(length <= 0 || width <= 0) throw new IllegalArgumentException();
        this.length = length;
        this.width = width;

    }

    public void setMaterial(Material m) throws NullPointerException {
        if(m == null) throw new NullPointerException();
        this.selectedMaterial = m;
    }

    public double getArea() {
        return this.length * this.width;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public double getPrice() {
        return this.selectedMaterial.getPricePerUnit()*this.selectedMaterial.getMaterialReq(this);
    }

    public Map<String, Integer> addMaterialReq(Map<String, Integer> materials) throws NullPointerException {
        if(this.selectedMaterial == null) throw new NullPointerException();
        for(Map.Entry<String, Integer> entry : materials.entrySet()) {
            if(entry.getValue() == null || entry.getKey() == null) throw new NullPointerException();
        }
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put(this.selectedMaterial.getName(), this.selectedMaterial.getMaterialReq(this));

        for(Map.Entry<String, Integer> entry : materials.entrySet()) {
            if(!myMap.containsKey(entry.getKey())) {
                myMap.put(entry.getKey(), entry.getValue() + this.selectedMaterial.getMaterialReq(this));
            } else {
                myMap.replace(entry.getKey(), myMap.get(entry.getKey()) + entry.getValue());
            }
        }
        return myMap;

    }



}
