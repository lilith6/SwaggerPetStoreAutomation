package api.tests;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDUserTests {

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    void testPostUser(String userID, String userName, String firstName, String lastName, String email, String password, String phone){

        User userPayload = new User();
        userPayload.setId(Integer.parseInt(userID));
        userPayload.setUsername(userName);
        userPayload.setFirstname(firstName);
        userPayload.setLastname(lastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);

        Response res = UserEndpoints.createUser(userPayload);
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 2, dataProvider = "Username", dataProviderClass = DataProviders.class)
    void testUserByName(String username){
        Response res = UserEndpoints.readUser(username);
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 3, dataProvider = "Username", dataProviderClass = DataProviders.class)
    void testDeleteUser(String username){

        Response res = UserEndpoints.deleteUser(username);
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);
    }

}
