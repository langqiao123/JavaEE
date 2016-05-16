package org.langqiao.util;

import java.io.Serializable;
import java.util.List;

/**
 * 前台页面请求结果封装类
 */
public class CallResult implements Serializable{
	private static final long serialVersionUID = -52383815040632810L;
	//访问结果,0:成功,1:失败
	private String code = "1";
	
	//返回非集合类型对象
	private Object row;
	
	//返回集合类型对象
	private List<? extends Object> rows;
	
	//信息数
	private long total;	
	
	//描述信息
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getRow() {
		return row;
	}
	public void setRow(Object row) {
		this.row = row;
	}
	public List<? extends Object> getRows() {
		return rows;
	}
	public void setRows(List<? extends Object> rows) {
		this.rows = rows;
	}	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
