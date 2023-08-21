package com.thanglv.hibernatemaster.repository;

import com.thanglv.hibernatemaster.entity.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    /*Để tránh N + 1 query
    * Thay vì dùng JOIN FETCH thì dùng EntityGraph
    * Nếu graphType = FETCH thì hibernate sẽ load hết các property của order lên và loại trừ n + 1 query
    * Nếu grapType = LOAD thì hibernate sẽ load hết orderDetail lên, các field khác của order thì load lazy
    * */
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"orderDetail"})
    List<Order> findAll();
}
