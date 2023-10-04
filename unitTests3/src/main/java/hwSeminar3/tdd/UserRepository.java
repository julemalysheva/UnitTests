package hwSeminar3.tdd;

/*
Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов.
Для этого, вам потребуется расширить класс User новым свойством, указывающим,
обладает ли пользователь админскими правами. Протестируйте данную функцию.
 */

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        //по логике сюда можно добавлять только аутентифицированных пользователей
        //сейчас это происходит некоррекно, проверяя user с user

        if (user.authenticate(user.name, user.password)) {
            user.isAuthenticate = true;
            this.data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logoutUsers() {
        for (User user : data) {
            if (!user.isAdmin) {
                user.isAuthenticate = false;
                data.remove(user);
            }
        }
    }
}
