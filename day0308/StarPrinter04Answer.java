package day0308;

import java.util.Scanner;

public class StarPrinter04Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 줄 수 만큼 입력하세요");
        System.out.print("> ");
        int userNumber = sc.nextInt();

        for (int i = 1; i <= userNumber; i++) {
            String stars = new String();

            // 공백을 담당하는 j for 문
            for (int j = 1; j <= i - 1; j++) {
                stars += " ";
            }
            // 별을 담당하는 j for 문
            for (int j = i; j <= userNumber; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
        sc.close();

    }

}
