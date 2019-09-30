package examples;

import com.tngtech.java.junit.dataprovider.DataProvider;


public class Chapter3Test {
    @DataProvider
    public static Object[][] zipCodesAndPlaces(){
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"}
        };
    }
}
