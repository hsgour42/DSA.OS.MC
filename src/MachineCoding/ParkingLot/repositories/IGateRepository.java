package MachineCoding.ParkingLot.repositories;

import MachineCoding.ParkingLot.models.Gate;

import java.util.Optional;

public interface IGateRepository {
    public Optional<Gate> findGateById(Long gateId);
}
