public class Animal {
    public double height;
    public double weight;
    public String name;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBodyIndex() {
        double index = (weight / height); 
        System.out.println(this.getClass().getSimpleName() + " move method is invoked");
        System.out.println("Body index: " + index);
        return index;
    }

    public void move() {
        System.out.println(this.getClass().getSimpleName() + " move method is invoked");
        System.out.println("Every " + this.getClass().getSimpleName() + " has a movement type");
    }

    @Override
    public boolean equals(Object o) {
        System.out.println(this.getClass().getSimpleName() + " equals method is invoked");
        
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        
        Animal paramObject = (Animal) o;
        if (paramObject.weight != this.weight)
            return false;
        
        if (paramObject.height != this.height)
            return false;

        if (!paramObject.name.equals(this.name))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return height + "\t" + weight + "\t" + name;
    }
}