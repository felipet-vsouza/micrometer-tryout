package felipetvsouza.github.micrometertryout.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class BaseResponse<T> {

    @Builder.Default
    private final String message = "Successfully";

    private final T content;

    public static <T> BaseResponse<T> build(T content) {
        return BaseResponse.<T>builder()
                .content(content)
                .build();
    }

    public static <T> BaseResponse<T> build(T content, String message) {
        return BaseResponse.<T>builder()
                .content(content)
                .message(message)
                .build();
    }

}
