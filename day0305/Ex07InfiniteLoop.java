package day0305;
// 무한루프

// 무한루프란, 조건식이 false가 나오지 않아
// 해당 프로그램을 강제 종료시키거나 사용자가 종료시킬때까지
// 영원히 반복되는 반복문을 무한루프라고 한다.

// 무한루프를 만드는데 여러가지 방법이 있지만
// 우리는 그 중에서 while을 이용한 무한루프를 만드는 세가지 방법을 알아볼 것이다.
// 무한루프 뒤에는 항상 에러가 생긴다.(Unreachable code)
public class Ex07InfiniteLoop {
    public static void main(String[] args) {
        // 1. 조건식의 변수가 변화가 없을 경우
        // int number = 3;
        // while (number > 0) {
        // System.out.println("무한루프 1번");
        // }

        // 2. 조건식을 항상 참이 나오는 조건식을 사용한다
        // while (1 > 0) {
        // System.out.println("무한루프 2번");
        // }

        // 3. 뭐하러 식을 만드나....
        // while(true) {
        // System.out.println("무한루프 3번");
        // }

        // 다들 무한루프가 나쁜거라고만 생각하지만,
        // 오히려 우리가 무한루프를 사용해서 우리가 원하는
        // 전체적인 틀을 만들어 줄 수도 있다.
    }

}
