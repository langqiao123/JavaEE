package org.langqiao.autobuildsql;

/**

 * @version: 1.1
 
 * @Time: 2005.03.02
 
 */
import java.util.*;
import javax.servlet.http.HttpServletRequest; 

public class PageUtil {
 
	private HttpServletRequest request = null ;
 
	public PageUtil(){
 
	}
 
	public void init(HttpServletRequest _request){
		this.request = _request ;
	}
 
	public void clear(){
		if(this.request != null){
			this.request = null ;
		}
	}
 
	public String get(String elementName){
		if(request == null || request.getParameter(elementName) == null){
			return "";
		}else{
			return request.getParameter(elementName);
		}
	}
 
	public String get(HttpServletRequest _request,String elementName){
		init(_request);
		return get(elementName);
	}
 
	public String getSQL(HttpServletRequest _request){
		init(_request);
		return getSQL();
	}
 
	public String getSQL(){
		String sqlstr = "";
		String c_table = get("c_table");
		String c_genre = get("c_genre");
		String c_where = get("c_where");
 
		if(c_genre == null || c_genre.equals("")){
			return "the action is null/empty";
		}
 
		if(c_table == null || c_table.equals("")){
			return "unknow table/empty" ;
		}
 
		if(c_genre.equalsIgnoreCase("INSERT")){
			java.util.Enumeration arg_names = request.getParameterNames();
			String colstr = "",valstr = "";
			String arg_name,pre_name,end_name ;
			while(arg_names.hasMoreElements()){
				arg_name = String.valueOf(arg_names.nextElement());
				if(arg_name.length() < 2){
					continue;
				}
				pre_name = arg_name.substring(0,2);
				end_name = arg_name.substring(2);
				if(pre_name.equalsIgnoreCase("i_")){
					colstr = colstr+","+end_name;
					if(get(arg_name).equals("")){
						valstr = valstr+",NULL";
					}else{
						valstr = valstr + "," + String.valueOf(get(arg_name));
					}
				}else if(pre_name.equalsIgnoreCase("s_")){
					colstr = colstr+","+end_name;
					if(get(arg_name).equals("")){
						valstr = valstr+",NULL";
					}else{
						valstr = valstr+",'"+get(arg_name).replaceAll("'","''")+"'";
					}
				}
			}
			if(!colstr.equals("")){
			    colstr = colstr.substring(1);
			    valstr = valstr.substring(1);
			}
		    sqlstr = "INSERT INTO "+c_table+" ("+colstr+") VALUES ("+valstr+")";
		    return sqlstr;
	    } else if(c_genre.equalsIgnoreCase("UPDATE")){
	    	java.util.Enumeration arg_names = request.getParameterNames();
	    	String colstr = "";
	    	String arg_name,pre_name,end_name ;
	    	while(arg_names.hasMoreElements()){
	    		arg_name = String.valueOf(arg_names.nextElement()).trim();
	    		if(arg_name.length() < 2){
	    			continue;
	    		}
	    		pre_name = arg_name.substring(0,2);
	    		end_name = arg_name.substring(2);
	    		if(pre_name.equalsIgnoreCase("i_")){
	    			if(get(arg_name).equals("")){
	    				colstr += ","+end_name+"=NULL";
	    			} else{
	    				colstr += ","+end_name+"="+get(arg_name);
	    			}
	    		} else if(pre_name.equalsIgnoreCase("s_")){
	    			if(get(arg_name).equals("")){
	    				colstr += ","+end_name+"="+get(arg_name);
	    			} else{
	    				colstr += ","+end_name+"='"+get(arg_name).replaceAll("'","''")+"'";
	    			}
	    		}
	    	}
		    if(!colstr.equals("")){
		    	colstr = colstr.substring(1);
		    }
		    sqlstr = "UPDATE "+c_table+" SET "+colstr;
		    if(!c_where.equals("")){
		    	sqlstr += " WHERE "+c_where;
		    }
		    return sqlstr;
	    } else if(c_genre.equalsIgnoreCase("DELETE")){
	    	sqlstr = "DELETE FROM "+c_table;
	    	if(c_where != null && !c_where.equals("")){
	    		sqlstr += " WHERE "+c_where;
	    	}
	    } else{
	    	//com.river.debug.Debug.show("unknow action type : "+c_genre);
	    	return null;
	    }
	    return sqlstr;
	}
	    
	public String toString(){
		return "version 1.0, date 2005.03.02, author river";
    }
	
}