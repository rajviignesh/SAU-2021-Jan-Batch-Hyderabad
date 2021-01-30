package com.accolite.test.service.impl;

import com.accolite.test.entity.Item;
import com.accolite.test.entity.Order;
import com.accolite.test.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    List<Order> orders = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public int createNewOrder(Order order){
        if(orders.size() == 0){
            order.setOrderId(1);
            orders.add(order);
        }
        else{
            order.setOrderId(orders.size() + 1);
            orders.add(order);
        }
        logger.info("New order created successfully!");
        return order.getOrderId();
    }

    @Override
    public Order getOrderById(int OrderId){
        for(Order o : orders){
            if(o.getOrderId() == OrderId){
                return o;
            }
        }
        return null;
    }

    @Override
    public String addItem(int OrderId, Item item){
        for(Order o : orders){
            if(o.getOrderId()== OrderId){
                if(o.getItems().size() == 0){
                    item.setItemId(1);
                    o.getItems().add(item);
                }
                else{
                    item.setItemId(o.getItems().size() + 1);
                    o.getItems().add(item);
                }
                logger.info("Item added successfully to order!");
                return "Item added Successfully";
            }
        }
        logger.warn("Order is Not found");
        return "Order Id Not found";
    }

    @Override
    public Item getItemById(int orderId, int itemId){
        for(Order o : orders){
            if(o.getOrderId() == orderId) {
                for (Item i : o.getItems()) {
                    if (i.getItemId() == itemId)
                        return i;
                }
            }
                else
                    return null;
            }
        return null;
    }

    @Override
    public String deleteItem(int orderId, int itemId){
        for(Order o : orders){
            if(o.getOrderId() == orderId) {
                for (Item i : o.getItems()) {
                    if (i.getItemId() == itemId) {
                        o.getItems().remove(i);
                        int newId = 1;
                        for(Item it : o.getItems()){
                            it.setItemId(newId++);
                        }
                        logger.info("Item deleted successfully to order!");
                        return "Item " + itemId + " removed";
                    }
                }
                logger.warn("Item is Not found");
                return "Item Id not found";
            }
        }
        logger.warn("Order is Not found");
        return "Order Id not found";
    }

    @Override
    public String updateItem(int orderId, int itemId, Item item) {
        for (Order o : orders) {
            if (o.getOrderId() == orderId) {
                for (Item i : o.getItems()) {
                    if (i.getItemId() == itemId) {
                        if (item.isEmpty()) return "Empty error : Enter Valid key";
                        if (!(item.getItemName() == null)) i.setItemName(item.getItemName());
                        if (!(item.getItemCategory() == null)) i.setItemCategory(item.getItemCategory());
                        if (!(item.getItemQuantity() == null)) i.setItemQuantity(item.getItemQuantity());
                        logger.info("Item updated successfully to order!");
                        return "Item Updated";
                    }
                }
                logger.warn("Item is Not found");
                return "Item Id not found";
            }
        }
        logger.warn("Order is Not found");
            return "Order Id not found";
    }
}
