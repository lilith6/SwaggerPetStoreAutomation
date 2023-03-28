package api.tests;

import api.endpoints.UserEndpointsfromproperties;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserTests2 {

    public Logger logger;
    Faker faker;
    User userPayload;
    public void setupData(){
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress("aaamail.com"));
        userPayload.setPassword(faker.internet().password(6,10, true, true, true));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        //logs

        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    void testPostUser(){
        setupData();
        logger.info("*************************Creating user*******************************");
        Response res = UserEndpointsfromproperties.createUser(userPayload);
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);

        logger.info("*************************User is created*******************************");

    }

    @Test(priority = 2)
    void testUserByName(){

        logger.info("*************************Retrieving user*******************************");
        String username = this.userPayload.getUsername();
        Response res = UserEndpointsfromproperties.readUser(username);
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);


    }

    @Test(priority = 3)
    void testUpdateUser(){

        logger.info("*************************Updating user*******************************");
        this.userPayload.setUserStatus(1);
        String username = this.userPayload.getUsername();
        Response res = UserEndpointsfromproperties.updateUser(username, userPayload);
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);

        Response resAfterUpdate = UserEndpointsfromproperties.readUser(username);
        Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);

        logger.info("*************************User is updated*******************************");
    }


    @Test(priority = 4)
    void testDeleteUser(){

        logger.info("*************************Deleting user*******************************");
        String username = this.userPayload.getUsername();
        Response res = UserEndpointsfromproperties.deleteUser(username);
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);

        logger.info("*************************User deletedr*******************************");
    }
}

