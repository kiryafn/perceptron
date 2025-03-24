package nai.perceptron;

import java.util.List;

public class Vector {

    private String name;
    private List<Double> values;
    private int label;

    public Vector(String name, List<Double> values){
        this.name = name;
        this.values = values;
        label = (name.equals("Iris-versicolor") ? 1 : 0);
    }

    public Vector(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }
}
