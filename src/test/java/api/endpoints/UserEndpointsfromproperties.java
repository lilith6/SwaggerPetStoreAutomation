package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class UserEndpointsfromproperties {

    static ResourceBundle getUrl(){
        ResourceBundle routes = ResourceBundle.getBundle("routes"); //load properties file
        return routes;
    }

    public static Response createUser(User payload){

        String url = getUrl().getString("post_url");
        Response res = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .accept(ContentType.JSON)
                .when()
                    .post(url);
        return res;
    }

    public static Response readUser(String userName){

        String url = getUrl().getString("get_url");
        Response res = given()
                .pathParams("username", userName)
                .accept(ContentType.JSON)
                .when()
                    .get(url);
        return res;
    }

    public static Response updateUser(String userName, User payload){

        String url = getUrl().getString("put_url");
        Response res = given()
                .pathParams("username", userName)
                .contentType(ContentType.JSON)
                .body(payload)
                .accept(ContentType.JSON)
                .when()
                    .put(url);
        return res;
    }

    public static Response deleteUser(String userName){

        String url = getUrl().getString("delete_url");
        Response res = given()
                .pathParams("username", userName)
                .when()
                    .delete(url);
        return res;
    }
}
