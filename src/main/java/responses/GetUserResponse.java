package responses;

import lombok.Getter;

@Getter
public class GetUserResponse extends BaseResponse {
    private Data data;
    private Support support;
}
