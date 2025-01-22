package ParkingLot;

import FloorManagement.FloorManagement;

public class ParkingLot {
    
    private FloorManagement floorManagement;

    public ParkingLot(){
        floorManagement = new FloorManagement();
    }

    public FloorManagement get_floor_management(){
        return floorManagement;
    }
}
