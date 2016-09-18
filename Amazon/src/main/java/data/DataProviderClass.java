package data;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by admin on 9/18/16.
 */
public class DataProviderClass {

    static Object[][] data = null;
    static final String path = "/Users/admin/Desktop/WebTestAutomationFramework/Amazon/external_data/TestData.xls";
    static FileInputStream fis = null;
    static HSSFWorkbook wkb = null;
    static HSSFSheet sheet = null;

    @DataProvider(name = "data")
    public static Object[][] getDataForAmazonSearch() {

        try {
            fis = new FileInputStream(path);
            wkb = new HSSFWorkbook(fis);
            sheet = wkb.getSheet("Sheet1");

            int rowsCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
            data = new Object[rowsCount][1];

            HSSFRow row = null;

            for (int i = 0; i < rowsCount; i++) {

                row = sheet.getRow(i + 1);

                data[i][0] = row.getCell(0).getStringCellValue();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (wkb != null) {
                    wkb.close();
                }
            } catch (IOException e) {
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
            }
        }

        return data;

    }



}