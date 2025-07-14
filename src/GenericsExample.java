public class GenericsExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal animal = new Animal();
        Box<Animal> box = new Box<>(dog);
//        Box<Dog> dog1 = new Box<Dog>(animal);
    }
}
class  Animal { }
class Dog extends  Animal{}
class Cat extends  Animal{}

class Box<T extends  Animal> {
    private T value;
    public Box(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}
