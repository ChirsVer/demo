package TCs;

import Listenter.TestListener;
import Logs.LogUtils;
import Page.RegisterPage;
import Provider.DataProviderExcel;
import common.BaseTest;
import keywords.DriverManager;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Helpers.CaptureHelper;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static Helpers.ExcelHelper.readExcelToList;
import static keywords.WebUI.sleep;


@Listeners(TestListener.class)
public class RegisterTCs extends BaseTest {
    RegisterPage r;

    @Test
    public void test(){
        r = new RegisterPage();
        r.testLocator();
    }

 //  <editor-fold desc="PASSWORD">
    @Test(groups = "UI-Password", description = "Check whether placeholder text should be shown properly for the name field.")
    public void verifyPlaceHolderPasswordTC() {

        r = new RegisterPage();

                r.verifyPlaceHolderPassword();
    }

    @Test(groups = "UI-Password", description = "When the user clicks on the name field, the text cursor should be visible in the name field.\n")
    public void verifyCursorPasswordTC() {
        r = new RegisterPage();
        r.isCursorPasswordVisiable();
    }

    @Test(groups = "UI-Password", description = "Check whether the user can click on the name field or not.")
    public void verifyClickPasswordTC() {
        r = new RegisterPage();
        r.verifyClickPassword();
    }

    @Test(groups = "UI-Password", description = "Check whether the user can type in the name field or not.")
    public void verifyTypePasswordTC() {
        r = new RegisterPage();
        r.verifyTypePassword();
    }

    @Test(groups = "UI-Password", description = "Check if Character removal by Backspace key.")
    public void removeFirstTextPasswordTC() {
        r = new RegisterPage();
        r.removeFirstTextByBackSpacePassword();
    }

    @Test(groups = "UI-Password", description = "Check if Character removal by Backspace key.")
    public void removeFinalTextPasswordTC() {
        r = new RegisterPage();
        r.removeFinalTextByBackSpacePassword();
    }

    @Test(groups = "UI-Password", description = "Check if Character removal by Backspace key.")
    public void removeSecondTextPasswordTC() {
        r = new RegisterPage();
        r.removeSecondTextByBackSpacePassword();
    }


    @Test(groups = "UI-Password", description = "Check the user  copy text by Control C key.")
    public void copyAllTextByControlCPasswordTC() {
        r = new RegisterPage();
        r.copyAllTextByControlCPassword();
    }

    @Test(groups = "UI-Password", description = "Check the user cut copy text by Control X key.")
    public void cutAllTextByControlXPasswordTC() {
        r = new RegisterPage();
        r.cutAllTextByControlXPassword();
    }

    @Test(groups = "UI-Password", description = "Check the user cut copy text by mouse.")
    public void cutAllTextByMousePasswordTC() {
        r = new RegisterPage();
        r.cutAllTextByMousePassword();
    }

    @Test(groups = "UI-Password", description = "Check the user can copy text by mouse.")
    public void copyAllTextByMousePasswordTC() {
        r = new RegisterPage();
        r.copyAllTextByMousePassword();
    }

    @Test(groups = "UI-Password", description = "Check the user can copy/paste text from the name field.")
    public void copypasteLastnameToPasswordTC() {
        r = new RegisterPage();
        r.copypasteLastnameToPassword();
    }

    @Test(groups = "UI-Password", description = "Check the user can cut/paste text from the name field.")
    public void cutpasteLastnameToPasswordTC() {
        r = new RegisterPage();
        r.copypasteLastnameToPassword();
    }

    @Test(groups = "UI-Password", description = ".Check the user can press tab key the previous field.")
    public void verifyTabPasswordTC() {
        r = new RegisterPage();
        r.verifyTabPassword();
    }

    @Test(groups = "Validate-Password", description = "")
    public void verifyMandatoryByTabPasswordTC() {
        r = new RegisterPage();
        r.verifyMandatoryByTabPassword();
    }

