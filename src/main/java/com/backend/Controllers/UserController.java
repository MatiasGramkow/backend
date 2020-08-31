package com.backend.Controllers;

import com.backend.Entities.User;
import com.backend.Repositories.UserRepository;
import com.backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserService userService;

    // Get All
    @GetMapping("/getAllUsers")
    public ResponseEntity<User> getAllUsers()
    {
        try
        {
            List<User> users = userService.findAll();
            return new ResponseEntity(users,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get One
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id)
    {
        try
        {
            Optional<User> user = userService.findById(id);
            return new ResponseEntity(user, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user)
    {
        Optional<User> currentUser = userService.findById(id);
        if (currentUser.isPresent())
        {
            User _user = currentUser.get();
            _user.setFirstname(user.firstname);
            _user.setLastname(user.lastname);
            _user.setRole(user.role);
            _user.setEmail(user.email);
            User updatedUser = userService.updateOrCreate(_user);
            return new ResponseEntity(updatedUser, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id)
    {
        Optional<User> user = userService.findById(id);

        if (user.isPresent())
        {
            userService.deleteById(id);
            return new ResponseEntity("Deleted user with id: '" + id + "'",HttpStatus.OK);
        } else
        {
            return new ResponseEntity("Id: '" + id + "' doesn't exist",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        try
        {
            userService.updateOrCreate(user);
            
            return new ResponseEntity(user, HttpStatus.CREATED);
        } catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
