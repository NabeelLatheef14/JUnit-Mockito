package com.nbl.order.bo;

import com.nbl.order.bo.exception.BOException;
import com.nbl.order.dto.Order;

public interface OrderBO {

    boolean placeOrder(Order order) throws BOException;

    boolean cancelOrder(int id) throws  BOException;

    boolean deleteOrder(int id) throws BOException;


}
