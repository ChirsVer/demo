package Page;

import Logs.LogUtils;
import TCs.RegisterTCs;
import keywords.DriverManager;
import keywords.DriverManager;
import keywords.WebUI;
import org.apache.commons.collections4.BagUtils;
import org.apache.commons.logging.Log;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.lang.reflect.Method;
import java.security.Key;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Helpers.ExcelHelper.readExcelToList;
import static keywords.WebUI.sleep;

import common.PageHelper;

public class RegisterPage {

    public void RegisterPage() {
    }
    //<editor-fold desc="By">
    public final String urlRegister = "https://www.desigual.com/en_US/register/";
    final int min_lenght_lastname = 5;
    final int max_lenght_lastname = 20;
    final String pass = "TestPW";
    //    public By adrressTxt = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div");
    public By emailTxt = By.xpath("//*[@id=\"registration-form-email\"]");
    //    By addressTxt=By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div");
//    By addressTxt = By.className("form-control ng-pristine ng-untouched ng-valid");
    //    By addressTxt=By.xpath("//input[@type='email']");
//    By addressTxt = By.cssSelector("div[class=form-control ng-pristine ng-untouched ng-valid]");
//    By phoneTxt = By.xpath("//body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]");
//    By firstnameTxt=By.xpath();
//    By firstnameTxt=By.xpath();
    public By passTxt = By.xpath("//input[@id='form-password']");
    String locatorSignupBtt = "//button[normalize-space()='Create account']";
    By singupBtt = By.xpath(locatorSignupBtt);
    String locatorLoginHyperlink = "Log in";
    By loginHyperLink = By.linkText(locatorLoginHyperlink);
    String locatorTermHyperlink = "//a[normalize-space()='See terms and conditions']";
    By termHyperlink = By.xpath(locatorTermHyperlink);
    String locatorGet25Hyperlink = "//a[normalize-space()='See conditions']";
    By get25Hyperlink = By.xpath(locatorGet25Hyperlink);
    String locatorSignupBottoBtt = "//span[@class='btn btn-brand btn-outline-black text-uppercase px-5']";
    By signupBottom = By.xpath(locatorSignupBottoBtt);
    By dobDatetimepicker = By.xpath("//input[@id='registration-form-birthday']");
    By phoneTxt = By.xpath("//input[@id='registration-form-phone']");
    By prefixPhone = By.xpath("//div[@class='dropdown-toggle prefix-selector']");
    //languege dropdownllist
    String string = "We are cows";
    String emailTest = "34@gmail@com";
    String locatorAcceptCookie="//*[@id=\"onetrust-accept-btn-handler\"]";
    By acceptCookieBtt=By.xpath(locatorAcceptCookie);

    //cái này sai
//    By monthDl = By.xpath("//*[@id=\"monthbox\"]");

    // 2 phương án: lấy dữ liệu từ excel và gán vào xpath như đã làm ở phần Language
    // phương án 2 là tự nó click chọn data tùy ý và gửi về lại excel
    //tạo hàm scroll down
    //</editor-fold>
    //<editor-fold desc="UI">
    public void openRegisterPage() {
        LogUtils.info("run cows");
        DriverManager.getDriver().get(urlRegister);
        clickElement(acceptCookieBtt);
    }

    public void verifyHeaderRegisterPage() {
        openRegisterPage();
        By headerRegister=By.xpath("//h1[@class='page-title text-center h2 h1-sm']");
        String headerText="design";
        WebUI.clickElement(emailTxt);
        LogUtils.info("desgin");
//        Assert.assertTrue(DriverManager.getDriver().findElement(headerRegister).getText().equalsIgnoreCase(headerText), "Invalid header page!");
    }

    //</editor-fold>
    public void testLocator() {
        
        clickElement(emailTxt);
        clickElement(passTxt);
        clickElement(phoneTxt);
        clickElement(prefixPhone);
        clickElement(loginHyperLink);
        clickElement(singupBtt);
        clickElement(signupBottom);
        clickElement(termHyperlink);



        sleep(2);
    }
    //<editor-fold desc="common">
    public void clickElement(By by) {
        WebElement element = getElement(by);
        element.click();
        sleep(2);
    }

    public WebElement getElement(By by) {
        WebElement element = DriverManager.getDriver().findElement(by);
        return element;
    }

    public void verifyPlaceHolderField(By by, String string) {
        
        WebElement element=getElement(by);
        element.click();
        Assert.assertEquals(DriverManager.getDriver().findElement(by).getAttribute("Placeholder"), string, "Invalid " + string + " placeholder!");

    }

