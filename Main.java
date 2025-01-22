import Floor.Floor;
import ParkingLot.ParkingLot;
import Person.Customer;
import Person.Person;
import Person.PersonFactory;
import Transaction.Transaction;
import Transaction.TransactionCash;
import Vehicle.*;

public class Main {
    public static void main(String[] args) {

        VehicleFactory vehicleFactory = new VehicleFactory();
        PersonFactory personFactory =  new PersonFactory();
        
        ParkingLot parking_lot= new ParkingLot();

        Floor floor = new Floor(1, 1, 1, 1, 1);

        Floor floor2 = new Floor(1, 1, 1, 1, 1);

        Person admin = personFactory.create_person("Admin");

        Person customer = personFactory.create_person("Customer");
        Vehicle vehicle =  new FourWheeler(5);


        Person customer2 = new Customer();
        Vehicle vehicle2 =  vehicleFactory.create_vehicle("EV", 5);

        Vehicle vehicle3 =  new EV(5);

        parking_lot.get_floor_management().add_floor(admin, floor);

        parking_lot.get_floor_management().add_floor(admin, floor2);
        
        parking_lot.get_floor_management().add_vehicle(customer,vehicle);

        parking_lot.get_floor_management().add_vehicle(customer2,vehicle2);

        parking_lot.get_floor_management().add_vehicle(customer2,vehicle3);


        parking_lot.get_floor_management().add_vehicle(customer2,new EV(10));

        floor.display_panel();
        floor2.display_panel();

        parking_lot.get_floor_management().pay(customer, vehicle, new TransactionCash());
        
        floor.display_panel();

        parking_lot.get_floor_management().cherge_ev(vehicle3, new Transaction(), 10);

    }
}
