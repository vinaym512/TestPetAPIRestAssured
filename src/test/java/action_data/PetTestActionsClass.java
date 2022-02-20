package action_data;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import step_def.Hooks;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PetTestActionsClass {
    static File jsonDataInFile = new File("src/test/resources/updateBody.json");
    static RequestSpecification request = Hooks.requestSpec;
    static Response res;

    public static void getPetName(int petId) {
        res = given().spec(request).pathParam("petId", petId).contentType(ContentType.JSON).get("/{petId}");
    }

    public static void updatePetInfo(int id) {
        res = given().spec(request).body(jsonDataInFile).contentType(ContentType.JSON).put();
    }

    public static void deletePetName(int petId) {
        res = given().spec(request).pathParam("petId", petId).contentType(ContentType.XML).delete("/{petId}");
    }

    public static void verifyResponse(int code) {
        Assert.assertTrue(res.getStatusCode() == code);
    }

}

