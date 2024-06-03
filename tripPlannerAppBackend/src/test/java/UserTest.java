import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.repostitories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {

    private User user;

    @BeforeEach
    public void setUp(){
        user =  new User("Claire", "Roy", "clairer@gmail.com", "Apples23");
    }

    @Test
    void testUserGetForename() {
        String userForename = user.getForename();
        assertThat(userForename).isEqualTo("Claire");
    }

    @Test
    void testUserSetForename() {
        user.setForename("Clara");
        assertThat(user.getForename()).isEqualTo("Clara");
    }


    @Test
    void testUserGetSurname() {
        String userSurname = user.getSurname();
        assertThat(userSurname).isEqualTo("Roy");
    }

    @Test
    void testUserSetSurname() {
        user.setSurname("Kim");
        assertThat(user.getSurname()).isEqualTo("Kim");
    }

    @Test
    void testUserGetEmail() {
        String userEmail = user.getEmail();
        assertThat(userEmail).isEqualTo("clairer@gmail.com");
    }

    @Test
    void testUserSetEmail() {
        user.setEmail("clarar2@gmail.com");
        assertThat(user.getEmail()).isEqualTo("clarar2@gmail.com");
    }

    @Test
    void testUserGetPassword() {
        String userPassword = user.getPassword();
        assertThat(userPassword).isEqualTo("Apples23");
    }

    @Test
    void testUserSetPassword() {
        user.setPassword("Pears3");
        assertThat(user.getPassword()).isEqualTo("Pears3");
    }




}
