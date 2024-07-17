package Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User_Expense extends Base_Model{
    @ManyToOne
    private User user;
    private double amount;

    @Enumerated(EnumType.STRING)
    private User_Expense_Type userExpenseType;
}
