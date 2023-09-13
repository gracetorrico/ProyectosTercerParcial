package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Employee {

    @Setter
    private String name;
    @Getter @Setter
    private String salary;
    @Getter @Setter
    private String age;

}
