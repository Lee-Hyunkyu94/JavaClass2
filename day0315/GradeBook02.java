package day0315;

import java.util.Scanner;

import util.ScannerUtil;

// 객체를 사용한 성적관리 프로그램
// 단, 지금 당장은 한명의 정보만 입력하고 출력해보자.
public class GradeBook02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 정보를 저장할 Student 객체를 선언과 초기화
        Student s = new Student();
        // 객체의 필드 혹은 메소드를 접근할 때에는
        // 객체 . 으로 접근하게 된다.
        // 그래서 . 을 자바에서는 접근 연산자 라고도 부른다.
        s.id = ScannerUtil.nextInt(sc, "번호를 입력해주세요");
        s.name = ScannerUtil.nextLine(sc, "이름을 입력해주세요");
        s.korean = ScannerUtil.nextInt(sc, "국어점수를 입력해주세요", 0, 100);
        s.english = ScannerUtil.nextInt(sc, "영어점수를 입력해주세요", 0, 100);
        s.math = ScannerUtil.nextInt(sc, "수학점수를 입력해주세요", 0, 100);
        
        // 정보를 출력할 때에는 별 다른거 할 거 없이
        // 그냥 Student 클래스의 객체인 s의 showInfo()만 실행해 주면 된다.
        s.showInfo();
        
        
        sc.close();
    }
}
