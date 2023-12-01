public class testInheritance2 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal2 = new Animal();
        Bird bird = new Bird();
        Cat cat = new Cat();

        animal.setHeight(100);
        animal2.setHeight(100);
        bird.setHeight(60);
        cat.setHeight(125);

        animal.setWeight(70);
        animal2.setWeight(70);
        bird.setWeight(40);
        cat.setWeight(20);

        animal.setName("Lion");
        animal2.setName("Lion");
        bird.setName("Boncuk");
        cat.setName("Mavis");

        boolean Animal2Comp = animal.equals(animal2);
        boolean BirdComp = animal.equals(bird);

        System.out.println(Animal2Comp + " " + BirdComp);
        System.out.println(animal2.toString());
        System.out.println(bird.toString());
        System.out.println(cat.toString());
    }
}
