package day0308;

// 별찍기 10번

import java.util.Scanner;

public class StarPrinter10Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 줄 수를 입력하세요");
        System.out.print("> ");
        int userNumber = sc.nextInt();

        // 총 폭이 9칸
        // if else 사용 1, 마지막줄 = * 쭉 찍기
        // i < userNumber 위 3 / else 나머지

        for (int i = 1; i <= 2 * userNumber - 1; i++) {
            String stars = new String();
            int score = userNumber -1;
            int lowerI = 2 * userNumber - i;

            if (i < score) {
                // 윗부분 별담당

                for (int j = 1; j <= userNumber - i; j++) {
                    stars += "*";
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    stars += " ";
                }
                for (int j = 1; j <= userNumber - i; j++) {
                    stars += "*";
                }

            } else if (i >= score) {
                // 별
                for (int j = 1; j <= userNumber - lowerI; j++) {
                    stars += "*";

                }
                    // 공백
                for (int j = 1; j <= 2 * lowerI - 1; j++) {
                    stars += " ";
                }
                // 별
                for (int j = 1; j <= userNumber - lowerI; j++) {
                    stars += "*";
                }

            } else if(i == 1 && i == 9) {
                
               for(int j =1; j <= i ;j++) {
                   stars = ".";

            }

            }

            System.out.println(stars);
        }

        sc.close();
    }
}
