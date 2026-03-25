public class entrygate {
   //int gate_id;
    parkinglot lot;
    public entrygate(parkinglot lot) {
        //this.gate_id = gate_id;
        this.lot = lot;
    }
    public ticket generate_ticket(vehicle v) {
       return lot.parkvehicle(v);
    }
}
