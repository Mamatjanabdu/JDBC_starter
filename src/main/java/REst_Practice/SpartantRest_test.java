package REst_Practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class SpartantRest_test {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://3.89.115.0";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
        // above will generate a BASE REQUEST URL OF http://52.23.254.102:8000/api
    }
    //    Given no headers are provided
//    When User send request to /Spartans
//    Then Reponse status code should be 200
//    and  header should have content Type / json
//    and  header should contains Date
    @Test
    public void Spartan_All_Test(){
        Response response = get("/spartans/");

        assertEquals(200, response.statusCode());
        assertEquals("",response.contentType());
        assertEquals("", response.getContentType());
        //assertEquals("",response);

    }
//    Given no headers are provided
//    When User send request to /api/spartans/2
//    Then Response status code should be 200
//    and header should have content Type / JSON
//   OPTIONAL  and json object id should be 2
}
