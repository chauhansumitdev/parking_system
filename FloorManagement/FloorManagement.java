package FloorManagement;

import java.util.*;
import Floor.Floor;
import Payment.Payment;
import Person.Admin;
import Person.ParkingAttendant;
import Person.Person;
import Ticket.Ticket;
import Transaction.Transaction;
import Vehicle.EV;
import Vehicle.FourWheeler;
import Vehicle.Handicap;
import Vehicle.LargeFourWheeler;
import Vehicle.TwoWheeler;
import Vehicle.Vehicle;

public class FloorManagement {
    
    public List<Floor> floors;

    public FloorManagement(){
        floors = new ArrayList<>();
    }

    /**
 * MARK :
 * DESC : this function allows to add the floor if the instance is of Admin
 * PARAMS : Person, Floor
 * OUTPUT : add a floor to the parking lot
 */
    public void add_floor(Person person, Floor floor){
        if(person instanceof Admin){
            floors.add(floor);
        }else{
            System.out.println(" RERSTRICTED ACCESS! ");
        }
    }

    /**
 * MARK : 
 * DESC : this allows the ev to charge their ev.
 * PARAMS : Vehicle vehicle, Transaction transaction, double amount
 * OUTPUT : charges the ev and completes the transaction
 */
    public void cherge_ev(Vehicle vehicle, Transaction transaction, double amount){
        pay(null, vehicle, transaction);
        System.out.println(" CHARGING EV -- "+ vehicle);
    }


    /**
 * MARK : Pay
 * DESC : this function allows the user to pay for the parking
 * PARAMS : Person person, Vehicle vehicle, Transaction transaction
 * OUTPUT : Transaction success/failed message
 */
    public void pay(Person person , Vehicle vehicle, Transaction transaction){

        if(person instanceof Admin){
            
            System.out.println(" ADMIN CANNOT MAKE PAYMENTS ");

            return;
        }

        for(Floor floor : floors){

            Map<Person, Vehicle> users = floor.get_user_management().get_users();

            for(Map.Entry<Person, Vehicle> entry : users.entrySet()){
                Person current_person = entry.getKey();

                if(current_person == person){

                    Payment payment = new Payment();

                    payment.scan_ticket_and_pay(vehicle.get_ticket(), transaction);

                    System.out.println(" EXIT : "+ current_person+" "+ entry.getValue());

                    users.remove(current_person);

                    increment_count(floor, vehicle);

                    return;
                }
            }

        }
    }


    public void increment_count(Floor floor, Vehicle vehicle){
        if(vehicle instanceof EV){
            floor.setSpots_ev(floor.getSpots_ev()+1);
        }else if(vehicle instanceof Handicap){
            floor.setSpots_handicap(floor.getSpots_handicap() +1);
        }else if(vehicle instanceof TwoWheeler){
            floor.setSpots_two_wheeler(floor.getSpots_two_wheeler()+1);
        }else if(vehicle instanceof FourWheeler){
            floor.setSpots_small_four_wheeler(floor.getSpots_small_four_wheeler()+1);
        }else{
            floor.setSpots_large_four_wheeler(floor.getSpots_large_four_wheeler()+1);
        }
    }


    /**
 * MARK :
 * DESC : this allos to add the data to the user management database
 * PARAMS : Person person, Vehicle vehicle
 * OUTPUT : adds the data to the database
 */
    public void add_vehicle(Person person, Vehicle vehicle){

        if(person instanceof Admin){
            System.out.println(" ADMIN CANNOT PERFORM THIS FUNCTIONALITY ");
            return;
        }

        for(Floor current_floor : floors){
            if(vehicle instanceof EV && current_floor.getSpots_ev() > 0){
                current_floor.get_user_management().add_user(person, vehicle);
                current_floor.setSpots_ev(current_floor.getSpots_ev() -1);
                vehicle.set_ticket(new Ticket(vehicle.get_time()));
                return;
            }else if(vehicle instanceof Handicap && current_floor.getSpots_handicap() > 0 ){
                current_floor.get_user_management().add_user(person, vehicle);
                current_floor.setSpots_handicap(current_floor.getSpots_handicap()-1);
                vehicle.set_ticket(new Ticket(vehicle.get_time()));
                return;
            }else if(vehicle instanceof TwoWheeler && current_floor.getSpots_two_wheeler() > 0){
                current_floor.get_user_management().add_user(person, vehicle);
                current_floor.setSpots_two_wheeler(current_floor.getSpots_two_wheeler()-1);
                vehicle.set_ticket(new Ticket(vehicle.get_time()));
                return;
            }else if(vehicle instanceof FourWheeler && current_floor.getSpots_small_four_wheeler() > 0){
                current_floor.get_user_management().add_user(person, vehicle);
                current_floor.setSpots_small_four_wheeler(current_floor.getSpots_small_four_wheeler()-1);
                vehicle.set_ticket(new Ticket(vehicle.get_time()));
                return;
            }else if(vehicle instanceof LargeFourWheeler && current_floor.getSpots_large_four_wheeler() > 0){
                current_floor.setSpots_large_four_wheeler(current_floor.getSpots_large_four_wheeler()-1);
                current_floor.get_user_management().add_user(person, vehicle);
                vehicle.set_ticket(new Ticket(vehicle.get_time()));
                return;
            }
        }

        System.out.println(" CANNOT PARK "+vehicle +": NO SPOTS AVAILABLE ");
    }

    public void remove_floor(Person person, Floor floor){
        if(person instanceof Admin){
            floors.remove(find_instance(floor));
        }
    }

    public void add_parking_attendant(Person person, Floor floor){
        if(person instanceof ParkingAttendant){
            find_instance(floor).get_user_management().add_user(person, null);
        }else{
            System.out.println(" PERSON TYPE MISMATCH ");
        }
    }


    public Floor find_instance(Floor floor){
        for(Floor curr_flooor : floors){

            if(curr_flooor == floor){
                return curr_flooor;
            }
        }

        return null;
    }
}
