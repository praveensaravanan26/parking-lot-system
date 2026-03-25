import java.util.*;
public class parkinglot {
    List<parkingfloor> floors;
    parkingstrategy strategy;
    Map<Integer,ticket> active_tickets = new HashMap<>();
    int ticketcounter = 1;
    public parkinglot(List<parkingfloor> floors, parkingstrategy strategy) {
        this.floors = floors;
        this.strategy = strategy;
        //this.active_tickets = new HashMap<>();
    }
    public ticket parkvehicle(vehicle v) {
        parkingspot spot = strategy.findspot(floors, v);
        if(spot != null) {
            spot.assignvehicle(v);
            ticket t = new ticket(ticketcounter++, v, spot);
            active_tickets.put(t.ticket_id, t);
            System.out.println("Vehicle parked successfully!");
            System.out.println("Ticket ID: " + t.ticket_id);
            return t;
        }
        System.out.println("Parking lot is full");
        return null;
    }
    public void unparkvehicle(int ticket_id, paymenttype pType) {
        if(active_tickets.isEmpty()) {
            System.out.println("No vehicles parked");
            return;
        }
        ticket t = active_tickets.get(ticket_id);
        if(t != null) {
            double fee = t.calculatefee();
            int pay_id = 1;
            new payment(pay_id++,fee, pType).processpayment();
            System.out.println("Payment of Rs " + fee + " processed for ticket " + ticket_id);
            parkingspot spot = t.spot;
            spot.removevehicle(t.v);
            active_tickets.remove(ticket_id);
            System.out.println("Vehicle exited from parking lot");
        } else {
            System.out.println("Invalid ticket");
            return;
        }
    }
    public void viewParkedVehicles() {
        if (active_tickets.isEmpty()) {
            System.out.println("No vehicles parked");
            return;
        }

        System.out.println("Parked Vehicles:");
        for (ticket t : active_tickets.values()) {
            System.out.println("Ticket ID: " + t.ticket_id +
                    " | Vehicle: " + t.v.license_plate +
                    " | Type: " + t.v.gettype() +
                    " | Spot: " + t.spot.id);
        }
    }
    public boolean hasvehicles() {
        return !active_tickets.isEmpty();
    }
}
