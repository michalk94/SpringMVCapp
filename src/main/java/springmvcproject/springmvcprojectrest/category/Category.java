package springmvcproject.springmvcprojectrest.category;


import lombok.Data;
import springmvcproject.springmvcprojectrest.asset.Asset;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private Set<Asset> assets = new HashSet<>();
}
