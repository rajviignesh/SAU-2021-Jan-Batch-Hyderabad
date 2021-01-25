package com.accolite.test.service;

import com.accolite.test.entity.Item;
import com.accolite.test.entity.Order;

public interface OrderService {

    public String createNewOrder(Order order);

    public Order getOrderById(int orderId);

    public String addItem(int OrderId, Item item);

    public Item getItemById(int orderId, int itemId);

    public String deleteItem(int orderId, int itemId);

    public String updateItem(int orderId, int itemId, Item item);
}
