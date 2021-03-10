package day0310;
// char 2차원 배열를 사용한 별찍기 1번

import java.util.Scanner;

public class StarsPrinter01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = sc.nextInt();

        // 출력할 내용을 저장할 char[][]을 만들어보자

        // 사용자가 5라고 입력하면?
        // char가 5개 들어가는 배열이 5개 모인 2차원 배열이 된다.

        char[][] stars = new char[userNumber][userNumber];
        
        // char 언어에 넣기

        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j <= i; j++) {
                stars[i][j] = '*';
            }

        }
        
        // 별찍기 시작
        for(int i = 0; i < stars.length;i++) {   // stars.length = 5
            for (int j = 0; j < stars[i].length;j++) {
                System.out.print(stars[i][j]);
                
            }
            System.out.println();
        }
        sc.close();
    }

}