    ///kểm tra all feilds
    public void isEmptyDefaultFields() {
        SoftAssert softAssert = new SoftAssert();
//        //dùng is empty ko dùng is blank (isblank trả về true, ko chứa whtespace)
//        Assert.assertTrue(DriverManager.getDriver().findElement(lastnameTxt).getText().isEmpty(), "Field is not null");
//        System.out.println(DriverManager.getDriver().findElement(lastnameTxt).getText());
//        softAssert.assertTrue(DriverManager.getDriver().findElement(firstnameTxt).getText().isEmpty(), "Field is not null");
//        System.out.println(DriverManager.getDriver().findElement(lastnameTxt).getText());
//
//        softAssert.assertTrue(DriverManager.getDriver().findElement(emailTxt).getText().isEmpty(), "Field is not null");
//        System.out.println(DriverManager.getDriver().findElement(lastnameTxt).getText());
//
//        By addressTxt = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div");
//        softAssert.assertTrue(DriverManager.getDriver().findElement(addressTxt).getText().isEmpty(), "Field is not null");
//        System.out.println(DriverManager.getDriver().findElement(lastnameTxt).getText());
//        By phoneTxt = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input");
//        Assert.assertTrue(DriverManager.getDriver().findElement(phoneTxt).getText().isEmpty(), "Field is not null");
//        Assert.assertTrue(DriverManager.getDriver().findElement(lastnameTxt).getText().isEmpty(),"Field is not null");

    }

    //nếu có tgianviet6t hàm láy dũ liệu về file excel
//    public String extractDataFromWebsite() {
//        
//        // Locate and extract the desired data
//        WebElement dataElement = DriverManager.getDriver().findElement(skillDropdownlist);
//        String data = dataElement.getText();
//
//        return data;
//    }

    //chưa clear
    public void verifyDefaultCountry() {
        
        //xpath này đúng
//        By countryDl = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div");
        By countryDl = By.xpath("//*[@id=\"country\"]");
        WebElement ele = DriverManager.getDriver().findElement(countryDl);

        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele);
        System.out.println(ele.getText());
        Assert.assertNull(ele.getText().isEmpty(), "Invalid Default Country field");

        ele.click();
    }

