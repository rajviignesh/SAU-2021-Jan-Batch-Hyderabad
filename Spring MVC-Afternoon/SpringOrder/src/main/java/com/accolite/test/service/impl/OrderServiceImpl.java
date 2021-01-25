package com.accolite.test.service.impl;

import com.accolite.test.entity.Item;
import com.accolite.test.entity.Order;
import com.accolite.test.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    List<Order> orders = new ArrayList<>();

    @Override
    public String createNewOrder(Order order){
        if(orders.size() == 0){
            order.setOrderId(1);
            orders.add(order);
        }
        else{
            order.setOrderId(orders.size() + 1);
            orders.add(order);
        }

        return "Created Successfully";
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
                return "Item added Successfully";
            }
        }
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
                        return "Item removed";
                    }
                }
                return "Item Id not found";
            }
        }
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
                        return "Item Updated";
                    }
                }
                return "Item Id not found";
            }
        }
            return "Order Id not found";
    }
}
