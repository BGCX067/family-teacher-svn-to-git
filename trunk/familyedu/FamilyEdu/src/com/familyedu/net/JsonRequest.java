package com.familyedu.net;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * 联网
 * 
 */
public class JsonRequest {

	public String httpGet(String url) {
		Log.d("httpGet", "request url-->" + url);
		// 创建请求HttpClient客户
		HttpClient httpClient = new DefaultHttpClient();
		try {
			// 创建请求的
			HttpGet get = new HttpGet(new URI(url));
			// 发get请求
			HttpResponse httpResponse = httpClient.execute(get);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			Log.d("httpGet", "statusCode-->" + statusCode);
			// 如果服务成功返回响应
			if (statusCode == 200) {
				HttpEntity entity = httpResponse.getEntity();
				if (entity != null) {
					// 获取服务器响应的json字符
					String json = EntityUtils.toString(entity);
					return json;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String httpPost(String url, Map<String, String> params) {
		Log.d("httpPost", "request url-->" + url);
		Log.d("httpPost", "request params-->" + params);
		// 创建请求HttpClient客户
		HttpClient httpClient = new DefaultHttpClient();
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		// 获得请求参数
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		try {
			HttpPost post = new HttpPost(new URI(url));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs, HTTP.UTF_8);
			post.setEntity(entity);
			// 发post请求
			HttpResponse httpResponse = httpClient.execute(post);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			Log.d("httpPost", "statusCode-->" + statusCode);
			// 如果服务成功返回响应
			if (statusCode == 200) {
				HttpEntity msg = httpResponse.getEntity();
				if (entity != null) {
					// 获取服务器响应的json字符
					String json = EntityUtils.toString(msg);
					return json;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
