public class ShareARide extends Service {
    public ShareARide() {
       super(50,0); 
    }

    @Override
    public int computeFare(Request r) {
        int fare = r.getDistance() * this.getFare();
        if (r.isPeakHours()) {
            fare += 500;
        }
        return fare / r.getPassenger();
    }

    @Override
    public String toString() {
        return "ShareARide";
    }

}

