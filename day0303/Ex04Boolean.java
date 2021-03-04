package day0303;
// 기본형 데이터타입 03

// 논리형

// 논리형 데이터타입에는 boolean 이라는 데이터타입 1개만 존재한다.
// 이 boolean 데이터타입은 단 두가지의 값만 존재하는데
// 하나는 true, 하나는 false 라는 값이다.

// boolean의 경우 우리가 특별히 변수를 만들어서 쓰기보다는
// 나중에 배우게 될 연산자 혹은 메소드의 결과물을 받아서 쓰는 경우가 대부분이다.

public class Ex04Boolean {
    public static void main(String[] args) {
        // boolean 변수 myBoolean 을 만드고 거기에
        // true를 할당해보자

        boolean my = true; // 여기서 myBoolean은 변수이름
        
        // myBoolean의 현재값을 출력해보자
        System.out.println(my);

        // myBoolean에 false를 할당해보자
        my = false;

        // myBoolean의 현재값을 출력해보자
        System.out.println(my);

    }

}
