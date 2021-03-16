package day0315;
// 강아지 클래스

// 필드: 이름, 등록번호(String), 품종, 나이
// 메소드: 사료먹기(사료 종류), 짖기(), 자기(), 객체간 비교()

public class Dog {
    // 1. 필드
    private String name;
    private String id;
    private String breed;
    private int age;

    // 2. 메소드
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    
    // 생성자
    public Dog(String name, String id, String breed, int age) {
        this.name = name;
        this.id = id;
        this.breed = breed;
        this.age = age;
    }
    
    public Dog() {
        
    }

    public void eat(String food) {
        System.out.println(food + "를 먹습니다!");
    }

    public void bark() {
        System.out.println("왕왕");
    }

    public void sleep() {
        System.out.println("zZz");
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dog) {
            Dog d = (Dog) obj;
            if (this.id.equals(d.id)) {
                return true;
            }
        }

        return false;

    }
    public void printInfo() {
        System.out.println("++++++++++++++++++++++++++++");
        System.out.printf("등록번호: %s 이름: %s\n",id,name);
        System.out.printf("품종: %s 나이: %02d살\n",breed,age);
        System.out.println("++++++++++++++++++++++++++++");
    }

}
