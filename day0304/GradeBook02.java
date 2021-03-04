package day0304;
// 사용자로부터

// 번호, 이름, 국어, 영어, 수학 점수를 차례대로 입력받아서
// 다음과 같은 형식으로 출력되는 프로그램을 작성하시오(15분까지)

// 번호: 0##번 이름: ###
// 국어: 0##점 영어: 0##점 수학: 0##점
// 총점: 0##점 평균: 0##점
import java.util.Scanner;

public class GradeBook02 {
    // 프로그램 내부적으로 사용할 상수들
    // 1. 과목의 숫자
    static final int SUBJECT_SIZE = 3;

    public static void main(String[] args) {
        System.out.println("번호를 입력하시오");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        System.out.println("번호: " + id);
        scan.nextLine();

        System.out.println("이름을 입력하시오");
        String name = new String(scan.nextLine());
        System.out.println("이름: " + name);

        System.out.println("점수를 입력하시오");
        int korean = scan.nextInt();
        int english = scan.nextInt();
        int math = scan.nextInt();

        int sum = korean + english + math;
        double average = sum / (double) SUBJECT_SIZE;
        System.out.printf("번호: %03d번 이름 %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %03f점", sum, average);

        scan.close();
    }

    /*
     * static final int SUBJECT_SIZE = 3;
     * 
     * public static void main(String[] args) { Scanner scanner = new
     * Scanner(System.in);
     * 
     * //번호입력 System.out.println("번호"); System.out.println("> "); int id =
     * scanner.nextInt();
     * 
     * // 이름입력 scanner.nextLine(); System.out.println("이름");
     * System.out.println("> "); String name = scanner.nextLine();
     * 
     * // 국어입력 System.out.println("국어"); System.out.println("> "); int korean =
     * scanner.nextInt();
     * 
     * //영어입력 System.out.println("영어"); System.out.println("> "); int english =
     * scanner.nextInt();
     * 
     * // 수학입력 System.out.println("수학"); System.out.println("> "); int math =
     * scanner.nextInt();
     * 
     * // 총점 과 평균 계산 int sum = korean + english + math; double average = sum /
     * (double)SUBJECT_SIZE;
     * 
     * 
     * // 정보출력 System.out.printf("번호: %03d번 이름: %3s\n", id,name);
     * System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
     * System.out.printf("총점: %03d점 평균: %03.2f\n", sum, average);
     * 
     * scanner.close(); }
     */
}
