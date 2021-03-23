package day0323;
// "Wolf"를 상속받는 Dog.java
public class Dog extends Wolf{
    public Dog() {
        System.out.println("Dog 생성자 호출");
    }
    public void loyal() {
        System.out.println("충성을 바친다.");
    }
    public void domestic() {
        System.out.println("가축화가 되었다.");
    }
    public void eat() {
        System.out.println("사료를 먹는다."); // 오버라이드를 하게 되면 부모 클래스가 아닌 오버라이드 된 자신의 클래스가 기준이 된다.
    }
}
