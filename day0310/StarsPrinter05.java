package day0310;
// char 2차원 배열를 사용한 별찍기 1번

import java.util.Scanner;

public class StarsPrinter05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = sc.nextInt();
        int userNumber2 = 2 * userNumber -1;

        char[][] stars = new char[userNumber][userNumber2];

        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j <= stars[i].length; j++) {
                stars[i][j] = '*';
            }
            for(int j =i; j < stars.length;i++) {
                stars[i][j] = '.';
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
