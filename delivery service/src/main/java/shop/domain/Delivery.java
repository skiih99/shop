package shop.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import shop.DeliveryServiceApplication;
import shop.domain.DeliveryCancelled;
import shop.domain.DeliveryStarted;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String orderId;

    private String address;

    private String status;

    private String productId;

    private Integer qty;

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryServiceApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(OrderPlaced orderPlaced) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(String.valueOf(orderPlaced.getId()));
        delivery.setCustomerId(orderPlaced.getCustomerId());
        delivery.setProductId(orderPlaced.getProductId());
        delivery.setQty(orderPlaced.getQty());
        delivery.setAddress(orderPlaced.getAddress());
        delivery.setStatus("Delivery Started");

        repository().save(delivery);

        DeliveryStarted deliveryStarted = new DeliveryStarted(delivery);
        deliveryStarted.publishAfterCommit();
    }

    
    public static void cancelADelivery(OrderCancelled orderCancelled) {

        Delivery delivery = repository().findByOrderId(String.valueOf(orderCancelled.getId()));

        if (delivery != null) {
            delivery.setStatus("Delivery Cancelled");
            repository().save(delivery);

            DeliveryCancelled deliveryCancelled = new DeliveryCancelled(delivery);
            deliveryCancelled.publishAfterCommit();
        }
    }
}
