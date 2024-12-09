package learn.ddd.domain;

import jakarta.persistence.*;
import learn.ddd.dto.request.staff.CreateStaffServiceRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbStaff extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long id;

    private String staffName;

    private String staffPassword;

    @Enumerated(EnumType.STRING)
    private StaffRole staffRole;

    private TbStaff(String staffName, String staffPassword, StaffRole staffRole) {
        this.staffName = staffName;
        this.staffPassword = staffPassword;
        this.staffRole = staffRole;
    }

    public static TbStaff create(CreateStaffServiceRequest request) {
        return new TbStaff(request.getStaffName(), request.getStaffPassword(), findStaffRole(request.getStaffRole()));
    }


    private static StaffRole findStaffRole(String staffRole) {
        if ("Barista".equals(staffRole)) {
            return StaffRole.BARISTA;
        }

        if ("Cashier".equals(staffRole)) {
            return StaffRole.CASHIER;
        }

        throw new IllegalArgumentException("존재하지 않은 역할입니다.");
    }

}
