public class parkingspot {
    int id;
    parkingspottype type;
    boolean isoccupied;
    vehicle v;
    public parkingspot(int id, parkingspottype type) {
        this.id = id;
        this.type = type;
        this.isoccupied = false;
        //this.v = v;
    }
    public boolean canfit(vehicle v) {
        return v.gettype().name().equals(type.name());
    }
    public  void assignvehicle(vehicle v) {
       this.v = v;
       this.isoccupied = true;
    }
    public  void removevehicle(vehicle v) {
        this.v = null;
        this.isoccupied = false;
    }
}
