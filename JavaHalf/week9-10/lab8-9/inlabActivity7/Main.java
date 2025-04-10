public class Main {
    public static void main(String[] args){
        vehicle Honda = new vehicle("Honda","Accord",2023,12.5,4.0);
        vehicle Leaf = new vehicle("Nissan","Leaf",2022,12.5,9.0);
        Honda.start();
        Honda.displayInfo();
        Honda.stop();
        Honda.refuel(8);
        Honda.displayInfo();
        Leaf.displayInfo();
    }   
}