    @Test(groups = "Validate-Password", description = "")
    public void verifyMandatoryByEnterPasswordTC() {
        r = new RegisterPage();
        r.verifyMandatoryByEnterPassword();
    }

    @Test(groups = "Validate-Password", description = "")
    public void verifyMandatoryByClickPasswordTC() {
        r = new RegisterPage();
        r.verifyMandatoryByClickPassword();
    }

    @Test(groups = "Validate-Password", description = "Check input data", dataProvider = "password", dataProviderClass = DataProviderExcel.class)
    public void verifyInputDataPasswordTC(String string) {
        r = new RegisterPage();
        r.verifyEnteredPassword(string);
    }

    @Test(groups = "Validate-Password", description = ".", dataProvider = "password", dataProviderClass = DataProviderExcel.class)
    public void boundaryPasswordTC(String str) {
        r = new RegisterPage();
        r.boundaryPassword(str);

    }


    //</editor-fold>@Test
    //<editor-fold desc="PHONE FIELD">
    //    @Test(groups = "Validate-Phone", dataProvider = "phone", dataProviderClass = DataProviderExcel.class)
    @Test
    public void validateFormatPhoneTC() {
        r = new RegisterPage();
//        r.validateFormatPhoneVN("907-347-9870");
//        r.validateFormatPhone("907-3479870");

    }

    @Test
    public void validateBoundaryPhoneTC() {
        r = new RegisterPage();
//        r.validateBoundaryPhone("09768939942");
    }

    @Test(groups = "Validate-Phone", dataProvider = "phone", dataProviderClass = DataProviderExcel.class)
    public void validateEnteredPhone(String input) {
        r = new RegisterPage();
//        r.validateEnteredPhone(input);
    }

    @Test(groups = "Validate-Phone", dataProvider = "phone", dataProviderClass = DataProviderExcel.class)
    public void validateEnteredPhoneTC(String input) {
        r = new RegisterPage();
//        r.validateEnteredPhone(input);
    }


    //</editor-fold>
    //<editor-fold desc="UI">
    @Test(groups = "UI-Header")
    public void verifyHeaderTC(Method method) {
        LogUtils.error("error");
        LogUtils.warn("warn");
        LogUtils.fatal("fatal");
        CaptureHelper.startRecord(method.getName());
        r = new RegisterPage();

                r.verifyHeaderRegisterPage();


    }

    @Test(groups = "UI")
    public void verifyDefaultFiledsEmptyTC() {

    }


//    </editor-fold>
 //   <editor-fold desc="EMAIL ADDRESS TEXTBOX">
    @Test(groups = "UI-EmailAddress")
    public void verifyTooltipAlertEmailAddressTC() {
        r = new RegisterPage();
        r.verifyTooltipAlertEmailAddress();
    }

    @Test(groups = "UI-EmailAddress", description = "Check whether placeholder text should be shown properly for the name field.")
    public void verifyPlaceHolderEmailAddressTC() {
        r = new RegisterPage();
        r.verifyPlaceHolderEmailAddress();
    }

    @Test(groups = "UI-EmailAddress", description = "When the user clicks on the name field, the text cursor should be visible in the name field.\n")
    public void verifyCursorEmailAddressTC() {
        LogUtils.info("I am a cow");
        r = new RegisterPage();
        r.isCursorEmailAddressVisiable();
    }

    @Test(groups = "UI-EmailAddress", description = "Check whether the user can click on the name field or not.")
    public void verifyClickEmailAddressTC() {
        r = new RegisterPage();
        r.verifyClickEmailAddress();
    }

    @Test(groups = "UI-EmailAddress", description = "Check whether the user can type in the name field or not.")
    public void verifyTypeEmailAddressTC() {
        r = new RegisterPage();
        r.verifyTypeEmailAddress();
    }

//    @Test(groups = "UI-EmailAddress", description = "Check if Character removal by Backspace key.")
//    public void removePositionTextEmailAddressTC() {
//        r = new RegisterPage();
//        r.removePositionTextEmailAddress();
//    }

