package day0308;

// 별찍기 9번

import java.util.Scanner;

public class StarPrinter09AnswerHard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 줄 수 만큼 입력하세요");
        System.out.print("> ");
        int userNumber = sc.nextInt();

        for (int i = 1; i <= 2 * userNumber - 1; i++) {
            String stars = new String();

            if (i < userNumber) {
                // 윗부분

                // 공백을 담당하는 j for 문
                for (int j = 1; j <= userNumber - i; j++) {
                    stars += " ";
                }

                // 별을 담당하는 j for 문
                for (int j = 1; j <= 2 * i - 1; j++) {
                    stars += "*";
                }
            } else {
                // 아랫부분
                // 아랫부분의 j for 문에서 사용할 loewrI
                int lowerI = userNumber * 2 - i;
                
                // 공백을 담당하는 j for 문
                for (int j = 1; j <= userNumber - lowerI; j++) {// -userNumber + i
                    stars += " ";
                }
                
                // 별을 담당하는 j for 문 
                for (int j = 1; j <= 2 * lowerI -1;j++) {
                    stars += "*";
                }

            }

            System.out.println(stars);
        }

        sc.close();

    }
}
