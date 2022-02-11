package automation.steps;

import automation.pages.LoginPage;
import automation.pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupSteps {

    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();

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
        signUpPage.verifyPage();
    }

    @And("verify title of the signup page")
    public void verifyTitleOfTheSignupPage() {
        signUpPage.verifyTitle();
    }

    @When("fill in the first form")
    public void fillInTheFirstForm() throws Exception {
        signUpPage.fillInFirstForm();
    }

    @Then("fill in the second form")
    public void fillInTheSecondForm() {
        signUpPage.fillInSecondForm();
    }


}
