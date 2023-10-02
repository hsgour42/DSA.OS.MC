package MachineCoding.ParkingLot.models;

import javax.xml.crypto.Data;
import java.util.Date;

public class BaseModel {
    private Long id;
    private Date createdAt;
    private Data lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Data getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Data lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
