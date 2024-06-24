
package org.example.examenll_dayronmyrie.Controller;
import org.example.examenll_dayronmyrie.Entity.Orden;
import org.example.examenll_dayronmyrie.Entity.OrdenItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private AtomicInteger orderCounter = new AtomicInteger();

    @PostMapping
    public OrderResponse processOrder(@RequestBody List<OrdenItem> orderItems) {
        if (orderItems != null) {
            int orderId = orderCounter.incrementAndGet();
            Orden orden = new Orden(String.valueOf(orderId), orderItems);
            System.out.println("Order received: " + orden);
            return new OrderResponse(orderId);
        } else {
           return null;
        }


    }

    public static class OrderResponse {
        private int orderId;

        public OrderResponse(int orderId) {
            this.orderId = orderId;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }
    }
}

