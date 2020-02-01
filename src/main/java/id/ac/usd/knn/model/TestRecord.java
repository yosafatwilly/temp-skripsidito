package id.ac.usd.knn.model;

public class TestRecord extends Record {

    public int predictedLabel;

    public TestRecord(double[] attributes) {
        super(attributes);
    }

    public TestRecord(double[] attributes, int classLabel) {
        super(attributes, classLabel);
    }

    public int getPredictedLabel() {
        return predictedLabel;
    }

    public void setPredictedLabel(int predictedLabel) {
        this.predictedLabel = predictedLabel;
    }
}
