package day0309;
// 로또 게임

import java.util.Random;

// 사용자로부터 로또 숫자 6개를 입력 받아서
// 정렬하여 출력하시오

// 단, 사용자가 잘못된 숫자 혹은 중복된 숫자를 입력하면
// 올바른 숫자를 입력 할 때 까지 다시 입력 받도록 하세요.(숙제)

import java.util.Scanner;

public class LottoGame04 {
    static final int SIZE = 6;
    static final int NUMBER_MAX = 45;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int idx = 0;
        int[] lotto = new int[SIZE];
        int[] userInput = new int[SIZE];

        System.out.println("숫자 6개를 입력하시오");
        System.out.println("> ");
        for (int i = 0; i < lotto.length; i++) 

            userInput[i] = sc.nextInt();
        
        // 중복이 ....
        while(idx < lotto.length) {
            int random = ran.nextInt(NUMBER_MAX);
            boolean NC = true;
            for(int i = 0; i < lotto.length;i++) {
                if(random == lotto[i]) {
                    NC = false;
                    break;
                }
            }
            if(NC) {
                lotto[idx]=random;
                idx++;
            }
        }
        
        
            // 정렬은 성공
        for (int i = 0; i < lotto.length - 1; i++) {
            if (userInput[i] > userInput[i + 1]) {
                int temp = userInput[i];
                userInput[i] = userInput[i + 1];
                userInput[i + 1] = temp;
                i = -1;
            }
        }

        System.out.println("결과출력");
        for (int i = 0; i < lotto.length; i++) {
            System.out.printf("%d [%d]\n", i, userInput[i]);
        }

    }
}
