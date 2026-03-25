import java.util.List;
public class parkingfloor {
    int floor_num;
    List<parkingspot> spots;
    public parkingfloor(int floor_num,List<parkingspot>spots) {
        this.floor_num = floor_num;
        this.spots = spots;
    }
    public  parkingspot findavailable(vehicle v) {
        for(parkingspot spot : spots) {
            if(!spot.isoccupied && spot.canfit(v)) {
                return spot;
            }
        }
        return null;
    }    
}
