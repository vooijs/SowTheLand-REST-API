package nl.novi.sowtheland.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.novi.sowtheland.Dto.CropDto;
import nl.novi.sowtheland.Model.Crop;
import nl.novi.sowtheland.Repository.CropRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor

@Service
public class CropService {
    private final CropRepository cropRepos;



    public ResponseEntity <Long> createCrop (CropDto cropDto){
        Crop crop = new Crop();

        crop.setCropId(cropDto.cropId);
        crop.setCropName(cropDto.cropName);
        crop.setCropType(cropDto.cropType);
        crop.setPosition(cropDto.position);
        crop.setBeginPlantingPeriod(cropDto.beginPlantingPeriod);
        crop.setEndPlantingPeriod(cropDto.endPlantingPeriod);
        crop.setWatering(cropDto.watering);

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
            cropDto.position = crop.getPosition();
            cropDto.beginPlantingPeriod = crop.getBeginPlantingPeriod();
            cropDto.endPlantingPeriod = crop.getEndPlantingPeriod();
            cropDto.watering = crop.getWatering();
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
            foundCrop.position = crop.getPosition();
            foundCrop.beginPlantingPeriod = crop.getBeginPlantingPeriod();
            foundCrop.endPlantingPeriod = crop.getEndPlantingPeriod();
            foundCrop.watering = crop.getWatering();

            return foundCrop;
        }
        public Long updateCrop (CropDto cropDto, Long cropId){
        Crop crop = cropRepos.findById(cropId).get();
         crop.setCropName(cropDto.cropName);
         crop.setCropType(cropDto.cropType);
         crop.setPosition(cropDto.position);
         crop.setBeginPlantingPeriod(cropDto.beginPlantingPeriod);
         crop.setEndPlantingPeriod(cropDto.endPlantingPeriod);
         crop.setWatering(cropDto.watering);

         cropRepos.save(crop);
         return crop.getCropId();
        }
        public ResponseEntity<?> deleteCrop (Long cropId){
        cropRepos.deleteById(cropId);
        return ResponseEntity.ok("crop was deleted");
        }
    }

