package org.langqiao.rest.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RMCCOSService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String test(@QueryParam("data") String data) {
		
		return "rest testing query param: [data = "+data+"]" ;
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/testFormPost")
	@SuppressWarnings("unchecked")
	public String testFormPost(@FormParam("data") String data){
		try {
			/*JSONObject jData=JSONObject.fromObject(data);
			TblMntrBasic mntrBasic=new TblMntrBasic();
			mntrBasic.setId(jData.getString("id"));
			JSONArray jArr=jData.getJSONArray("param");
			Iterator<JSONObject> iter=jArr.iterator();
			 List<TblMntrDeviceParm> mntrDeviceParmList=new ArrayList<TblMntrDeviceParm>();
			while(iter.hasNext()){
				mntrDeviceParmList.add((TblMntrDeviceParm)JSONObject.toBean(iter.next(), TblMntrDeviceParm.class));
			}
			CollectParam collectParam = getCollectParamBean();
			boolean result=collectParam.updateMntrIndex(cityName, systemName, mntrBasic, mntrDeviceParmList);
			if(result){
				JSONObject json = new JSONObject();
				json.put("data", data);
				Pair<String, JSONObject> ret = new ImmutablePair<String, JSONObject>("object", json );
				res.setData(ret);
			}*/
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return res.toJson().toString();
		return data;
	}
	
	/*@POST
	@Path("/posttest")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String simplePostTest() {
		return "test post ok ";
	}*/
	
	@POST
	@Path("/posttest")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String simplePostTest(){
		return "OK";
	}

	
	
	/*public String simplePostTest(HttpRequest request) {
		HttpParams result=request.getParams();
		System.out.println(result.toString());
		return "post ok";
	}*/

	
	public static void main(String[] args) {
		/*HttpRequest client = new HttpRequest();
		Map<String, String> param = new HashMap<String, String>();
		String baseURL = "http://127.0.0.1:8082/RestTest/service";
		try {
			param.put("data","{\"id\":\"4028fbca48435f8201484380b31e0012\",\"param\":[{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"1\",\"id\":\"4028fbca489cb67d01489cbfaa4e000e\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"10\",\"id\":\"4028fbca489cb67d01489cbfaa500017\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"2\",\"id\":\"4028fbca489cb67d01489cbfaa4e000f\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"3\",\"id\":\"4028fbca489cb67d01489cbfaa4e0010\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"4\",\"id\":\"4028fbca489cb67d01489cbfaa4f0011\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"4028fbca4887e74a014887f9d36f000b\",\"id\":\"4028fbca489cb67d01489cbfaa49000d\",\"mntrPeriod\":88888,\"modTime\":null,\"modifier\":\"\",\"status\":\"1\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"5\",\"id\":\"4028fbca489cb67d01489cbfaa4f0012\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"6\",\"id\":\"4028fbca489cb67d01489cbfaa4f0013\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"7\",\"id\":\"4028fbca489cb67d01489cbfaa4f0014\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"8\",\"id\":\"4028fbca489cb67d01489cbfaa500015\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"9\",\"id\":\"4028fbca489cb67d01489cbfaa500016\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0}]}");
			String res = client.getWebContent(baseURL+"/test", param);
			System.out.println(res);
			res = client.getWebContent(baseURL+"/update_device", param);
			System.out.println(res);
			res = client.getWebContent(baseURL+"/delete_device?id=id");
			System.out.println(res);
			res = client.getWebContent(baseURL+"/add_mnt_idx", param);
			System.out.println(res);
			res = client.getWebContent(baseURL+"/update_mnt_idx", param);
			System.out.println(res);
			res = client.getWebContent(baseURL+"/delete_mnt_idx?id=id");
			System.out.println(res);
			String res = client.getWebContent(baseURL+"/posttest", param);
			//String res = client.getWebContent(baseURL+"/test?data=id");
			System.out.println(res);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		testFormPostData();
	}
	
	//测试get方式访问
	public static void testRestGet(){
		HttpRequest client = new HttpRequest();
		String baseURL = "http://192.168.10.240:8082/RestTest/service";
		String res;
		try {
			res = client.getWebContent(baseURL+"/test?data=id");
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//测试post方式访问
	public static void testFormPostData(){
		HttpRequest client = new HttpRequest();
		Map<String, String> param = new HashMap<String, String>();
		//String baseURL = "http://192.168.10.240:8082/RestTest/service";
		String baseURL = "http://10.31.154.48:9000/meihui/posttest";
		String res;
		try {
			param.put("data","{\"id\":\"4028fbca48435f8201484380b31e0012\",\"param\":[{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"1\",\"id\":\"4028fbca489cb67d01489cbfaa4e000e\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"10\",\"id\":\"4028fbca489cb67d01489cbfaa500017\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"2\",\"id\":\"4028fbca489cb67d01489cbfaa4e000f\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"3\",\"id\":\"4028fbca489cb67d01489cbfaa4e0010\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"4\",\"id\":\"4028fbca489cb67d01489cbfaa4f0011\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"4028fbca4887e74a014887f9d36f000b\",\"id\":\"4028fbca489cb67d01489cbfaa49000d\",\"mntrPeriod\":88888,\"modTime\":null,\"modifier\":\"\",\"status\":\"1\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"5\",\"id\":\"4028fbca489cb67d01489cbfaa4f0012\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"6\",\"id\":\"4028fbca489cb67d01489cbfaa4f0013\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"7\",\"id\":\"4028fbca489cb67d01489cbfaa4f0014\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"8\",\"id\":\"4028fbca489cb67d01489cbfaa500015\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0},{\"basicId\":\"4028fbca48435f8201484380b31e0012\",\"bid\":\"9\",\"id\":\"4028fbca489cb67d01489cbfaa500016\",\"mntrPeriod\":0,\"modTime\":null,\"modifier\":\"\",\"status\":\"0\",\"version\":0}]}");
			res = client.getWebContent(baseURL, param);
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
