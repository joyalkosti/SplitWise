package DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User_Login_DTO {
    private String name;
    private int id;
    private String email;
    private List<User_Friend_DTO> userFriendList;
    private List<Group_DTO> groupDtoList;

}
