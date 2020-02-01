package id.ac.usd.knn.controller;

import id.ac.usd.knn.dto.Input;
import id.ac.usd.knn.excel.BacaExcel;
import id.ac.usd.knn.model.TestRecord;
import id.ac.usd.knn.service.KnnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ViewController {

    private KnnService knnService;

    TestRecord[] testRecords;

    @Autowired
    public ViewController(KnnService knnService) {
        this.knnService = knnService;
    }

    @GetMapping("/info")
    public ModelAndView info(){
        return new ModelAndView("info");
    }

    @GetMapping("/help")
    public ModelAndView help(){
        return new ModelAndView("help");
    }

    @PostMapping("/upload")
    public ModelAndView upload(@RequestPart MultipartFile excel) throws IOException {
        testRecords = BacaExcel.readTestExcel(excel.getInputStream());
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("testing", testRecords);
        return modelAndView;
    }

    @PostMapping("/hitung")
    public ModelAndView hitung(int inputK){
        double akurasi  = knnService.hitungAkurasi(testRecords, inputK);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("akurasi", akurasi);
        return modelAndView;
    }

    @PostMapping("/predict")
    public ModelAndView predict(Input input){
        double[] attributes = new double[12];
        attributes[0] = input.getMaskD();
        attributes[1] = input.getMaskI();
        attributes[2] = input.getMaskS();
        attributes[3] = input.getMaskC();
        attributes[4] = input.getPressureD();
        attributes[5] = input.getPressureI();
        attributes[6] = input.getPressureS();
        attributes[7] = input.getPressureC();
        attributes[8] = input.getSelfD();
        attributes[9] = input.getSelfI();
        attributes[10] = input.getSelfS();
        attributes[11] = input.getSelfC();
        TestRecord testRecord = new TestRecord(attributes);
        ModelAndView modelAndView = new ModelAndView("index");
        int hasil = knnService.predict(testRecord);
        modelAndView.addObject("output", hasil);
        return modelAndView;
    }
}
