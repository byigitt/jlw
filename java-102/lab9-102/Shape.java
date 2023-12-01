class Shape {
    public double calculateArea() {
        return 0.0;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(9, 10);
        Circle c = new Circle(3);
        double pii = 3;
        ShapeCalculator calculator = new ShapeCalculator();
        double rectangleArea = calculator.calculateArea(r);
        System.out.println("The area of the rectangle is " + rectangleArea);
        double rectangleArea2 = calculator.calculateArea(r,true);
        System.out.println("The area of the square is " + rectangleArea2);
        double rectangleArea3 = calculator.calculateArea(r,false);
        System.out.println("The area of the not square is " + rectangleArea3);
        double circleArea = calculator.calculateArea(c);
        System.out.println("The area of the circle is " + circleArea);
        double circleArea2 = calculator.calculateArea(c,pii);
        System.out.println("The area of the circle is " + circleArea2);        
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    public double calculateArea(boolean isSquare) {
        if (isSquare) {
            return length * length;
        } else {
            return calculateArea();
        }
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateArea(double customPi) {
        return customPi * radius * radius;
    }
}

class ShapeCalculator {
    public double calculateArea(Rectangle r) {
        return r.calculateArea();
    }

    public double calculateArea(Rectangle r, boolean isSquare) {
        return r.calculateArea(isSquare);
    }

    public double calculateArea(Circle c) {
        return c.calculateArea();
    }

    public double calculateArea(Circle c, double customPi) {
        return c.calculateArea(customPi);
    }
}