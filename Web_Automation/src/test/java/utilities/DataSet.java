package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name="invalidUsr")
    public static Object[][] invalidCredential(){
        Object[][]  data= {{"standard_user","12","Epic sadface: Username and password do not match any user in this service"},

                {"","secret_sauce","Epic sadface: Username is required"},
                {"","","Epic sadface: Username is required"}};

        return data;
    }
}
