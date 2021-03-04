package day0303;
// 여러분들이 직접 변수를 만들어서 다음과 같은 형태로 출력이 될 수 있게
// 프로그램을 작성해보세요 (10분)

// 번호: #번
// 이름: ###
// 국어: ##점
// 영어: ##점
// 수학: ##점
// 총점: ##점
// 평균: ##.####점
public class GradeBook01 {
    public static void main(String[] args) {
       /* int id = 1;
        String str1 = new String("바보");
        int korean = id * 20;
        int english = ++korean;
        int math = 24
        
        int sum = korean + english + math;
        double average = sum / 3.0;
        System.out.println(" 번호: " + id + " 번 ");
        System.out.println(" 이름: " + str1);
        System.out.println(" 국어: " + korean + " 점 ");
        System.out.println(" 영어: " + english + " 점 ");
        System.out.println(" 수학: " + math + " 점 ");
        System.out.println(" 총점: " + sum + " 점 ");
        System.out.println(" 평균: " + average + " 점 ");
        */
        
        int id = 3;
        String name = new String("바보");
        int korean = 80;
        int english = 81;
        int math = 81;
        
        // 총점과 평균은 우리가 직접 값을 입려갷서 계산을 해주는 것이 아니라
        // 우리가 만든 변술ㄹ 기준으로 할당을 해주어야 한다.
        int sum = korean + english + math;
        double average = sum / 3.0;
        
        //출력
        System.out.println("번호 : "+id+"번");
        System.out.println("이름 : "+name);
        System.out.println("국어 : "+korean+"점");
        System.out.println("영어 : "+english+"점");
        System.out.println("수학 : "+math+"점");
        System.out.println("총점 : "+sum+"점");
        System.out.println("평균 : "+average+"점");
        
        }

}
