public class exitgate {
    //int gate_id;
    parkinglot lot;
    public exitgate(parkinglot lot) {
        //this.gate_id = gate_id;
        this.lot = lot;
    }
    public void process_exit(int ticket_id, paymenttype p) {
       lot.unparkvehicle(ticket_id, p);
    }
}