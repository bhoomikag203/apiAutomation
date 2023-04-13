package responses;

import lombok.Getter;

@Getter
public class CreateUserResponse extends BaseResponse {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}
