package starter.stepdef.comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.JsonPlaceHolderAPI;

public class DeleteCommentStepDef {

    @Steps
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    @Given("Set path {} delete")
    public void setPathDelete(int param) {
        jsonPlaceHolderAPI.deleteComments(param);
    }

    @When("Send request delete comments")
    public void sendRequestDeleteComments() {
        SerenityRest.when().get(JsonPlaceHolderAPI.COMMENTS_PARAM);
    }

    @Given("Set path {string} delete with string")
    public void setPathDeleteWithString(String param) {
        jsonPlaceHolderAPI.deleteComments(param);
    }

    @Given("Set path delete with empty parameter {string}")
    public void setPathDeleteWithEmptyParameter(String param) {
        jsonPlaceHolderAPI.deleteComments(param);
    }

    @Given("Set path {string} delete with special character")
    public void setPathDeleteWithSpecialCharacter(String param) {
        jsonPlaceHolderAPI.deleteComments(param);
    }
}
