package MachineCoding.ParkingLot.repositories;

import MachineCoding.ParkingLot.models.Gate;
import MachineCoding.ParkingLot.models.ParkingLot;

import java.util.Optional;

public interface IParkingLotRepository {
    public Optional<ParkingLot> getParkingLotOfGate(Gate gate);
}
