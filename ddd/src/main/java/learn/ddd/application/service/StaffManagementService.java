package learn.ddd.application.service;

import learn.ddd.domain.TbStaff;
import learn.ddd.dto.request.staff.CreateStaffServiceRequest;
import learn.ddd.infra.repository.StaffJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StaffManagementService {

    private final StaffJpaRepository staffJpaRepository;

    @Transactional
    public void createStaff(CreateStaffServiceRequest serviceRequest) {
        TbStaff tbStaff = TbStaff.create(serviceRequest);
        staffJpaRepository.save(tbStaff);
    }
}
