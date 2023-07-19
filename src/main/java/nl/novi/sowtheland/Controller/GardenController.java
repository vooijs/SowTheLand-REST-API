package nl.novi.sowtheland.Controller;

import nl.novi.sowtheland.Dto.GardenDto;
import nl.novi.sowtheland.Model.Garden;
import nl.novi.sowtheland.Service.GardenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/gardens")
public class GardenController {
    private final GardenService gardenService;
    private GardenController (GardenService gardenService){
        this.gardenService = gardenService;
    }
    @PostMapping
    public ResponseEntity<Object> createGarden (@RequestBody GardenDto gardenDto){
        Long newGardenId = gardenService.createGarden(gardenDto).getBody();
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newGardenId).toUriString());

        return ResponseEntity.created(uri).body(gardenDto);
    }
    @GetMapping
    public List<GardenDto> getAllGardens(){
        return gardenService.getAllGardens();
    }
    @GetMapping("/search/{gardenId}")
    public ResponseEntity<GardenDto> findGardenById (@PathVariable Long gardenId){
        return gardenService.findGardenbyId(gardenId);
    }
    @PutMapping("/update/{gardenId}")
    public ResponseEntity<GardenDto> updateGarden (@PathVariable Long gardenId,@RequestBody GardenDto gardenDto){
        gardenService.updateGarden(gardenDto, gardenId);
        return ResponseEntity.ok(gardenDto);
    }
@DeleteMapping("/delete/{gardenId}")
    public ResponseEntity<?> deleteGarden (@PathVariable Long gardenId){
        gardenService.deleteGarden(gardenId);
        return ResponseEntity.ok("garden was deleted");
}


}
