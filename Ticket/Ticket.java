package Ticket;

public class Ticket {
    private double amount;
    private double time;

    public Ticket(double time){
        this.time = time;
        if(time <= 1){
            amount = 4*time;
        }else if(time > 1 && time <= 2){
            amount = 3.5*time;
        }else if(time > 2){
            amount = 2*time;
        }
    }

    public double getAmount() {
        return amount;
    }

    public double getTime() {
        return time;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTime(double time) {
        this.time = time;
    }

    
    
}
