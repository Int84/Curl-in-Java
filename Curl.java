package curlAPI;

import java.io.*;
import java.net.*;

public class Curl{
	String s;
	String Surl;
	int cntHeader=0;
	String[][] Header;
	String rqs;
	public void SetURL(String _url) {
		Surl=_url;
	}
	public void AddHeader(String name,String v) {
		Header[cntHeader]=new String[2];
		Header[cntHeader][0]=name;
		Header[cntHeader][1]=v;
	}
	public void SetRequestType(String type) {
		rqs=type;
	}
	public String GetReturn()throws Exception {
		URL url = new URL(Surl); 
		HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
		con.setRequestMethod(rqs); 
		int i;
		for(i=0;i<cntHeader;i++) {
			con.setRequestProperty(Header[i][0], Header[i][1]);
		}
		BufferedReader in ;
		in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
		String inputLine; 
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) { 
			response.append(inputLine); 
		} 
		in.close(); 
		return response.toString();
	}
	public int GetResponseCode()throws Exception{
		URL url = new URL(Surl); 
		HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
		con.setRequestMethod(rqs); 
		int i;
		for(i=0;i<cntHeader;i++) {
			con.setRequestProperty(Header[i][0], Header[i][1]);
		}
		return con.getResponseCode(); 
		
	}

}