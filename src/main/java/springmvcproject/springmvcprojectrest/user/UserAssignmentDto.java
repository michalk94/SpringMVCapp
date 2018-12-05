package springmvcproject.springmvcprojectrest.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserAssignmentDto {

    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long assetId;
    private String assetName;
    private String assetSerialNumber;
}
