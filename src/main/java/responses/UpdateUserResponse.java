package responses;

import lombok.Getter;

@Getter
public class UpdateUserResponse extends BaseResponse {
    private String name;
    private String job;
    private String updatedAt;
}
