package springmvcproject.springmvcprojectrest.assignment;


import lombok.Data;
import springmvcproject.springmvcprojectrest.asset.Asset;
import springmvcproject.springmvcprojectrest.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;


}
