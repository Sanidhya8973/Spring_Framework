package _01__Wiring_And_Autowiring._03__autowiring._01__autowiring_with_single_bean_of_same_type.beans.autowired_required_false;

import jakarta.annotation.PostConstruct;

public class Vehicle {

    private String name;

    @PostConstruct
    public void initialize() {
        this.name = "FORD";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}