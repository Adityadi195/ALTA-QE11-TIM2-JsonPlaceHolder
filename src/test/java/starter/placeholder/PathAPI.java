package starter.placeholder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PathAPI {
    public static String POSTS_PATH = Constants.BASE_URL + "/posts";
    public static String POSTS_PARAM = Constants.BASE_URL + "/posts/{param}";
    public static String COMMENTS_PATH = Constants.BASE_URL + "/comments";
    public static String SINGLE_COMMENTS = Constants.BASE_URL + "/comments/{param}";
    public static String USERS_PATH = Constants.BASE_URL + "/users";
    public static String USERS_PARAM = Constants.BASE_URL + "/users/{param}";

    @Step("Get comments")
    public void getAllComments() {
        SerenityRest.given();
    }

    @Step("Get comments")
    public void getSingleComment(Object param) {
        SerenityRest.given()
                .pathParam("param", param);
    }

    @Step("Post comments")
    public void postComments(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Put Posts
    @Step("Put comments")
    public void putComments(Object id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Delete Post
    @Step("Delete comments")
    public void deleteComments(Object id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get List Users")
    public void getListUsers(){
        SerenityRest.given();
    }

    @Step("Get Single User")
    public void getSingleUser(Object param){
        SerenityRest.given().pathParam("param", param);
    }

    @Step("Post Create New User")
    public void createNewUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Put Update User")
    public void updateUser(Object param, File json){
        SerenityRest.given()
                .pathParam("param", param)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete User")
    public void deleteUser(Object param){
        SerenityRest.given()
                .pathParam("param", param);
    }
}
