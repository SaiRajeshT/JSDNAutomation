package com.jamcracker.utilities;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetApiResponse {
	static String jsdnToken;
	public static void main(String[] args)
	{
		//jsdnToken =GetApiResponse.getApiToken("http://clrstore.jamcracker.com:8080", "hugowda.gmail.com", "Root123#", "hugowda") ;
		jsdnToken =GetApiResponse.getApiToken("http://www.targetmp.com:8080", "vijay720425a.gmail.com", "Target12345#", "targetmp") ;
		getAFMDForReseller("http://www.targetmp.com:8080", "microsoft365e3", "microsoft365e3", "hugowda", "hugowda@gmail.com", "adminPassword", jsdnToken);
	}
	 
	public static  String getAFMDForReseller(String mktplaceUrl, String serviceCode, String offerCode, String companyAcronym, String email, String fieldName1,String jsdnToken ){
		  
		  String responseAsString= null;
		  String msMPNID = null;
		  String requestUrl = String.format("%s%s%s%s", mktplaceUrl , "/api", "/1.0","/catalog/afmddata");
		 
		//  LOG.debug("ReequestUrl for getAFMDForReseller Method= " + requestUrl);
		 
		  final HttpClient httpclient = new HttpClient();
		  final PostMethod post = new PostMethod(requestUrl);
		  
		  post.addRequestHeader("Accept", "application/json");
		  post.addRequestHeader("Content-Type", "application/json");
		  post.addRequestHeader("X-Auth-Token", jsdnToken);
		  
		  JSONObject json = new JSONObject();
		  JSONObject fields = new JSONObject();
		  JSONArray field = new JSONArray(); //To keep array values
		  JSONObject fieldval = new JSONObject();
		  
		  try {
		   fieldval.put("name", fieldName1);  
		   field.put(fieldval); //keeping value inside Json array
		   fields.put("serviceCode", serviceCode);
		   fields.put( "offerCode", offerCode);
		   fields.put("actorType", "C");
		   fields.put("companyAcronym", companyAcronym);
		   fields.put("email", email);
		   fields.put("field", field); //keeping field json array object to fields json object
		   json.put("Fields", fields);
		  // LOG.debug("Request json format and Value for getAFMDForReseller = "+ json.toString());
		   
		   try {
		    post.setRequestEntity(new StringRequestEntity(json.toString(), "application/json", "UTF-8"));
		   } catch (final UnsupportedEncodingException e1) {
		   }
		  
		   try {
		    httpclient.executeMethod(post);
		    responseAsString = post.getResponseBodyAsString();
		   } catch (HttpException e1) {
		   // LOG.error(e1,e1);
		   } catch (IOException e1) {
		  //  LOG.error(e1,e1);
		   }
		 //  LOG.debug("Response Body String of Get ADFMD for Reseller =" + responseAsString);
		   
		    
		     JSONObject result = new JSONObject(responseAsString);
		    try {
		     
		     JSONArray jsonsry = result.getJSONObject("Fields").getJSONArray("field");
		     for (int i = 0; i < jsonsry.length(); ++i) {
		         JSONObject rec = jsonsry.getJSONObject(i);
		         String value = rec.getString("name");
		       //  LOG.debug("Required field Name to fetch"+ fieldName1);
		         if (value.equals(fieldName1)){
		          msMPNID = (rec.getString("value"));
		      //    LOG.debug("msMPNID Value = "+ msMPNID);
		         }
		        
		      }
		    } catch (JSONException e) {
		     //LOG.error("JSONException getAFMDForReseller",e);
		    }
		   // LOG.debug("msMPNID Value at getAFMDForReseller= "+ msMPNID);
		    
		    
		  }catch (JSONException e) {
		 //  LOG.error(" Error getAFMDForReseller",e);  
		   }
		  return msMPNID; 
		 }

	public static String getApiToken(String mktplaceUrl,String mktPlaceAdminUserName, String mktPlaceAdminPassword,String mktPlaceAcronym){
		  
		 // UtilityHelper helper = new UtilityHelper();
		  String jsdnToken =null;

		 
		  String requestUrl = String.format("%s%s%s%s", mktplaceUrl , "/api", "/v2.0","/tokens");
		  System.out.println(requestUrl);

		 // LOG.debug("Request URL at getApiToken Method " + requestUrl);

		  final HttpClient httpclient = new HttpClient();
		  final PostMethod post = new PostMethod(requestUrl);
		  
		  post.addRequestHeader("Accept", "application/json");
		  post.addRequestHeader("Content-Type", "application/json");
		  
		  try {
		  final JSONObject credentils = new JSONObject();
		  final JSONObject pwdcredentils = new JSONObject();
		  final JSONObject authcreden = new JSONObject();
		  
		  credentils.put("username", mktPlaceAdminUserName);
		  credentils.put("password",mktPlaceAdminPassword );
		  
		  pwdcredentils.put("passwordCredentials", credentils);
		  pwdcredentils.put("tenantId", mktPlaceAcronym);
		  
		  authcreden.put("auth",pwdcredentils);

		  try {
		   post.setRequestEntity(new StringRequestEntity(authcreden.toString(), "application/json", "UTF-8"));
		  } catch (final UnsupportedEncodingException e1) {
		   // TODO Auto-generated catch block
		   e1.printStackTrace();
		  }
		  //LOG.debug(" After setting Request Entity");
		  System.setProperty("jsse.enableSNIExtension", "false");
		   httpclient.executeMethod(post);
		   
		   //LOG.debug("Response Body String =");
		     
		   final String responseAsString = post.getResponseBodyAsString();
		    //LOG.debug("Response Body String =" + responseAsString);
		    
		     JSONObject result = new JSONObject(responseAsString);
		    //LOG.debug("Required Token =" + result.getJSONObject("access").getJSONObject("token").get("id"));
		    jsdnToken = result.getJSONObject("access").getJSONObject("token").get("id").toString();
		   // LOG.debug("jsdnToken =" + jsdnToken);
		    
		   }
		  
		  catch (Exception Ex){
		 //  LOG.error("Response Body String Error"+ Ex);
		  }
		  return jsdnToken;
		}
}
