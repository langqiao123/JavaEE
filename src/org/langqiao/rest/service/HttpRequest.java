package org.langqiao.rest.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * @author yhzhu
 *
 */
public class HttpRequest {
	private static final Log LOG = LogFactory.getLog(HttpRequest.class);
	private int timeout = 30;

	private HttpClient httpclient = null;

	public HttpRequest() {
	}

	/**s
	 * Initialize httpclient
	 */
	public void open() {
		httpclient = getDefaultHttpClient();
	}

	/**
	 * destroy resource
	 */
	public void close() {
		httpclient.getConnectionManager().shutdown();
	}

	/**
	 *
	 * @param url
	 *            请求的url
	 * @param param
	 *            请求参数
	 * @return 请求成功后返回一个utf-8的字符串
	 * @throws IOException
	 */
	public String getWebContent(String url, Map<String, String> param)
			throws IOException {
		return getWebContent(url, param, Charset.forName(HTTP.UTF_8));
	}

	/**
	 *
	 * @param param
	 *            url 请求的url
	 * @param os
	 *            http请求成功后写输出流
	 * @throws IOException
	 */
	public void getWebStream(String url, OutputStream os) throws IOException {
		getWebStream(url, null, os);
	}

	/**
	 *
	 * @param param
	 *            url 请求的url
	 * @param param
	 *            http请求参数
	 * @param os
	 *            http请求成功后写输出流
	 * @throws IOException
	 */
	public void getWebStream(String url, Map<String, String> param,
			OutputStream os) throws IOException {
		HttpClient httpclient = getDefaultHttpClient();
		try {
			URI uri = new URI(url);
			HttpGet get = new HttpGet(uri);
			if (null != param) {
				String u = paramToURL(param);
				if (u != null) {
					if (-1 == url.indexOf("?"))
						url += "?" + u;
					else
						url += "&" + u;
				}
				LOG.info("param = " + paramToURL(param));
			}
			HttpParams params = get.getParams();
			params.setParameter(
					org.apache.http.params.CoreProtocolPNames.HTTP_CONTENT_CHARSET,
					HTTP.UTF_8);
			params.setParameter("http.method.retry-handler",
					new DefaultHttpRequestRetryHandler());
			get.setParams(params);
			LOG.info("request url: " + url);
			long begin = System.currentTimeMillis();
			HttpResponse res = httpclient.execute(get);
			long end = System.currentTimeMillis();
			LOG.info("end request url: " + url + " cost: "
					+ String.valueOf(end - begin));
			int code = res.getStatusLine().getStatusCode();
			if (code != HttpStatus.SC_OK) {
				throw new Exception(code + " "
						+ res.getStatusLine().getReasonPhrase());
			}
			HttpEntity entity = res.getEntity();
			if (entity == null) {
				throw new Exception("response does not enclose an entity");
			}
			InputStream is = null;
			String coding = getHeaderValue(res.getAllHeaders(),
					org.apache.http.HttpHeaders.CONTENT_ENCODING);
			if (coding != null && coding.equalsIgnoreCase("gzip"))
				is = new GZIPInputStream(entity.getContent());
			else
				is = entity.getContent();
			try {
				byte[] buf = new byte[8192];
				int len = -1;
				while ((len = is.read(buf)) != -1) {
					os.write(buf, 0, len);
				}
			} finally {
				is.close();
			}
		} catch (Exception e) {
			if (LOG.isDebugEnabled())
			    LOG.warn("request url exception "+url);
			throw new IOException(e);
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	/**
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public byte[] getWebByte(String url) throws IOException{
		return getWebByte(url, null);
	}
	/**
	 * 
	 * @param url
	 * @param param
	 * @return
	 * @throws IOException
	 */
	public byte[] getWebByte(String url, Map<String, String> param) throws IOException {
		HttpClient httpclient = getDefaultHttpClient();
		try {
			URI uri = new URI(url);
			HttpGet get = new HttpGet(uri);
			if (null != param) {
				String u = paramToURL(param);
				if (u != null) {
					if (-1 == url.indexOf("?"))
						url += "?" + u;
					else
						url += "&" + u;
				}
				LOG.info("param = " + paramToURL(param));
			}
			HttpParams params = get.getParams();
			params.setParameter(
					org.apache.http.params.CoreProtocolPNames.HTTP_CONTENT_CHARSET,
					HTTP.UTF_8);
			params.setParameter("http.method.retry-handler",
					new DefaultHttpRequestRetryHandler());
			get.setParams(params);
			LOG.info("request url: " + url);
			long begin = System.currentTimeMillis();
			HttpResponse res = httpclient.execute(get);
			long end = System.currentTimeMillis();
			LOG.info("end request url: " + url + " cost: "
					+ String.valueOf(end - begin));
			int code = res.getStatusLine().getStatusCode();
			if (code != HttpStatus.SC_OK) {
				throw new Exception(code + " "
						+ res.getStatusLine().getReasonPhrase());
			}
			HttpEntity entity = res.getEntity();
			if (entity == null) {
				throw new Exception("response does not enclose an entity");
			}
			InputStream is = null;
			String coding = getHeaderValue(res.getAllHeaders(),
					org.apache.http.HttpHeaders.CONTENT_ENCODING);
			if (coding != null && coding.equalsIgnoreCase("gzip"))
				is = new GZIPInputStream(entity.getContent());
			else
				is = entity.getContent();
			try {
				byte[] buf = new byte[8192];
				ByteArrayOutputStream baos = new ByteArrayOutputStream();			
				int len = -1;
				while ((len = is.read(buf)) != -1) {
					baos.write(buf, 0, len);
				}
				return baos.toByteArray();
			} finally {
				is.close();
			}
		} catch (Exception e) {
			if (LOG.isDebugEnabled())
			    LOG.warn("request url exception "+url);
			throw new IOException(e);
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	/**
	 *
	 * @param url
	 *            请求的url
	 * @param defaultCharset
	 *            httpserver默认的的字符集
	 * @return 请求成功后返回一个httpserver指定字符集 的字符串
	 * @throws IOException
	 */
	public String getWebContent(String url, Map<String, String> param,
			Charset defaultCharset) throws IOException {
		HttpClient httpclient = getDefaultHttpClient();
		try {
			URI uri = new URI(url);
			HttpPost post = new HttpPost(uri);

			if (null != param) {
				List<NameValuePair> nvs = new ArrayList<NameValuePair>();
				for (Entry<String, String> p : param.entrySet()) {
					nvs.add(new BasicNameValuePair(p.getKey(), p.getValue()));
				}
				post.setEntity(new UrlEncodedFormEntity(nvs, HTTP.UTF_8));
				LOG.info("param = " + paramToURL(param));
			}
			HttpParams params = post.getParams();
			params.setParameter(
					org.apache.http.params.CoreProtocolPNames.HTTP_CONTENT_CHARSET,
					HTTP.UTF_8);
			params.setParameter("http.method.retry-handler",
					new DefaultHttpRequestRetryHandler());
			post.setParams(params);
			LOG.info("request url: " + url);
			long begin = System.currentTimeMillis();
			HttpResponse res = httpclient.execute(post);
			long end = System.currentTimeMillis();
			LOG.info("end request url: " + url + " cost: "
					+ String.valueOf(end - begin));
			int code = res.getStatusLine().getStatusCode();
			if (code != HttpStatus.SC_OK) {
				throw new Exception(code + " "
						+ res.getStatusLine().getReasonPhrase());
			}
			HttpEntity entity = res.getEntity();
			if (entity == null) {
				throw new Exception("response does not enclose an entity");
			}
			Charset charSet = getContentCharset(entity, defaultCharset);
			byte[] contentBuf = EntityUtils.toByteArray(entity);
			Header[] headers = res.getAllHeaders();
			processGzipContent(contentBuf, headers);
			String content = new String(contentBuf, charSet);
			return content;
		} catch (Exception e) {
			if (LOG.isDebugEnabled())
			    LOG.warn("request url exception "+url);
			throw new IOException(e);
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	/**
	 *
	 * @param url
	 *            请求的url
	 * @return 请求成功后返回一个httpserver指定字符集 的字符串
	 * @throws IOException
	 */
	public String getWebContent(String url) throws IOException {
		return getWebContent(url, Charset.forName(HTTP.UTF_8));
	}
	/**
	 *
	 * @param url
	 *            请求的url
	 * @param defaultCharset
	 *            httpserver默认的的字符集
	 * @return 请求成功后返回一个httpserver指定字符集 的字符串
	 * @throws IOException
	 */
	public String getWebContent(String url,
			Charset defaultCharset) throws IOException {
		HttpClient httpclient = getDefaultHttpClient();
		try {
			URI uri = new URI(url);
			HttpGet get = new HttpGet(uri);
			
			HttpParams params = get.getParams();
			params.setParameter(
					org.apache.http.params.CoreProtocolPNames.HTTP_CONTENT_CHARSET,
					HTTP.UTF_8);
			params.setParameter("http.method.retry-handler",
					new DefaultHttpRequestRetryHandler());
			get.setParams(params);
			LOG.info("request url: " + url);
			long begin = System.currentTimeMillis();
			HttpResponse res = httpclient.execute(get);
			long end = System.currentTimeMillis();
			
			
			LOG.info("end request url: " + url + " cost: "
					+ String.valueOf(end - begin));
			int code = res.getStatusLine().getStatusCode();
			if (code != HttpStatus.SC_OK) {
				throw new Exception(code + " "
						+ res.getStatusLine().getReasonPhrase());
			}
			HttpEntity entity = res.getEntity();
			if (entity == null) {
				throw new Exception("response does not enclose an entity");
			}
			Charset charSet = getContentCharset(entity, defaultCharset);
			byte[] contentBuf = EntityUtils.toByteArray(entity);
			Header[] headers = res.getAllHeaders();
			processGzipContent(contentBuf, headers);
			String content = new String(contentBuf, charSet);
			return content;
		} catch (Exception e) {
			if (LOG.isDebugEnabled())
			    LOG.warn("request url exception "+url);
			throw new IOException(e);
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	
	public Charset getContentCharset(HttpEntity entity, Charset defaultCharset) {
		if (null != entity.getContentType()) {
			String contentType = entity.getContentType().getValue();
			String[] array = contentType.split("charset=");
			if (array.length == 2) {
				String type = array[1];
				LOG.debug("construct string by charset " + type);
				return Charset.forName(type);
			}
		}
		LOG.debug("use default charset: " + defaultCharset);
		return defaultCharset;
	}

	public String getHeaderValue(final Header[] headers, String name) {
		for (Header h : headers) {
			if (h.getName().equalsIgnoreCase(name)) {
				return h.getValue().trim();
			}
		}
		return null;
	}

	public void processGzipContent(byte[] content, Header[] headers)
			throws IOException {
		if (content == null || headers == null)
			return;
		String coding = getHeaderValue(headers,
				org.apache.http.HttpHeaders.CONTENT_ENCODING);
		if (coding != null && coding.equalsIgnoreCase("gzip")) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			decompress(new ByteArrayInputStream(content), baos);
			content = baos.toByteArray();
		}
	}

	/**
	 * decompress gzip stream
	 *
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public void decompress(InputStream in, OutputStream out) throws IOException {
		InputStream is = new GZIPInputStream(in);
		byte[] b = new byte[4096];
		int r = is.read(b);
		while (r >= 0) {
			out.write(b, 0, r);
			r = is.read(b);
		}
	}

	private String paramToURL(Map<String, String> param) {
		if (param == null)
			return null;
		try {
			StringBuffer sb = new StringBuffer();
			for (Entry<String, String> e : param.entrySet()) {
				if (sb.length() > 0)
					sb.append("&");
				String key = URLEncoder.encode(e.getKey(), HTTP.UTF_8);
				String value = URLEncoder.encode(e.getValue(), HTTP.UTF_8);
				if (!key.trim().equals("") && !value.trim().equals("")) {
					sb.append(key);
					sb.append("=");
					sb.append(value);
				}
			}
			if (sb.length() > 0)
				return sb.toString();
			else
				return null;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	private HttpClient getDefaultHttpClient() {
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter("http.socket.timeout",
				timeout * 1000);
		httpclient.getParams().setParameter("http.connection.timeout",
				timeout * 1000);
		httpclient.getParams().setParameter("http.connection-manager.timeout",
				new Long(timeout * 1000));
		httpclient.getParams().setParameter("http.protocol.head-body-timeout",
				timeout * 1000);
		return httpclient;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getTimeout() {
		return timeout;
	}
}
