package day0309;
// 로또 게임 2번

// 1-45의 랜덤한 숫자를 크기가 6인 배열에 넣어주고 출력해주는 프로그램
// + 중복제거 알고리즘 추가

import java.util.Random;

public class LottoGame02 {
    static final int SIZE = 6;
    static final int NUMBER_MAX = 45;

    public static void main(String[] args) {
        Random ran = new Random();

        System.out.println("로또 게임 ver 0.2");

        // [] 는 배열이라는 데이터타입을 말하는 것이다.
        // 즉 아래의 선언식의 경우
        // "int 가 모여있는 int 배열 lottoNumbers를 선언하고 그리고 해당 배열의 크기(=길이)는 SIZE 이다"
        // 라는 의미가 된다.

        // element vs index
        // element는 배열 안의 각각의 구성원을 우리가 element 라고 한다.
        // 일반적인 변수의 경우, 우리가 그 변수의 이름을 알고 있기 때문에
        // 그 이름을 통해서 해당 변수에 접근할 수 있지만
        // 배열의 경우 우리는 그 변수의 이름을 모른다.

        // 그 대신, 배열의 각 칸에는 해당 element에 대한 주소값이 저장되어있다.
        // 따라서 우리가 해당 element에 접근할 때에는(=값을 할당하거나 호출할 때에는)
        // 이름 대신 배열의 해당 칸에 저장되어 있는 주소값을 이용해서 접근하게 되는 것이다.
        // 그때, 우리가 배열의 몇번째 칸에 접근할 것인지를 적어야 하는데,
        // 그 몇번째 인지(=칸의 위치)를 우리가 index라고 부르는 것이다.

        int[] lottoNumbers = new int[SIZE];

        // 아래의 for문은 우리가
        // lottoNumbers 배열의 i 번째 인덱스마다
        // random.nextInt(NUMBER_MAX) + 1 한 값을 할당해주는 for 문이다

        for (int i = 0; i < lottoNumbers.length; i++) {

            // 아래 코드는
            // "lottoNumbers 의 i번째 칸에 저장되어 있는 주소값을 타고 가서
            // 그 공간에 ran.nextInt(NUMBER_MAX) + 1 한 결과값을
            // 할당해라" 라는 의미이다
            lottoNumbers[i] = ran.nextInt(NUMBER_MAX) + 1;
        }

        System.out.println();
        System.out.println("중복 제거 전");
        System.out.println();

        // 아래의 for문은 우리가
        // lottoNumbers 배열의 i 번재 인데긋에 저장되어 있는 값을 호출해서
        // 화면에 출력하는 for 문이다.
        for (int i = 0; i < lottoNumbers.length; i++) {

            // 아래에서 lottoNumbers[i] 라고 적어주는데 이때는
            // lottoNumbers 배열의 i 번째 칸의 저장된 주소값을 타고 들어가서
            // 그 공간에 저장되어 있는 int 값을 불러오는 것이다.
            System.out.printf("lottoNumbers[%d]: [%2d]\n", i, lottoNumbers[i]);
        }
        System.out.println("------------------------------------");
        // 중복 제거용 2중 for 문
        // i 와 j가 다르지만
        // lottoNumbers[i] 와 lottoNumbers[j]가 같다는건 중복이므로
        // lottoNumbers[i]에 새로운 값을 넣어주고 다시 처음부터 검사하게 만들어준다.

        // 무식한 방법이다.
        // 만약 이 방법을 쓸 경우, j for 문은 매우 많이 반복될 수도 있다.
        // 또한 최소 36번 이상 if 조건식을 실행하게 된다.( 6 * 6 )
        // for (int i = 0; i < lottoNumbers.length; i++) { // i는 중복시 0 -> 1 순으로 넘어감.
        // for (int j = 0; j < lottoNumbers.length; j++) {
        //
        // if (i != j && lottoNumbers[i] == lottoNumbers[j]) {
        // System.out.printf("%d index와 %d index가 중복이므로 %d에 새로운 값 할당\n", i, j, i);
        // lottoNumbers[i] = ran.nextInt(NUMBER_MAX) + 1;
        // j = -1; // j++되면 1이 되기 때문에 -1 초기화를 넣어 초기화 값으로 다시 만들어준다.
        //
        // }
        // }
        // }

        // 2. 좀더 나은 방법
        // 우리가 랜덤 숫자를 하나 뽑아서
        // 그 숫자가 우리 배열에 존재하는지 체크하여
        // 존재하지 않을 때에만 배열에 넣어준다.

        // 어디 위치에 추가할 지를 정하는 int idx
        int idx = 0;

        while (idx < lottoNumbers.length) {
            // 새로 추가해줄 숫자
            // 랜덤 객체를 사용해서 1~45 사이의 랜덤 숫자를 하나 뽑아서
            // randomNumber 변수에 할당한다!
            int randomNumber = ran.nextInt(NUMBER_MAX) + 1;
            // randomNumber 가 우리의 int 배열인 lottoNumbers에 이미 존재하는 숫자일 때
            // 값이 false로 바뀔 boolean 변수 numberChecker
            
            // 중복된 숫자일 경우, false로 바뀌는 boolean변수
            boolean numberChecker = true; // numberChecker false면 while 절 탈출

            // for 문을 통해 lottoNumbers의 각 element가 randomNumber와 같은지 체크하여
            // 같을 시에는 numberChecker의 값을 false로 바꾸고 break를 한다.
            // 아래의 for 문은 우리가 lottoNumbers 의 i 번째에 저장된 값과
            // randomNumber의 현재값과 비교해서
            // 두 값이 같을 경우, numberChecker의 값을 false로 바꾸고
            // 곧장 for 문을 종료시킨다.
            for (int i = 0; i < lottoNumbers.length; i++) {
                if (randomNumber == lottoNumbers[i]) {
                    numberChecker = false;
                    break;
                }
            }
            
            // numberChecker의 현재값이 true 일 때에는
            // 아래의 if 문이 실행되는데,
            // numberChecker가 true라는 것은 randomNumber의 현재값과
            // 일치하는 값이 lottoNumbers에 존재하지 않는다라는 의미이고
            // 따라서 randomNumber의 값은 중복되지 않는 값이라고 할 수 있다.
            if (numberChecker) {
                // 아래 코드는 lottoNumbers 배열 변수의 idx빈 칸에
                // randomNumber의 현재값을 할당하겠다.
                lottoNumbers[idx] = randomNumber; // lottoNumers != randomNumber
                idx++; // -> idx 가 lottoNumber[] 안에 들어가면 lottoNumber[idx] 잖아
                       // 그러면 lottoNumber[] 배열 안에 lottoNumber[idx1] , lottoNumber[idx2]...
                       // lottoNumber[] 가 가지는 값은 그대로....(idx 1, idx 2 는 순서임)
                       // i 로 다시 lottoNumber[] 를 불러올때 i 번째도 순서이니까 값을 그대로 가져오는거임??
                       // idx 도 0 1 2 3 4 5 순서대로 나오는거니까
                       // 아래 i 도 0 1 2 3 4 5 순서대로 나와서 그대로 값이 나올수 있다.
            }

        }

        System.out.println();
        System.out.println("중복 제거 후");
        System.out.println();
        for (int i = 0; i < lottoNumbers.length; i++) {

            System.out.printf("lottoNumbers[%d]: [%2d]\n", i, lottoNumbers[i]);
            // lottoNumbers[i] = 배열변수 lottoNumbers "의 i 번째"
            // lottoNumbers[i] == lottoNumbers[idx] 일 경우는 같은 칸을 보는거지 i == idx라는 뜻은 아니다.
        }

    }

}
