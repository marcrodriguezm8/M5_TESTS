/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package softlearning.core.component.order.domain.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import softlearning.core.component.client.domain.model.Client;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.GeneralDateTimeException;
import softlearning.core.component.shared.exceptions.ServiceException;
import softlearning.core.component.shared.physics.PhysicalData;
import softlearning.core.component.book.domain.model.Book;

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

    //private final ArrayList<OrderDetail> shopCart;

    public OrderTest() throws BuildException, ServiceException {
        Book b1 = Book.getInstance(101, "PHP avanzado", "CEFPNuria", "Programacion", "PHP",
                "Richard Stallman", 14.95, "7234567891013", 2, "23-10-2021",
                12.0, 18.0, 2.0, 0.3, false);
        Book b2 = Book.getInstance(102, "Java para todos", "CEFPNuria", "Programacion", "Java basico",
                "Uncle Bob", 19.95, "1234567891013", 4, "22-10-2019",
                12.0, 18.0, 2.0, 0.3, false);
        Book b3 = Book.getInstance(103, "C# intro", "CEFPNuria", "Programacion", "C# basico",
                "John Williams", 24.95, "5234567891013", 3, "12-12-2020",
                12.0, 18.0, 2.0, 0.3, false);
       
        this.c = Client.getInstance("Jose Meseguer", "12345456X", "22-02-2000", "carrer kalea 2",
                "666555444", "111222333444", "********", 1, false, "2023-02-10");
        this.instance = Order.getInstance(1991, "10/02/2023-09:10:15", "Esta es una descripcion breve", c);

        this.instance.setDetail(b1, 2);
        this.instance.setDetail(b2, 1);
        this.instance.setDetail(b3, 4);
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
    public void testGetInstanceBadClient() throws BuildException {
        Order order = null;
        String result = "";
        String[] expectedResult = { "Bad", "ERROR" };

        try {
            Client client = Client.getInstance("Ma", "12345456X", "22-02-2000", "carrer kalea 2",
                    "666555444", "111222333444", "********", 1, false, "2023-02-10");
            order = Order.getInstance(1, "10/02/2023-09:10:15", "Esto es una descripción breve", client);
        } catch (BuildException ex) {
            result += ex.getMessage();
        }
        System.out.println(result);
        Boolean detected = false;

        for (String word : expectedResult) {
            System.out.println(word);
            if (result.contains(word))
                detected = true;
        }

        assertTrue(detected);
    }

    /**
     * Test of getSize method, of class Order.
     */
    @Test
    public void testGetSize() throws BuildException {
    
    String physics = "h:10.0,w:5.0,d:3.0,W:50.0,f:true";
    this.instance.setPackageDimensions(physics);

    
    String expectedSize = "heigth:10.0;width:5.0;depth:3.0";
    assertEquals(expectedSize, this.instance.getSize());
}

    

    /**
     * Test of getVolum method, of class Order.
     */
    @Test
    public void testGetVolum() throws BuildException {
    String physics = "h:10.0,w:5.0,d:3.0,W:50.0,f:true";
    this.instance.setPackageDimensions(physics);

    double expectedVolume = 10.0 * 5.0 * 3.0;
    assertEquals(expectedVolume, this.instance.getVolum(), 0.01); // 0.01 es el margen de error permitido
}


    /**
     * Test of getWeight method, of class Order.
     */
    @Test
    public void testGetWeight() throws BuildException {
        String physics = "h:10.0,w:5.0,d:3.0,W:50.0,f:true";
        this.instance.setPackageDimensions(physics);
    
        double expectedWeight = 50.0;
        assertEquals(expectedWeight, this.instance.getWeight(), 0.01); // 0.01 es el margen de error permitido
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
        assertEquals(this.c.getCode(), 1);
    }

    /**
     * Test of getNumDetails method, of class Order.
     */
    @Test
    public void testGetNumDetails() {
        assertEquals(this.instance.getNumDetails(), 3);
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
        assertEquals(this.instance.getDetail(1), "102,Java para todos,19.95,1,0.0");
    }

    /**
     * Test of getDetail method, of class Order.
     */
    @Test
    public void testGetDetail_String() throws Exception {
        assertEquals(this.instance.getDetail("102"), "102,Java para todos,19.95,1,0.0");
    }

    /**
     * Test of getDetail method, of class Order.
     */
    @Test
    public void testGetDetail_OrderDetail() throws Exception {
        assertEquals(this.instance.getDetail(this.instance.shopCart.get(1)), "102,Java para todos,19.95,1,0.0");
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
        assertEquals(this.instance.getPrice(), 149.64999999999998, 0.001);
    }

    /**
     * Test of findByPos method, of class Order.
     */
    @Test
    public void testFindByPos() {
        assertEquals(this.instance.findByPos(1).toString(), "102,Java para todos,19.95,1,0.0");
    }

    /**
     * Test of findByRef method, of class Order.
     */
    @Test
    public void testFindByRef() {
        assertEquals(this.instance.findByRef("102").toString(), "102,Java para todos,19.95,1,0.0");
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
        assertEquals(this.instance.getTotalCost(), 0, 0.0001);
    }

    /**
     * Test of getClientData method, of class Order.
     */
    @Test
    public void testGetClientData() {
        assertEquals(this.instance.getClientData(), "name:Jose Meseguer;phone:666555444;address:carrer kalea 2");
    }

    /**
     * Test of getShopCart method, of class Order.
     */
    @Test
    public void testGetShopCart() {
        assertEquals(this.instance.getShopCart(), "101,PHP avanzado,14.95,2,0.0;102,Java para todos,19.95,1,0.0;103,C# intro,24.95,4,0.0;");
    }
}