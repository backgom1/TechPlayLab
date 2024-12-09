package learn.ddd.dto.request.staff;

import lombok.Getter;

@Getter
public class CreateStaffServiceRequest {
    private String staffName;
    private String staffPassword;
    private String staffRole;

    private CreateStaffServiceRequest(String staffName, String staffPassword, String staffRole) {
        this.staffName = staffName;
        this.staffPassword = staffPassword;
        this.staffRole = staffRole;
    }

    public static CreateStaffServiceRequest toServiceRequest(CreateStaffRequest request){
        return new CreateStaffServiceRequest(request.getStaffName(), request.getStaffPassword(), request.getStaffRole());
    }
}
