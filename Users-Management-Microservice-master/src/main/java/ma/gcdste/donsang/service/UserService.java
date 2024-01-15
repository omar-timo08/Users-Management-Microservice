package ma.gcdste.donsang.service;

import com.google.common.hash.Hashing;
import jakarta.transaction.Transactional;
import ma.gcdste.donsang.model.entities.User;
import ma.gcdste.donsang.model.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public int addUser(User user){
        String hashedPassword = Hashing.sha256()
                .hashString(user.getPassword(), StandardCharsets.UTF_8)
                .toString();
        user.setPassword(hashedPassword);
        if (findUser(user)==null) {
            userRepo.save(user);
            return 1;
        }
        else{
            return 0;
        }
    }

    public User findUserByName(String nom){
        return userRepo.findUserByName(nom);
    }

    public User findUser(User user){
        return userRepo.findUserByEmail(user.getEmail());
    }
    public List<User> listByBloodType(String groupe_sanguin){
        return userRepo.findUsersByGroupeSanguin(groupe_sanguin);
    }

    public int findUserByEmailAndPassword(String email, String password) {
        String hashedPassword = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        if (userRepo.findUserByEmailAndPassword(email,hashedPassword)==null)return 0;
        else return 1;
    }

    public String getName(String email){
        User user=userRepo.findUserByEmail(email);
        if (user==null) return "No User";
        else return user.getName();
    }
    public String getMail(String name){
        User user=userRepo.findUserByName(name);
        return user.getEmail();
    }
    public String getAge(String name){
        User user=userRepo.findUserByName(name);
        return user.getAge();
    }
    public String getGroupe(String name){
        User user=userRepo.findUserByName(name);
        return user.getGroupeSanguin();
    }
    @Transactional
    public void deleteUser(String email){
        userRepo.deleteByEmail(email);
    }
    }



