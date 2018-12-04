package springmvcproject.springmvcprojectrest.asset;


import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import springmvcproject.springmvcprojectrest.exception.DuplicateSerialNumberException;

import java.util.List;
import java.util.Optional;
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

    List<AssetDto> findAllByNameOrSerialNumber(String text) {
        return assetRepository.findAllByNameOrSerialNumber(text)
                .stream()
                .map(assetMapper::toDto)
                .collect(Collectors.toList());
    }

    AssetDto save(AssetDto asset) {
        Optional<Asset> assetBySerialNo = assetRepository.findBySerialNumber(asset.getSerialNumber());
        assetBySerialNo.ifPresent(asset1 -> {
            throw new DuplicateSerialNumberException();
        });
        return mapAndSave(asset);
    }

    Optional<AssetDto> findById(Long id) {
        return assetRepository.findById(id).map(assetMapper::toDto);


    }

    AssetDto update(AssetDto asset){
        Optional<Asset> assetBySerialNo = assetRepository.findBySerialNumber(asset.getSerialNumber());
        assetBySerialNo.ifPresent(a -> {
            if (!a.getId().equals(asset.getId()))
                throw new DuplicateSerialNumberException();
        });
        return mapAndSave(asset);
    }

    private AssetDto mapAndSave(AssetDto asset){
        Asset assetEntity = assetMapper.toEntity(asset);
        Asset savedAsset = assetRepository.save(assetEntity);
        return assetMapper.toDto(savedAsset);
    }
}
