package springmvcproject.springmvcprojectrest.asset;

import lombok.Data;

@Data
public class AssetDto {

    private Long id;
    private String name;
    private String description;
    private String serialNumber;
    private String category;
}
