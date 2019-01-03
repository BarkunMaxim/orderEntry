//package com.netcraker.barkun.dao;
//
//import com.netcracker.barkun.dao.impl.OrderDaoImpl;
//import com.netcracker.barkun.entity.Order;
//import com.netcracker.barkun.entity.OrderItem;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//public class TestOrderDaoImpl {
//
//    private OrderDao orderDao;
//    private Order testOrder;
//
//    @Before
//    public void setUp() {
//        orderDao = new OrderDaoImpl();
//        List<OrderItem> items = new ArrayList<>();
//        items.add(new OrderItem("Книга", "Фантастика", 1L, 1L, null));
//        items.add(new OrderItem("Книга", "Историческая", 1L, 1L, null));
//        testOrder = new Order(new Date(), true, "asd", items);
//    }
//
//    @Test
//    public void testCreateOrder() {
//
//        Order createOrder = orderDao.createOrder(testOrder);
//
//        assertNotNull(createOrder);
//    }
//
//    @Test
//    public void testFindAllOrder() {
//
//        orderDao.createOrder(testOrder);
//
//
//        List<Order> orders = orderDao.findAllOrder();
//
//        assertEquals(orders.size(), 1);
//    }
//
//    @Test
//    public void testFindOrderById() {
//
//        Order createOrder = orderDao.createOrder(testOrder);
//        Order foundOrder = orderDao.findOrderById(createOrder.getId());
//
//        assertEquals(createOrder.getId(), foundOrder.getId());
//    }
//
//    @Test
//    public void testUpdateOrder() {
//        Order createOrder = orderDao.createOrder(testOrder);
//        createOrder.setPayStatus(false);
//        Order updateOrder = orderDao.updateOrder(createOrder);
//
//        assertEquals(createOrder.isPayStatus(), updateOrder.isPayStatus());
//    }
//
//    @Test
//    public void testDeleteOrder() {
//        Order createOrder = orderDao.createOrder(testOrder);
//        orderDao.deleteOrder(createOrder.getId());
//        Order foundOrder = orderDao.findOrderById(createOrder.getId());
//
//        assertNull(foundOrder);
//    }
//}
