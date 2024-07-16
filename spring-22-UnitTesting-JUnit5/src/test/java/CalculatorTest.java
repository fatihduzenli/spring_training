import org.junit.jupiter.api.*;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll //Before all has to be static method. This method will be executed after all the methods are executed.
    static void setUpAll() {

    }

    @AfterAll
    static void tearDownAll() {

    }

    @BeforeEach // THis method will be executed after each method execution each time
    void setUpEach() {
        System.out.println("BeforeEach is executed");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("AfterEach is executed");
    }

    @Test
    void add() {
        System.out.println("Add method");
        // Calculator is my class and add is the method we have inside
        // Whatever this method is returning will be my actual
        int actual = Calculator.add(2, 3);
        // Expected is first actual is the second always
        assertEquals(5, actual, "Test fail");
        //OR
        //  assertEquals(6, Calculator.add(2, 3), "Test fail");
    }

    @Test
    void testCase1() {
        System.out.println("Test case 1");
        assertTrue(Calculator.operator.equals("add"));
        //OR
        assertEquals("add", Calculator.operator);
    }


    @Test
    void testCase2() {
        System.out.println("Test case 2");
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3}, "Arrays are not same.");
    }


    @Test
    void testCase3() {
        System.out.println("Test case 3");
        String notNullString = "Cydeo";
        String nullString = null;

        assertNull(nullString);
        assertNotNull(notNullString);
    }


    @Test
    void testCase4() {
        System.out.println("Test case 4");

        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1, c2);
        assertNotSame(c3, c2);
    }


    @Test
    void testCase5() {
        System.out.println("Add2 method");
// Condition was --> if numb1<numb2 throw exception, if exception occurs test will pass.If it doesn't occur or different type of exception occur test will fail
        //    assertThrows(IllegalArgumentException.class,()-> Calculator.add2(1,2));
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(1, 2));
    }

}