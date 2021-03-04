package day0303;
// 기본형 데이터타입 02

// 실수형 데이터타입
// 실수형 데이터타입에는
// float(32비트)과 double(64비트)가 있다.
// java에서는 실수에 대한 기본 데이터타입을 double로 설정해놓았다.
// 그러므로 우리도 double을 사용하면 된다!
public class Ex01RealNumber {
    public static void main(String[] args) {
        // double 변수 myDouble을 선언해보자
        double myDouble;

        // myDouble에 1.234를 할당해보자
        myDouble = 1.234;

        // myDouble의 현재값을 화면에 출력해보자
        System.out.println(myDouble);

        // 정수 - 실수 타입 캐스팅을 직접 체험해보자.

        // 1. 정수형 값을 실수 공간에 할당하는 암시적 형변환

        // myDouble에 5를 넣어보자
        myDouble = 5;

        // myDouble에 현재값을 화면에 출력해보자
        System.out.println(myDouble);

        // 2. 실수형값을 정수 공간에 할당하는 명시적 형변환

        // myDouble에 3.9를 할당해주자
        myDouble = 3.9;

        // int 변수 myInt를 선언
        int myInt;

        // myInt에 myDouble의 현재값을 할당해보자
        myInt = (int) myDouble; // 반올림 x

        // myInt의 현재값을 화면에 출력해보자
        System.out.println(myInt);

        // float 변수(상수)에 값을 넣는 두가지 방법

        // 1. 코드에 적혀잇는 실수를 명시적 형변환을 통해 float으로 바꿔주는 방법

        // float 변수 myFloat 선언
        float myFloat;

        // myFloat에 3.4를 명시적 형변환을 통해 float으로 바꾸어서 할당해라
        myFloat = (float) 3.4;

        // myFloat의 현재값을 화면에 출력해보자
        System.out.println(myFloat);
        
        // 2. 우리가 코드에 적은 실수가 double 이 아니라 float이라고 미리 말해주는 방법
        
        // float 타입을 가진 실수값을 만들려면
        // 실수값 뒤에 f를 붙여주면 된다.
        myFloat = 9.9f;
        
        // myFloat의 현재값을 화면에 출력해보자
        System.out.println(myFloat);
        
        // double 쓰는게 편하다. 굳이 float 쓸 필요 없음
    }

}

















