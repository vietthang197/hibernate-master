package com.thanglv.hibernatemaster.services;

import com.thanglv.hibernatemaster.entity.Order;
import com.thanglv.hibernatemaster.entity.OrderDetail;
import com.thanglv.hibernatemaster.repository.OrderDetailRepository;
import com.thanglv.hibernatemaster.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TestService {

    private final OrderRepository orderRepository;

    @PostConstruct
    @Transactional
    public void testOrder() {
        Order order = new Order();
        order.setCreatedDate(LocalDateTime.now());

        OrderDetail detail = new OrderDetail();
        detail.setAmount(new BigDecimal("100"));

        // bắt buộc phải set relationship như này
        detail.setOrder(order);
        order.setOrderDetail(detail);

        // Khi sử dụng cascade thì chỉ cần save ở
        orderRepository.save(order);
    }
}
