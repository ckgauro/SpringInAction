package com.gauro.data;

import com.gauro.domain.Order;

/**
 * @author Chandra
 */
public interface OrderRepository {
    Order save(Order order);
}
