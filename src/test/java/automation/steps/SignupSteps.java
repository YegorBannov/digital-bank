package automation.steps;

import automation.pages.LoginPage;
import automation.pages.SignupPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupSteps {

    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();

    @Then("verify user is on login page")
    public void verifyUserIsOnLoginPage() {
        loginPage.verifyPage();
    }

    @When("user click on signup link")
    public void userClickOnSignupLink() {
        loginPage.signupClick();
    }

    @Then("verify user is on signup page")
    public void verifyUserIsOnSignupPage() {
        signupPage.verifyPage();
    }

    @And("verify title of the signup page")
    public void verifyTitleOfTheSignupPage() {
        signupPage.verifyTitle();
    }

    @When("fill in the first form")
    public void fillInTheFirstForm() throws Exception {
        signupPage.fillInFirstForm();
    }

    @Then("fill in the second form")
    public void fillInTheSecondForm() {
        signupPage.fillInSecondForm();
    }


}
