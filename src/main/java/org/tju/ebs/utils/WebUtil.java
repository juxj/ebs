package org.tju.ebs.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import org.apache.soap.encoding.SOAPMappingRegistry;
import org.apache.soap.encoding.soapenc.BeanSerializer;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Response;



public class WebUtil {

	private final static String IP_URL="webservice.webxml.com.cn";
	private final static String MOBILE_URL="http://WebXml.com.cn/getCountryCityByIp";
	private final static String POST_CODE_URL="";
	
	private SOAPMappingRegistry registry;
	private BeanSerializer serializer;
	private Call call;
	private Vector params;
	private Response rpcResponse;
	private URL url;
	
	private void initialize(String url, String method) throws MalformedURLException{
		this.url = new URL(url);
		
	}
	
	public String[] getCityByIP(String ip) {
		String[] result= null;
		
		
		
		return result;
	}
	
	public String[] getCityByMobile(String mobile){
		String[] result= null;
		
		return result;
	}
	
	public String[] getCityByPostCode(String postCode) {
		
		String[] result= null;
		
		return result;
	}
	
	public String[] getCityByIdCard(String idCard){
		String[] result= null;
		
		return result;
	}
	
}
