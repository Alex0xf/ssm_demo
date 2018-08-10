package com.javasm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * ClassName: TestPOI 
 * @Description: 测试POI xls、xlsx等格式均可以读写
 * @author Alex
 * @date 2018年8月10日
 */
public class TestPOI {

	public static void main(String[] args) {
		//readExcel();
		writeExcel();
	}
	//写数据到Excel
	//HSSFWorkbook、HSSFSheet、HSSFRow生成xls文件
	//XSSFWorkbook、XSSFSheet、XSSFRow生成xlsx文件
	public static void writeExcel(){
		try {
			String url = "D://save//poi_test_write.xlsx";
			//获得file对象
			File file = new File(url);
			//判断文件是否存在 不存在就创建
			if(!file.exists()){
				file.createNewFile();
			}
			//创建输出的文件对象
			FileOutputStream fos= new FileOutputStream(file);
			//创建工作簿
			XSSFWorkbook workbook = new XSSFWorkbook();
			//创建工作表
			XSSFSheet sheet = workbook.createSheet("sheet");
			//向工作表中写数据
			for(int row=0;row < 20;row ++){
				//行
				XSSFRow xssfRow = sheet.createRow(row);
				for(int col=0;col< 10;col++){
					Cell cell = xssfRow.createCell(col);
					cell.setCellValue(row);
				}
			}
			workbook.write(fos);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//读取excel
	public static void readExcel(){
		try {
			String url = "D://save//poi_test_read.xlsx";
			//获得file对象
			File file = new File(url);
			//因为是读文件所以默认文件是存在的 不再判断文件是否存在了
			//获得工作簿
			Workbook workbook = WorkbookFactory.create(file);
			//获得工作表的个数
			int sheetCount = workbook.getNumberOfSheets();
			//遍历工作表
			for(int i=0;i<sheetCount;i++){
				//获得工作表
				Sheet sheet = workbook.getSheetAt(i);
				//获得行数
				int rownum = sheet.getLastRowNum() + 1;
				if(rownum > 1){
					//获得row对象
					Row tmprow = sheet.getRow(0);//拿到第一行 为了获取列数
					if(tmprow != null){//防止空指针异常
						//第一行的列数 认为第一行的列数代表整个工作表的列数
						int colnum = tmprow.getPhysicalNumberOfCells();
						//读取数据
						for(int row = 0;row<rownum;row++){
							Row r = sheet.getRow(row);//行对象
							for(int col=0;col<colnum;col++){//循环列数
								Cell cell = r.getCell(col);//行与列的交叉 就是单元格
								int type = cell.getCellType();//当前单元格的数据类型
								if(type == Cell.CELL_TYPE_STRING){
									//String
									System.out.print(cell.getStringCellValue()+"\t");
								}else if(type == Cell.CELL_TYPE_NUMERIC){
									System.out.print(cell.getNumericCellValue()+"\t");
								}
							}
							System.out.println();
						}
					}
				}
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
