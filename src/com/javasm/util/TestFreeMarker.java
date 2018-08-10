package com.javasm.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * 
 * ClassName: TestFreeMarker 
 * @Description: 利用freeMarker模板技术生成word文档 可以生成任何格式的文本  html java代码等
 * API：freemarker.foofun.cn/ref.html
 * @author Alex
 * @date 2018年8月10日
 */
public class TestFreeMarker {

	public static void main(String[] args) {
		TestFreeMarker tf = new TestFreeMarker();
		tf.writeWord();
	}
	
	public void writeWord(){
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("name","小明同学");
            map.put("title","尚马教育的标题");
            map.put("department","尚马教育的清洁部");
            Map<String,Object> dateMap = new HashMap<String, Object>();
            dateMap.put("year", "2018");
            dateMap.put("month", "8");
            dateMap.put("day", "10");
            map.put("d",dateMap);
            
            Writer out  = new OutputStreamWriter(new FileOutputStream("D:\\free_marker_my.doc"), "UTF-8");
            //freemarker.template.Configuration
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("UTF-8");//设置编码
            //类加载器，设置xml模板文件的路径
            configuration.setClassForTemplateLoading(this.getClass(), "/com/javasm/util/word");
            //获取模板对象 传入模板名称
            //Template t = configuration.getTemplate("test.xml");
            Template t = configuration.getTemplate("free_marker_my.xml");
            t.process(map, out);//模板中传入数据
            out.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

}
