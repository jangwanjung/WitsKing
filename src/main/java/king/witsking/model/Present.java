package king.witsking.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class Present {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String giftPhoto;

    private String giftName;

    @CreationTimestamp
    private Timestamp creatDate;
}
