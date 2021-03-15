package day0315;

import java.util.Scanner;

import util.ScannerUtil;

public class DogEx01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Dog 클래스 객체 생성
        Dog d = new Dog();
        // d의 필드에 값 입력
        d.name = "알베르도";
        d.id = "01A001";
        d.breed = "말티즈";
        d.age = 4;

        System.out.println("강아지를 찾아드립니다.");
        System.out.println("현재 우리 센터에서 임시보호중인 강아지의 마릿수는 1마리 입니다.");
        Dog d2 = new Dog();
        d2.id = ScannerUtil.nextLine(sc, "강아지의 등록번호를 입력해주세요");

        if (d.equals(d2)) {
            System.out.println("주인을 찾았습니다.");
        } else {
            System.out.println("당신과 관련이 없습니다.");
        }

        sc.close();

    }
}
