package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.dao.UserDao;
import ru.itsjava.domain.User;


import java.sql.SQLException;

@SpringBootApplication
public class SpringBootJdbcFoundationsHomeworkApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(SpringBootJdbcFoundationsHomeworkApplication.class, args);

//        Console.main(args);

        UserDao userDao = context.getBean(UserDao.class);
        System.out.println("userDao.count() = " + userDao.count());

        User user = new User("Dima", 29);
        userDao.insert(user);

        System.out.println("userDao.count() = " + userDao.count());

        User updatedUser = new User("Dima 2", 100);
        updatedUser.setId(1L);
        userDao.update(updatedUser);

        System.out.println("studentDao.findById(1L) = " + userDao.findById(1L));

        userDao.delete(updatedUser);
        System.out.println("userDao.count() = " + userDao.count());

        Console.main(args);

    }
}
