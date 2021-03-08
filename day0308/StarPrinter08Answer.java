package day0308;

// 별찍기 8번

import java.util.Scanner;

public class StarPrinter08Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 줄 수 만큼 입력하세요");
        System.out.print("> ");
        int userNumber = sc.nextInt();

        for (int i = 1; i <= userNumber; i++) {
            for (int j = 1; j <= userNumber - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++)
                System.out.print("*");

            System.out.println();
        }
        for (int i = 1; i <= userNumber - 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j <= userNumber - 1; j++)
                System.out.print("*");

            System.out.println();
        }
            sc.close();
            
    }
}
