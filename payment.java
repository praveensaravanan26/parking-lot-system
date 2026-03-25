public class payment {
    //int payment_id;
    double amount;
    paymenttype type;
    paymentstatus status;
    public payment(int payment_id, double amount, paymenttype type) {
        //this.payment_id = payment_id;
        this.amount = amount;
        this.type = type;
        this.status = paymentstatus.PENDING;
    }
    public void processpayment() {
        System.out.println("Payment of ₹" + amount + " done via " + type);
    }
}
