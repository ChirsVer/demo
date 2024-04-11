package keywords;

import Logs.LogUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

public class WebUI {
    private static int TIMEOUT = 10; //Chờ đợi của WebDriverWait
    private static double STEP_TIME = 0.5; //Chờ đợi của hàm sleep
    private static int PAGE_LOAD_TIMEOUT = 40; //Chờ đợi trang load

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }
    public static WebElement getWebElement(By by){
        return DriverManager.getDriver().findElement(by);
    }
    //Chờ đợi trang load xong mới thao tác
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) (DriverManager.getDriver());

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }
    public static void waitForElementVisible(WebDriver driver, By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second), Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Wait for Element

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            logConsole("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementVisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            logConsole("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Element not exist. " + by.toString());
            logConsole("Element not exist. " + by.toString());
        }
    }

    public static void waitForElementPresent(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Element not exist. " + by.toString());
            logConsole("Element not exist. " + by.toString());
        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            logConsole("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    public static void waitForElementClickable(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            logConsole("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    public static void waitForElementNotVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element NOT visible. " + by.toString());
            logConsole("Timeout waiting for the element NOT visible. " + by.toString());
        }
    }

    public static void waitForElementNotVisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element NOT visible. " + by.toString());
            logConsole("Timeout waiting for the element NOT visible. " + by.toString());
        }
    }

    public static void setKey(By by, Keys key) {
        waitForPageLoaded();
        getWebElement(by).sendKeys(key);
        System.out.println("Set key: " + key.toString() + " on element " + by);
    }

    public static void setTextAndKey(By by, String value, Keys key) {
        waitForPageLoaded();
        getWebElement(by).sendKeys(value, key);
        System.out.println("Set text: " + value + " on element " + by);
    }

    public static void scrollToElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
        LogUtils.info("");
    }

    public static void scrollToElementByElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToPosition(int X, int Y) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(" + X + "," + Y + ");");
    }

    public static boolean moveToElement(By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            logConsole(e.getMessage());
            return false;
        }
    }

    public static boolean moveToOffset(int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveByOffset(X, Y).build().perform();
            return true;
        } catch (Exception e) {
            logConsole(e.getMessage());
            return false;
        }
    }

    public static boolean hoverElement(By by) {
        try {

            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean mouseHover(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean dragAndDrop(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
            //action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            logConsole(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropElement(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            logConsole(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropOffset(By fromElement, int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            //Tính từ vị trí click chuột đầu tiên (clickAndHold)
            action.clickAndHold(getWebElement(fromElement)).pause(1).moveByOffset(X, Y).release().build().perform();
            return true;
        } catch (Exception e) {
            logConsole(e.getMessage());
            return false;
        }
    }

    public static boolean pressENTER() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressESC() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressF11() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F11);
            robot.keyRelease(KeyEvent.VK_F11);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    //<editor-fold desc="common">
    public static  void clickElement(By by) {
        WebElement element = getElement(by);
        element.click();
        LogUtils.info("Click element " + by);
        sleep(2);
    }

    public static  WebElement getElement(By by) {
        WebElement element = DriverManager.getDriver().findElement(by);
        return element;
    }

    public static  void verifyPlaceHolderField(By by, String string) {
        
        WebElement element=getElement(by);
        element.click();
        Assert.assertEquals(DriverManager.getDriver().findElement(by).getAttribute("Placeholder"), string, "Invalid " + string + " placeholder!");

    }

    ///kểm tra all feilds
    public static  void isEmptyDefaultFields() {
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
//    public static  String extractDataFromWebsite() {
//        
//        // Locate and extract the desired data
//        WebElement dataElement = DriverManager.getDriver().findElement(skillDropdownlist);
//        String data = dataElement.getText();
//
//        return data;
//    }

    //chưa clear
    public static  void verifyDefaultCountry() {
        
        //xpath này đúng
//        By countryDl = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div");
        By countryDl = By.xpath("//*[@id=\"country\"]");
        WebElement ele = DriverManager.getDriver().findElement(countryDl);

        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele);
        System.out.println(ele.getText());
        Assert.assertNull(ele.getText().isEmpty(), "Invalid Default Country field");

        ele.click();
    }

//    public static  void verifyCountryDroplist(String a) {
//        
//        WebElement ele = DriverManager.getDriver().findElement(countryDl);
//        Select select = new Select(ele);
//        select.selectByVisibleText(a);
//        sleep(2);
//    }

    public static  void verifySearchCountry(String au) {
        
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

    public static  void verifyDefaultField(By by, Method method) {
        

        WebElement passEle = DriverManager.getDriver().findElement(by);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", passEle);

        Assert.assertTrue(passEle.getText().isEmpty(), method.getName() + "invalid");
        System.out.println(method.getName() + passEle.getText());


    }

    private void verifyEnteredData(By b, String a) {
        WebElement dataEntered = DriverManager.getDriver().findElement(b);
        Assert.assertTrue(dataEntered.getAttribute("Value").equalsIgnoreCase(a), "Entered data is matching");

    }


    public static  void isCursorVisiable(By by) {
        
        WebElement ele = DriverManager.getDriver().findElement(by);
        ele.click();
        WebElement eleActive = DriverManager.getDriver().switchTo().activeElement();
        Assert.assertEquals(ele, eleActive, "Text cursor is not visiable");

    }

    public static  void isClickableField(By by) {
        
        WebElement ele = DriverManager.getDriver().findElement(by);
        boolean stt = ele.isEnabled();
        Assert.assertTrue(stt, "The field can't be enable");

    }

    public static  void verifyTypeField(By by, String testtype) {
        
        WebElement element = DriverManager.getDriver().findElement(by);
        element.sendKeys(testtype);
        String verifyTest = element.getAttribute("value");
        Assert.assertEquals(testtype, verifyTest, "The a entered value is not match");
    }


    public static  void verifyTab(By preBy, By by) {
        
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


    public static  void boundaryField(By by, String str, int min, int max) {
        
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
//    public static  void boundaryFristname(String s) {
//        boundaryField(firstnameTxt, s, min_lenght_lastname, max_lenght_lastname);
//    }

    public static  void enterData(By by, String str) {

        WebElement ele = DriverManager.getDriver().findElement(by);
        ele.sendKeys(str);
        sleep(4);
        System.out.println("entered data" + ele.getAttribute("value"));
    }


    //cuoi
    public static  void removeFinalTextBackSpace(By by, String str, int times) {
        
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


    public static  void removePositionText(By by, String text, int positionCursor, int times) {
        
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

    public static  void removeAllTextBackspace(By by) {
        
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


    public static  void copyAllTextByControlC(By by,String string) {
        
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


    public static  void cutAllTextByControlX(By by,String string) {
        
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


    public static  void copyAllTextByMouse(By by,String string) {
        
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


    public static  void cutAllTextByMouse(By by,String string) {
        
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


    public static  void copyFieldtoField(By byFrom, By byTo,String string) {
        
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

    public static  void cutFieldtoField(By byFrom, By byTo,String string) {
        
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


    public static  void verifyMandatoryByClickField() {
    }

    public static  void verifyMandatoryByEnterFields(By by, By nextBy) {
        
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

    public static  void validateInputTextbox(By by, String string) {
        
        WebElement element = DriverManager.getDriver().findElement(by);
        element.sendKeys(string);
        sleep(2);
        //verify
        String checkText = element.getAttribute("value");
        Assert.assertEquals(string, checkText, "The input text don't match");

    }

    // </editor-fold>


}
