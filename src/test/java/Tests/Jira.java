package Tests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Jira {

    public static void main (String[] args){
        System.out.println("Welcome");
        RestAssured.baseURI = "https://issues.sonatype.org/secure/Dashboard.jspa";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("nikhil.jain");
        authScheme.setPassword("Sonatype@1234");
        RestAssured.authentication = authScheme;
//        getterSetter values=new getterSetter();
//        values.setProject(13204);
//        values.setSummary("Checking via REST Assured");
//        values.setIssueType(3);
//        values.setReporter("#######");
//        values.setPriority(3);
//        values.setDescription("Welcome to JAVA World");
//        //Updating sprint name custom field value
//        values.setCustomfield_10201(10608);

        RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json").request();
        String statusCode = String.valueOf(httpRequest.get().getStatusCode());

        System.out.println("Status Code : " + statusCode);
//        String values = "";
//
//        Gson gson=new Gson();
//        String json= gson.toJson(values);
//        System.out.println("JSON Values " + json);
//
//        RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json").body(json);
//        System.out.println(httpRequest + " Request ");
//
//        Response response = httpRequest.request(Method.POST, "");
//        System.out.println(response.getStatusCode());
//
//        String responseBody = response.getBody().asString();
//        System.out.println("response " + responseBody);
//
//        JsonPath jsonPath = new JsonPath(responseBody);
    }
}
