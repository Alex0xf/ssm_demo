package com.javasm.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
/**
 * 
 * ClassName: TestJXL 
 * @Description: 测试JXL 只能读写格式为xls的excel 不能读取xlsx 但是效率高一点
 * @author Alex
 * @date 2018年8月10日
 */
public class TestJXL {
	
	public static void main(String[] args) {
		writeExcel();
		//readExcel();
	}
	
	//写数据到excel
	public static void writeExcel(){
		try {
			//要写入的文件地址
			String url = "D://save//write_demo.xls";
			File file = new File(url);
			if(!file.exists()){
				file.createNewFile();
			}
			//创建工作簿对象
			WritableWorkbook workbook=Workbook.createWorkbook(file);
			//创建sheet工作表
			WritableSheet sheet = workbook.createSheet("test_sheet_name", 0);
			//向工作表加数据
			for(int row=0;row<20;row++){
				 for(int col=0;col<5;col++){
					 String str = row+":"+col;
						Label label = new Label(col, row, str);
						sheet.addCell(label);
					}
				}
				workbook.write();//写入
				workbook.close();
		} catch (IOException | WriteException e) {
			e.printStackTrace();
		}
	}
	
	//读取excl
	public static void readExcel(){

		try {
			//文件地址
			String url = "D://save//def.xls";
			//获取file对象
			File file = new File(url);
			if(file.exists()){//如果文件存在
				//文件变成流对象
				//InputStream is = new FileInputStream(file);
				//创建工作簿
				Workbook workbook = Workbook.getWorkbook(file);
				//获得工作表 sheet
				//Sheet[] sheetArray = workbook.getSheets();
				Sheet one = workbook.getSheet(0);//获得第一个工作簿
				//行数
				int rownum = one.getRows();
				//如果行数大于1 继续操作
				if(rownum > 1){
					//循环每一行每一列  单元格
					for(int i=0;i<rownum;i++){
						//获得行里的所有单元格集合
						Cell[] cells = one.getRow(i);
						//获得每一个cell里的值
						for(Cell cell : cells){
							String str = cell.getContents();
							System.out.print(str+"\t");
						}
						System.out.println();
					}
					
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
