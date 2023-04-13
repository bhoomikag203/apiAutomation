package client;

import io.restassured.response.Response;
import utils.ConfigLoader;

import static io.restassured.RestAssured.given;

public class ClientRequest {

    public Response post(String path, Object payload) {
        return given(RequestSpecificationBuilder.getRequestSpecification())
                .body(payload)
                .when()
                .post(path)
                .then()
                .spec(ResponseSpecificationBuilder.getResponseSpecification())
                .extract()
                .response();
    }

    public Response get(String path) {
        return given()
                .when()
                .get(path)
                .then()
                .spec(ResponseSpecificationBuilder.getResponseSpecification())
                .extract()
                .response();
    }

    public Response update(String path, Object payload) {
        return given(RequestSpecificationBuilder.getRequestSpecification())
                .body(payload)
                .when()
                .put(path)
                .then()
                .spec(ResponseSpecificationBuilder.getResponseSpecification())
                .extract()
                .response();
    }

    public Response delete(String path) {
        return given()
                .when()
                .delete(path)
                .then()
                .extract()
                .response();
    }
}