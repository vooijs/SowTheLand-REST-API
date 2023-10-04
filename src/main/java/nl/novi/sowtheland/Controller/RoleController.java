package nl.novi.sowtheland.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.novi.sowtheland.Dto.RoleDto;
import nl.novi.sowtheland.Model.Role;
import nl.novi.sowtheland.Repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RestController
public class RoleController {
    private final RoleRepository roleRepository;

    @GetMapping("/roles")
    public List<RoleDto> getRoles() {
        List<RoleDto> roleDtos = new ArrayList<>();
        for(Role r : roleRepository.findAll()) {
            RoleDto roleDto =new RoleDto();
            roleDto.rolename = r.getRolename();
            roleDtos.add(roleDto);
        }
        return roleDtos;
    }
}
