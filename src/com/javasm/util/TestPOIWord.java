package com.javasm.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
/**
 * 
 * ClassName: TestPOIWord 
 * @Description: 测试POI方式来完成word的导出
 * @author Alex
 * @date 2018年8月10日
 */
public class TestPOIWord {

	public static void main(String[] args) {
		writeWord();
	}
	
	public static void writeWord1(String path, String content) {
        try {
            //文档对象
            POIFSFileSystem fs = new POIFSFileSystem();
            DirectoryEntry directory = fs.getRoot();
            //输出流
            FileOutputStream ostream = new FileOutputStream(path);
            //内容文字包装起来
            byte b[] = content.getBytes("UTF-8");
            ByteArrayInputStream bais = new ByteArrayInputStream(b);
            //文本写入文档
            //DocumentEntry de = directory.createDocument("WordDocument", bais);
            directory.createDocument("WordDocument", bais);
            //文档中写入流
            fs.writeFilesystem(ostream);
            //内容写入关闭
            bais.close();
            ostream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

	public static void writeWord(){
        try {
            XWPFDocument document= new XWPFDocument();//文档对象
            //输出流
            FileOutputStream out = new FileOutputStream(new File("D://save//test3.doc"));
            //添加标题
            XWPFParagraph titleParagraph = document.createParagraph();
            //设置段落居中
            titleParagraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun titleParagraphRun = titleParagraph.createRun();
            titleParagraphRun.setText("尚马教育");
            titleParagraphRun.setColor("000000");
            titleParagraphRun.setFontSize(30);
            //段落
            XWPFParagraph firstParagraph = document.createParagraph();
            XWPFRun run = firstParagraph.createRun();
            run.setText("有背景色的文字");
            run.setColor("696969");
            run.setFontSize(16);
            //设置段落背景颜色
            CTShd cTShd = run.getCTR().addNewRPr().addNewShd();
            cTShd.setVal(STShd.CLEAR);
            cTShd.setFill("97FFFF");
            //换行
            XWPFParagraph paragraph1 = document.createParagraph();
            XWPFRun paragraphRun1 = paragraph1.createRun();
            paragraphRun1.setText("\r");
            //基本信息表格
            XWPFTable infoTable = document.createTable();
            //去表格边框
            infoTable.getCTTbl().getTblPr().unsetTblBorders();
            //列宽自动分割
            CTTblWidth infoTableWidth = infoTable.getCTTbl().addNewTblPr().addNewTblW();
            infoTableWidth.setType(STTblWidth.DXA);
            infoTableWidth.setW(BigInteger.valueOf(9072));
            //表格第一行
            XWPFTableRow infoTableRowOne = infoTable.getRow(0);
            infoTableRowOne.getCell(0).setText("职位");
            infoTableRowOne.addNewTableCell().setText("Java 开发工程师");
            //表格第二行
            XWPFTableRow infoTableRowTwo = infoTable.createRow();
            infoTableRowTwo.getCell(0).setText("姓名");
            infoTableRowTwo.getCell(1).setText("张三");
            //两个表格之间加个换行
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun paragraphRun = paragraph.createRun();
            paragraphRun.setText("\r");
            //工作经历表格
            XWPFTable ComTable = document.createTable();
            //列宽自动分割
            CTTblWidth comTableWidth = ComTable.getCTTbl().addNewTblPr().addNewTblW();
            comTableWidth.setType(STTblWidth.DXA);
            comTableWidth.setW(BigInteger.valueOf(9072));
            //表格第一行
            XWPFTableRow comTableRowOne = ComTable.getRow(0);
            comTableRowOne.getCell(0).setText("开始时间");
            comTableRowOne.addNewTableCell().setText("结束时间");
            comTableRowOne.addNewTableCell().setText("公司名称");
            comTableRowOne.addNewTableCell().setText("职位");
            //表格第二行
            XWPFTableRow comTableRowTwo = ComTable.createRow();
            comTableRowTwo.getCell(0).setText("2017-09-06");
            comTableRowTwo.getCell(1).setText("至今");
            comTableRowTwo.getCell(2).setText("尚马科技");
            comTableRowTwo.getCell(3).setText("Java开发工程师");

            document.write(out);
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
