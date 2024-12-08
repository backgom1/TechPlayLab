package learn.ddd.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbPayment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TbOrder tbOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    public TbPayment(TbOrder tbOrder, String paymentMethod) {
        this.tbOrder = tbOrder;
        this.paymentMethod = findPaymentMethod(paymentMethod);
        this.paymentStatus = PaymentStatus.UNPAID;
    }

    public void completePay(){
        if (this.paymentStatus == PaymentStatus.PAID) {
            throw new IllegalStateException("이미 완료된 결제입니다.");
        }
        this.paymentStatus = PaymentStatus.PAID;
    }

    private PaymentMethod findPaymentMethod(String type) {
        if ("Card".equals(type)) {
            return PaymentMethod.CARD;
        }
        if ("App".equals(type)) {
            return PaymentMethod.APP;
        }
        if ("Cash".equals(type)) {
            return PaymentMethod.CASH;
        }
        return null;
    }

}
