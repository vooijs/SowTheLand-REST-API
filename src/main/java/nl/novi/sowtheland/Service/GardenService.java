package nl.novi.sowtheland.Service;

import nl.novi.sowtheland.Dto.GardenDto;
import nl.novi.sowtheland.Model.Garden;
import nl.novi.sowtheland.Repository.GardenRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GardenService {
    private final GardenRepository gardenRepos;
    private GardenService(GardenRepository gardenRepos){
        this.gardenRepos = gardenRepos;
    }
    public ResponseEntity <Long> createGarden (GardenDto gardenDto){
        Garden garden = new Garden();

        garden.setGardenId(gardenDto.gardenId);
        garden.setGardenSize(gardenDto.gardenSize);

        gardenRepos.save(garden);
        return new ResponseEntity<>(garden.getGardenId(), HttpStatus.CREATED);
    }
    public List<GardenDto> getAllGardens () {
        Iterable<Garden> gardens = gardenRepos.findAll();
        List<GardenDto> allGardens = new ArrayList<>();

        for (Garden garden : gardens) {
            GardenDto gardenDto = new GardenDto();
            gardenDto.gardenId = garden.getGardenId();
            gardenDto.gardenSize = garden.getGardenSize();
            allGardens.add(gardenDto);
        }
        return allGardens;
    }
    public ResponseEntity<GardenDto> findGardenbyId (Long gardenId){
        Garden foundgarden = gardenRepos.findById(gardenId).get();
        GardenDto gardenDto = new GardenDto();
        gardenDto.gardenId = foundgarden.getGardenId();
        gardenDto.gardenSize = foundgarden.getGardenSize();


        return ResponseEntity.ok(gardenDto);
    }
    public Long updateGarden(GardenDto gardenDto, Long gardenId){
        Garden garden = gardenRepos.findById(gardenId).get();
        garden.setGardenSize(gardenDto.gardenSize);
        gardenRepos.save(garden);
        return garden.getGardenId();
    }
    public ResponseEntity<?> deleteGarden (Long gardenId){
        gardenRepos.deleteById(gardenId);
        return ResponseEntity.ok("deleted");
    }

}
