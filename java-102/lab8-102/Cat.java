public class Cat extends Animal {
    private String walk = "walks";

    public String getMove() {
      return walk;
    }

    public void setMove(String action) {
        this.walk = action;
    }

    public double getBodyIndex(double num) {
        System.out.println(this.getClass().getSimpleName() + " move method is invoked");
        return (weight / height) * num;
    }

    public void move() {
        super.move();
        System.out.println(this.getClass().getSimpleName() + " move method is invoked");
        System.out.println("The animal " + this.getClass().getSimpleName() + " " + walk);
    }
}