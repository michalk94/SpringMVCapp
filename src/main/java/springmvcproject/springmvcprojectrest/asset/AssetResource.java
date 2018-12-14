package springmvcproject.springmvcprojectrest.asset;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/assets")
@AllArgsConstructor
public class AssetResource {

    private AssetService assetService;

    @GetMapping("")
    public List<AssetDto> findAll(@RequestParam(required = false) String text) {
        if (text != null)
            return assetService.findAllByNameOrSerialNumber(text);
        else
            return assetService.findAll();
    }

    public ResponseEntity<AssetDto> save(@RequestBody AssetDto asset) {
        if (asset.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " You need to set up id");
        AssetDto savedAsset = assetService.save(asset);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAsset.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedAsset);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetDto> findById(@PathVariable Long id) {
        return assetService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetDto> update(@PathVariable Long id,
                                           @RequestBody AssetDto asset) {
        if (!id.equals(asset.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong id of updated asset");
        AssetDto updateAsset = assetService.update(asset);
        return ResponseEntity.ok(updateAsset);
    }

    @GetMapping("/{id}/assignments")
    public List<AssetAssignmentDto> getAssetAssignments(@PathVariable Long id){
        return assetService.getAssetAssignments(id);
    }
}
