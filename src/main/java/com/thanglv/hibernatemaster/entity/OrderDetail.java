package com.thanglv.hibernatemaster.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "order_detail_id", columnDefinition = "BINARY(16)")
    private String id;

    // Các trường khác của bảng OrderDetail
    private BigDecimal amount;

    /*Quan hệ OneToOne
     * Bảng chính là Order, bảng phụ order_detail có cột foreign key nối tới bảng Order chính
     * */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}
