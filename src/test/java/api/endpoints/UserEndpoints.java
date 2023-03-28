package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payload.User;
public class UserEndpoints {

    public static Response createUser(User payload){

        Response res = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .accept(ContentType.JSON)
                .when()
                    .post(Routes.post_url);
        return res;
    }

    public static Response readUser(String userName){

        Response res = given()
                .pathParams("username", userName)
                .accept(ContentType.JSON)
                .when()
                    .get(Routes.get_url);
        return res;
    }

    public static Response updateUser(String userName, User payload){

        Response res = given()
                .pathParams("username", userName)
                .contentType(ContentType.JSON)
                .body(payload)
                .accept(ContentType.JSON)
                .when()
                    .put(Routes.put_url);
        return res;
    }

    public static Response deleteUser(String userName){

        Response res = given()
                .pathParams("username", userName)
                .when()
                    .delete(Routes.delete_url);
        return res;
    }
}
