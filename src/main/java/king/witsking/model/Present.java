package king.witsking.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Present {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
