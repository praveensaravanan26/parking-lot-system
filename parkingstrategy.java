import java.util.List;
interface parkingstrategy {
    parkingspot findspot(List<parkingfloor> floors, vehicle v);
}
class nearestfirst implements parkingstrategy {
    public parkingspot findspot(List<parkingfloor> floors, vehicle v) {
        for(parkingfloor floor : floors) {
            parkingspot spot = floor.findavailable(v);
            if(spot != null) {
                return spot;
            }
        }
        return null;
    }
}
