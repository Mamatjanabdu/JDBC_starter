package REst_Practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SparantRest_WeekEnd {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://3.89.115.0";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
        // above will generate a BASE REQUEST URL OF http://52.23.254.102:8000/api
    }
    @Test
    public void test1(){
        //RequestSpecification reqSpec = given().accept(ContentType.JSON);
        Response response =
                // RequestSpecification
                given()
                        .accept(ContentType.JSON).
                        when()
                        // Actual request is being sent using HTTP verbs methods with URL
                        .get("/spartans") ;
        // eventually it will return a Response object
    }
    @Test
    public void test2(){
        //RequestSpecification reqSpec = given().accept(ContentType.JSON);
        Response response =
                // RequestSpecification
                given()
                        .accept(ContentType.JSON).
                        when()
                        // Actual request is being sent using HTTP verbs methods with URL
                        .get("/spartans/2") ;
        // eventually it will return a Response object
        response.prettyPrint();
        assertEquals( "Male" , response.path("gender").toString()     );
    }
    @Test
    public void Search_By_Providing_Query_Parameter() {
        Response response = given().
                accept(ContentType.JSON).
                queryParam("gender", "Male").
                //param("gender","Male").
                        when().
                        get("/spartans/search");
        assertEquals(200, response.statusCode());
        assertFalse(response.asString().contains("Female"));
        response.prettyPrint();
        System.out.println(response.path("pageable.sort.empty").toString());
        boolean isEMpty= response.jsonPath().getBoolean("pageable.sort.empty");
        assertTrue(isEMpty);

long  firstPhone= response.jsonPath().getLong("content[4].phone");
        System.out.println(firstPhone);
       // boolean totalElements =response.jsonPath().getBoolean("totalElements");
List<String> nameList=response.jsonPath().getList("content.name");
        System.out.println(nameList);
    }
}
