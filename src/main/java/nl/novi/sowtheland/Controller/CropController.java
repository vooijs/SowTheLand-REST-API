package nl.novi.sowtheland.Controller;

import nl.novi.sowtheland.Dto.CropDto;
import nl.novi.sowtheland.Service.CropService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/crops")
public class CropController {
    private final CropService cropService;
    private CropController (CropService cropService){
        this.cropService =cropService;
    }
    @PostMapping
    public ResponseEntity <Object> createCrop (@RequestBody CropDto cropDto){
        Long newCropId =cropService.createCrop(cropDto).getBody();
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newCropId).toUriString());
        return ResponseEntity.created(uri).body(cropDto);
    }
    @GetMapping
    public List<CropDto> getAllCrops(){
        return cropService.getAllCrops();
    }
    @GetMapping("/search")
    public ResponseEntity<CropDto> findCropByName (@RequestParam String cropName){
        return ResponseEntity.ok(cropService.findCropByName(cropName));
    }

}
