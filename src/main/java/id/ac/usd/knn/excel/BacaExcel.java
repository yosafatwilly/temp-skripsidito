package id.ac.usd.knn.excel;

import java.io.IOException;
import java.io.InputStream;

import id.ac.usd.knn.model.TestRecord;
import id.ac.usd.knn.model.TrainRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class BacaExcel {

    public static TrainRecord[] readTrainExcel(InputStream input) {
        TrainRecord[] records = null;
        try {
            Workbook workbook = WorkbookFactory.create(input);
            Sheet sheet = workbook.getSheetAt(0);
            records = new TrainRecord[sheet.getLastRowNum() - 1];
            int index = 0;
            for (Row row : sheet) {
                double[] attributes = new double[12];
                int classLabel = -1;
                int i = 0;
                for (Cell cell : row) {
                    if (row.getRowNum() >= 2) {
                        if (cell.getColumnIndex() >= 1 && cell.getColumnIndex() <= 12) {
                            attributes[i] = cell.getNumericCellValue();
                            i++;
                        } else if (cell.getColumnIndex() == 13) {
                            classLabel = (int) cell.getNumericCellValue();
                        }
                    }
                }
                if (attributes.length == 12 && classLabel != -1) {
                    records[index] = new TrainRecord(attributes, classLabel);
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static TestRecord[] readTestExcel(InputStream input) {
        TestRecord[] records = null;
        try {
            Workbook workbook = WorkbookFactory.create(input);
            Sheet sheet = workbook.getSheetAt(0);
            records = new TestRecord[sheet.getLastRowNum() - 1];
            int index = 0;
            for (Row row : sheet) {
                double[] attributes = new double[12];
                int classLabel = -1;
                int i = 0;
                for (Cell cell : row) {
                    if (row.getRowNum() >= 2) {
                        if (cell.getColumnIndex() >= 1 && cell.getColumnIndex() <= 12) {
                            attributes[i] = cell.getNumericCellValue();
                            i++;
                        } else if (cell.getColumnIndex() == 13) {
                            classLabel = (int) cell.getNumericCellValue();
                        }
                    }
                }
                if (attributes.length == 12 && classLabel != -1) {
                    records[index] = new TestRecord(attributes, classLabel);
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}

