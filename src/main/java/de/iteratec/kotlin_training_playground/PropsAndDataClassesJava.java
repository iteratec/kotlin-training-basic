package de.iteratec.kotlin_training_playground;

class JavaCat {
    private String name = "cat";
    private int age = 1;

}

public class PropsAndDataClassesJava {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("Kessi");
        dog.setAge(5);
        System.out.println("dog = " + dog);
    }
}
