package starter.JsonPlaceholder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class pathAPI {
    public static String POSTS_PATH = Constants.BASE_URL + "/posts";
    public static String POSTS_PARAM = Constants.BASE_URL + "/posts/{param}";
    public static String COMMENTS_PATH = Constants.BASE_URL + "/comments";
    public static String SINGLE_COMMENTS = Constants.BASE_URL + "/comments/{param}";
    public static String USERS_PATH = Constants.BASE_URL + "/users";
    public static String USERS_PARAM = Constants.BASE_URL + "/users/{param}";
    public static String LIST_POSTS = Constants.BASE_URL + "/posts";
    public static String SINGLE_POSTS = Constants.BASE_URL + "/posts/{id}";

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
    //Get Posts
    //Get Posts
    @Step("Get posts")
    public void getPosts(Object id) {
        SerenityRest.given()
                .pathParam("id", id);
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
    public void postPostsString(String id) {
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Post posts")
    public void postPostsInt(int id) {
        SerenityRest.given().pathParam("id",id);
    }

    //Put Posts
    @Step("Put posts")
    public void putPosts(Object id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Update post with valid id")
    public void putUpdatePost(int id, File json){
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }
    @Step("Put posts with empty parameter")
    public void putPostss(Object id) {
        SerenityRest.given().pathParam("id", id);
    }

    //Delete Post
    @Step("Delete posts")
    public static void deletePosts(Object id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

}
