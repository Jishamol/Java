import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ExcelReader {
	
	public ArrayList<CommandClass> readExcel() throws Exception{
		boolean isFirstRowPass= false;
		ArrayList<CommandClass> commandList = new ArrayList<>();
		// ResourceBundle Class is used to read the property file from src location
		ResourceBundle rb = ResourceBundle.getBundle("config");
		//String path = "D:\\Selenium-WS\\xls-file\\KeywordDriven.xls";
		String path = rb.getString("excelpath");
		// For Reading the Bytes
		FileInputStream fi = new FileInputStream(path);
		HSSFWorkbook workBook = new HSSFWorkbook(fi);
		HSSFSheet sheet = workBook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		while(rows.hasNext()){
			Row currentRow = rows.next();
			if(isFirstRowPass==false){
				isFirstRowPass = true;
				continue;
			}
			Iterator<Cell> cells = currentRow.cellIterator();
			int colCounter = 1;
			CommandClass cmdClass = new CommandClass(); // Creating a Blank CommandClass Object
			while(cells.hasNext()){
				
				Cell currentCell = cells.next();
				// Logic for Filling the CommandClass Object
				if(colCounter == 1){
					cmdClass.command = currentCell.getStringCellValue();
				}
				else
				if(colCounter == 2){
					cmdClass.target = currentCell.getStringCellValue();
				}
				else
				if(colCounter==3){
					cmdClass.value = currentCell.getStringCellValue();
				}
				colCounter++;
			} // Cells Loop Ends Here
			commandList.add(cmdClass);  // Filling the ArrayList with Command Object
		} //Row Loop Ends Here
		workBook.close();
		fi.close();
		return commandList;
		
	}

}
