package day0310;

import java.util.Scanner;

public class StarsPrinter06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = sc.nextInt();
        int userNumber2 = 2 * userNumber - 1;

        char[][] stars = new char[userNumber][userNumber2];
        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < stars.length; j++) {
                stars[i][j] = ' '; 
            }
            
            for (int j = i; j < stars[i].length-i; j++) {
                stars[i][j] = '*';
            }
            
            // 04
            // 13 14 15
            // 22 23 24 25 26
        }

        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < stars[i].length; j++) {
                System.out.print(stars[i][j]);

            }
            System.out.println();
        }
        sc.close();
    }
}
