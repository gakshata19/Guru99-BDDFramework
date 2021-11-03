package Com.UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader1	 {
	public FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public ExcelReader1() {
		File f=new File("C:\\Users\\akshatag\\Automation\\eclipse\\Workbook\\BDDGuru99BankProject\\src\\main\\java\\Com\\TestDataLayer\\TestData.xlsx");
		try {
			fis=new FileInputStream(f);
			wb= new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getData(int sheetindex, int row, int col) {
		sheet=wb.getSheetAt(sheetindex);
		String data= sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public int rowcount(int sheetindex) {
		sheet=wb.getSheetAt(sheetindex);
		int count=sheet.getLastRowNum();
		count=count+1;
		return count;
	}
}
