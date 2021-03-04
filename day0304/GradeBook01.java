package day0304;
// 여러분들이 직접 변수를 만들고 그리고 다음과 같은 형식을 갖추어 출력될 수 있게 프로그램을 작성하세요

// 번호: 0##번 이름: ###
// 국어: 0##점 영어: 0##점 수학: 0##점
// 총점: 0##점 평균: 0##.##점

public class GradeBook01 {
    public static void main(String[] args) {
        int id = 1;
        String name = new String("멍청이");
        int korean = 80;
        int english = 90;
        int math = 77;

        int sum = korean + english + math;
        double average = sum / 3.0;

        System.out.printf("번호: %03d번 이름: %3s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %03.2f\n", sum, average);

    }

}
