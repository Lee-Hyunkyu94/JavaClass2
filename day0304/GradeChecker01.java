package day0304;
// 사용자로부터 점수를 입력받아서
// A, B, C, D, F 가 출력되는 프로그램을 작성하세요

import java.util.Scanner;

// 90점이상: A
// 80점대: B
// 70점대: C
// 60점대: D
// 그외: F
public class GradeChecker01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하시오");
        System.out.println("> ");
        double number = sc.nextDouble();
        
        if(number >= 90) {
            System.out.println(" A ");
        } else if(number < 90 && number >= 80) {
            System.out.println(" B ");
        } else if(number < 80 && number >= 70) {
            System.out.println(" c ");
        } else if(number < 70 && number >= 60) {
            System.out.println(" D ");
         } else {
                System.out.println(" F ");
            }
            
        
        System.out.println("프로그램 종료");
        sc.close();
        
    }

}
