package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;


public class MainApp {
    public static void main(String[] args)  {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        Car car1 = new Car("Model1", 1);
        user1.setCar(car1);

        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        Car car2 = new Car("Model2", 2);
        user2.setCar(car2);

        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        Car car3 = new Car("Model3", 3);
        user3.setCar(car3);

        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        Car car4 = new Car("Model4", 4);
        user4.setCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getModel());
            System.out.println("Car Series = " + user.getCar().getSeries());
            System.out.println();

        }

        User user44 = userService.getUserByCarModelAndSeries("Model4", 4);
        System.out.println("найден юзер по модели и серии авто:");
        System.out.println("Id = " + user44.getId());
        System.out.println("First Name = " + user44.getFirstName());
        System.out.println("Last Name = " + user44.getLastName());
        System.out.println("Email = " + user44.getEmail());
        System.out.println("Car = " + user44.getCar().getModel());
        System.out.println("Car Series = " + user44.getCar().getSeries());
        System.out.println();
        context.close();
    }

}
