package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends Base_Model {
    private String description;
    private double amount;
    private LocalDateTime expenseTime;
    private Currency currency;

    @ManyToOne
    private User addedBy;
    private List<User_Expense> user_expenseList;
}
