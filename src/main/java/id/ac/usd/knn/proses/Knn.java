package id.ac.usd.knn.proses;

import id.ac.usd.knn.model.Record;
import id.ac.usd.knn.model.TestRecord;
import id.ac.usd.knn.model.TrainRecord;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Knn {

    public double hitungAkurasi(TrainRecord[] trainRecords, TestRecord[] testRecords, int K) {
        if (K <= 0) {
            System.out.println("K should be larger than 0!");
            return -1;
        }

        //normalisasi
        TrainRecord[] trainingSet = trainRecords;
        TestRecord[] testingSet = testRecords;

        trainingSet = (TrainRecord[]) normalisasi(trainingSet);
        testingSet = (TestRecord[]) normalisasi(testingSet);

        //test those TestRecords one by one
        int numOfTestingRecord = testingSet.length;
        for (int i = 0; i < numOfTestingRecord; i++) {
            TrainRecord[] neighbors = findKNearestNeighbors(trainingSet, testingSet[i], K);
            int classLabel = classify(neighbors);
            testingSet[i].predictedLabel = classLabel; //assign the predicted label to TestRecord
        }

        int correctPrediction = 0;
        for (int j = 0; j < numOfTestingRecord; j++) {

            if (testingSet[j].predictedLabel == testingSet[j].classLabel) {
                correctPrediction++;
            }
        }
        return ((double) correctPrediction / numOfTestingRecord) * 100;
    }

    public int predict(TrainRecord[] trainingSet, TestRecord testing, int K){
        TrainRecord[] neighbors = findKNearestNeighbors(trainingSet, testing, K);
        int classLabel = classify(neighbors);
        return classLabel;
    }

    // Find K nearest neighbors of testRecord within trainingSet
    static TrainRecord[] findKNearestNeighbors(TrainRecord[] trainingSet, TestRecord testRecord, int K) {
        int NumOfTrainingSet = trainingSet.length;
        assert K <= NumOfTrainingSet : "K is lager than the length of trainingSet!";

        //Update KNN: take the case when testRecord has multiple neighbors with the same distance into consideration
        //Solution: Update the size of container holding the neighbors
        TrainRecord[] neighbors = new TrainRecord[K];

        //initialization, put the first K trainRecords into the above arrayList
        int index;
        for (index = 0; index < K; index++) {
            trainingSet[index].distance = getDistance(trainingSet[index], testRecord);
            neighbors[index] = trainingSet[index];
        }

        //go through the remaining records in the trainingSet to find K nearest neighbors
        for (index = K; index < NumOfTrainingSet; index++) {
            trainingSet[index].distance = getDistance(trainingSet[index], testRecord);

            //get the index of the neighbor with the largest distance to testRecord
            int maxIndex = 0;
            for (int i = 1; i < K; i++) {
                if (neighbors[i].distance > neighbors[maxIndex].distance) {
                    maxIndex = i;
                }
            }

            //add the current trainingSet[index] into neighbors if applicable
            if (neighbors[maxIndex].distance > trainingSet[index].distance) {
                neighbors[maxIndex] = trainingSet[index];
            }
        }

        return neighbors;
    }

    // Get the class label by using neighbors
    static int classify(TrainRecord[] neighbors) {
        //construct a HashMap to store <classLabel, weight>
        HashMap<Integer, Double> map = new HashMap<Integer, Double>();
        int num = neighbors.length;

        for (int index = 0; index < num; index++) {
            TrainRecord temp = neighbors[index];
            int key = temp.classLabel;

            //if this classLabel does not exist in the HashMap, put <key, 1/(temp.distance)> into the HashMap
            if (!map.containsKey(key)) {
                map.put(key, 1 / temp.distance);
            } //else, update the HashMap by adding the weight associating with that key
            else {
                double value = map.get(key);
                value += 1 / temp.distance;
                map.put(key, value);
            }
        }

        //Find the most likely label
        double maxSimilarity = 0;
        int returnLabel = -1;
        Set<Integer> labelSet = map.keySet();
        Iterator<Integer> it = labelSet.iterator();

        //go through the HashMap by using keys
        //and find the key with the highest weights
        while (it.hasNext()) {
            int label = it.next();
            double value = map.get(label);
            if (value > maxSimilarity) {
                maxSimilarity = value;
                returnLabel = label;
            }
        }

        return returnLabel;
    }

    public static double getDistance(Record s, Record e) {
        assert s.attributes.length == e.attributes.length : "s and e are different types of records!";
        int numOfAttributes = s.attributes.length;
        double sum2 = 0;
        for (int i = 0; i < numOfAttributes; i++) {
            sum2 += Math.pow(s.attributes[i] - e.attributes[i], 2);
        }
        return Math.sqrt(sum2);
    }

    public static Record[] normalisasi(Record[] records) {
        int numJmlData = records.length;
        int numJmlVar = records[0].attributes.length;
        double[] max = new double[numJmlVar];
        double[] min = new double[numJmlVar];
        for (int j = 0; j < numJmlVar; j++) {
            double[] temp = new double[numJmlData];
            for (int i = 0; i < numJmlData; i++) {
                temp[i] = records[i].attributes[j];
            }
            Arrays.sort(temp);
            min[j] = temp[0];
            max[j] = temp[temp.length - 1];
        }
        for (Record record : records) {
            for (int j = 0; j < record.attributes.length; j++) {
                record.attributes[j] = (record.attributes[j] - min[j]) / (max[j] - min[j]);
            }
        }
        return records;
    }
}
