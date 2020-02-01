package id.ac.usd.knn.service;

import id.ac.usd.knn.excel.BacaExcel;
import id.ac.usd.knn.model.TrainRecord;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class FileManager {
    public TrainRecord[] trainRecords;

    public FileManager() {
        InputStream in = FileManager.class.
                getResourceAsStream("/training.xlsx");
        trainRecords = BacaExcel.readTrainExcel(in);
    }
}
