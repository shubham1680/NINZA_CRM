package DataDrivenTestingPractice;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericutilities.ExcelFileUtility;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//FileInputStream fis=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\NINJACrm.xlsx");
		//Workbook wb = WorkbookFactory.create(fis);
		ExcelFileUtility eLib=new ExcelFileUtility();
		int rowCount = eLib.getRowCount("Practice");
		//Sheet sh = wb.getSheet("Practice");
		//int rowNum=sh.getLastRowNum();
		System.out.println(rowCount);
		for(int row=1;row<=rowCount;row++)
		{
			//String PRODUCT_NAME=wb.getSheet("Practice").getRow(row).getCell(0).getStringCellValue();
			String data=eLib.readDataFromExcelFile("Practice", row, 0);
			System.out.println(data);
		}
		

	}

}
