package praktikum;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static praktikum.Login.URL;

public class User {

    static final String API_LOGIN_USER = "/api/auth/login";
    static final String API_AUTH_USER = "/api/auth/user";
    static final String API_REGISTER_USER = "/api/auth/register";

    private String email;
    private String password;
    private String name;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Step("Register user using API")
    public static void registerUserUsingAPI(String email, String password, String name) {
        User user = new User(email, password, name);
        given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(URL + API_REGISTER_USER);
    }

    @Step("Delete user using API")
    public static void deleteUserUsingAPI(String email, String password) {
        User user = new User(email, password, "");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(user)
                        .when()
                        .post(URL + API_LOGIN_USER);
        JsonPath body = response.jsonPath();
        String accessToken = body.get("accessToken");
        given()
                .auth().oauth2(accessToken.replace("Bearer ", ""))
                .delete(URL + API_AUTH_USER)
                .then().statusCode(202);
    }

}