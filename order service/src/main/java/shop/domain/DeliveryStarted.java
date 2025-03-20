package shop.domain;

import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String customerId;
    private Integer deliveryId;
    private String address;
    private String orderId;
    private String productId;
    private Integer qty;
    private String status;
}
