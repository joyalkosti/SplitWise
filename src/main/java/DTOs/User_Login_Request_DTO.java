package DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User_Login_Request_DTO {
    private String Password;
    private String Email;
}
