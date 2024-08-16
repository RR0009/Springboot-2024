package owu.com.ua.springbootrepitition2024.services;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import owu.com.ua.springbootrepitition2024.dao.UserDao;
import owu.com.ua.springbootrepitition2024.models.User;
import owu.com.ua.springbootrepitition2024.models.userdto.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserDao userDao;

    public void saveUser(UserDto userDto){
        String name = userDto.getUserName();

        User user = new User(name);
        userDao.save(user);

    }

    public ResponseEntity <List<UserDto>> getAllUsers(){
        List<UserDto> collect;
        collect = userDao.findAll().stream().map(user -> new UserDto(user.getName())).collect(Collectors.toList());
        return new ResponseEntity<>(collect, HttpStatus.ACCEPTED);
    }

            public ResponseEntity <User> getUserById(int id){
                                if(id<0) {
                        throw new RuntimeException();
                    }
                     return new ResponseEntity<>(userDao.findById(id).get(), HttpStatus.OK);
    }

    public List<User> deleteById(int id){
        if(id<0) {
            throw new RuntimeException();
        }

        userDao.deleteById(id);
        return userDao.findAll();
    }




}
