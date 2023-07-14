package starter.placeholder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class JsonPlaceHolderAPI {
    public static String POSTS_PATH = Constants.BASE_URL + "/posts";
    public static String POSTS_PARAM = Constants.BASE_URL + "/posts/{param}";
    public static String COMMENTS_PATH = Constants.BASE_URL + "/comments";
    public static String COMMENTS_PARAM = Constants.BASE_URL + "/comments/{param}";
    public static String USERS_PATH = Constants.BASE_URL + "/users";
    public static String USERS_PARAM = Constants.BASE_URL + "/users/{param}";
    public static String LIST_POSTS = Constants.BASE_URL + "/posts";
    public static String SINGLE_POSTS = Constants.BASE_URL + "/posts/{param}";

    @Step("Get comments")
    public void getAllComments() {
        SerenityRest.given();
    }

    @Step("Get comments")
    public void getSingleComment(Object param) {
        SerenityRest.given()
                .pathParam("param", param);
    }

    @Step("Get comments with value")
    public void getCommentWithParam(Object params){
        SerenityRest.given()
                .pathParam("params", params);
    }

    @Step("Post comments")
    public void postComments(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }


    //Put Posts
    @Step("Put comments")
    public void putComments(Object param, File json) {
        SerenityRest.given()
                .pathParam("param", param)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Delete Post
    @Step("Delete comments")
    public void deleteComments(Object param) {
        SerenityRest.given()
                .pathParam("param", param);
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

    @Step("Get posts")
    public void getPosts(Object param) {
        SerenityRest.given()
                .pathParam("param", param);
    }

    //Get List Posts
    @Step("Get posts")
    public void getListPosts() {
        SerenityRest.given();
    }

    //Post Posts
    @Step("Post posts")
    public void postPosts(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post posts")
    public void postPostsString(String param) {
        SerenityRest.given().pathParam("param",param);
    }
    @Step("Post posts")
    public void postPostsInt(int param) {
        SerenityRest.given().pathParam("param",param);
    }

    //Put Posts
    @Step("Put posts")
    public void putPosts(Object param, File json) {
        SerenityRest.given()

                .pathParam("param", id)

                .pathParam("param", param)

                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Update post with valid id")
    public void putUpdatePost(int param, File json){
        SerenityRest.given().pathParam("param",param).contentType(ContentType.JSON).body(json);
    }
    @Step("Put posts with empty parameter")
    public void putPosts(Object param) {
        SerenityRest.given().pathParam("param", param);
    }

    //Delete Post
    @Step("Delete posts")
    public static void deletePosts(Object param) {
        SerenityRest.given()

                .pathParam("param", id);

                .pathParam("param", param);

    }
}
