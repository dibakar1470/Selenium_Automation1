package Framework.ExcelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {

	public ArrayList<String> getData(String testcase) throws IOException {
		// -- Identify the required column by scanning all the columns in the 1st row.
		// -- In this case we are identifying the FIRST NAME column.
		// -- once the column is identified identify the row and then take the whole data in the row.
				
				ArrayList<String> data_arr = new ArrayList<String>();
				//fileInputStream Argument
				FileInputStream file1 = new FileInputStream("C:\\Users\\dibakar\\Downloads\\Data_Book_Selenium_Script.xlsx");
				XSSFWorkbook wbook = new XSSFWorkbook(file1);
				
				int sheets = wbook.getNumberOfSheets();
				for (int i = 0; i < sheets; i++) {
					if (wbook.getSheetName(i).equalsIgnoreCase("Details")) {
						
						XSSFSheet sheet = wbook.getSheetAt(i);
						
						// -- Identify the required column by scanning all the columns in the 1st row.
						//use the iterator concept of JAVA collections.
						
						Iterator<Row> rows = sheet.iterator();  //sheet is collection of rows
						Row firstrow = rows.next();   //as we need only the 1st row
						Iterator<Cell> ce = firstrow.cellIterator();  //row is collection of cells
						
						int count = 0;
						int column = 0;
						
						//In this case we are identifying the FIRST NAME column.
						while(ce.hasNext()) {
							Cell value = ce.next();
							//String name = value.getStringCellValue();
							//System.out.println(name);
							if(value.getStringCellValue().equalsIgnoreCase("FIRST NAME")) {
								column = count;
							}
							count++;
						}
						//System.out.println(column);
						
						//once the column is identified identify the row and then take the whole data in the row.
						while(rows.hasNext()) {
							Row ro = rows.next();
							if(ro.getCell(column).getStringCellValue().equalsIgnoreCase(testcase)) {
								
								//lets grab all the data of this row
								Iterator<Cell> data = ro.cellIterator();
								while(data.hasNext()) {
									Cell ce1 = data.next();
									if(ce1.getCellTypeEnum() == CellType.STRING) {
										data_arr.add(ce1.getStringCellValue());
									}
									else {
										data_arr.add(NumberToTextConverter.toText(ce1.getNumericCellValue()));
									}
								}
							}
						}
						
					}
				}
				return data_arr;
	}
	
}
