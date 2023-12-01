public class testInheritance {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Bird bird = new Bird();
        Cat cat = new Cat();

        animal.setHeight(100);
        bird.setHeight(60);
        cat.setHeight(125);

        animal.setWeight(70);
        bird.setWeight(40);
        cat.setWeight(20);

        animal.setName("Lion");
        bird.setName("Boncuk");
        cat.setName("Mavis");

        animal.getBodyIndex();
        bird.getBodyIndex();
        cat.getBodyIndex();

        animal.move();
        bird.move();
        cat.move();
    };
}