//    public void verifyCountryDroplist(String a) {
//        
//        WebElement ele = DriverManager.getDriver().findElement(countryDl);
//        Select select = new Select(ele);
//        select.selectByVisibleText(a);
//        sleep(2);
//    }

    public void verifySearchCountry(String au) {
        
        By countryDl = By.xpath("//span[@role='combobox']");
        WebElement eleCountryDl = DriverManager.getDriver().findElement(countryDl);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", eleCountryDl);
        sleep(3);
        eleCountryDl.click();
        //enter valid
        By countryTxt = By.xpath("//input[@role='textbox']");
        WebElement eleTxt = DriverManager.getDriver().findElement(countryTxt);
        eleTxt.sendKeys(au);
        sleep(2);
// luc1 đunúng lúc sai
//WebElement firstOp=DriverManager.getDriver().findElement(By.xpath("//*[@id=\"country\"]/option[1]"));
//        String str=firstOp.getText();
//        By resultSearch = By.xpath("//*[@id=\"select2-country-results\"]/li");
//        DriverManager.getDriver().findElement(resultSearch).click();
//        By resultSearchSecond=By.xpath("//*[@id=\"select2-country-results\"]/li[2]");
//        DriverManager.getDriver().findElement(resultSearchSecond).click();
//
//        By listResultSearch = By.xpath("//*[@id=\"select2-country-results\"]");
        By listResultLocator = By.className("select2-results__options");
        List<WebElement> listResult = DriverManager.getDriver().findElements(listResultLocator);
        Integer toltalResult = listResult.size();
        System.out.println(toltalResult);
        String currentRes = null;
        for (WebElement elee : listResult) {

            currentRes = elee.getText();
            if (currentRes.contains(au)) {
                toltalResult++;
                Assert.assertTrue(currentRes.contains(au), "Not match result search");
                elee.click();
                sleep(2);
                break;
            }

        }
        Assert.assertTrue(toltalResult != 0, "Not found result");
//        WebElement optionSecond = DriverManager.getDriver().findElement(resultSearchSecond);
        //verifyResultReturn
        By confirmLactor = By.xpath("//*[@id=\"select2-country-container\"]");
        WebElement confirmResult = DriverManager.getDriver().findElement(confirmLactor);
        Assert.assertTrue(confirmResult.getText().equalsIgnoreCase(currentRes), "Result search not match");
    }

    public void verifyDefaultField(By by, Method method) {
        

        WebElement passEle = DriverManager.getDriver().findElement(by);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", passEle);

        Assert.assertTrue(passEle.getText().isEmpty(), method.getName() + "invalid");
        System.out.println(method.getName() + passEle.getText());


    }

    private void verifyEnteredData(By b, String a) {
        WebElement dataEntered = DriverManager.getDriver().findElement(b);
        Assert.assertTrue(dataEntered.getAttribute("Value").equalsIgnoreCase(a), "Entered data is matching");

    }


    public void isCursorVisiable(By by) {
        openRegisterPage();
        WebElement ele = DriverManager.getDriver().findElement(by);
        ele.click();
        WebElement eleActive = DriverManager.getDriver().switchTo().activeElement();
        Assert.assertEquals(ele, eleActive, "Text cursor is not visiable");

    }

    public void isClickableField(By by) {
        
        WebElement ele = DriverManager.getDriver().findElement(by);
        boolean stt = ele.isEnabled();
        Assert.assertTrue(stt, "The field can't be enable");

    }

    public void verifyTypeField(By by, String testtype) {
        
        WebElement element = DriverManager.getDriver().findElement(by);
        element.sendKeys(testtype);
        String verifyTest = element.getAttribute("value");
        Assert.assertEquals(testtype, verifyTest, "The a entered value is not match");
    }


    public void verifyTab(By preBy, By by) {
        
        WebElement preEle = DriverManager.getDriver().findElement(preBy);
        preEle.click();
        //curosr in next field
        preEle.sendKeys(Keys.TAB);
        //get the active element after pressing TAB
        WebElement actEle = DriverManager.getDriver().switchTo().activeElement();
        sleep(3);
//expected next filed
        WebElement nextEle = DriverManager.getDriver().findElement(by);
        //compare act vs next
        Assert.assertEquals(actEle, nextEle, "Tab key navigation is failed!");

    }


    public void boundaryField(By by, String str, int min, int max) {
        
        WebElement ele = DriverManager.getDriver().findElement(by);
        ele.sendKeys(str);

//        ele.sendKeys(Keys.ENTER);
        sleep(4);
        //get entered value
        // Retrieve the entered data using JavaScript Executor
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
//        String enteredData = (String) jsExecutor.executeScript("return arguments[0].value", lastnameTxt);
//        String lenghtData = ele.getAttribute("maxlength"); //lỗi g ko biết
//        System.out.println(ele.getAttribute("minlenght"));
        String enteredData = ele.getAttribute("value");

        System.out.println(enteredData);
        System.out.println(enteredData.length());
//Dùng nào cũng đc, nhưng dùng sau nó rõ ràng hơn
//        Assert.assertTrue(enteredData.length()>=min_lenght_lastname && enteredData.length()<max_lenght_lastname,"Value is not with the specificed range!");

        Assert.assertTrue(enteredData.length() >= min, "Field length is not as expected for minimun lenght input!");
        Assert.assertTrue(enteredData.length() <= max, "Field length is not as expected for maximun lenght input!");

    }
