package requests.user;

import client.ClientRequest;
import constants.Route;
import io.restassured.response.Response;
import entites.User;
import org.testng.Reporter;
import responses.CreateUserResponse;
import responses.GetUserResponse;
import responses.UpdateUserResponse;
import utils.ConfigLoader;

public class UserRequest {

    ClientRequest clientRequest;

    public UserRequest() {
        clientRequest = new ClientRequest();
    }

    String path = new ConfigLoader().getHost() + Route.USER;

    public CreateUserResponse create(User user) {
        Response response = clientRequest.post(path, user);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        Reporter.log(String.format("\nCreate User Request: (POST) %s", path), true);
        Reporter.log(String.format("Create User Response: (%s)\n%s", response.getStatusCode(), response.asString()), true);
        createUserResponse.setStatusCode(response.getStatusCode());
        return createUserResponse;
    }

    public GetUserResponse get(int userId) {
        Response response = clientRequest.get(path + "/" + userId);
        GetUserResponse getUserResponse = response.as(GetUserResponse.class);
        Reporter.log(String.format("\nGet User Request: (GET) %s/%d", path, userId), true);
        Reporter.log(String.format("Get User Response: (%s)\n%s", response.getStatusCode(), response.asString()), true);
        getUserResponse.setStatusCode(response.getStatusCode());
        return getUserResponse;
    }

    public UpdateUserResponse update(String userId, User user) {
        Response response = clientRequest.update(path + "/" + userId, user);
        UpdateUserResponse updateUserResponse = response.as(UpdateUserResponse.class);
        Reporter.log(String.format("\nUpdate User Request: (PUT) %s/%s", path, userId), true);
        Reporter.log(String.format("Update User Response: (%s)\n%s", response.getStatusCode(), response.asString()), true);
        updateUserResponse.setStatusCode(response.getStatusCode());
        return updateUserResponse;
    }

    public Response delete(String userId) {
        Response response = clientRequest.delete(path + userId);
        Reporter.log(String.format("\nDelete User Request: (DELETE) %s/%s", path, userId), true);
        Reporter.log(String.format("Delete User Response: (%s)\n%s", response.getStatusCode(), response.asString()), true);
        return response;
    }
}
