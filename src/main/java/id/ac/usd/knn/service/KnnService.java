package id.ac.usd.knn.service;

import id.ac.usd.knn.model.TestRecord;
import id.ac.usd.knn.proses.Knn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnnService {

    @Autowired
    FileManager fileManager;
    Knn knn = new Knn();

    public double hitungAkurasi(TestRecord[] testingSet, int K){
        return knn.hitungAkurasi(fileManager.trainRecords, testingSet, K);
    }

    public int predict(TestRecord testing){
        return knn.predict(fileManager.trainRecords, testing, 1);
    }
}