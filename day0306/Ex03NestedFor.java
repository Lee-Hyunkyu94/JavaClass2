package day0306;

public class Ex03NestedFor {
    public static void main(String[] args) {
        for(int i = 1; i <= 3; i++) {
            for(int j = 101; j <= 104; j++) {
                System.out.printf("i의 현재값: [%d], j의 현재값: [%d]\n", i, j);
            }
            System.out.println("==============================================");
        }
    }
}
