package id.ac.usd.knn.model;

public class TrainRecord extends Record {

    public double distance;

    public TrainRecord(double[] attributes, int classLabel) {
        super(attributes, classLabel);
    }


}