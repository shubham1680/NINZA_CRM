package PropertiesFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataToProperty {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\LoginData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		
		pobj.setProperty("url", "https://demowebshop.tricentis.com/register");
		pobj.setProperty("user", "Shubham");
		pobj.setProperty("email", "shubham123@gmail.com");
		
		FileOutputStream fos=new FileOutputStream("C:\\\\Users\\\\dshub\\\\OneDrive\\\\Documents\\\\LoginData.properties");
		pobj.store(fos, "adding common data");
		fos.close();
		System.out.println("vlaues added succesfully");

	}

}
