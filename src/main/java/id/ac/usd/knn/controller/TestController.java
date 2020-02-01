package id.ac.usd.knn.controller;

import id.ac.usd.knn.excel.BacaExcel;
import id.ac.usd.knn.model.TestRecord;
import id.ac.usd.knn.model.TrainRecord;
import id.ac.usd.knn.service.FileManager;
import id.ac.usd.knn.proses.Knn;
import id.ac.usd.knn.service.KnnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
@RequestMapping("test")
public class TestController {


    @Autowired
    KnnService knnService;

    @GetMapping("/akurasi")
    public double hitungAkurasi(){
        InputStream in = FileManager.class.
                getResourceAsStream("/testing.xlsx");
       return knnService.hitungAkurasi(BacaExcel.readTestExcel(in), 1);
    }

    @GetMapping("predict")
    public int test(){
        double[] attributes = new double[12];
//        attributes[0] = 6;
//        attributes[1] = 4;
//        attributes[2] = 2;
//        attributes[3] = 6;
//        attributes[4] = 6;
//        attributes[5] = 4;
//        attributes[6] = 4;
//        attributes[7] = 6;
//        attributes[8] = 0;
//        attributes[9] = 0;
//        attributes[10] = 2;
//        attributes[11] = 0;

        attributes[0] = 3;
        attributes[1] = 7;
        attributes[2] = 7;
        attributes[3] = 4;
        attributes[4] = 9;
        attributes[5] = 2;
        attributes[6] = 4;
        attributes[7] = 8;
        attributes[8] = 6;
        attributes[9] = 5;
        attributes[10] = 3;
        attributes[11] = 4;
        TestRecord testRecord = new TestRecord(attributes);
        return knnService.predict(testRecord);
    }

}
//3	7	7	4	9	2	4	8	6	5	3	4
