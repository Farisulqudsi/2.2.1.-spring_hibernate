package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      /*User Aslambo = new User("Aslambo", "Lambo", "Lambo95@lam.bek", new Car("Lambo", 99));
      User Rustam = new User("Rustam", "Novosadovskiy", "Rustam@mchs.ru", new Car("Camry", 70));
      User Mansur = new User("Mansur", "MMA", "MechtiNeSbilis@gaz.prom", new Car("Camry", 55));
      User Zelim = new User("Zelim", "TopRassrochk yeg", "RossNeft@nefti.net", new Car("Focus", 3));


      userService.add(Aslambo); //Yes, this is your student)
      userService.add(Rustam);
      userService.add(Mansur);
      userService.add(Zelim);*/



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println(userService.getUserByCar("Lambo", 99));
      }

      context.close();
   }
}
