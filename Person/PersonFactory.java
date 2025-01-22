package Person;

public class PersonFactory {
    

    public Person create_person(String str){
        if(str.equals("Admin")){
            return new Admin();
        }else if(str.equals("Customer")){
            return new Customer();
        }else{
            return new ParkingAttendant();
        }
    }

}
