package day0311;
// 사용자로부터 번호, 이름, 국어, 영어, 수학 점수를 입력받아서

// 예쁘게 출력 하는 프로그램을 만드시오.
// 해당 프로그램은 총 6명의 학생의 정보를 입력할 수 있습니다.

// 단, 국어 영어 수학 점수는 2차원 배열을 사용하여
// 묶어서 관리가 가능하게 만드시오(11시 20분까지)
import java.util.Scanner;

public class GradeBook01Answer {
    static final int SUBJECT = 3;
    static final int STUDENT = 6;
    static final int SCORE_MIN = 0;
    static final int SCORE_MAX = 100;
    static final int KOREAN = 0;
    static final int ENGLISH = 1;
    static final int MATH = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 번호를 담당하는 배열
        int[] id = new int[STUDENT];
        // 이름을 담당하는 배열
        String[] name = new String[STUDENT];
        // 점수를 담당하는 2차원 배열
        // 각배열안의 배열이 실제 점수를 저장하는 용도가 된다.
        int[][] score = new int[STUDENT][SUBJECT];

        int index = 0;

        while (true) {
            System.out.println();
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = sc.nextInt();
            System.out.println();

            if (userChoice == 1) {
                if(index < STUDENT) {
                    // 정보 입력하기
                    System.out.println("번호");
                    System.out.print("> ");
                    id[index] = sc.nextInt();
                    
                    System.out.println("이름");
                    System.out.print("> ");
                    sc.nextLine();
                    name[index]= new String(sc.nextLine());
                    
                    System.out.println("국어");
                    System.out.print("> ");
                    score[index][KOREAN] = sc.nextInt(); // 2차원 배열에 점수 입력 코드
                    
                    System.out.println("영어");
                    System.out.print("> ");
                    score[index][ENGLISH] = sc.nextInt(); // 2차원 배열에 점수 입력 코드
                    
                    System.out.println("수학");
                    System.out.print("> ");
                    score[index][MATH] = sc.nextInt(); // 2차원 배열에 점수 입력 코드
                    
                    index++;
                    
                }else {
                    System.out.println("더이상 입력하실 수 없습니다.");
                }

            } else if (userChoice == 2) {
                if (index > 0) {
                    // 정보 출력하기
                    for(int i = 0; i < index; i++) {
                        System.out.printf("번호: %03d번 이름: %s\n",id[i],name[i]);
                        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점",
                                score[i][KOREAN],score[i][ENGLISH],score[i][MATH]);
                        System.out.println();
                        int sum = score[i][KOREAN]+score[i][ENGLISH]+score[i][MATH];
                        double average = (double)sum/SUBJECT;
                        System.out.printf("총점: %03d점 평균: %06.2f점\n",sum,average);
                    }
                } else {

                    System.out.println("입력이나 하고 오십쇼");
                }
            } else if (userChoice == 3) {
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }

        }
        sc.close();
    }
}
