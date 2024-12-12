abstract class Animal {  
    //abstract void sound();  

    void eat() {  
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {  
    @Override
    void sound() {  
        System.out.println("Bark");
    }
}

public class test {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();  
        dog.eat();    
    }
}
