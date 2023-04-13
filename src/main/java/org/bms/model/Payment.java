package org.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Payment extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    private String thirdPartyRefId;

}
