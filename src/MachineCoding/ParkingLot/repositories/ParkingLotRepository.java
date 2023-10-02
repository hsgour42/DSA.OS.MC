package MachineCoding.ParkingLot.repositories;

import MachineCoding.ParkingLot.models.Gate;
import MachineCoding.ParkingLot.models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository implements IParkingLotRepository {
    private Map<Long,ParkingLot> parkingLots = new TreeMap<>();
    @Override
    public Optional<ParkingLot> getParkingLotOfGate(Gate gate) {
        for(ParkingLot parkingLot : parkingLots.values()){
            if(parkingLot.getGates().contains(gate)){
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }
}
