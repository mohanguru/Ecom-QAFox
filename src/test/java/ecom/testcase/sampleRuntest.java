package ecom.testcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class sampleRuntest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String excelPath = System.getProperty("user.dir")
		        + "/src/test/resources/testData/dataProvider/loginData_DP.xlsx";
		FileInputStream file=new FileInputStream(excelPath);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet ws=wb.getSheetAt(0);
		int row=ws.getLastRowNum();
		int col=ws.getRow(0).getLastCellNum();
		Object xlsxData[][] = new Object[row][col];
		
		for(int r=1;r<=row;r++) {
			XSSFRow curRow=ws.getRow(r);
			for(int c=0;c<col;c++) {
			XSSFCell curCell=curRow.getCell(c);
			String xlval=curCell.toString();
			xlsxData[r-1][c]=xlval;
			}
		}
		
		System.out.println(Arrays.deepToString(xlsxData));

        wb.close();
        file.close();
	}

}
