package springmvcproject.springmvcprojectrest.user;

import springmvcproject.springmvcprojectrest.asset.Asset;
import springmvcproject.springmvcprojectrest.assignment.Assignment;

public class UserAssignmentMapper {

    static UserAssignmentDto toDto(Assignment assignment){
        UserAssignmentDto dto = new UserAssignmentDto();
        dto.setId(assignment.getId());
        dto.setAssetId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());
        Asset asset = assignment.getAsset();
        dto.setAssetId(asset.getId());
        dto.setAssetName(asset.getName());
        dto.setAssetSerialNumber(asset.getSerialNumber());
        return dto;
    }
}
