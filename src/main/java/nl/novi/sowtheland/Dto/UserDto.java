package nl.novi.sowtheland.Dto;

import nl.novi.sowtheland.Model.Crop;
import nl.novi.sowtheland.Model.Role;

import java.util.ArrayList;

;

public class UserDto {
    public Long userId;

    public String userName;

    public String email;
    public String password;

    public ArrayList <Crop> garden;
    public String[] roles;
}
