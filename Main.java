import java.util.*;

public class Main {
    static int vehicleId = 1;
    public static boolean isvalidplate(String plate) {
        plate = plate.toUpperCase();
        return plate.matches("[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 🔥 ADMIN SETUP
        System.out.println("Enter number of floors:");
        int f = sc.nextInt();

        List<parkingfloor> floors = new ArrayList<>();

        for (int i = 1; i <= f; i++) {
            System.out.println("Enter width & height for floor " + i);
            int w = sc.nextInt();
            int h = sc.nextInt();

            List<parkingspot> spots = new ArrayList<>();
            int id = 1;
            int totalSpots = w * h;
            int bikecount = 0;
            int carcount = 0;
            int truckcount = 0;
            for (int j = 0; j < w * h; j++) {
                if (j % 3 == 0) {
                    spots.add(new parkingspot(id++, parkingspottype.BIKE));
                    bikecount++;
                } else if (j % 3 == 1) {
                    spots.add(new parkingspot(id++, parkingspottype.CAR));
                    carcount++;
                } else {
                    spots.add(new parkingspot(id++, parkingspottype.TRUCK));
                    truckcount++;
                }
            }
            System.out.println("Added floor " + i + " with " + totalSpots + " spots (" + bikecount + " for bikes, " + carcount + " for cars, " + truckcount + " for trucks)");
            floors.add(new parkingfloor(i, spots));
        }

        parkinglot lot = new parkinglot(floors, new nearestfirst());
        entrygate entry = new entrygate(lot);
        exitgate exit = new exitgate(lot);

        // 🔁 USER MENU
        while (true) {
            System.out.println("\n=== Parking Lot System ===");
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Unpark Vehicle");
            System.out.println("3. View Parked Vehicles");
            System.out.println("4. Exit System");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Type (1-Bike 2-Car 3-Truck): ");
                    int t = sc.nextInt();

                    System.out.println("Plate:");
                    String plate = sc.next();
                    plate = plate.toUpperCase();
                    if(!isvalidplate(plate)){
                        System.out.println("Invalid plate format. Please try again.");
                        continue;
                    }
                    vehicle v = null;

                    if (t == 1) v = new bike(vehicleId++, plate);
                    else if (t == 2) v = new car(vehicleId++, plate);
                    else if (t == 3) v = new truck(vehicleId++, plate);

                    entry.generate_ticket(v);
                    break;

                case 2:
                    if(!lot.hasvehicles()) {
                        System.out.println("No vehicles parked");
                        break;
                    }
                    System.out.println("Enter Ticket ID:");
                    int id = sc.nextInt();

                    System.out.println("Payment (1-CASH 2-CARD 3-UPI):");
                    int p = sc.nextInt();

                    paymenttype pt = (p == 1) ? paymenttype.CASH :
                                     (p == 2) ? paymenttype.CARD :
                                     paymenttype.UPI;

                    exit.process_exit(id, pt);
                    break;
                case 3:
                    lot.viewParkedVehicles();
                    break;    
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    return;
            }
        }
    }
}