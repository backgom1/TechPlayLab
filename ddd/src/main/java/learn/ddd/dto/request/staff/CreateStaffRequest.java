package learn.ddd.dto.request.staff;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CreateStaffRequest {

    @NotBlank(message = "스태프 이름을 작성해주세요.")
    private String staffName;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "ddd",message = "비밀번호 형식이 올바르지 않습니다.")
    private String staffPassword;

    @NotBlank(message = "스태프 역할을 선택해주세요")
    private String staffRole;
}
