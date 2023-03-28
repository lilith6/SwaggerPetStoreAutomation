package api.endpoints;



//Base URL: petstore.swagger.io/v2
//User :  https://petstore.swagger.io/v2/user
// get; update; delete: https://petstore.swagger.io/v2/user/{username}
//create https://petstore.swagger.io/v2/user

public class Routes {

    public static String base_url = "https://petstore.swagger.io/v2/";

    //User module

    public static String post_url = base_url + "user";
    public static String get_url = base_url + "user/{username}";
    public static String put_url = base_url + "user/{username}";
    public static String delete_url = base_url + "user/{username}";

    //Store module

    //TODO

    //Pet module

    //TODO

}
