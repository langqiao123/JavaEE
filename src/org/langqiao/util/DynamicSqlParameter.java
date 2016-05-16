package org.langqiao.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author Administrator
 * 封装页面传递的动态参数的公共类
 */
public class DynamicSqlParameter implements Serializable{
	private static final long serialVersionUID = 1L;
	private Map<String, String> like;
	private Map<String, String> equal;
	private Map<String, String> notequal;
	private Map<String, String> startwith;
	private Map<String, String> endwith;
	private Map<String, Object> inMap;
	private Map<String, Object> notInMap;
	private List<Rule> rules;
	private String op;
	private Map<String, Object> updateValue;
	private String noId;
	private int page;
	private int rows;
	private int pagesize = 1;
	private String order;
	private String sort;
	
	public static DynamicSqlParameter getUpdateDynamicSqlParameter(String equalKey, String equalIdValue, Map<String, Object> updateValueMap){
	    DynamicSqlParameter parameter = null;
		if ((null == equalKey) || (null == equalIdValue) || (null == updateValueMap) || ("".equals(equalKey)) || ("".equals(equalIdValue))) {
		   return parameter;
		}
		
		parameter = new DynamicSqlParameter();
		Map equalMap = new HashMap();
		
    	equalMap.put(equalKey, equalIdValue);
		
		parameter.setEqual(equalMap);
		parameter.setUpdateValue(updateValueMap);
		return parameter;
	}
	
	public String getNoId() {
	    return this.noId;
	}
	
	public void setNoId(String noId) {
	    this.noId = noId;
	}
	
	public int getStartNum(){
	    return (this.page - 1) * this.rows;
	}
	
	public int getEndNum(){
	    return getStartNum() + this.pagesize * this.rows;
	}
	
	public int getPage() {
	    return this.page;
	}
	
	public void setPage(int page) {
	    this.page = page;
	}
	
	public int getRows() {
	    return this.rows;
	}
	
	public void setRows(int rows) {
	    this.rows = rows;
	}
	
    public int getPagesize() {
	    return this.pagesize;
	}
	
	public void setPagesize(int pagesize) {
	    this.pagesize = pagesize;
	}
	
	public String getOrder() {
	    return this.order;
	}
	
	public void setOrder(String order){
	    this.order = order;
	}
	
	public String getSort(){
	    return this.sort;
	}
	
	public void setSort(String sort) {
	    this.sort = sort;
	}
	
	public Map<String, Object> getUpdateValue() {
	    return this.updateValue;
	}
	
	public void setUpdateValue(Map<String, Object> updateValue) {
	    this.updateValue = updateValue;
	}
	
	public Map<String, String> getLike(){
	    return this.like;
	}
	
	public void setLike(Map<String, String> like) {
	    this.like = like;
	}
	
	public Map<String, String> getEqual() {
	    return this.equal;
	}
	
	public void setEqual(Map<String, String> equal) {
	    this.equal = equal;
	}
	
	public Map<String, Object> getInMap() {
	    return this.inMap;
	}
	
	public void setInMap(Map<String, Object> inMap) {
	    this.inMap = inMap;
	}
	
	public Map<String, Object> getNotInMap() {
	    return this.notInMap;
	}
	
	public void setNotInMap(Map<String, Object> notInMap) {
	    this.notInMap = notInMap;
	}
	
	public Map<String, String> getNotequal() {
	    return this.notequal;
	}
	
	public void setNotequal(Map<String, String> notequal) {
	    this.notequal = notequal;
	}
	
	public Map<String, String> getStartwith() {
	    return this.startwith;
	}
	
	public void setStartwith(Map<String, String> startwith) {
	    this.startwith = startwith;
	}
	
	public Map<String, String> getEndwith() {
	    return this.endwith;
	}
	
	public void setEndwith(Map<String, String> endwith) {
	    this.endwith = endwith;
	}
	
	public List<Rule> getRules(){
	    return this.rules;
	}
	
	public void setRules(List<Rule> rules) {
	    this.rules = rules;
	}
	
	public String getOp() {
	    return this.op;
	}
	
	public void setOp(String op) {
	    this.op = op;
	}
	
	public String toString(){
	    StringBuffer buff = new StringBuffer();
	    if ((this.like != null) && (this.like.size() != 0)) buff.append("[包含条件:").append(this.like).append("]");
	    if ((this.equal != null) && (this.equal.size() != 0)) buff.append("[等于条件:").append(this.equal).append("]");
	    if ((this.notequal != null) && (this.notequal.size() != 0)) buff.append("[不等于条件:").append(this.notequal).append("]");
	    if ((this.startwith != null) && (this.startwith.size() != 0)) buff.append("[以...条件开始:").append(this.startwith).append("]");
	    if ((this.endwith != null) && (this.endwith.size() != 0)) buff.append("[以...条件结束:").append(this.endwith).append("]");
	    if ((this.inMap != null) && (this.inMap.size() != 0)) buff.append("[在...中条件:").append(this.inMap).append("]");
	    if ((this.notInMap != null) && (this.notInMap.size() != 0)) buff.append("[不在...中条件:").append(this.notInMap).append("]");
	
	     return buff.toString();
	}
}
