package day0311;
// char 2차원 배열를 사용한 별찍기 1번

import java.util.Scanner;

public class StarsPrinter05Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("별찍기 5번");
        System.out.println("출력할 줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = sc.nextInt();
        int userNumber2 = 2 * userNumber - 1;

        char[][] stars = new char[userNumber][userNumber2];

        for (int i = 0; i < stars.length; i++) {
            // 별의 갯수 = (i + 1) * 2 - 1
            // = 2 * i + 2 - 1
            // = 2 * i + 1
            int starWidth = 2 * i + 1;

            // 별이 찍히는 시작 지점: 4 - 3 - 2 - 1 - 0
            // = userNumber - (i + 1)
            int starStart = userNumber - (i + 1);

            // 별을 담당하는 j for 문
            for (int j = starStart; j < starStart + starWidth; j++) {
                stars[i][j] = '*';
            }

        }

        for (int i = 0; i < stars.length; i++) { // stars.length = 5
            for (int j = 0; j < stars[i].length; j++) {
                System.out.print(stars[i][j]);

            }
            System.out.println();
        }
        sc.close();
    }

}