package Vehicle;

public class VehicleFactory {
    
    public Vehicle create_vehicle(String str, double time){

        if(str.equals("EV")){
            return new EV(time);
        }else if(str.equals("Handicap")){
            return new Handicap(time);
        }else if(str.equals("TwoWheeler")){
            return new TwoWheeler(time);
        }else if(str.equals("FourWheeler")){
            return new FourWheeler(time);
        }else{
            return new LargeFourWheeler(time);
        }
    }

}
