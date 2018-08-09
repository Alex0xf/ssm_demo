package com.javasm.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 
 * ClassName: HttpClientDemo 
 * @Description: 测试http连接
 * @author Alex
 * @date 2018年8月9日
 */
public class HttpClientDemo {

	public static void main(String[] args) {
		//testGet();
		testPost();
	}
	
	   //请求哪个地址
	   //static String url = "http://www.baidu.com";
	    static String url = "http://192.168.14.243:8080/myweb3/interface/videosecondcategory";
		public static void testGet(){
			try {
				//创建一个客户端 HttpClient的对象
				CloseableHttpClient httpclient = HttpClients.createDefault();
				//创建一个get方法的连接
				HttpGet get = new HttpGet(url);
				//获得Response对象
				HttpResponse response = httpclient.execute(get);
				//获得response的响应
				HttpEntity entity = response.getEntity();
				//判断请求是否成功  如果成功 响应码200
				if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
					//使用EntityUtil对HttpEntity字符进行处理
					String str = new String(EntityUtils.toByteArray(entity),"UTF-8");
					System.out.println(str);
					//防止TCP状态一致保持在Close_waite 
					get.setHeader("Connection", "close");
					//终止实例
					get.abort();
					//（必须）关闭连接
					httpclient.close();
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public static void testPost(){
			try {
				//创建一个客户端 HttpClient的对象
				CloseableHttpClient httpclient = HttpClients.createDefault();
				//创建一个post方法的连接
				HttpPost post = new HttpPost(url);
				//传递参数
				List<BasicNameValuePair> paramList=new ArrayList<>();
				paramList.add(new BasicNameValuePair("cid","4"));
				paramList.add(new BasicNameValuePair("name","3"));
				paramList.add(new BasicNameValuePair("age","3"));
				paramList.add(new BasicNameValuePair("icon","3"));
				//参数传到post对象中
				post.setEntity(new UrlEncodedFormEntity(paramList,"UTF-8"));
				//获得Response对象
				HttpResponse response = httpclient.execute(post);
				//获得response的响应
				HttpEntity entity = response.getEntity();
				//判断请求是否成功  如果成功 响应码200
				if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
					//使用EntityUtil对HttpEntity字符进行处理
					String str = new String(EntityUtils.toByteArray(entity),"UTF-8");
					System.out.println(str);
					//防止TCP状态一致保持在Close_waite 
					post.setHeader("Connection", "close");
					//终止实例
					post.abort();
					//（必须）关闭连接
					httpclient.close();
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
