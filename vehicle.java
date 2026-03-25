abstract class vehicle {
    int id;
    String license_plate;
    vehicletype type;
    public vehicle(int id, String license_plate, vehicletype type) {
        this.id = id;
        this.license_plate = license_plate;
        this.type = type;
    }
    public vehicletype gettype() {
        return type;
    }
}