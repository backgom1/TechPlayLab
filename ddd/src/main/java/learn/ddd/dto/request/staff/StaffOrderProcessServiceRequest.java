package learn.ddd.dto.request.staff;


import lombok.Getter;

@Getter
public class StaffOrderProcessServiceRequest {

    private Long OrderId;
    private Long StaffId;

    private StaffOrderProcessServiceRequest(Long orderId, Long staffId) {
        OrderId = orderId;
        StaffId = staffId;
    }

    public static StaffOrderProcessServiceRequest toServiceRequest(StaffOrderProcessRequest request) {
        return new StaffOrderProcessServiceRequest(request.getOrderId(), request.getStaffId());
    }
}
