package restAssuredTestNG;

import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matcher;

public class RestUtils {
    public static String empName() {
        String generatedName = RandomStringUtils.randomAlphabetic(5);
        return ("Hiru-" + generatedName);
    }

    public static String location() {
        String generatedLocation = RandomStringUtils.randomAlphabetic(2);
        return ("New York-" + generatedLocation);
    }

    public static String phone() {
        String generatedPhone = RandomStringUtils.randomNumeric(10);
        return generatedPhone;
    }

    public static String age() {
        String generatedAge = RandomStringUtils.randomNumeric(2);
        return generatedAge;
    }
}
