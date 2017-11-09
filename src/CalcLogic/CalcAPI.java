package CalcLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

public class CalcAPI
{
	public static String Calc(int a,int b,String op) throws ClientProtocolException, IOException
	{

		String uri = "http://localhost:2345/";
        String temp = uri + "?a=" + a + "&b=" + b + "&op=" + op;
        HttpGet httpGet = new HttpGet(temp);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(httpGet);
        String responseString = new BasicResponseHandler().handleResponse(response);
        return responseString;
	}
}
