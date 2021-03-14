package Homework;

import java.util.Random;
import java.util.Scanner;

import Util.ArrayUtil;
import Util.ScannerUtil;

public class LottoGameLast02UsingArrayUtil {
    static final int MAX = 45;
    static final int MIN = 1;
    static final int SIZE = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        int[] userArray = new int[SIZE];      
        int[] computerArray = new int[SIZE];

        int index = 0;

        while (index < SIZE) {
            int randomNumber = ran.nextInt(MAX) + 1;

            ArrayUtil.contains(computerArray, randomNumber);
            index++;
            }
        

        index = 0;

        int userGameSize = ScannerUtil.nextInt(sc, "몇번 플레이 하시겠습니까?");

        int[][] userArrays = new int[userGameSize][SIZE];

        for (int i = 0; i < userArray.length; i++) {
            int userChoice = ScannerUtil.nextInt(sc, (i + 1) + "번 게임");

            index = 0;

            if (userChoice == 1) {
                while (index < userArrays[i].length) {
                    int userNumber = ScannerUtil.nextInt(sc, (index + 1) + "번 숫자를 입력해주세요");

                    boolean inputSwitch = userNumber >= MIN && userNumber <= MAX;

                    for (int j = 0; j < userArrays.length; j++) {
                        if (userNumber == userArray[j]) {
                            inputSwitch = false;
                            break;
                        }
                    }
                    if (inputSwitch) {
                        userArrays[i][index] = userNumber;
                        index++;
                    } else {
                        System.out.println("잘못된 숫자입니다.");
                        System.out.println("다시 입력해주세요.");
                    }

                }
            } else {
                while (index < SIZE) {
                    int randomNumber = ran.nextInt(MAX) + 1;

                    ArrayUtil.contains(userArrays[i], randomNumber);
                }
            }
        }
        for (int i = 0; i < computerArray.length; i++) {
            for (int j = 0; j < userArrays.length; j++)
                if (userArrays[i][j] > userArrays[i][j + 1]) {
                    int temp = userArrays[i][j];
                    userArrays[i][j] = userArrays[i][j + 1];
                    userArrays[i][j + 1] = temp;
                    j = -1;
                }

        }System.out.printf("컴퓨터의 숫자: [%2d, %2d, %2d, %2d, %2d, %2d]\n", computerArray[0], computerArray[1],
                computerArray[2], computerArray[3], computerArray[4], computerArray[5]);
        
        for(int i = 0;i < userArrays.length;i++) {
            int count = 0;
            for(int j = 0; j < userArrays[i].length;j++) {
                for(int k = 0; k < computerArray.length;k++) {
                    if(userArrays[i][j] == computerArray[k]) {
                        count ++;
                    }
                }
            }
            System.out.printf("게임 %2d번: [%2d, %2d, %2d, %2d, %2d, %2d]\n 맞춘 갯수: %2d개, ", i + 1, userArrays[i][0],
                    userArrays[i][1], userArrays[i][2], userArrays[i][3], userArrays[i][4], userArrays[i][5], count);

            if(count > 2) {
                System.out.println("등수: "+(SIZE - count + 1) + "등");
                
            }else {
                System.out.println("잘가셈");
            }
        }
        sc.close();
    }
}