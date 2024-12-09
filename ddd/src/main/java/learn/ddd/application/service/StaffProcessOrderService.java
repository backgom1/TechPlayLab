package learn.ddd.application.service;

import learn.ddd.domain.OrderStatus;
import learn.ddd.domain.TbOrder;
import learn.ddd.domain.TbStaff;
import learn.ddd.dto.request.staff.StaffOrderProcessRequest;
import learn.ddd.dto.response.StaffOrderProcessResponse;
import learn.ddd.infra.repository.OrderJpaRepository;
import learn.ddd.infra.repository.StaffJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StaffProcessOrderService {

    private final StaffJpaRepository staffJpaRepository;
    private final OrderJpaRepository orderJpaRepository;


    @Transactional
    public StaffOrderProcessResponse processReadyOrder(StaffOrderProcessRequest request) {
        TbStaff tbStaff = staffJpaRepository.findById(request.getStaffId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 스텝입니다."));

        TbOrder tbOrder = orderJpaRepository.findById(request.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 주문입니다."));

        verifyOrderState(tbOrder, tbStaff);

        tbOrder.changeReady(tbStaff.getStaffRole());

        //추후 개발 : 어떤 스탭이 음료를 변경했는지 알려주는 히스토리
        return new StaffOrderProcessResponse("음료 픽업이 완료되었습니다.");
    }

    private void verifyOrderState(TbOrder tbOrder, TbStaff tbStaff) {
        boolean canChangeOrderState = tbOrder.canChangeOrderState(tbStaff.getStaffRole(), tbOrder.getOrderStatus(), OrderStatus.READY);
        if (canChangeOrderState) {
            throw new IllegalStateException("주문 순서 동작이 올바르지 않습니다.");
        }
    }


    @Transactional
    public StaffOrderProcessResponse pickUpOrder(StaffOrderProcessRequest request) {
        TbStaff tbStaff = staffJpaRepository.findById(request.getStaffId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 스텝입니다."));
        TbOrder tbOrder = orderJpaRepository.findById(request.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 주문입니다."));

        tbOrder.changePickup();

        //추후 개발 : 어떤 스탭이 음료를 변경했는지 알려주는 히스토리
        return new StaffOrderProcessResponse("고객이 음료 픽업을 했습니다.");
    }
}
