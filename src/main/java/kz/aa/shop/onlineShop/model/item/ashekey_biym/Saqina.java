package kz.aa.shop.onlineShop.model.item.ashekey_biym;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.buym.PropertySaqina;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "saqina")
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Saqina extends BaseEntity {
    private String name;

    private Double price;

    private Boolean isUsed = true;

    @OneToOne(mappedBy = "saqina", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertySaqina propertySaqina;
}
