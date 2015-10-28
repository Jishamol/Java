import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ExcelReader {
	
	// this method is used to read the data from excel file and store the result in 2-D array and return the result
	public Object[][] readDataFromExcel() throws Exception{
		boolean isFirstRowSkip = false;
		Object array[][]=new Object[3][2];
		String excelPath = "E:\\Selenium-OctBatch11to1\\DemoProject\\xls\\UserData.xls";
		// It is a Predefine in Java and it is used to read the bytes
		FileInputStream fi = new FileInputStream(excelPath);
		// Read the WorkBook
		HSSFWorkbook workBook = new HSSFWorkbook(fi);
		HSSFSheet sheet = workBook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		int rowNumber = 0;
		// rows.hasNext() check is there any row in a sheet
		// this loop is for row traverse
		while(rows.hasNext()){
			// rows.next() method give the current row and then move to the next row
			Row currentRow = rows.next();
			Iterator<Cell> cells = currentRow.cellIterator();
			int colNumber = 0;
			Cell newCell = currentRow.createCell(2);
			newCell.setCellValue("Pass");
			if(isFirstRowSkip==false){
				isFirstRowSkip = true;
				continue; // continue is keyword in Java and it skip the current row
			}
			// this loop is for column (cell) traverse
			while(cells.hasNext()){
				Cell currentCell = cells.next();
				if(currentCell.getCellType()==Cell.CELL_TYPE_BLANK){
					
				}
				else
				if(currentCell.getCellType()==Cell.CELL_TYPE_STRING){
					array[rowNumber][colNumber] = currentCell.getStringCellValue();
				}
				else
				if(currentCell.getCellType()==Cell.CELL_TYPE_NUMERIC){	
					
				}
				colNumber++;
				
			} // Cell loop close here
			rowNumber++;
		} // Row Loop Close here
		FileOutputStream fo = new FileOutputStream(excelPath);
		workBook.write(fo);
		workBook.close();
		return array;
		
	}

}
