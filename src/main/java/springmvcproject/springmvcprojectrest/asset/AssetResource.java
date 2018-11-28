package springmvcproject.springmvcprojectrest.asset;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
