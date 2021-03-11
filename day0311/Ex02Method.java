package day0311;
// 메소드

// 메소드란 기능이라고도 볼 수 있는데
// 우리가 자주 쓰게 되는 코드를
// 반복적으로 처음부터 끝가지 계속 적어주는 것이 아니라
// 어떤 이름을 가진 기능으로 만들어서
// 우리가 간단하게 그 이름만 부르면 해당 코드들이
// 차례대로 시작되게 만들어주는 것을 말한다.

// 메소드는 선언과 구현으로 이루어지는데
// 인터페이스가 아닐 경우에는 반드시 메소드의 구현이 선언과 같이 있어야 한다.

// 메소드의 선언과 구현은 다음과 같은 형식을 따른다.
// 접근제한자 (static) 리턴타입이름(파라미터){
//     실행될 코드
// }

// 1. 접근제한자
//    접근제한자란, 해당 메소드가 어디에 있는 다른 클래스가 사용가능한지를 규정하는 키워드 이다.
//    public: 퍼블릭은, 다른 패키지의 다른 클래스들도 접근 가능하다.
//            즉, 해당 메소드를 어디서든 실행 가능하다.

//    protected: 프로텍티드는 만약 다른 패키지일 경우, 상속받는 관계의 클래스만 해당 메소드를 사용 가능하다.
//               같은 패키지 안이라면, 그러한 제약은 없다

//    package:   패키기 접근 제한자는 오직 같은 패키지의 있는 다른 클래스들만 해당 메소드를 사용할 수 있다.
//               디폴트 접근 제한자라고도 하는데, 우리가 아무것도 적어주지 않으면 자동으로 패키지 접근 제한이 걸린다.
//               오히려, package나 default 라고 적어주면 에러가 발생하는데, 그 이유는 해당 키워드들이 이미 다른 곳에서
//               사용되고 있기 때문이다!

//    private:   프라이빗 접근 제한자는 다른 클래스는 아무도 사용할 수 없다.
//               즉, 클래스 내부에서만 해당 메소드를 호출할 수 있다.

// 2. static: 만약 해당 메소드를 객체 생성 없이 사용하고 싶다면 static 이라는 키워드를 붙여주면 된다.
//            추후에 다시 설명하겠지만 이 방법은 객체지향 프로그래밍과는 어울리지 않으므로 나중에는 사용을 안하는 것이 좋다.

// 3. 리턴 타입: 리턴 타입이란, 해당 메소드가 종료될 때, 그 메소드를 호출했던 곳으로 보내줄 값의 데이터타입을 리턴 타입이라고 한다.
//             리턴 타입이 존재할 때에는 해당 메소드 내부에는 반드시 return 이라는 키워드를 사용해서, 그 데이터 타입과 일치하는 데이터 타입을 가진
//             값을 반드시 return 해주어야한다.
//             또한 return의 경우, 실행 되는 코드가 되면 메소드를 그 자리에서 곧장 종료시킨다.
//             만약 해당 메소드가 아무런 값도 보내주지 않을 때에는 우리가 void 라고 적어준다.
//             이때는 오히려 return을 적으면 에러가 발생한다!

// 4. 이름: 소문자로 시작하는 동사

// 5. 파라미터: 파라미터란 해당 메소드를 실행시킬 때 외부로부터 꼭 받아와야 하는 특정한 종류의 데이터가 있을 경우
//           우리가 파라미터 안에 적어서 "이 메소드를 실행 시킬 때에는 이게 필요합니다!" 라고 적어주는 곳이다.
//           파라미터는 우리가 한국말로 "매개 변수" 라고도 하는데, 왜냐면 메소드 전체에서 해당 파라미터는 메소드 전체가 유효범위인 변수가 된다.
//           파라미터는 우리가 변수를 선언하듯, '데이터타입 이름' 이렇게 적어주면 된다.
//           또한 우리가 파라미터에 어떠한 이름을 적더라고, 실제 그 메소드를 호출할 때에는 그 이름의 변수를 꼭 넣어줄 필요는 없지만
//           해당 파라미터의 데이터타입과 일치하는 값 혹은 변수를 넣어주어야 한다!
import java.util.Random;

public class Ex02Method {
    public static void main(String[] args) {
        print();
        // showBigger 라는 메소드는
        // 실행하기 위해서는 반드시 2개의 int 값이 필요하다.
        // 따라서 아래와 같이 아무것도 적어주지 않거나
        // 넘겨주는 int 값의 갯수가 다르면 에러가 난다.(int 값 이 한개 or 두개 초과일 경우 에러!)
        // showBigger();

        // 아래 코드의 경우, 우리가 showBigger 메소드를 선언할 때 파라미터를
        // int a, int b 라고 했지만
        // 그것은 메소드 내부에서 해당 파라미터를 어떻게 부를지를 지정해주는 것이라고 보면 좋다.
        // 즉 실제 해당 메소드를 호출하는 곳에서는 데이터타입과 순서만 맞으면 어떠한 이름의 변수나 상수
        // 혹은 값 그 자체를 넘겨줘도 문제가 없다.
        showBigger(3, 4);

        int number = selectRandom();
        System.out.println(number);
        
        System.out.println(typeCasting(selectRandom()));  // ()안의 결과값이 먼저 실행 -> 그 밖에 있는 파라미터에 들어감.
    }

    // 우리가 해당 메소드를 호출 하면
    // 화면에 이것은 메소드입니다!!!
    // 라고 출력되는 메소드를 만들어보자.
    public static void print() {
        System.out.println("이것은 메소드 입니다.");
    }

    // 사용자가 2가지 int 값을 주면, 둘 중 뭐가 더 큰지 출력해주는 메소드
    public static void showBigger(int a, int b) { // int a, int b 는 파라미터
        if (a > b) {
            System.out.println(a + "가 더 큽니다.");
        } else if (b > a) {
            System.out.println(b + "가 더 큽니다.");
        } else {
            System.out.println(a + "와" + b + "는 같습니다.");
        }

    }

    // 사용자한테 1~10사이의 랜덤한 숫자를 리턴해주는 메소드
    public static int selectRandom() { // 여기서 int 는 리턴타입(메소드 선언과 구현시)
        Random random = new Random();
        int max = 10;

        // 우리가 굳이 int 타입의 변수만 return 해줄 수 있는 것이 아니라
        // int 타입의 값이면 뭐든 return 해줄 수 있다.
        return random.nextInt(max) + 1;

    }
    
    // 사용자가 넘겨주는 int 값을 double로 바꿔주는 메소드
    public static double typeCasting(int number) {
        return (double) number;
    }
}
