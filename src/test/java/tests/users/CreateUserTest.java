package tests.users;

import factories.UserDataFactory;
import io.restassured.http.ContentType;
import org.junit.Test;
import pojo.CreateUsersPojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static utils.BaseUrlUtil.baseUrlUser;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CreateUserTest {

    @Test
    public void testUserContract(){
        CreateUsersPojo user = new UserDataFactory().user();
        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(baseUrlUser)
                .then()
                .statusCode(201)
                .body(matchesJsonSchemaInClasspath("schema/user-schema.json"));
    }

    @Test
    public void testCreateAdmUser() {
        CreateUsersPojo user = new UserDataFactory().user();
        given()
            .contentType(ContentType.JSON)
            .body(user)
        .when()
            .log().all()
            .post(baseUrlUser)
        .then()
            .log().all()
            .statusCode(201)
                .body("name", equalTo(user.getName()))
                .body("job", equalTo(user.getJob()))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }

    @Test
    public void testCreateUserWithoutName() {
        CreateUsersPojo user = new UserDataFactory().userWithoutName();
        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .log().all()
                .post(baseUrlUser)
                .then()
                .log().all()
                .statusCode(201)
                .body("name", equalTo(user.getName()))
                .body("job", equalTo(user.getJob()))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }

    @Test
    public void testCreateUserWithoutJob() {
        CreateUsersPojo user = new UserDataFactory().userWithoutJob();
        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .log().all()
                .post(baseUrlUser)
                .then()
                .log().all()
                .statusCode(201)
                .body("name", equalTo(user.getName()))
                .body("job", equalTo(user.getJob()))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }


}
