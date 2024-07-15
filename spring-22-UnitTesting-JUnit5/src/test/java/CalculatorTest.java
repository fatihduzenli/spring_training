import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        // Calculator is my class and add is the method we have inside
        // Whatever this method is returning will be my actual
        int actual = Calculator.add(2, 3);
        // Expected is first actual is the second always
        assertEquals(6, actual, "Test fail");
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
        assertArrayEquals(new int[]{1,2,3},new int []{1,2,3},"Arrays are not same.");
    }


    @Test
    void testCase3() {
        System.out.println("Test case 3");
        String notNullString="Cydeo";
        String nullString=null;

        assertNull(nullString);
        assertNotNull(notNullString);
    }


    @Test
    void testCase4() {
        System.out.println("Test case 4");
    }


    @Test
    void testCase5() {
        System.out.println("Test case 5");
    }

}