package DataDrivenTestingPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\NINJACrm.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Practice");
		sh.getRow(3).createCell(1, CellType.STRING).setCellValue("Yes");
		sh.getRow(6).createCell(1, CellType.STRING).setCellValue("No");
		fis1.close();
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\dshub\\OneDrive\\Documents\\NINJACrm.xlsx");
		wb.write(fos);
		fos.close();
		wb.close();
	}

}
