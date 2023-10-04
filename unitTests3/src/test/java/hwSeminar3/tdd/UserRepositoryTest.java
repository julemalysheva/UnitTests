package hwSeminar3.tdd;
/*
Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов.
Для этого, вам потребуется расширить класс User новым свойством, указывающим,
обладает ли пользователь админскими правами. Протестируйте данную функцию.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
    }

//    private void createAndAuthenticateUser(String name, String password, boolean isAdmin){
//        User user = new User(name, password, isAdmin);
//        userRepository.addUser(user);
//    }

    @Test
    void testLogoutUsersWithAdmins() {

        userRepository.addUser(new User("admin1", "password1", true));
        userRepository.addUser(new User("admin2", "password2", true));

        userRepository.logoutUsers();

        assertTrue(userRepository.findByName("admin1") &&
                userRepository.findByName("admin2"), "Администраторы не должны быть разлогинены");
    }

    @Test
    void testLogoutUsersWithoutAdmins() {

        userRepository.addUser(new User("user1", "password1", false));
        userRepository.addUser(new User("user2", "password2", false));

        userRepository.logoutUsers();

        assertFalse(userRepository.findByName("user1") &&
                userRepository.findByName("user2"), "Неадминистраторы должны быть разлогинены");
    }

    @Test
    void testLogoutDifferentUsers() {
//        createAndAuthenticateUser("admin1", "password1", true);
//        createAndAuthenticateUser("user1", "password1", false);
        userRepository.addUser(new User("user1", "password1", false));
        userRepository.addUser(new User("admin1", "password1", true));

        userRepository.logoutUsers();

        assertTrue(userRepository.findByName("admin1"), "Администраторы не должны быть разлогинены");
        assertFalse(userRepository.findByName("user1"), "Неадминистраторы должны быть разлогинены");
    }

}