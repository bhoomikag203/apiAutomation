import constants.StatusCode;
import entites.User;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import requests.user.UserRequest;
import responses.CreateUserResponse;
import responses.GetUserResponse;
import responses.UpdateUserResponse;
import utils.JsonHelper;

public class UserTest {

    JSONObject testdata;

    @BeforeClass
    public void setupData() {
        JsonHelper jsonHelper = new JsonHelper();
        testdata = jsonHelper.getJsonObject("testdata.json");
    }

    @Test(description = "should be able to create user")
    public void shouldBeAbleToCreateUser() {
        User user = (User) JsonHelper.getObject(String.valueOf(testdata.get("user1")), User.class);

        CreateUserResponse createUserResponse = new UserRequest().create(user);

        Assert.assertEquals(createUserResponse.getStatusCode(), StatusCode.CODE_201.getCode());
        Assert.assertNotNull(createUserResponse.getId());
        Assert.assertEquals(createUserResponse.getName(), user.getName());
        Assert.assertEquals(createUserResponse.getJob(), user.getJob());
    }

    @Test(description = "should be able to get user")
    public void shouldBeAbleGetUserById() {
        JSONObject user2Details = testdata.getJSONObject("user2");

        GetUserResponse getUserResponse = new UserRequest().get(user2Details.getInt("id"));

        Assert.assertEquals(getUserResponse.getStatusCode(), StatusCode.CODE_200.getCode());
        Assert.assertEquals(getUserResponse.getData().getEmail(), user2Details.get("email"));
        Assert.assertEquals(getUserResponse.getData().getFirst_name(), user2Details.get("firstName"));
        Assert.assertEquals(getUserResponse.getData().getLast_name(), user2Details.get("lastName"));
    }

    @Test(description = "should be able to update user")
    public void shouldBeAbleToUpdateUser() {
        User user = (User) JsonHelper.getObject(String.valueOf(testdata.get("user1")), User.class);
        UserRequest userRequest = new UserRequest();
        CreateUserResponse response = userRequest.create(user);
        Assert.assertEquals(response.getStatusCode(), StatusCode.CODE_201.getCode());
        user = (User) JsonHelper.getObject(String.valueOf(testdata.get("updateUserDetails")), User.class);

        UpdateUserResponse userUpdateResponse = userRequest.update(response.getId(), user);

        Assert.assertEquals(userUpdateResponse.getStatusCode(), StatusCode.CODE_200.getCode());
        Assert.assertEquals(userUpdateResponse.getName(), user.getName());
        Assert.assertEquals(userUpdateResponse.getJob(), user.getJob());
    }


    @Test(description = "should be able to delete user")
    public void shouldBeAbleToDeleteUser() {
        User user = (User) JsonHelper.getObject(String.valueOf(testdata.get("user1")), User.class);
        UserRequest userRequest = new UserRequest();
        CreateUserResponse response = userRequest.create(user);
        Assert.assertEquals(response.getStatusCode(), StatusCode.CODE_201.getCode());

        Response deleteUserResponse = userRequest.delete(response.getId());

        Assert.assertEquals(deleteUserResponse.getStatusCode(), StatusCode.CODE_204.getCode());
    }
}
