package Assignment.SectorQube.service;

import Assignment.SectorQube.model.User;
import Assignment.SectorQube.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
        
    public User getUserById(Integer userid){
        Optional<User> user = userRepository.findById(userid);
        if (user.isPresent()){
            return user.get();
        }
        return new User();
    }

    public void updateUser(User userData,int userid){
        Optional<User> existingUser = userRepository.findById(userid);
        if (existingUser.isPresent()){
            User user = existingUser.get();
            user.setFullname(userData.getFullname());
            user.setPassword(userData.getPassword());
            userRepository.save(user);
        }
    }
}
        

