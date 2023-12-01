public class Bird extends Animal {
    private String fly = "flies";

    public String getMove() {
      return fly;
    }

    public void setMove(String action) {
        this.fly = action;
    }

    public double getBodyIndex(double num) {
        System.out.println(this.getClass().getSimpleName() + " move method is invoked");
        return (weight / height) * num;
    }

    public void move() {
        super.move();
        System.out.println(this.getClass().getSimpleName() + " move method is invoked");
        System.out.println("The animal " + this.getClass().getSimpleName() + " " + fly);
    }
}