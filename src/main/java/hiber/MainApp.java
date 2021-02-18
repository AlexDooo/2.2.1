package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        //userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Mazda", 3345)));
        //userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Opel", 100001)));
        //userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Ford", 999)));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        for (User userss : users) {
            System.out.println(userss.toString());
        }
        System.out.println(" ");

        System.out.println(userService.сarUsers("Ford", 999));
        context.close();
    }
}
