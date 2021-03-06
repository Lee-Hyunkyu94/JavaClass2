package day0306;
// 1부터 100까지의 소수를 구하는 프로그램

// 1. 소수란 무엇인가?
//    1과 자기자신 외에는 약수가 없는 숫자
//    = 약수의 갯수가 2인 숫자
// 2. 약수란 무엇인가?
//    A를 B로 나누어서 나눠 떨어지면 B는 A의 약수이다.
//    예시) 5를 1로 나누어서 나눠 떨어지면 1은 5의 약수이다.
//    = A를 B로 나누어서 나머지가 0이면 B가 A의 약수이다.
// 3. 어떤 숫자의 가장 큰 약수는?
//    자기 자신이다.

// 우리는 이 3가지 조건만 활용해서 1부터 100까지의 소수를 구하는 프로그램을 만들게 될 것이다.

public class Ex04PrimeNumber {
    public static void main(String[] args) {
        // 여기서 우리가 중첩 for문을 만들어서 소수를 구하는데
        // i for문은 해당 숫자가 소수인지 아닌지를 검사할 숫자가 된다.
        // 그렇다면 iStart는? 1
        // iEnd는? 100
        int iStart = 1;
        int iEnd = 10000;

        for (int i = iStart; i <= iEnd; i++) {
            // i의 약수가 몇개인지를 저장할 변수 count를 선언과 초기화 해준다.
            int count = 0;

            // j for문에서는 j는 i의 약수인지 아닌지를 검사할 숫자가 된다.
            // 그렇다면
            // jStart는? 1
            // jEnd는? 1

            int jStart = 1;
            int jEnd = 1;

            for (int j = jStart; j <= jEnd; j++) {
                // j가 i의 약수일 때 마다
                // count의 값을 1씩 증가시켜준다.

                if (i % j == 0) {
                    count++;
                }

            }
            // count의 갯수가 2일때마다
            // i가 소수입니다 라는 메시지를 출력해준다.
            
            if(count==2) {
                System.out.printf("[%3d]는 소수입니다.\n",i);
            }

        }

    }

}
