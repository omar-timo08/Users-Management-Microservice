package ma.gcdste.donsang.model.repositories;

import ma.gcdste.donsang.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public User findUserByEmail(String email);
    public User findUserByName(String nom);
    public User findUserByEmailAndPassword(String email,String password);
    public List<User> findAll();
    List<User> findUsersByGroupeSanguin(String groupe_sanguin);
    void deleteByEmail(String email);
}
