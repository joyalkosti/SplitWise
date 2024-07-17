package Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class Base_Model {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int Id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
