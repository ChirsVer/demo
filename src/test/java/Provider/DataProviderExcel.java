package Provider;

import Helpers.ExcelHelper;
import Helpers.SystemHelper;
import org.testng.annotations.DataProvider;


public class DataProviderExcel {
    @DataProvider(name = "data_provider_login_excel")
    public Object[][] dataLoginCRMFromExcel() {
        ExcelHelper excelHelpers = new ExcelHelper();
        Object[][] data = excelHelpers.getExcelData(SystemHelper.getCurrentDir() + "src/test/java/TestData/crm.xlsx", "Login");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    @DataProvider(name = "harddata")
    public Object[][] dataLogin() {
        return new Object[][]{{"hello@gmail.com", "123456"}, {"hello1234@gmail.com", "123456"}};
    }

    @DataProvider(name = "register")
    public Object[][] dataRegisterFromExcel() {
        ExcelHelper excelHelpers = new ExcelHelper();
        Object[][] data = excelHelpers.getExcelData(SystemHelper.getCurrentDir() + "src/test/java/DataTest/dataRegister01.xlsx", "dataRegister01");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    @DataProvider(name = "gender")
    public Object[][] dataTestFromExcel() {
        ExcelHelper excelHelpers = new ExcelHelper();
        Object[][] data = excelHelpers.getExcelData(SystemHelper.getCurrentDir() + "src/test/java/DataTest/dataTest.xlsx", "gender");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    @DataProvider(name = "language")
    public Object[][] dataLanguageExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData(SystemHelper.getCurrentDir() + "src/test/java/DataTest/dataTest.xlsx", "language");
        System.out.printf("Language from Excel" + data);
        return data;
    }

    @DataProvider(name = "skills")
    public Object[][] dataSkillsExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/java/DataTest/dataTest.xlsx", "skills");
        System.out.println("Skills from Excel " + data);
        return data;
    }

    @DataProvider(name = "country")
    public Object[][] dataCountryExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/java/DataTest/dataTest.xlsx", "country");

        return data;
    }

    @DataProvider(name = "date")
    public Object[][] dataDateExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/java/DataTest/dataTest.xlsx", "date");

        return data;
    }

    @DataProvider(name = "search-country")
    public Object[][] dataSearchCountryExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/java/DataTest/dataTest.xlsx", "search_country");

        return data;
    }

    @DataProvider(name = "password")
    public Object[][] dataPasswordExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/java/DataTest/dataTest.xlsx", "password");

        return data;
    }

    @DataProvider(name = "repassword")
    public Object[][] dataRePasswordExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/java/DataTest/dataTest.xlsx", "repassword");

        return data;
    }

    @DataProvider(name = "lastname")
    public Object[][] dataLoginHRMFromExcelHashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable(Helpers.SystemHelper.getCurrentDir() + "src/test/java/DataTest/dataTest.xlsx", "lastname", 2, 4);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    @DataProvider(name = "address")
    public Object[][] dataFristnameExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/java/DataTest/dataTest.xlsx", "address");

        return data;
    }
    @DataProvider(name = "firstname")
    public Object[][] data() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/java/DataTest/dataTest.xlsx", "firstname");
//        Object[][] data = excelHelper.getDataHashTable(Helpers.SystemHelper.getCurrentDir() + "src/test/java/DataTest/dataTest.xlsx", "firstname", 1,4);

        return data;
    }
    @DataProvider(name = "phone")
    public Object[][] dataPhoneExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/java/DataTest/dataTest.xlsx", "phone");
//        Object[][] data = excelHelper.getDataHashTable(Helpers.SystemHelper.getCurrentDir() + "src/test/java/DataTest/dataTest.xlsx", "firstname", 1,4);

        return data;
    }
    @DataProvider(name = "email")
    public Object[][] dataEmailExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/java/DataTest/dataTest.xlsx", "email");
//        Object[][] data = excelHelper.getDataHashTable(Helpers.SystemHelper.getCurrentDir() + "src/test/java/DataTest/dataTest.xlsx", "firstname", 1,4);

        return data;
    }


}
