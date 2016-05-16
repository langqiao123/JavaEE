package org.langqiao.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.langqiao.util.CallResult;
import org.langqiao.util.DynamicSqlParameter;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 所有Action的基类
 */
public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 9199406228043801587L;
	protected static final String JSON = "json";
	// 页面展示的结果集
	protected CallResult result = new CallResult();
	// 页面传递动态参数
	protected DynamicSqlParameter requestParam = new DynamicSqlParameter();
	// 页面传递数组类型的键值对
	protected List<Map<String, Object>> mapList;
	// 分页属性,当前页数
	protected int page = 1;
	// 分页属性,每页显示多少行
	protected int rows = 10;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		requestParam.setPage(page);
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
		requestParam.setRows(rows);
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public void setResult(CallResult result) {
		this.result = result;
	}

	public CallResult getResult() {
		return result;
	}

	public DynamicSqlParameter getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(DynamicSqlParameter requestParam) {
		this.requestParam = requestParam;
	}

	public List<Map<String, Object>> getMapList() {
		return mapList;
	}

	public void setMapList(List<Map<String, Object>> mapList) {
		this.mapList = mapList;
	}
}
