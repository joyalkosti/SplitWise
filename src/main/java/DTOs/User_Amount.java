package DTOs;

import Entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User_Amount {
    private User user;
    private double amount;

    public User_Amount(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }
}
