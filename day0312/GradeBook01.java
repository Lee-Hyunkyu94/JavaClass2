package day0312;


// 6명의 학생을 관리하는 프로그램을 작성하시오
// 단, 입력 부분은 ScannerUtil 을 사용하시오(20분)

import util.ScannerUtil;
import java.util.Scanner;
public class GradeBook01 {
    static final int STUDENT = 6;
    static final int SUBJECT = 3;
    static final int KOREAN = 0;
    static final int ENGLISH = 1;
    static final int MATH = 2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int id[] = new int[STUDENT];
        String name[] = new String[STUDENT];
        int index = 0;
        int[][] score = new int[STUDENT][SUBJECT];
                
        while (true) {
            System.out.println();
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = sc.nextInt();
            
            if(userChoice == 1) {
                // 1. 입력
                if(index < STUDENT) {
                    
                    id[index] = ScannerUtil.nextInt(sc, "번호를 입력하세요",1,6);
                    
                    name[index] = ScannerUtil.nextLine(sc, "이름을 입력하세요");
                    
                    score[index][KOREAN] = ScannerUtil.nextInt(sc, "국어점수를 입력해주세요", 1, 100);
                    score[index][ENGLISH] = ScannerUtil.nextInt(sc, "영어점수를 입력해주세요", 1, 100);
                    score[index][MATH] = ScannerUtil.nextInt(sc, "수학점수를 입력해주세요", 1, 100);
                    
                    index++;
                    
                    
                }else {
                    System.out.println("입력 학생을 초과하셨습니다.");
                }
                        
            }else if(userChoice == 2) {
                // 출력
                if(index > 0) {
                    for(int i  = 0; i < index; i++) {
                        System.out.printf("번호: %03d번 이름: %s\n",id[i],name[i]);
                        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점",
                                score[i][KOREAN],score[i][ENGLISH],score[i][MATH]);
                        System.out.println();
                        int sum = score[i][KOREAN]+score[i][ENGLISH]+score[i][MATH];
                        double average = (double)sum/SUBJECT;
                        System.out.printf("총점: %03d점 평균: %06.2f점\n",sum,average);
                    }
                }else {
                    System.out.println("입력이나 하고 오십쇼");
                }
            }else if(userChoice == 3) {
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }

        }
        sc.close();
    }

}
