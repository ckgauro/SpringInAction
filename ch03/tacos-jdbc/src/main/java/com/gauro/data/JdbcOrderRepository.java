package com.gauro.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.domain.Order;
import com.gauro.domain.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chandra
 */
@Slf4j
@Repository
public class JdbcOrderRepository implements  OrderRepository{
    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderTacoInserter;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc){
        this.orderInserter=new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_order")
                .usingGeneratedKeyColumns("id");

        this.orderTacoInserter=new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order_Tacos");
        this.objectMapper=new ObjectMapper();
    }

    @Override
    public Order save(Order order) {
        order.setPlaceAt(new Date());
      //  long orderId=save
        return order;
    }
    private long saveOrderDetails(Order order) {
        @SuppressWarnings("unchecked")
        Map<String, Object> values=objectMapper.convertValue(order,Map.class);
        values.put("placeAt",order.getPlaceAt());
        long orderId=orderInserter.executeAndReturnKey(values)
                .longValue();
        return orderId;
    }

    private void saveTacoToOrder(Taco taco, long orderId) {
        Map<String,Object> values=new HashMap<>();
        values.put("tacoOrdere",orderId);
        values.put("taco",taco.getId());
        orderTacoInserter.execute((values));

    }

}
