package requests.user;

import client.ClientRequest;
import constants.Route;
import io.restassured.response.Response;
import entites.User;
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
        createUserResponse.setStatusCode(response.getStatusCode());
        return createUserResponse;
    }

    public GetUserResponse get(int userId) {
        Response response = clientRequest.get(path + "/" + userId);
        GetUserResponse getUserResponse = response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(response.getStatusCode());
        return getUserResponse;
    }

    public UpdateUserResponse update(String userId, User user) {
        Response response = clientRequest.update(path + "/" + userId, user);
        UpdateUserResponse updateUserResponse = response.as(UpdateUserResponse.class);
        updateUserResponse.setStatusCode(response.getStatusCode());
        return updateUserResponse;
    }

    public Response delete(String userId) {
        return clientRequest.delete(path + userId);
    }
}
