package springmvcproject.springmvcprojectrest.asset;


import lombok.Data;
import springmvcproject.springmvcprojectrest.category.Category;

import javax.persistence.*;


@Entity
@Data
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(unique = true)
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
