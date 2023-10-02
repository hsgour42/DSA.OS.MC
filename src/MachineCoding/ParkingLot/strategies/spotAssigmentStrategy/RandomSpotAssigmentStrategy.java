package MachineCoding.ParkingLot.strategies.spotAssigmentStrategy;

import MachineCoding.ParkingLot.models.*;

import java.util.Optional;

public class RandomSpotAssigmentStrategy implements SpotAssigmentStrategy{
    @Override
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) {
        for(ParkingFloor parkingFloor: parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot: parkingFloor.getParkingSpots()){
                if(parkingSpot.getSpotStatus().equals(SpotStatus.AVAILABLE) &&
                        parkingSpot.getVehicleTypes().contains(vehicleType)
                ){
                    return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();
    }
}
