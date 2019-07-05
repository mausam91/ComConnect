/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/


package com.mausamcon.comconnect.api;

import com.mausamcon.comconnect.model.UserType;
import com.mausamcon.comconnect.model.Users;
import com.mausamcon.comconnect.persistence.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Collection;

@RestController
@RequestMapping("comconnect/users")
public class UsersController {


    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Autowired
    private JavaMailSender sender;


    public String sendMail(String email) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(email);
            helper.setText("Greetings :)");
            helper.setSubject("Thanks for registering with ComConnect!!");
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        return "Mail Sent Success!";
    }

    //INSERT USER
    @PostMapping
    public void insert(@RequestBody Users user) {
        this.usersRepository.insert(user);
        if (user.getEmail() != null) {
            sendMail(user.getEmail());
        }
    }

    //UPDATE USER
    @PutMapping
    public void update(@RequestBody Users user) {
        this.usersRepository.save(user);
    }

    //DELETE USERS BY THEIR ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.usersRepository.deleteById(id);
    }

    //GET ALL USERS
    @GetMapping("allusers")
    public Collection<Users> allusers() {

        return this.usersRepository.findAll();
    }

    //GET ALL USER (SORTED BY FIRSTNAME)
    @GetMapping("/allbyname")
    public Collection<Users> all() {
        Sort sortByFNameAsc = Sort.by("firstName").ascending();
        Collection<Users> users = this.usersRepository.findAll(sortByFNameAsc);
        return users;
    }

    // //Get all user by their Id
    @GetMapping("/{id}")
    public Users byId(@PathVariable String id) {
        Users users = this.usersRepository.findById(id).orElse(null);
        return users;
    }


    //Get all user by their FirstName
    @GetMapping("/byFirstName/{firstName}")
    public Collection<Users> byFirstName(@PathVariable String firstName) {
        return this.usersRepository.findALlByFirstNameContains(firstName);
    }

    //Get all user by their LastName
    @GetMapping("/byLastName/{lastName}")
    public Collection<Users> byLastName(@PathVariable String lastName) {
        return this.usersRepository.findALlByLastNameContains(lastName);
    }

    //Get all user with UserType "SEEKER"
    @GetMapping("/seeker")
    public Collection<Users> byUserType() {
        return this.usersRepository.findAllByUserType(UserType.SEEKER);
    }

    //Get all user by their usertype
    @GetMapping("/byUserType/{userType}")
    public Collection<Users> byUserType(@PathVariable UserType userType) {
        return this.usersRepository.findAllByUserType(userType);
    }

    //UserType Seeker And FirstName starts with "M"
    @GetMapping("/seekerAndM")
    public Collection<Users> byUserTypeAndM() {
        return this.usersRepository.findAllByUserTypeAndFirstNameStartsWith(UserType.SEEKER, "M");
    }


    @GetMapping("byState/{byState}")
    public Collection<Users> byState(@PathVariable String byState) {
        return usersRepository.findAllByUsersByState(byState);
    }

}
