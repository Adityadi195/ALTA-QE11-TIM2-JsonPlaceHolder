package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.PathAPI;
import starter.utils.Constants;

public class DeleteUser {
    @Steps
    PathAPI pathAPI;

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        pathAPI.deleteUser(id);
    }

    @When("User send request delete user")
    public void userSendRequestDeleteUser() {
        SerenityRest.when().delete(PathAPI.USERS_PARAM);
    }
}
