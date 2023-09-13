import com.fasterxml.jackson.core.JsonProcessingException;
import entities.Employee;
import io.restassured.RestAssured;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.not;


public class RestAssureCrud {

    @Test
    public void getEmployeesTest()
    {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
        Response response = RestAssured
                .when().get( "/employees");

        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("size()", not(0));
        response.then().log().body();
    }

    @Test
    public void getEmployeeTest()
    {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
        Response response = RestAssured
                .given().pathParam("id", "1")
                .when().get("/employee/{id}");

        response.then().log().body();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("data.id", Matchers.equalTo(1));

        response.then().assertThat().body("data.employee_name", Matchers.equalTo("Tiger Nixon"));
    }
    @Test
    public void postEmployeeTest() throws JsonProcessingException {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        Employee employee = new Employee();
        employee.setName("Diego");
        employee.setAge("29");
        employee.setSalary("4500");

        ObjectMapper mapper = new ObjectMapper();

        String payload = mapper.writeValueAsString(employee);
        System.out.println(payload);

        Response response = RestAssured
                .given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
                .when().post("/create");

        response.then().log().body();

        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("data.name", Matchers.equalTo(employee.getName()));
        response.then().assertThat().body("data.salary", Matchers.equalTo(employee.getSalary()));
        response.then().assertThat().body("data.age", Matchers.equalTo(employee.getAge()));

    }

    @Test
    public void putEmployeeTest() throws JsonProcessingException {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        Employee employee = new Employee();
        employee.setName("Carlos");
        employee.setAge("25");
        employee.setSalary("4700");

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(employee);

        Response response = RestAssured
                .given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
                .and().pathParam("id","1")
                .when().put("/update/{id}");

        response.then().log().body();

        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("message", Matchers.equalTo("Successfully! Record has been updated."));
        response.then().assertThat().body("data.name", Matchers.equalTo(employee.getName()));
        response.then().assertThat().body("data.age", Matchers.equalTo(employee.getAge()));
        response.then().assertThat().body("data.salary", Matchers.equalTo(employee.getSalary()));
    }

    @Test
    public void deleteEmployeeTest() throws JsonProcessingException {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        Response response = RestAssured
                .given().pathParam("id", "1")
                .when().delete("/delete/{id}");

        response.then().log().body();
        response.then().assertThat().body("message", Matchers.equalTo("Successfully! Record has been deleted"));
    }
}
