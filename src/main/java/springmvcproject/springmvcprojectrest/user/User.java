package springmvcproject.springmvcprojectrest.user;

import lombok.Data;

import javax.persistence.*;

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
}
