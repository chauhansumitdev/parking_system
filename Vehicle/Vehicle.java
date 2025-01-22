package Vehicle;

import Ticket.Ticket;

public class Vehicle {

    private Ticket ticket;

    private double time;

    public Vehicle(double time){
        this.time = time;
    }
    
    public void set_ticket(Ticket ticket){
        this.ticket = ticket;
    }

    public Ticket get_ticket(){
        return ticket;
    }

    public double get_time(){
        return time;
    }

    public void set_time(double time){
        this.time = time;
    }
}