//
//    public void boundaryFristname(String s) {
//        boundaryField(firstnameTxt, s, min_lenght_lastname, max_lenght_lastname);
//    }

    public void enterData(By by, String str) {
        
        WebElement ele = DriverManager.getDriver().findElement(by);
        ele.sendKeys(str);
        sleep(4);
        System.out.println("entered data" + ele.getAttribute("value"));
    }


    //cuoi
    public void removeFinalTextBackSpace(By by, String str, int times) {
        
        str = "we are cows";
        WebElement ele = DriverManager.getDriver().findElement(by);
        ele.sendKeys(str);
        sleep(2);
        for (int i = 0; i < times; i++) {
            ele.sendKeys(Keys.BACK_SPACE);
        }
        sleep(2);

        System.out.println(ele.getAttribute("value"));
        String updateData = str.substring(0, ele.getAttribute("value").length());
        System.out.println(updateData);
        Assert.assertEquals(updateData, ele.getAttribute("value"), "Backspace key verification failed. Delected characters do not match the expected value!");

    }


    //times !=0
    private void removeSecondTextBackSpace(By by, String str, int times) {
        
        str = "we are cows";
        WebElement ele = DriverManager.getDriver().findElement(by);
        ele.sendKeys(str);
        String firstData = ele.getAttribute("value");
        //move cursor by arrow_LEFT key
        for (int i = 1; i < firstData.length(); i++) {
            ele.sendKeys(Keys.ARROW_LEFT);
        }
        sleep(2);
        for (int i = 0; i < times; i++) {
            ele.sendKeys(Keys.BACK_SPACE);
            System.out.println(i);
            sleep(1);
        }
        sleep(2);

        System.out.println(ele.getAttribute("value"));
//        String firstLetter=str.substring(0,1);
//        String otherLetter=str.substring(2,ele.getAttribute("value").length());
//        String updateDate=firstLetter.concat(otherLetter);
        String updateData = str.substring(1, ele.getAttribute("value").length() + 1);//chieu dài chuổi phải +1
        System.out.println(updateData);
        Assert.assertEquals(updateData, ele.getAttribute("value"), "Backspace key verification failed. Delected characters do not match the expected value!");

    }


    public void removePositionText(By by, String text, int positionCursor, int times) {
        
        text = "we are cows";
        WebElement ele = DriverManager.getDriver().findElement(by);
        ele.sendKeys(text);
        sleep(2);
        String firstData = ele.getAttribute("value");
        if (positionCursor >= times) {
            //move cursor by arrow_LEFT key
            for (int i = 0; i < firstData.length(); i++) {
                ele.sendKeys(Keys.ARROW_LEFT);
            }
            sleep(2);
            for (int i = 0; i < positionCursor; i++) {
                ele.sendKeys(Keys.ARROW_RIGHT);
            }
            for (int i = 0; i < times; i++) {
                ele.sendKeys(Keys.BACK_SPACE);
            }
            sleep(2);
            System.out.println("actual");
            System.out.println(ele.getAttribute("value"));
            String firstLetter = text.substring(0, positionCursor - times);
            System.out.println(firstLetter);
            String otherLetter = text.substring(positionCursor, ele.getAttribute("value").length() + times);
            System.out.println(otherLetter);
            String updateData = firstLetter.concat(otherLetter);
//        String updateData = text.substring(1, ele.getAttribute("value").length() + 1);//chieu dài chuổi phải +1
            System.out.println(updateData);
            Assert.assertEquals(updateData, ele.getAttribute("value"), "Backspace key verification failed. Delected characters do not match the expected value!");

        } else {
            System.out.println("Position cursor must greater or equal times! Plase check it again!");
        }

    }

    public void removeAllTextBackspace(By by) {
        
        String text = "we are cows";
        WebElement ele = DriverManager.getDriver().findElement(by);
        ele.sendKeys(text);
        sleep(2);
        ele.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        ele.sendKeys(Keys.BACK_SPACE);
        // Select all text using "Ctrl + A" keyboard shortcut dùng  01 trong 2 cách
//        Actions actions = new Actions(DriverManager.getDriver());
//        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        System.out.println(ele.getAttribute("value"));
        Assert.assertTrue(ele.getAttribute("value").isEmpty(), "Remove all with Backspace key is not action");
    }


    public void copyAllTextByControlC(By by) {
        
        WebElement ele = DriverManager.getDriver().findElement(by);
        ele.sendKeys(string);
        //use action class to contrl A, C
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(ele).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        sleep(1);

        //control C
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        sleep(1);
        // Retrieve the copied text
        String copiedText = "";
        try {
            copiedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //verify
        Assert.assertEquals(copiedText, string, "Text copy from field is failed");
    }


    public void cutAllTextByControlX(By by) {
        
        WebElement element = DriverManager.getDriver().findElement(by);
        element.sendKeys(string);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();
        // Retrieve the copied text
        String copiedText = "";
        try {
            copiedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //verify
        Assert.assertEquals(copiedText, string, "Text cut from field is failed");

    }


    public void copyAllTextByMouse(By by) {
        
        WebElement element = DriverManager.getDriver().findElement(by);
        element.sendKeys(string);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.contextClick(element).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).contextClick(element).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

// Retrieve the copied text
        String copiedText = "";
        try {
            copiedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //verify
        Assert.assertEquals(copiedText, string, "Text cut from field is failed");
    }


    public void cutAllTextByMouse(By by) {
        
        WebElement element = DriverManager.getDriver().findElement(by);
        element.sendKeys(string);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.contextClick(element).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).contextClick(element).keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();

// Retrieve the copied text
        String copiedText = "";
        try {
            copiedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //verify
        System.out.println(copiedText);
        Assert.assertEquals(copiedText, string, "Text cut from field is failed");
    }


    public void copyFieldtoField(By byFrom, By byTo) {
        
        WebElement elementFrom = DriverManager.getDriver().findElement(byFrom);
        WebElement elementTo = DriverManager.getDriver().findElement(byTo);
        elementFrom.sendKeys(string);

        Actions actions = new Actions(DriverManager.getDriver());
        sleep(2);
        actions.moveToElement(elementFrom).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        sleep(3);
        //nhớ phải click thì lệnh dưới mới chạy đc, ko click nó ko hiểu
        actions.moveToElement(elementTo).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
        sleep(3);
        String textTo = elementTo.getAttribute("value");
        System.out.println(textTo);
        Assert.assertEquals(string, textTo, "The copied text do not match");


    }

    public void cutFieldtoField(By byFrom, By byTo) {
        
        WebElement eleFrom = DriverManager.getDriver().findElement(byFrom);
        WebElement eleTo = DriverManager.getDriver().findElement(byTo);
        eleFrom.sendKeys(string);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(eleFrom).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        sleep(3);
        //crtl x
        actions.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();
        sleep(3);
        sleep(01);
        //ctrl v
        actions.moveToElement(eleTo).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
        sleep(3);
        sleep(01);
        String textTo = eleTo.getAttribute("value");
        System.out.println(textTo);
        Assert.assertEquals(string, textTo, "The copied text do not match");
    }


    private void verifyMandatoryByTabFields(By by, By nextBy) {
        
        WebElement element = DriverManager.getDriver().findElement(by);
        WebElement elementNext = DriverManager.getDriver().findElement(nextBy);

        String validationMessage = element.getAttribute("validationMessage");
        System.out.println(validationMessage);
        element.click();
        element.sendKeys(Keys.TAB);
        Assert.assertEquals(validationMessage, "Please fill out this field.", "The validation message is not match");

    }

    private void verifyMandatoryByClickFields(By by, By nextBy) {
        
        WebElement element = DriverManager.getDriver().findElement(by);
        WebElement elementNext = DriverManager.getDriver().findElement(nextBy);
        //Check HTML5 Message With Value Valid - True
        System.out.println("Check Valid: " + ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return arguments[0].validity.valid;", element));
        element.click();
        elementNext.click();

        sleep(2);
        Assert.assertTrue((Boolean) ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return arguments[0].validity.valid;", element), "Email value not valid.");


    }


    public void verifyMandatoryByClickField() {
    }

    public void verifyMandatoryByEnterFields(By by, By nextBy) {
        
        WebElement element = DriverManager.getDriver().findElement(by);
        WebElement elementNext = DriverManager.getDriver().findElement(nextBy);
        String validationMessage = element.getAttribute("validationMessage");
        System.out.println(validationMessage);
        element.click();
        element.sendKeys(Keys.ENTER);
        Assert.assertEquals(validationMessage, "Please fill out this field.", "The validation message is not match");
//        //Check HTML5 Message With Value Valid - True
//        System.out.println("Check Valid: " + ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return arguments[0].validity.valid;", element));
//        element.click();
//        element.sendKeys(Keys.ENTER);
//        sleep(2);
//        Assert.assertTrue((Boolean) ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return arguments[0].validity.valid;", element), "Email value not valid.");


    }

    public void validateInputTextbox(By by, String string) {
        
        WebElement element = DriverManager.getDriver().findElement(by);
        element.sendKeys(string);
        sleep(2);
        //verify
        String checkText = element.getAttribute("value");
        Assert.assertEquals(string, checkText, "The input text don't match");

    }

    // </editor-fold>

    //<editor-fold desc="PASSWORD">
    public void verifyDefaultPassword(Method method) {
        verifyDefaultField(passTxt, method);

    }

    public void verifyPassword(String a) {


    }


    public void verifyEnteredPasswordfIELD(String a) {
        
        WebElement passwordE = DriverManager.getDriver().findElement(passTxt);
        passwordE.sendKeys(a);
        System.out.println("hello" + passwordE.getAttribute("textContent"));
//        verifyEnteredData(passTxt,a);
//        Assert.assertTrue(passwordE.getAttribute("Value").equalsIgnoreCase(a), "E");
    }

    public void verifyPlaceHolderPassword() {
    }

    public void isCursorPasswordVisiable() {
    }

    public void verifyClickPassword() {
    }

    public void verifyTypePassword() {
    }

    public void removeFirstTextByBackSpacePassword() {
    }

    public void removeFinalTextByBackSpacePassword() {
    }

    public void removeSecondTextByBackSpacePassword() {
    }

    public void copyAllTextByControlCPassword() {
    }

    public void cutAllTextByControlXPassword() {
    }

    public void cutAllTextByMousePassword() {
    }

    public void copyAllTextByMousePassword() {
    }

    public void copypasteLastnameToPassword() {
    }

    public void verifyTabPassword() {
    }

    public void verifyMandatoryByTabPassword() {
    }

    public void verifyMandatoryByEnterPassword() {
    }

    public void verifyMandatoryByClickPassword() {
    }

    public void verifyEnteredPassword(String string) {
    }

    public void boundaryPassword(String str) {
        //min =5, max =20
        boundaryField(passTxt, str, 5, 20);
    }

    //error
    public void checkFieldMask(By by) {
//        enterData(passTxt, pass);
        
        WebElement ele = DriverManager.getDriver().findElement(passTxt);
        ele.sendKeys(pass);
        sleep(4);
        
        String input = ele.getAttribute("Value");

        System.out.println("entered data" + ele.getAttribute("value"));

//        WebElement element=DriverManager.getDriver().findElement(passTxt);
//        element.sendKeys(pass);
//        sleep(4);

        String typeInput = ele.getAttribute("type");
        System.out.println(typeInput);
        Assert.assertEquals(typeInput, "password", "The field is not password type");
        String mask = "*";
        System.out.println(input);
        String inputRepearMask = mask.repeat(input.length());
        System.out.println(inputRepearMask);
        String passMasked = mask.repeat(pass.length());
        Assert.assertEquals(passMasked, inputRepearMask, "The password field displays characters in asterisks or bullets does not match");

    }

    public void checkPasswordFieldMask() {
        checkFieldMask(passTxt);
    }
    //</editor-fold>
    //<editor-fold desc="EMAIL ADDRESS TEXTBOX">


    public void verifyPlaceHolderEmailAddress() {
        verifyPlaceHolderField(emailTxt, "Email Address");
    }

    public void isCursorEmailAddressVisiable() {
        isCursorVisiable(emailTxt);
    }

    public void verifyClickEmailAddress() {
        isClickableField(emailTxt);
    }

    public void verifyTypeEmailAddress() {
        openRegisterPage();
        verifyTypeField(emailTxt,"cowsne");
    }

    public void removeFirstTextByBackSpaceEmailAddress() {
        openRegisterPage();
        removeFirstTextByBackSpacePassword();
    }

    public void removeFinalTextByBackSpaceEmailAddress() {
    }

    public void removeSecondTextByBackSpaceEmailAddress() {
    }

    public void copyAllTextByControlCEmailAddress() {
    }

    public void cutAllTextByControlXEmailAddress() {
    }

    public void cutAllTextByMouseEmailAddress() {
    }

    public void copyAllTextByMouseEmailAddress() {
    }

    public void copypasteLastnameToEmailAddress() {
    }

    public void cutpasteLastnameToEmailAddress() {
    }

    public void verifyTabEmailAddress() {
    }

    public void verifyMandatoryByTabEmailAddress() {
    }

    public void verifyMandatoryByEnterEmailAddress() {
    }

    public void verifyMandatoryByClickEmailAddress() {
    }

    public void verifyEnteredEmailAddress(String string) {
    }

    public void boundaryEmailAddress(String str) {
//        
//        boundaryField(emailTxt, str, 6, 20);
        openRegisterPage();
        sleep(2);
        sleep(2);
        WebElement element = DriverManager.getDriver().findElement(emailTxt);
        element.sendKeys(str);
        sleep(2);
        System.out.printf(element.getAttribute("value"));

    }

//    public void verifyTooltipAlertEmailAddress() {
//
////        WebElement element = DriverManager.getDriver().findElement(tooltipEmail);
////        WebElement elementEmail = DriverManager.getDriver().findElement(emailTxt);
////        elementEmail.click();
////        String string = element.getText();
////        System.out.println(string);
////        Assert.assertEquals("Provide a valid email id for further updates", string, "The text in tool tip do not match");
//    }


    private boolean isNumberic(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void verifyTooltipAlertEmailAddress() {
    }


    //</editor-fold>



    }