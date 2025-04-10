public class vehicle {
    private String make;
    private String model;
    private int year;
    private double fuelCapacity;
    private double currentFuel;
    public vehicle(String make, String model,int year,double fuelCapacity,double currentFuel){
        this.make=make;
        this.model=model;
        this.year=year;
        this.fuelCapacity=fuelCapacity;
        this.currentFuel=currentFuel;
    }
    public void setMake(String make){
        this.make=make;
    }
    public String getMake(){
        return make;
    }
    public void setModel(String model){
        this.model=model;
    }
    public String getModel(){
        return model;
    }
    public void setYear(int year){
        this.year=year;
    }
    public int getYear(){
        return year;
    }
    public void setFuelCapacity(double fuelCapacity){
        this.fuelCapacity=fuelCapacity;
    }
    public double getFuelCapacity(){
        return fuelCapacity;
    }
    public void setCurrentFuel(double currentFuel){
        this.currentFuel=currentFuel;
    }
    public double getCurrentFuel(){
        return currentFuel;
    }
    public void displayInfo(){
        System.out.println("Vehicle-\nMake: "+this.make+"\nVehicle Model: "+this.model+"\nYear: "+this.year+"\nFuel Capacity: "+this.fuelCapacity+"\nCurrent Fuel: "+this.currentFuel+"\n");
    }
    public void start(){
        System.out.println("Vehicle is Starting\n");
    }
    public void stop(){
        System.out.println("Vehicle is Stopping\n");
    }
    public void refuel(double amount){
        if(this.currentFuel+amount<=this.fuelCapacity){
            this.currentFuel+=amount;
            System.out.println("Vehicle refueled to: "+this.currentFuel+"\nMax capacity:"+this.fuelCapacity+"\n");
        }
        else if(this.currentFuel+amount>this.fuelCapacity){
            this.currentFuel=this.fuelCapacity;
            System.out.println("Vehicle refueled to full!\n");
        }
        else{
            System.out.println("Vehicle is already at full capacity+\n");
        }
    }
}
