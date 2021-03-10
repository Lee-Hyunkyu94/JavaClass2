package day0310;

import java.util.Scanner;

public class StarsPrinter03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 줄 수 만큼 입력하시오");
        System.out.print("> ");
        int userNumber = sc.nextInt();
        char[][] stars = new char[userNumber][userNumber];

        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < stars.length; j++) {
                stars[i][j] = '*';
            }
            for(int j =0; j < stars.length-i-1;j++){
                star[i][j] = ' ';
            }
        } // 5행일때 다 찍혀야함 j=0 부터 시작
          // 4행일때 4개 j = 1부터 4까지
        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < stars[i].length; j++) {
                System.out.print(stars[i][j]);
            }
            System.out.println();
        }
        sc.close();

    }

}
