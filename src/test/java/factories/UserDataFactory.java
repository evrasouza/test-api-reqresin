package factories;

import com.github.javafaker.Faker;
import pojo.CreateUsersPojo;

public class UserDataFactory {
    Faker faker = new Faker();

    public CreateUsersPojo user(){
        CreateUsersPojo user = new CreateUsersPojo();
        user.setName(faker.name().fullName());
        user.setJob(faker.company().profession());
        return user;
    }

    public CreateUsersPojo userWithoutName(){
        CreateUsersPojo user = new CreateUsersPojo();
        user.setJob(faker.company().profession());
        return user;
    }

    public CreateUsersPojo userWithoutJob(){
        CreateUsersPojo user = new CreateUsersPojo();
        user.setName(faker.name().fullName());
        return user;
    }
}