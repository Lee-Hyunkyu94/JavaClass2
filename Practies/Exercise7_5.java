package exercise;

class Product {
    int price; // ��ǰ�� ����
    int bonusPoint; // ��ǰ���� �� �����ϴ� ���ʽ� ����

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
// ���� ���ǵ� �ν��Ͻ� �������� �ʱ�ȭ�ǵ��� �ϱ� ���ؼ�.
// �� Ŭ������ �����ڴ� �ش� Ŭ������ ����� �ν��Ͻ� ������ �ʱ�ȭ�� ����ϰ�, ������ ��Ӻ��� ����Ŭ������ �����ڰ� ó���ϵ���
// �ؾ��ϴ� ���̴�.

// 7-7
// x = 200
// Child() -> Child(int x) -> Parent() -> Parent(int x) -> Object()

// 7-8
// a -> public - protected -> (default) -> private

// 7-9
// c. �޼��� -> overroading �� ���� overriding �� �Ұ���;;
