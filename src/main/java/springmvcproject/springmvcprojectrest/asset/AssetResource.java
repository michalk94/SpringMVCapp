package springmvcproject.springmvcprojectrest.asset;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@AllArgsConstructor
public class AssetResource {

    private AssetService assetService;

    @GetMapping("")
    public List<AssetDto> findAll(){
        return assetService.findAll();
    }
}