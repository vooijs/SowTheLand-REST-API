package nl.novi.sowtheland.Service;

import nl.novi.sowtheland.Dto.CropDto;
import nl.novi.sowtheland.Model.Crop;
import nl.novi.sowtheland.Repository.CropRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CropService {
    private final CropRepository cropRepos;
    public CropService (CropRepository cropRepos){
        this.cropRepos = cropRepos;
    }
    public ResponseEntity <Long> createCrop (CropDto cropDto){
        Crop crop = new Crop();

        crop.setCropId(cropDto.cropId);
        crop.setCropName(cropDto.cropName);
        crop.setCropType(cropDto.cropType);
        crop.setDescription(cropDto.description);

        cropRepos.save(crop);

        return new ResponseEntity<>(crop.getCropId(), HttpStatus.CREATED);
    }
    public List<CropDto> getAllCrops (){
        Iterable<Crop> crops = cropRepos.findAll();
        List<CropDto> allCrops = new ArrayList<>();

        for(Crop crop : crops){
            CropDto cropDto = new CropDto();

            cropDto.cropId = crop.getCropId();
            cropDto.cropName = crop.getCropName();
            cropDto.cropType = crop.getCropType();
            cropDto.description = crop.getDescription();
            allCrops.add(cropDto);
        }
        return allCrops;
    }
    public CropDto findCropByName (String cropName){
        Crop crop = cropRepos.findByCropNameContainingIgnoreCase(cropName);

            CropDto foundCrop = new CropDto();
            foundCrop.cropId = crop.getCropId();
            foundCrop.cropName = crop.getCropType();
            foundCrop.cropType = crop.getCropType();
            foundCrop.description = crop.getDescription();

            return foundCrop;
        }
        public Long updateCrop (CropDto cropDto, Long cropId){
        Crop crop = cropRepos.findById(cropId).get();
         crop.setCropName(cropDto.cropName);
         crop.setCropType(cropDto.cropType);
         crop.setDescription(cropDto.description);

         cropRepos.save(crop);
         return crop.getCropId();
        }
        public ResponseEntity<?> deleteCrop (Long cropId){
        cropRepos.deleteById(cropId);
        return ResponseEntity.ok("crop was deleted");
        }
    }

