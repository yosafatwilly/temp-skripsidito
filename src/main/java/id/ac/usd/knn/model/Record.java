package id.ac.usd.knn.model;

import java.util.Arrays;

public class Record {

    public double[] attributes;
    public int classLabel;

    public Record(double[] attributes) {
        this.attributes = attributes;
    }

    public Record(double[] attributes, int classLabel) {
        this.attributes = attributes;
        this.classLabel = classLabel;
    }

    public double[] getAttributes() {
        return attributes;
    }

    public void setAttributes(double[] attributes) {
        this.attributes = attributes;
    }

    public int getClassLabel() {
        return classLabel;
    }

    public void setClassLabel(int classLabel) {
        this.classLabel = classLabel;
    }

    @Override
    public String toString() {
        return "Record{" + "attributes=" + Arrays.toString(attributes) + ", classLabel=" + classLabel + '}';
    }
}