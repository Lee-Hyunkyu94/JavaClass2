package day0310;

import java.util.Scanner;

public class Starsprinter04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 줄 수 만큼 입력하시오");
        System.out.print("> ");
        int userNumber = sc.nextInt();
        char[][] stars = new char[userNumber][userNumber];

        for (int i = 0; i < stars.length; i++) {
            for (int j = i; j < stars.length; j++) {
                stars[i][j] = '*';
            }
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
