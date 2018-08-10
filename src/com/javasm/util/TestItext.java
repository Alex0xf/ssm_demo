package com.javasm.util;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;
/**
 * 
 * ClassName: TestItext 
 * @Description: 测试Itext方式来完成word的导出
 * @author Alex
 * @date 2018年8月10日
 */
public class TestItext {

	public static void main(String[] args) {
		writeWord();
	}

	public static void writeWord() {
		// 创建word文档,并设置纸张的大小
		// com.lowagie.text.Document com.lowagie.text.PageSize
		Document document = new Document(PageSize.A4);
		try {
			// com.lowagie.text.rtf.RtfWriter2
			// 输出流
			FileOutputStream fos = new FileOutputStream("D://save//word_TestExpWord.doc");
			RtfWriter2.getInstance(document, fos);
			// 打开文档
			document.open();
			// 设置文档头
			Paragraph ph = new Paragraph();
			Font f = new Font();// com.lowagie.text.Font
			Paragraph p = new Paragraph("尚马教育", new Font(Font.NORMAL, 18, Font.BOLDITALIC, new Color(0, 0, 0)));// java.awt.Color
			p.setAlignment(1);
			document.add(p);
			ph.setFont(f);
			// 创建有三列的表格
			Table table = new Table(4);// com.lowagie.text.Table
			document.add(new Paragraph("生成表格"));
			table.setBorderWidth(1);
			table.setBorderColor(Color.BLACK);
			table.setPadding(0);
			table.setSpacing(0);
			// 添加表头的元素
			Cell cell = new Cell("表头");// 单元格
			cell.setHeader(true);
			cell.setColspan(3);// 设置表格为三列 合并列
			cell.setRowspan(3);// 设置表格为三行 合并行
			table.addCell(cell);// 单元格写入table对象
			table.endHeaders();// 表头结束
			// 表格的主体
			cell = new Cell("Example cell 2");
			cell.setRowspan(2);// 当前单元格占两行,纵向跨度
			table.addCell(cell);
			table.addCell("1,1");
			table.addCell("1,2");
			table.addCell("1,3");
			table.addCell("1,4");
			table.addCell("1,5");
			document.add(table);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
