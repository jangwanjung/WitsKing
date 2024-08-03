package king.witsking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int scale;

    private String giftname;

    private String giftphoto;

    private boolean play;

    @OneToOne
    @JoinColumn(name = "winner_username")
    private User winner;

    @OneToMany
    private List<User> users;
}
