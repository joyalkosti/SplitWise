package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.ast.tree.from.MappedByTableGroup;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name="SPLITWISE_GROUP")
public class Group extends Base_Model{
    private String name;

    @ManyToOne
    private User createdBy;
    private LocalDateTime creationDate;
    private double totalAmountSpent;

    @ManyToMany(mappedBy = "groupList")
    private List<User> members;

    @OneToMany
    private List<Expense> expenseList;

    @OneToMany
    private List<Settlement_Transcation> settlement_transcationList;
}
