public class Calculator {

    public static String operator="add";

    public static int add(int num1, int numb2){
        return num1+numb2;
    }

    public static int add2(int num1, int numb2){
        if (num1<numb2){
            throw new IllegalArgumentException("My exception");
        }

        return num1+numb2;
    }


}
