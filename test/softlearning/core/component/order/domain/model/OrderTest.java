/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package softlearning.core.component.order.domain.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import softlearning.core.component.client.domain.model.Client;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.GeneralDateTimeException;
import softlearning.core.component.shared.physics.PhysicalData;

import java.util.Optional;

import static org.junit.Assert.*;
import softlearning.core.component.shared.products.Marketable;

/**
 *
 * @author Alumnes
 */
public class OrderTest {
    
    private final Order instance;
    private final Client c;
    
    public OrderTest() throws BuildException{
        this.c = Client.getInstance("Jose Meseguer", "12345456X", "22-02-2000", "carrer kalea 2", 
                    "666555444", "111222333444", "********", 1, false, "2023-02-10");
        this.instance = Order.getInstance(1991, "10/02/2023-09:10:15", "Esta es una descripcion breve", c);
    }
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    /**
     * Test of getInstance method, of class Order.
     */
    @Test
    public void testGetInstanceBadId() {
        Order order = null;
        System.out.println("hola");
        String expectedResult = "Bad ID";
        String result = "";
        try {
            order = Order.getInstance(-1, "10/02/2023-09:10:15", "Esta es una descripcion breve", c);
        } catch (BuildException ex) {
            result += ex.getMessage();
        }
        
        assertEquals(result, expectedResult);
    }
    @Test
    public void testGetInstanceStartDate() {
        Order order = null;
        String expectedResult = "ERROR AL PARSEAR FECHA";
        String result = "";
        try {
            order = Order.getInstance(1, "10/02/2023", "Esta es una descripcion breve", c);
        } catch (BuildException ex) {
            result += ex.getMessage();
        }
        assertTrue(result.startsWith(expectedResult));
    }
    @Test
    public void testGetInstanceBadDescription() {
        Order order = null;
        String expectedResult = "Bad Description";
        String result = "";
        try {
            order = Order.getInstance(1, "10/02/2023-09:10:15", "Mal", c);
        } catch (BuildException ex) {
            result += ex.getMessage();
        }
        assertEquals(result, expectedResult);
    }
    @Test
    public void testGetInstanceBadClient() throws BuildException{
        Order order = null;
        String result = "";
        String[] expectedResult = {"Bad", "ERROR"};
        
        try {
            Client client = Client.getInstance("Ma", "12345456X", "22-02-2000", "carrer kalea 2", 
        "666555444", "111222333444", "********", 1, false, "2023-02-10");
            order = Order.getInstance(1, "10/02/2023-09:10:15", "Esto es una descripción breve", client);
        } catch (BuildException ex) {
            result += ex.getMessage();
        }
        System.out.println(result);
        Boolean detected = false;

        for(String word : expectedResult) {
            System.out.println(word);
            if(result.contains(word)) detected = true;
        }
        
        assertTrue(detected);
    }

