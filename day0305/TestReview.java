package day0305;

public class TestReview {
    public static void main(String[] args) {
        int num1 = 0, num2 = 0;
        boolean result;
        // Q1.
        
        int a = 10;
        char ch = 'A';
        double d = 3.14d;
        
        //Stirng s = 'Hello';
        String s = "Hello";
        
        // Q2. 
        result = ((num1 =+ 10) < 0 && (num2 +=10) > 0);
        System.out.println("num1= " + num1 + "num2= " + num2);
        result = ((num1 =+ 10) > 0 || (num2 +=10) > 0);
        System.out.println("num1= " + num1 + "num2= " + num2);
        
    }

}
