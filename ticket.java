import java.time.*;
import java.util.*;
public class ticket {
    int ticket_id;
    vehicle v;
    parkingspot spot;
    LocalDateTime entry_time;
    //boolean ispaid;

    static Map<vehicletype,Integer> costperhour = Map.of(
        vehicletype.CAR, 20,
        vehicletype.BIKE, 10,
        vehicletype.TRUCK, 30
    );
    public ticket(int ticket_id, vehicle v, parkingspot spot) {
        this.ticket_id = ticket_id;
        this.v = v;
        this.spot = spot;
        this.entry_time = LocalDateTime.now();
        System.out.println("Generated ticket " + ticket_id + " for vehicle " + v.license_plate + " at spot " + spot.id);
        System.out.println("Entry time: " + entry_time);
    }
    public double calculatefee() {
        long hours = Duration.between(entry_time, LocalDateTime.now()).toHours();
        int rate = costperhour.get(v.gettype());
        return Math.max(rate,hours * rate); // 10 rs per hr
    }
}
