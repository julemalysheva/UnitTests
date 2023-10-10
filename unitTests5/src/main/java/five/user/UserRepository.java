package five.user;

// UserRepository.java
public class UserRepository {
    public User getUserById(int userId) {
        // Здесь должен быть код, который получает пользователя из базы данных по его ID
        // В данном примере мы просто вернем заглушку
        return new User(userId, "John Doe");
    }
}
//public class UserRepository {
//    public String getUserById(int id) {
//        // В реальной жизни здесь был бы код, работающий с базой данных
//        return "User " + id;
//    }
//}
