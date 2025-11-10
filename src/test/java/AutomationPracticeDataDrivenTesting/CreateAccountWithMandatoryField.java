package AutomationPracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateAccountWithMandatoryField {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis1=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\AutomationExercise.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String FIRST_NAME=wb.getSheet("RegisterUser").getRow(1).getCell(2).getStringCellValue();
		String LAST_NAME=wb.getSheet("RegisterUser").getRow(1).getCell(3).getStringCellValue();
		String ADDRESS=wb.getSheet("RegisterUser").getRow(1).getCell(4).getStringCellValue();
		String STATE=wb.getSheet("RegisterUser").getRow(1).getCell(5).getStringCellValue();
		String CITY=wb.getSheet("RegisterUser").getRow(1).getCell(6).getStringCellValue();
		String ZIPCODE=wb.getSheet("RegisterUser").getRow(1).getCell(7).getStringCellValue();
		String MOBILE=wb.getSheet("RegisterUser").getRow(1).getCell(8).getStringCellValue();

	}

}
