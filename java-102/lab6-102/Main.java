public class Main {
    public static void main(String[] args) {
        CarBeing mercedes = new CarBeing("Mercedes",2006,230);
        System.out.println(mercedes);
        CarBeing bmw = new CarBeing("BMW",2016,250);
        System.out.println(bmw);
        System.out.println("Car Population : " + CarBeing.getCarPopulation());
        
    }   
}
