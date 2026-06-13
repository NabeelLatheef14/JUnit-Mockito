package com.nbl.order.bo;

import com.nbl.order.bo.exception.BOException;
import com.nbl.order.dao.OrderDAO;
import com.nbl.order.dto.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderBOImplTest {

    public static final int ONE = 1;
    public static final int ZERO = 0;
    public static final int ID = 123;
    private OrderBOImpl bo;

    @Mock
    private OrderDAO dao;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(this);
        bo = new OrderBOImpl();
        bo.setDao(dao);

    }

    @Test
    void placeOrderShouldCreateAnOrder() throws SQLException, BOException {
        Order order = new Order();
        when(dao.create(order)).thenReturn(ONE);
        boolean result = bo.placeOrder(order);
        assertTrue(result);
        verify(dao).create(order);
    }

    @Test
    void placeOrderShouldNotCreateAnOrder() throws SQLException, BOException {
        Order order = new Order();
        when(dao.create(order)).thenReturn(ZERO);
        boolean result = bo.placeOrder(order);
        assertFalse(result);
        verify(dao).create(order);
    }

    @Test
    void placeOrderShouldThrowBOException() throws SQLException, BOException {
        Order order = new Order();
        when(dao.create(order)).thenThrow(SQLException.class);
        Assertions.assertThrows(BOException.class, ()->{
            bo.placeOrder(order);
        });
    }

    @Test
    void cancelOrderShouldCancelTheOrder() throws SQLException, BOException {
        Order order = new Order();
        when(dao.read(ID)).thenReturn(order);
        when(dao.update(order)).thenReturn(ONE);
        boolean result = bo.cancelOrder(ID);
        assertTrue(result);
        verify(dao).read(ID);
        verify(dao).update(order);
    }

    @Test
    void cancelOrderShouldNotCancelTheOrder() throws SQLException, BOException {
        Order order = new Order();
        when(dao.read(ID)).thenReturn(order);
        when(dao.update(order)).thenReturn(ZERO);
        boolean result = bo.cancelOrder(ID);
        assertFalse(result);
        verify(dao).read(ID);
        verify(dao).update(order);
    }

    @Test
    void cancelOrderShouldThrowBOExceptionOnRead() throws SQLException, BOException {
        when(dao.read(ID)).thenThrow(SQLException.class);
        Assertions.assertThrows(BOException.class, ()-> {
            bo.cancelOrder(ID);
        });
    }

    @Test
    void cancelOrderShouldThrowBOExceptionOnUpdate() throws SQLException, BOException {
        Order order = new Order();
        when(dao.read(ID)).thenReturn(order);
        when(dao.update(order)).thenThrow(SQLException.class);
        Assertions.assertThrows(BOException.class, ()-> {
            bo.cancelOrder(ID);
        });
    }

}
