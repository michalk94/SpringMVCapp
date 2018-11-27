package springmvcproject.springmvcprojectrest.asset;


import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AssetService {

    private AssetRepository assetRepository;
    private AssetMapper assetMapper;


    List<AssetDto> findAll() {
        return assetRepository.findAll()
                .stream()
                .map(assetMapper::toDto)
                .collect(Collectors.toList());
    }
}
