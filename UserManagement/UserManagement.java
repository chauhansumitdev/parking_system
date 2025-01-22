package UserManagement;

import java.util.*;

import Person.Person;
import Vehicle.Vehicle;

public class UserManagement {
    
    private Map<Person, Vehicle> users;

    public UserManagement(){
        users = new HashMap<>();
    }

    public Map<Person, Vehicle> get_users(){
        return users;
    }

    public void add_user(Person person, Vehicle vehicle){

        if(users.containsKey(person)){
            System.out.println(" CANNOT PARK : CONTAINS ALREADY PARKED VEHICLE ");
            return;
        }

        users.put(person, vehicle);
    }

    public void remove_user(Person person){
        users.remove(person);
    }

}
