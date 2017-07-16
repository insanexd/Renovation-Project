import java.util.*;

public class StructuredObject extends RenovationObject {

    private Set<RenovationObject> parts = new HashSet<>();

    public StructuredObject() {}

    public void add(RenovationObject r) throws NullPointerException {
        if(r == null) throw new NullPointerException();
        parts.add(r);

    }

    @Override
    public double getPrice() {
        double price = 0;
        for(RenovationObject ro :  parts) {
            price = price + ro.getPrice();
        }
        return price;
    }

    @Override
    public Map<String, Integer> addMaterialReq(Map<String, Integer> materials) throws NullPointerException {
        for(Map.Entry<String, Integer> entry : materials.entrySet()) {
            if(entry.getKey() == null || entry.getValue() == null) throw new NullPointerException();

        }
        Map<String, Integer> materialsForStructuredObject = new HashMap<>();
        for(RenovationObject ro : this.parts) {
            for(Map.Entry<String, Integer> entry : ro.addMaterialReq(materials).entrySet()) {
                //System.out.println("oioi     " + entry.getKey() + entry.getValue());
                materialsForStructuredObject.put(entry.getKey(), entry.getValue());

            }

        }
        System.out.println(materialsForStructuredObject.keySet());
        System.out.println(materialsForStructuredObject.values());
        return materialsForStructuredObject;
    }
}
