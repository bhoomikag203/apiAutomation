package constants;

import lombok.Getter;

@Getter
public enum StatusCode {
    CODE_200(200),
    CODE_201(201),
    CODE_204(204),
    CODE_400(400),
    CODE_404(404);

    public int code;

    StatusCode(int code) {
        this.code = code;
    }
}
