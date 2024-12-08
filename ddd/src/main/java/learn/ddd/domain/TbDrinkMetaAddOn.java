package learn.ddd.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbDrinkMetaAddOn extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drink_meta_add_on_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TbDrink tbDrink;

    private String addOnName;

}
