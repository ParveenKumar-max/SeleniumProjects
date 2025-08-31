package org.apitestinglearning.Ex_SeleniumTest.DataDriven;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {

  /*  Read the file - xlsx - FileinputStream (Java)
    WorkBook - WorkbookFactory
    Sheet -> book
    R, C -> Sheet
    Object[][] data -> all the values in cell -> data [] [] -> For loop.
*/

    // WorkBook and Sheet  Variable we have created.
    static Workbook workbook;
    static Sheet sheet;

    //File Path
    public static String Sheet_path = System.getProperty("user.dir")+"\\src\\test\\resources\\MOCK_DATA.xlsx";


    public static Object[][] getTestDataFromExcel(String sheetName){
        FileInputStream fileInputStream = null;
        try {
             fileInputStream = new FileInputStream(Sheet_path); // IS used for Open or Search the file
            workbook = WorkbookFactory.create(fileInputStream); // Create a temporary file.
            sheet = workbook.getSheet(sheetName); // Get the data from the sheet.

            // Handle exception
        } catch (FileNotFoundException e) {
            System.out.println("Either File not Found  " + e.getStackTrace());
        } catch (IOException e) {
            System.out.println("Data OR Workbook Not Created" + e.getStackTrace());
        }

        // getLastRowNum --> Count the file rows like 10, 15, 20
        //getRow(0) --> 0 index pr, getLastCellNum(), --> How many column are there and i.e 2
        // So the Matrix or file will be row --> 100, 0 Row index, we have 2 col.
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++){ // 0 to 100 , its count the rows

            for (int j = 0; j < sheet.getRow(0).getLastCellNum() ; j++){
                // Its counts the column
                // from 0 Row index which means 2 col.

                // we don't need 0 index rows i.e: email and password
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();

            }
        }
    return data;
    }
}
