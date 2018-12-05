package springmvcproject.springmvcprojectrest.user;

import lombok.Data;
import springmvcproject.springmvcprojectrest.assignment.Assignment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String pesel;

    @OneToMany(mappedBy = "user")
    private List<Assignment> assignments = new ArrayList<>();

}

