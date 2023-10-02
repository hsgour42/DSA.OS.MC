package MachineCoding.ParkingLot.strategies.spotAssigmentStrategy;

import MachineCoding.ParkingLot.models.*;

import java.util.Optional;

public interface SpotAssigmentStrategy {
    Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate);
}
