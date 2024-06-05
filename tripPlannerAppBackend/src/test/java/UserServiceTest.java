import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.models.dtos.UserDTO;
import com.tripPlanner.demo.repostitories.UserRepository;
import com.tripPlanner.demo.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;


import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    UserService userService;
//   creates an instance of the class and injects the mocks that are created with the @Mock annotations into this instance.

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserByIdTest(){
        Long knownId = 1L;
        User user = new User("Claire", "Roy", "clairer@gmail.com", "Apples23");
        user.setId(knownId); // set the new user created id to KnownId
        when(userRepository.findById(knownId)).thenReturn(Optional.of(user));

        User userFound = userService.getUserById(knownId);

        assertThat(userFound).isEqualTo(user);
    }

    @Test
    public void addUserEmailInUseTest(){
        UserDTO userDTO = new UserDTO("Claire", "Roy", "clairer@gmail.com", "Apples23");
        User user = new User("Claire", "Roy", "clairer@gmail.com", "Apples23");

        when(userRepository.findByEmail("clairer@gmail.com")).thenReturn(null);
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User addedUser = userService.addUser(userDTO);
        assertThat(addedUser).isNotNull();
        assertThat(addedUser.getEmail()).isEqualTo("clairer@gmail.com");

        when(userRepository.findByEmail("clairer@gmail.com")).thenReturn(user);

        User duplicateUser = userService.addUser(userDTO);
        assertThat(duplicateUser).isNull();
    }

    @Test
    public void checkLoginCredentialsTest(){
        //    test checkLoginCredentials
//    test correct login
//    test correct email but incorrect password
//    test incorrect email input
//        need to create a user
        UserDTO user = new UserDTO("Claire", "Roy", "clairer@gmail.com", "Apples23");
//        as have tested it works
        userService.addUser(user);

//        call method and with input
        User responseIncorrectEmail = userService.checkLoginCredentials("clairer@hotmail.com", "Apples123");
        assertThat(responseIncorrectEmail).isNull();

//        failing
        User responseCorrectLogin = userService.checkLoginCredentials("clairer@gmail.com", "Apples23");
        assertThat(responseCorrectLogin).isNotNull();
        assertThat(responseCorrectLogin.getEmail()).isEqualTo("clairer@gmail.com");
        assertThat(responseCorrectLogin.getEmail()).isEqualTo("Apples23");

        User responseIncorrectPassword = userService.checkLoginCredentials("clairer@gmail.com", "Apples2323");
        assertThat(responseIncorrectPassword).isNull();

        User responseIncorrectLogin = userService.checkLoginCredentials("johnjones@gmail.com", "ButtonSKPear");
        assertThat(responseIncorrectLogin).isNull();

    }
}
