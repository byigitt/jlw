import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter front train speed: ");
        int fSpeed = keyboard.nextInt();
        System.out.print("Enter front train distance: ");
        int fDistance = keyboard.nextInt();
        
        keyboard.close();

        STAR21 d1 = new STAR21(420, fSpeed, fDistance);
        d1.engineStart();
    }
}

class Train {
    public String name() {
        return "Train";
    }
}

abstract class HighSpeedTrains extends Train {
    protected final int topSpeed = 425;

    abstract void engineStart();
    abstract void showSpeed();
}

class STAR21 extends HighSpeedTrains {
    private int driverSpeed;
    private int frontTrainSpeed;
    private int distance;

    public STAR21(int speed) {
        this.driverSpeed = speed;
        this.frontTrainSpeed = 0;
        this.distance = 0;
    }

    public STAR21(int speed, int frontTrainSpeed, int distance) {
        this.driverSpeed = speed;
        this.frontTrainSpeed = frontTrainSpeed;
        this.distance = distance;
    }

    @Override
    void engineStart() {
        try {
            System.out.println("Engine is started!");
            Thread.sleep(1000);
            System.out.println("Welcome to Train STAR21");
            Thread.sleep(1000);
            System.out.println("Driver wants to achieve " + driverSpeed + " km/h speed");
            Thread.sleep(1000);
            showSpeed();
            Thread.sleep(1000);
            
            if (frontTrainSpeed != 0 && distance != 0) 
                adaptiveCruiseControlSpeed(driverSpeed, frontTrainSpeed, distance);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    void showSpeed() {
        try {
            System.out.println("Let's check your speed if it is safe...");
            Thread.sleep(1000);
            System.out.println("Limited Top Speed is: " + topSpeed + " km/h");
            Thread.sleep(1000);
            if (driverSpeed <= topSpeed) {
                System.out.println("It is safe to drive at " + driverSpeed + " speed!");
            } else {
                System.out.println("Warning: Driver requested speed is greater than the train speed limit!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void adaptiveCruiseControlSpeed(int speed, int frontTrainSpeed, int distance) {
        System.out.println("Adaptive Cruise Control is active.");

        System.out.println("The front train speed is " + frontTrainSpeed);
        System.out.print("The distance: " + distance + ".");

        try {
            if (speed > 200 && speed > frontTrainSpeed && distance < 50) {
                Thread.sleep(250);
                System.out.println(" Emergency Braking is applying!");
            } else if (speed > 200 && speed > frontTrainSpeed && distance >= 50) {
                Thread.sleep(250);
                System.out.println(" Train is slowing...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WIN350 extends HighSpeedTrains {
    private int driverSpeed;

    public WIN350(int speed) {
        this.driverSpeed = speed;
    }

    @Override
    void engineStart() {
        try {
            System.out.println("Engine is started!");
            Thread.sleep(1000);
            System.out.println("Welcome to Train WIN350");
            Thread.sleep(1000);
            System.out.println("Driver wants to achieve " + driverSpeed + " km/h speed");
            Thread.sleep(1000);
            showSpeed();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    void showSpeed() {
        try {
            System.out.println("Let's check your speed if it is safe...");
            Thread.sleep(1000);
            System.out.println("Limited Top Speed is: " + topSpeed + " km/h");
            Thread.sleep(1000);
            if (driverSpeed <= topSpeed) {
                System.out.println("It is safe to drive at " + driverSpeed + " speed!");
            } else {
                System.out.println("Warning: Driver requested speed is greater than the train speed limit!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
