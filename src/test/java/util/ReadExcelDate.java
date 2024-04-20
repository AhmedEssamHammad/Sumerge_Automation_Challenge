package util;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelDate {

    @DataProvider(name = "testData")
    public static Object[][] getData() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/testDataSheet.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("hotelReservation");
        int totalRowCounts = sheet.getLastRowNum();
        int totalColumnCount = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[totalRowCounts][totalColumnCount];
        for (int i = 0; i < totalRowCounts; i++) {
            for (int j = 0; j < totalColumnCount; j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
            }
        }
        return data;
    }

}
