package _01__Wiring_And_Autowiring._03__autowiring._02_autowiring_with_multiple_beans_of_same_type.step_1.main;

import _01__Wiring_And_Autowiring._03__autowiring._02_autowiring_with_multiple_beans_of_same_type.step_1.beans.Person;
import _01__Wiring_And_Autowiring._03__autowiring._02_autowiring_with_multiple_beans_of_same_type.step_1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person myPerson = context.getBean(Person.class);

        System.out.println("\n> Person  Name: " + myPerson.getName());
        System.out.println("\n> Vehicle Name: " + myPerson.getVehicle().getName());
        System.out.println("\n> " + myPerson.getName() + " owns " + myPerson.getVehicle().getName());

        context.close();
    }

}
