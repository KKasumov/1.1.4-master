package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.jetbrains.annotations.NotNull;


public class Main {
    public static void main(String @NotNull [] args) {
        // реализуйте алгоритм здесь


        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Арнольд", "Шварценеггер", (byte) 60);
        userService.saveUser("Сильвестр", "Сталлоне", (byte) 60);
        userService.saveUser("Жан-Клод", "Ван Дамм", (byte) 50);
        userService.saveUser("Брюс", "Ли", (byte) 35);
        userService.removeUserById(args.length);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