    @Test(groups = "UI-EmailAddress", description = "Check if Character removal by Backspace key.")
    public void removeFirstTextEmailAddressTC() {
        r = new RegisterPage();
        r.removeFirstTextByBackSpaceEmailAddress();
    }

    @Test(groups = "UI-EmailAddress", description = "Check if Character removal by Backspace key.")
    public void removeFinalTextEmailAddressTC() {
        r = new RegisterPage();
        r.removeFinalTextByBackSpaceEmailAddress();
    }

    @Test(groups = "UI-EmailAddress", description = "Check if Character removal by Backspace key.")
    public void removeSecondTextEmailAddressTC() {
        r = new RegisterPage();
        r.removeSecondTextByBackSpaceEmailAddress();
    }


    @Test(groups = "UI-EmailAddress", description = "Check the user  copy text by Control C key.")
    public void copyAllTextByControlCEmailAddressTC() {
        r = new RegisterPage();
        r.copyAllTextByControlCEmailAddress();
    }

    @Test(groups = "UI-EmailAddress", description = "Check the user cut copy text by Control X key.")
    public void cutAllTextByControlXEmailAddressTC() {
        r = new RegisterPage();
        r.cutAllTextByControlXEmailAddress();
    }

    @Test(groups = "UI-EmailAddress", description = "Check the user cut copy text by mouse.")
    public void cutAllTextByMouseEmailAddressTC() {
        r = new RegisterPage();
        r.cutAllTextByMouseEmailAddress();
    }

    @Test(groups = "UI-EmailAddress", description = "Check the user can copy text by mouse.")
    public void copyAllTextByMouseEmailAddressTC() {
        r = new RegisterPage();
        r.copyAllTextByMouseEmailAddress();
    }

    @Test(groups = "UI-EmailAddress", description = "Check the user can copy/paste text from the name field.")
    public void copypasteLastnameToEmailAddressTC() {
        r = new RegisterPage();
        r.copypasteLastnameToEmailAddress();
    }

    @Test(groups = "UI-EmailAddress", description = "Check the user can cut/paste text from the name field.")
    public void cutpasteLastnameToEmailAddressTC() {
        r = new RegisterPage();
        r.cutpasteLastnameToEmailAddress();
    }

    @Test(groups = "UI-EmailAddress", description = ".Check the user can press tab key the previous field.")
    public void verifyTabEmailAddressTC() {
        r = new RegisterPage();
        r.verifyTabEmailAddress();
    }

    @Test(groups = "Validate-EmailAddress", description = "")
    public void verifyMandatoryByTabEmailAddressTC() {
        r = new RegisterPage();
        r.verifyMandatoryByTabEmailAddress();
    }

    @Test(groups = "Validate-EmailAddress", description = "")
    public void verifyMandatoryByEnterEmailAddressTC() {
        r = new RegisterPage();
        r.verifyMandatoryByEnterEmailAddress();
    }

    @Test(groups = "Validate-EmailAddress", description = "")
    public void verifyMandatoryByClickEmailAddressTC() {
        r = new RegisterPage();
        r.verifyMandatoryByClickEmailAddress();
    }

    @Test(groups = "Validate-EmailAddress", description = "Check input data", dataProvider = "address", dataProviderClass = DataProviderExcel.class)
    public void verifyInputDataEmailAddressTC(String string) {
        r = new RegisterPage();
        r.verifyEnteredEmailAddress(string);
    }

//    @Test(groups = "Validate-EmailAddress", description = ".", dataProvider = "email", dataProviderClass = DataProviderExcel.class)
//    public void boundaryEmailAddressTC(String str) {
//        r = new RegisterPage();
//        r.boundaryEmailAddress(str);
//
//    }

    //lỗi ver123 chưa test email
    @Test
    public void test02() {
        r = new RegisterPage();
        r.boundaryEmailAddress("123");

    }

    //</editor-fold>
}
