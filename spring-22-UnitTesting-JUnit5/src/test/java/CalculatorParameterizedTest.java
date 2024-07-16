import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {


    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "C#", ""})
        // this provides a single parameter per test method
    void testCase1(String arg) {
        Assertions.assertFalse(arg.isEmpty()); // this will be run for each string value
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10})
        // this provides a single parameter per test method
    void testCase2(int num) {
        Assertions.assertEquals(0, num % 2); // this will be run for each string value
    }


    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "C#", "TS"}) // this provides a single parameter per test method
    //  @EmptySource  " "
    //   @NullSource
    @NullAndEmptySource
    void testCase3(String arg) {
        Assertions.assertFalse(arg.isEmpty()); // this will be run for each string value
    }


    @ParameterizedTest
    @MethodSource("stringProvider")
        // this will run each string in the string provider method
        // Basically we provide method for our test case to test
    void testCase4(String arg) {
        Assertions.assertFalse(arg.isEmpty()); // this will be run for each string value
    }

    static String[] stringProvider() {

        return new String[]{"Java", "JS", "C#", "TS"};
    }

    @ParameterizedTest
    @CsvSource({
            "10, 10, 20",
            "20, 30, 50",
            "100, 200, 300"
    })
    void testCase5(int num1, int num2, int result) { // it will test each row one by one continuously
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    @DisplayName("Test6")
    void testCase6(int num1, int num2, int result) { // it will test each row one by one continuously
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }


}
