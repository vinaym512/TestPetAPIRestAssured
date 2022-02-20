package step_def;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_OK;

public class Hooks {

    public static RequestSpecification requestSpec;
    static File jsonDataInFile = new File("src/test/resources/updateBody.json");

    @BeforeAll
    public static void setup() {
        baseURI = "https://petstore.swagger.io/v2";
        basePath = "/pet";
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .log(LogDetail.ALL).build();
//  Create a pet data as pre requisite
        given().spec(requestSpec).body(jsonDataInFile).contentType(ContentType.JSON).post().then().statusCode(SC_OK);
    }
    @Before
    public static void before_each_test() throws InterruptedException {
//        to avoid concurrent http calls
        Thread.sleep(1000);
    }

}
