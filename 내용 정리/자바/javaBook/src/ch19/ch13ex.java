package ch19;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ch13ex {

	public static void main(String[] args) throws IOException, InterruptedException {
		String url = "https://api.openweathermap.org/data/2.5/weather";
//		String lat = "lat";
//		String lon = "lon";
		String q = "bangkok";
		String api_key = "dfa13e079c939a4c716799ec18517b75";
		url = url + "?q=" + q + "&appid=" + api_key;

		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());

		ObjectMapper om = new ObjectMapper();

		JsonNode jsonNode = om.readTree(response.body());
		System.out.println("지역 : " + jsonNode.get("name"));
		JsonNode weatherArray =  jsonNode.get("weather");
        JsonNode obj =  weatherArray.get(0);
        System.out.println("날씨 : "+obj.get("main"));
        JsonNode mainArray = jsonNode.get("main");
        double ktemp = Double.parseDouble(mainArray.get("temp").toString());
        double temp = ktemp-273.15;
        System.out.printf("온도 : %.2f\n",temp);
		

	}

}
