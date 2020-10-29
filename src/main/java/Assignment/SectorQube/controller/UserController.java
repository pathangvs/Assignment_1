package Assignment.SectorQube.controller;


import Assignment.SectorQube.model.User;
import Assignment.SectorQube.repository.UserRepository;
import Assignment.SectorQube.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String getlogin()
    {
        return "Login";
    }

    @RequestMapping(value = "/user/{userid}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable("userid") Integer userid, @RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        userService.updateUser(user,userid);
        return new ResponseEntity<String>(
                "User Updated Successfully", headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/allusers")
    public ResponseEntity<List<User>> getAllUser1(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        List<User> user1 = userRepository.findAll();
        //return user1;
        return new ResponseEntity<List<User>>(
                user1, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userid}")
    public User getUser(@PathVariable("userid") Integer userid) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        User entity = userService.getUserById(userid);
        return entity;
    }






    /*  @RequestMapping(value="/home", method = RequestMethod.GET)
        public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

    }*/

}

