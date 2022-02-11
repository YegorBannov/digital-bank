package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class SignUpPage extends BasePage{
    final String SIGNUP_PAGE_URL= "http://3.129.60.236:8080/bank/signup";

    @Override
    public void verifyPage() {
        assertEquals("Failed URL missmatch", SIGNUP_PAGE_URL, driver.getCurrentUrl());
    }
    public void verifyTitle(String title){
        assertEquals("Failed - Title missmatch", title, driver.getTitle());
    }

    WebElement firstName = driver.findElement(By.id("firstName"));
    WebElement lastName = driver.findElement(By.id("lastName"));
    WebElement maleGenderSelect = driver.findElement(By.xpath("//input[@value='M']"));
    WebElement femaleGenderSelect = driver.findElement(By.xpath("//input[@value='F']"));
    WebElement dob = driver.findElement(By.id("dob"));
    WebElement ssn = driver.findElement(By.id("ssn"));
    WebElement email = driver.findElement(By.id("emailAddress"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
    WebElement submitPassword = driver.findElement(By.id("submit"));

//    WebDriverWait wait = new WebDriverWait(driver,20);
//    wait.until(ExpectedConditions.elementToBeCLickable(element));

    public void typeIn(WebElement elm, String text){
        elm.sendKeys(text);
    }

    public void selectFromDropDown(WebElement dropdown, String value){
        Select select = new Select(dropdown);
        String mr ="Mr.";
        String ms ="Ms.";
        String mrs ="Mrs.";
        switch (value){
            case "Mister" : select.selectByValue(mr);
            break;
            case "Miss" : select.selectByValue(ms);
            break;
            case "Mistress" : select.selectByValue(mrs);
            break;
        }


    }

    public void selectGender(String gender) throws Exception {
        String mr ="Male";
        String ms ="Female";

        switch (gender){
            case "Male" : maleGenderSelect.click();
                break;
            case "Female" : femaleGenderSelect.click();
                break;
            default: throw new Exception("Gender mismatch");
        }


    }



}
