package bdd.APIFramework;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	public static JsonPath rawToJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}
	
	public static String payloadVar2Val (String response, String payloadVariable) {
		String payloadValue = "";
		JsonPath js = new JsonPath(response);
		payloadValue = js.getString(payloadVariable);
		return payloadValue;
	}
}
