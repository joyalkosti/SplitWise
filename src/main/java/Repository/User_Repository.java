package Repository;

import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repository extends JpaRepository<User, Integer> {
    User findUserByEmail(String Email);
}
