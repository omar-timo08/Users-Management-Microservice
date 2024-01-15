package ma.gcdste.donsang.controller;

import ma.gcdste.donsang.model.entities.User;
import ma.gcdste.donsang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/findUser")
    public User findUser(@RequestBody User user){
        return userService.findUser(user);
    }

    @GetMapping("/findUserByName/{nom}")
    public User findUserByName(@PathVariable("nom") String nom){
        return userService.findUserByName(nom);
    }
    @GetMapping("/listByBloodType/{blood_type}")
    public List<User> listUsersByBloodType(@PathVariable("blood_type") String groupe_sanguin){
        return userService.listByBloodType(groupe_sanguin);
    }
    @PostMapping("/register")
    public int register(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/login/{email}/{password}")
    public int findUserByEmailAndPassword(@PathVariable("email") String email,@PathVariable("password") String password) {
        return userService.findUserByEmailAndPassword(email, password);
    }

    @GetMapping("/getName/{email}")
    public String getName(@PathVariable("email") String email) {
        return userService.getName(email);
    }

    @GetMapping("/getMail/{name}")

    public String getMail(@PathVariable("name") String name) {
        return userService.getMail(name);
    }

    @GetMapping("/getAge/{name}")

    public String getAge(@PathVariable("name")String name) {
        return userService.getAge(name);
    }
    @GetMapping("/getGroupe/{name}")
    public String getGroupe(@PathVariable("name") String name) {
        return userService.getGroupe(name);
    }

    @DeleteMapping("/deleteUser/{email}")
    public void delete(@PathVariable String email){
        userService.deleteUser(email);
    }
}
