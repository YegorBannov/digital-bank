package automation.pages;

import automation.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SignupPage extends BasePage{
    final String SIGNUP_PAGE_URL= "http://3.129.60.236:8080/bank/signup";
    final String TITLE_SIGNUP_PAGE= "Digital Bank";

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "title")
    WebElement dropdownTitle;

    @FindBy(xpath = "//input[@value='M']")
    WebElement maleGenderSelect;

    @FindBy(id = "//input[@value='F']")
    WebElement femaleGenderSelect;

    @FindBy(id = "dob")
    WebElement dob;

    @FindBy(id = "ssn")
    WebElement ssn;

    @FindBy(id = "emailAddress")
    WebElement email;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement nextBtn;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(id = "locality")
    WebElement localityInput;

    @FindBy(id = "region")
    WebElement regionInput;

    @FindBy(id = "postalCode")
    WebElement postalCodeInput;

    @FindBy(id = "country")
    WebElement countryInput;

    @FindBy(id = "homePhone")
    WebElement homePhoneInput;

    @FindBy(id = "mobilePhone")
    WebElement mobilePhoneInput;

    @FindBy(id = "workPhone")
    WebElement workPhoneInput;

    @FindBy(id = "agree-terms")
    WebElement agreeTermsCheckbox;



    public void verifyPage() {
        assertEquals("Failed URL missmatch", SIGNUP_PAGE_URL, driver.getCurrentUrl());
    }
    public void verifyTitle(){
        assertEquals("Failed - Title missmatch", TITLE_SIGNUP_PAGE, driver.getTitle());
    }

//    WebElement firstName = driver.findElement(By.id("firstName"));
//    WebElement lastName = driver.findElement(By.id("lastName"));
//    WebElement dropdownTitle = driver.findElement(By.id("title"));
//    WebElement maleGenderSelect = driver.findElement(By.xpath("//input[@value='M']"));
//    WebElement femaleGenderSelect = driver.findElement(By.xpath("//input[@value='F']"));
//    WebElement dob = driver.findElement(By.id("dob"));
//    WebElement ssn = driver.findElement(By.id("ssn"));
//    WebElement email = driver.findElement(By.id("emailAddress"));
//    WebElement passwordInput = driver.findElement(By.id("password"));
//    WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
//    WebElement nextBtn = driver.findElement(By.xpath("//button[@type='submit']"));
//    WebElement addressInput = driver.findElement(By.id("address"));
//    WebElement localityInput = driver.findElement(By.id("locality"));
//    WebElement regionInput = driver.findElement(By.id("region"));
//    WebElement postalCodeInput = driver.findElement(By.id("postalCode"));
//    WebElement countryInput = driver.findElement(By.id("country"));
//    WebElement homePhoneInput = driver.findElement(By.id("homePhone"));
//    WebElement mobilePhoneInput = driver.findElement(By.id("mobilePhone"));
//    WebElement workPhoneInput = driver.findElement(By.id("workPhone"));
//    WebElement agreeTermsCheckbox = driver.findElement(By.id("agree-terms"));

//    WebDriverWait wait = new WebDriverWait(driver,20);

//    wait.until(ExpectedConditions.elementToBeCLickable(element));

    public void fillInFirstForm() throws Exception {
        String selectTitle = PropertyReader.getProperty("signup.title");
        String gender = PropertyReader.getProperty("signup.gender");
        selectFromDropDown(dropdownTitle, selectTitle);
        firstName.sendKeys(PropertyReader.getProperty("signup.firstname"));
        lastName.sendKeys(PropertyReader.getProperty("signup.lastname"));
        selectGender(gender);
        dob.sendKeys(PropertyReader.getProperty("signup.dob"));
        ssn.sendKeys(PropertyReader.getProperty("signup.ssn"));
        email.sendKeys(PropertyReader.getProperty("signup.email"));
        passwordInput.sendKeys(PropertyReader.getProperty("signup.password"));
        confirmPassword.sendKeys(PropertyReader.getProperty("signup.password"));
        nextBtn.click();


    }

    public void fillInSecondForm() {
        addressInput.sendKeys(PropertyReader.getProperty("signup.address"));
        localityInput.sendKeys(PropertyReader.getProperty("signup.locality"));
        regionInput.sendKeys(PropertyReader.getProperty("signup.region"));
        postalCodeInput.sendKeys(PropertyReader.getProperty("signup.postalcode"));
        countryInput.sendKeys(PropertyReader.getProperty("signup.country"));
        homePhoneInput.sendKeys(PropertyReader.getProperty("signup.homephone"));
        mobilePhoneInput.sendKeys(PropertyReader.getProperty("signup.mobilephone"));
        workPhoneInput.sendKeys(PropertyReader.getProperty("signup.workphone"));
        agreeTermsCheckbox.click();
        nextBtn.click();


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
