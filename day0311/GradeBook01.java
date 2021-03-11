package day0311;
// 사용자로부터 번호, 이름, 국어, 영어, 수학 점수를 입력받아서

// 예쁘게 출력 하는 프로그램을 만드시오.
// 해당 프로그램은 총 6명의 학생의 정보를 입력할 수 있습니다.

// 단, 국어 영어 수학 점수는 2차원 배열을 사용하여
// 묶어서 관리가 가능하게 만드시오(11시 20분까지)
import java.util.Scanner;

public class GradeBook01 {
    static final int SUBJECT = 3;
    static final int STUDENT = 6;
    static final int SCORE_MIN = 0;
    static final int SCORE_MAX = 100;
    static final int INDEX_KOREAN = 0;
    static final int INDEX_ENGLISH = 1;
    static final int INDEX_MATH = 2;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] id = new int[STUDENT];
        String[] name = new String[STUDENT];
        //점수를 담당하는 2차원 배열
        // 각배열안의 배열이 실제 점수를 저장하는 용도가 된다.
        int[][] score = new int[STUDENT][SUBJECT];
        int[] korean = new int[STUDENT];
        int[] english = new int[STUDENT];
        int[] math = new int[STUDENT];
        int index = 0;

        while(true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = sc.nextInt();
       if(userChoice == 1) {
           
        if (index < STUDENT) {
            // 학생 입력

            // 번호
            System.out.println("번호");
            System.out.print("> ");
            id[index] = sc.nextInt();

            // 이름
            sc.nextLine();
            System.out.println("이름");
            System.out.print("> ");
            name[index] = sc.nextLine();
            // 국어
            System.out.println("국어");
            System.out.print("> ");
            korean[index] = sc.nextInt();
            if (!(index >= SCORE_MIN && index <= SCORE_MAX)) {
                System.out.println("점수가 올바르지 않습니다.");
                System.out.println("다시 입력해주세요");
                System.out.println("국어");
                System.out.print("> ");
                korean[index] = sc.nextInt();
            }
            // 영어
            System.out.println("영어");
            System.out.print("> ");
            english[index] = sc.nextInt();
            if (!(index >= SCORE_MIN && index <= SCORE_MAX)) {
                System.out.println("점수가 올바르지 않습니다.");
                System.out.println("다시 입력해주세요");
                System.out.println("영어");
                System.out.print("> ");
                english[index] = sc.nextInt();
            }
            //수학
            System.out.println("수학");
            System.out.print("> ");
            math[index] = sc.nextInt();
            if (!(index >= SCORE_MIN && index <= SCORE_MAX)) {
                System.out.println("점수가 올바르지 않습니다.");
                System.out.println("다시 입력해주세요");
                System.out.println("수학");
                System.out.print("> ");
                math[index] = sc.nextInt();
            }
            index++;

        } else {
            System.out.println("더이상 학생을 추가하실수 없습니다.");
        }
       }else if(userChoice == 2) {
          if(index < 0) {
              System.out.println("입력이나 하고 오십쇼");
          }else {
              for(int i =0; i <= index;i++) {
                  for(int j =0;j<=index;j++) {
                      
                      System.out.println("정보 출력");
                      System.out.println("=====" + name[i] + " 학생의 정보=====");
                      System.out.printf("번호: %d번 이름: %s\n",id[i],name[i]);
                      System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean[i], english[i],
                              math[i]);
                  }
                  }
                  
              }
       }else if(userChoice == 3) {
           System.out.println("이용해주셔서 감사합니다.");
           
       }
       sc.close();
        }

    }
}
