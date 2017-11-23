package CalcLogic;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;

public class CalcAPI
{
    @Asynchronous
	public static String Calc(int a, int b, String op) throws IOException, ExecutionException, InterruptedException {
        String uri = "http://localhost:2345/";
        String temp = uri + "?a=" + a + "&b=" + b + "&op=" + op;
        HttpGet httpGet = new HttpGet(temp);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse resp = httpClient.execute(httpGet);
        String result = new BasicResponseHandler().handleResponse(new AsyncResult<HttpResponse>(resp).get());
        return result;
	}
}
