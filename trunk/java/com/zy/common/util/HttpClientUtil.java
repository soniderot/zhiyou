package com.zy.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpProtocolParams;
import org.apache.log4j.Logger;

public class HttpClientUtil {
	public static String getFromHttp(String url, String charset) {
		Logger logger = Logger.getLogger("HttpClientUtil");
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, charset);
		HttpGet httpget = new HttpGet(url);
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
			return buffer.toString();
		} catch (ClientProtocolException e) {
			logger.error("Http request error (ClientProtocolException) in HttpClientUtil.java");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Http request error (IOException) in HttpClientUtil.java");
			e.printStackTrace();
		} finally {
			httpget.abort();
			httpclient.getConnectionManager().shutdown();
		}
		return null;
	}
}
