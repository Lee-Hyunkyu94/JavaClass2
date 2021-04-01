package exercise;

class Product {
    int price; // 제품의 가격
    int bonusPoint; // 제품구매 시 제공하는 보너스 점수

    Product() {

    }

    Product(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0);
    }
}

class Tv extends Product {
    Tv() {

    }

    public String toString() {
        return "Tv";
    }
}

public class Exercise7_5 {
    public static void main(String[] args) {
        Tv t = new Tv();
    }
}

// 7-6
// 조상에 정의된 인스턴스 변수들이 초기화되도록 하기 위해서.
// 각 클래스의 생성자는 해당 클래스에 선언된 인스턴스 변수의 초기화만 담당하고, 나머지 상속분은 조상클래스의 생성자가 처리하도록
// 해야하는 것이다.

// 7-7
// x = 200
// Child() -> Child(int x) -> Parent() -> Parent(int x) -> Object()

// 7-8
// a -> public - protected -> (default) -> private

// 7-9
// c. 메서드 -> overroading 은 가능 overriding 이 불가능;;