    /**
     * Test of getSize method, of class Order.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Order instance = new Order();
        String expResult = "";
        String result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVolum method, of class Order.
     */
    @Test
    public void testGetVolum() {
        System.out.println("getVolum");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getVolum();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class Order.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getWeight();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFragile method, of class Order.
     */
    @Test
    public void testIsFragile() {
        System.out.println("isFragile");
        Order instance = new Order();
        boolean expResult = false;
        boolean result = instance.isFragile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientId method, of class Order.
     */
    @Test
    public void testGetClientId() {
        System.out.println("getClientId");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getClientId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumDetails method, of class Order.
     */
    @Test
    public void testGetNumDetails() {
        System.out.println("getNumDetails");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getNumDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetail method, of class Order.
     */
    @Test
    public void testSetDetail() throws Exception {
        System.out.println("setDetail");
        Marketable product = null;
        int amount = 0;
        Order instance = new Order();
        instance.setDetail(product, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetail method, of class Order.
     */
    @Test
    public void testGetDetail_int() throws Exception {
        System.out.println("getDetail");
        int pos = 0;
        Order instance = new Order();
        String expResult = "";
        String result = instance.getDetail(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetail method, of class Order.
     */
    @Test
    public void testGetDetail_String() throws Exception {
        System.out.println("getDetail");
        String ref = "";
        Order instance = new Order();
        String expResult = "";
        String result = instance.getDetail(ref);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetail method, of class Order.
     */
    @Test
    public void testGetDetail_OrderDetail() throws Exception {
        System.out.println("getDetail");
        OrderDetail od = null;
        Order instance = new Order();
        String expResult = "";
        String result = instance.getDetail(od);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDetail method, of class Order.
     */
    @Test
    public void testUpdateDetail_int_int() throws Exception {
        System.out.println("updateDetail");
        int pos = 0;
        int amount = 0;
        Order instance = new Order();
        int expResult = 0;
        int result = instance.updateDetail(pos, amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDetail method, of class Order.
     */
    @Test
    public void testUpdateDetail_String_int() throws Exception {
        System.out.println("updateDetail");
        String ref = "";
        int amount = 0;
        Order instance = new Order();
        int expResult = 0;
        int result = instance.updateDetail(ref, amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDetail method, of class Order.
     */
    @Test
    public void testUpdateDetail_OrderDetail_int() throws Exception {
        System.out.println("updateDetail");
        OrderDetail od = null;
        int amount = 0;
        Order instance = new Order();
        int expResult = 0;
        int result = instance.updateDetail(od, amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDetail method, of class Order.
     */
    @Test
    public void testDeleteDetail_int() throws Exception {
        System.out.println("deleteDetail");
        int pos = 0;
        Order instance = new Order();
        int expResult = 0;
        int result = instance.deleteDetail(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDetail method, of class Order.
     */
    @Test
    public void testDeleteDetail_String() throws Exception {
        System.out.println("deleteDetail");
        String ref = "";
        Order instance = new Order();
        int expResult = 0;
        int result = instance.deleteDetail(ref);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDetail method, of class Order.
     */
    @Test
    public void testDeleteDetail_OrderDetail() throws Exception {
        System.out.println("deleteDetail");
        OrderDetail od = null;
        Order instance = new Order();
        int expResult = 0;
        int result = instance.deleteDetail(od);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Order.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByPos method, of class Order.
     */
    @Test
    public void testFindByPos() {
        System.out.println("findByPos");
        int pos = 0;
        Order instance = new Order();
        OrderDetail expResult = null;
        OrderDetail result = instance.findByPos(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByRef method, of class Order.
     */
    @Test
    public void testFindByRef() {
        System.out.println("findByRef");
        String ref = "";
        Order instance = new Order();
        OrderDetail expResult = null;
        OrderDetail result = instance.findByRef(ref);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of orderConfirmation method, of class Order.
     */
    @Test
    public void testOrderConfirmation() {
        System.out.println("orderConfirmation");
        Order instance = new Order();
        instance.orderConfirmation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of orderCanceled method, of class Order.
     */
    @Test
    public void testOrderCanceled() {
        System.out.println("orderCanceled");
        Order instance = new Order();
        instance.orderCanceled();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPackageDimensions method, of class Order.
     */
    @Test
    public void testSetPackageDimensions() throws Exception {
        System.out.println("setPackageDimensions");
        String physics = "";
        Order instance = new Order();
        instance.setPackageDimensions(physics);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalCost method, of class Order.
     */
    @Test
    public void testGetTotalCost() {
        System.out.println("getTotalCost");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getTotalCost();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientData method, of class Order.
     */
    @Test
    public void testGetClientData() {
        System.out.println("getClientData");
        Order instance = new Order();
        String expResult = "";
        String result = instance.getClientData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShopCart method, of class Order.
     */
    @Test
    public void testGetShopCart() {
        System.out.println("getShopCart");
        Order instance = new Order();
        String expResult = "";
        String result = instance.getShopCart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}