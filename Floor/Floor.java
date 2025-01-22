package Floor;

import UserManagement.UserManagement;
import Vehicle.Vehicle;
import Person.Admin;
import Person.Customer;
import Person.ParkingAttendant;
import Person.Person;
import java.util.*;

public class Floor {
    private int spots_handicap;
    private int spots_ev;
    private int spots_two_wheeler;
    private int spots_small_four_wheeler;
    private int spots_large_four_wheeler;

    public int getSpots_handicap() {
        return spots_handicap;
    }

    public void setSpots_handicap(int spots_handicap) {
        this.spots_handicap = spots_handicap;
    }

    public void setSpots_ev(int spots_ev) {
        this.spots_ev = spots_ev;
    }

    public void setSpots_two_wheeler(int spots_two_wheeler) {
        this.spots_two_wheeler = spots_two_wheeler;
    }

    public void setSpots_small_four_wheeler(int spots_small_four_wheeler) {
        this.spots_small_four_wheeler = spots_small_four_wheeler;
    }

    public void setSpots_large_four_wheeler(int spots_large_four_wheeler) {
        this.spots_large_four_wheeler = spots_large_four_wheeler;
    }

    public void setUsermanagement(UserManagement usermanagement) {
        this.usermanagement = usermanagement;
    }

    public int getSpots_ev() {
        return spots_ev;
    }

    public int getSpots_two_wheeler() {
        return spots_two_wheeler;
    }

    public int getSpots_small_four_wheeler() {
        return spots_small_four_wheeler;
    }

    public int getSpots_large_four_wheeler() {
        return spots_large_four_wheeler;
    }

    public UserManagement getUsermanagement() {
        return usermanagement;
    }

    public UserManagement usermanagement;

    public Floor(int spots_handicap, int spots_ev, int spots_two_wheeler, int spots_small_four_wheeler, int spots_large_four_wheeler){
        this.spots_handicap = spots_handicap;
        this.spots_ev =spots_ev;
        this.spots_small_four_wheeler = spots_small_four_wheeler;
        this.spots_large_four_wheeler = spots_large_four_wheeler;

        usermanagement = new UserManagement();
    }

    public void add_vehicle(Person person, Vehicle vehicle){
        if(person instanceof Customer){
            usermanagement.add_user(person, vehicle);
        }
    }

    /**
 * MARK : 
 * DESC : this is used to display the current status of the floor , the vehicle, the customer info and the amount
 * PARAMS : none
 * OUTPUT : console out
 */
    public void display_panel(){

        System.out.println();
        System.out.println();
        System.out.println("---------------------");

        System.out.println("--"+" "+this+" "+" PANEL INFO --");

        Map<Person, Vehicle> users = usermanagement.get_users();

        for(Map.Entry<Person, Vehicle> entry : users.entrySet()){
            Person person = entry.getKey();
            Vehicle vehicle = entry.getValue();

            if(person instanceof Admin){
                System.out.print(" ADMIN ");
            }else if(person instanceof ParkingAttendant){
                System.out.print(" PARKING_ATTENDANT ");
            }else{
                System.out.print(" CUSTOMER ");
                System.out.println(vehicle);
                System.out.println(vehicle.get_ticket().getAmount());
            }

            System.out.println();
        }
        System.out.println("---------------------");
        System.out.println();
    }

    public UserManagement get_user_management(){
        return usermanagement;
    }
}
