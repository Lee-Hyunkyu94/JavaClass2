package day0308;

// 별찍기 7번

import java.util.Scanner;

public class StarPrinter07Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 줄 수 만큼 입력하세요");
        System.out.print("> ");
        int userNumber = sc.nextInt();

        // 윗부분을 담당하는 i for 문
        for (int i = 1; i <= userNumber - 1; i++) {
            String stars = new String();

            for (int j = 1; j <= i; j++) {
                stars += "*";
            }

            System.out.println(stars);
        }

        // 아랫부분을 담당하는 i for문
        for (int i = 1; i <= userNumber; i++) {
            String stars = new String();

            for (int j = i; j <= userNumber; j++)
                stars += "*";

            System.out.println(stars);
        }

        sc.close();
    }
}
