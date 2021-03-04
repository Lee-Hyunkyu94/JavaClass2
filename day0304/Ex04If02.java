package day0304;
// 1. 사용자로부터 숫자를 입력받아서 자연수이면 자연수입니다 가 출력되게 만드시오

// 2. 사용자로부터 나이를 입력받아서 미성년자이면 미성년자입니다가 출력되게 만드시오
// 3. 사용자로부터 숫자를 입력받아서 홀수이면 홀수입니다 가 출력되게 만드시오
// 4. 사용자로부터 아이디와 비밀번호를 입력받아서 아이디가 "admin", 비밀번호가 "111"이면 로그인 성공 을 출력되게 만드시오
// 5. 사용자로부터 숫자를 입력받아서 0이상 100 미만일 경우, "두자리 자연수입니다" 가 출력되게 만드시오


// 45분까지

import java.util.Scanner;
public class Ex04If02 {
    public static void main(String[] args) {
        /*
         * Scanner sc = new Scanner(System.in); 
         * //1. 숫자입력 
         * System.out.println("숫자 입력");
         * System.out.println("> "); 
         * int number = sc.nextInt(); 
         * if (number > 0) {
         * System.out.println("자연수 입니다."); 
         * } 
         * // 2. 나이입력 
         * System.out.println("나이 입력");
         * System.out.println("> "); 
         * int number2 = sc.nextInt(); if (number2 < 20) {
         * System.out.println("미성년자입니다."); }
         * // 3. 숫자입력 
         * System.out.println("숫자 입력");
         * System.out.println("> "); 
         * int number3 = sc.nextInt(); 
         * if (number3 % 2 == 1) {
         * System.out.println("홀수 입니다."); 
         * } 
         * // 4. 아이디와 비밀번호 입력 
         * sc.nextLine();
         * System.out.println("아이디를 입력하시오"); 
         * System.out.println("> "); 
         * String name = new String(sc.nextLine()); 
         * System.out.println("비밀번호를 입력하시오");
         * System.out.println("> "); 
         * String number4 = new String(sc.nextLine()); 
         * if(name == "admin" && number4 == "111") { 
         * System.out.println("로그인 성공"); 
         * } 
         * // 5. 사용자로부터 숫자 입력받아서 0이상 100 미만일 경우, "두자리 자연수" 
         * System.out.println("숫자를 입력하시오");
         * System.out.println("> "); 
         * int number5 = sc.nextInt(); 
         * if (number5 >= 0 && number5 <100 ) { 
         * System.out.println("두자리 자연수 입니다"); 
         * }
         * System.out.println("프로그램 종류"); 
         * sc.close();
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("1번");
        System.out.println("숫자를 입력해주세요");
        System.out.println("> ");
        int number = scanner.nextInt();

        if (number >= 0) {
            System.out.println("자연수입니다.");
        } else {
            System.out.println("음의 정수입니다.");
        }
        System.out.println("2번");
        System.out.println("나이를 입력해주세요");
        System.out.println("> ");
        int age = scanner.nextInt();

        if (age < 20) {
            System.out.println("미성년자 입니다.");
        } else {
            System.out.println("미성년자가 아닙니다.");
        }
        System.out.println("3번");
        System.out.println("숫자를 입력해주세요");
        System.out.println("> ");
        int number2 = scanner.nextInt();

        if (number2 % 2 == 1) {
            System.out.println("홀수 입니다.");
        } else {
            System.out.println("짝수 입니다.");
        }

        System.out.println("4번");
        scanner.nextLine();
        System.out.println("아이디를 입력하시오");
        System.out.println("> ");
        String id = new String(scanner.nextLine());
        System.out.println("패스워드를 입력하시오");
        System.out.println("> ");
        String pw = new String(scanner.nextLine());
        if (id.equals("admin") && pw.equals("111")) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }

        System.out.println("5번");
        System.out.println("숫자를 입력하시오");
        System.out.println("> ");
        int number3 = scanner.nextInt();
        if (number3 >= 0 && number3 < 100) {
            System.out.println("두자리 이하 자연수입니다.");
        } else {
            System.out.println("두자리 이하 자연수가 아닙니다.");
        }

        System.out.println("------------------");

        System.out.println("프로그램 종료");
        scanner.close();
        
    }

}
