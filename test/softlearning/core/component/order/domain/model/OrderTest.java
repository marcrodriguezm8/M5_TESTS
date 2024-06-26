/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package softlearning.core.component.order.domain.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import softlearning.core.component.book.domain.model.Book;
import softlearning.core.component.client.domain.model.Client;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.ServiceException;
import softlearning.core.component.shared.physics.PhysicalData;
import softlearning.core.component.shared.products.Marketable;

import static org.junit.Assert.*;

/**
 * @author Alumnes
 */
public class OrderTest {

    private Order instance;
    private Client c;
    private PhysicalData orderPackage;

    //private final ArrayList<OrderDetail> shopCart;

    public OrderTest() {}

    // Para inicializar los objetos que se van a utilizar en los tests, se deben insertar en el método setUp.
    // El método setUp se ejecuta antes de cada test y nos asegura que los objetos son creados correctamente
    // y sin alteraciones entre tests.
    @Before
    public void setUp() throws BuildException, ServiceException {
        Book b1 = Book.getInstance(201, "PHP avanzado II", "CEFPNuria", "Programacion", "PHP",
                "Richard Stallman", 15.95, "7234567891013", 3, "23-10-2022",
                15.0, 20.0, 3.0, 0.4, false);
        Book b2 = Book.getInstance(202, "Java para expertos", "CEFPNuria", "Programacion", "Java avanzado",
                "Uncle Bob", 29.95, "1234567891013", 5, "22-10-2021",
                15.0, 20.0, 3.0, 0.4, false);
        Book b3 = Book.getInstance(203, "C# avanzado", "CEFPNuria", "Programacion", "C# intermedio",
                "John Williams", 34.95, "5234567891013", 4, "12-12-2022",
                15.0, 20.0, 3.0, 0.4, false);
    
        this.c = Client.getInstance("Juan Pérez", "12345456X", "22-02-1995", "calle San Juan 10",
                "666999888", "111222333444", "********", 2, false, "2022-02-10");
    
        this.instance = Order.getInstance(1992, "11/02/2023-09:10:15", "Esta es una descripción detallada", c);
    
        this.instance.setDetail(b1, 3);
        this.instance.setDetail(b2, 2);
        this.instance.setDetail(b3, 6);

    }
    

    // El método tearDown() sirve para limpiar los objetos que se han utilizado en los tests.
    // En el caso de este proyecto, no es necesario limpiar nada, pero es una buena práctica ya que facilita la
    // limpieza de memoria por parte del Garbage Collector.
    @After
    public void tearDown() throws Exception {
        this.instance = null;
        this.c = null;
    }

    /**
     * Test of getInstance method, of class Order.
     */
    @Test
    public void testGetInstanceBadId() {
        Order order = null;

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
        String[] expectedResult = {"Bad", "ERROR"};

        try {
            Client client = Client.getInstance("Ma", "12345456X", "22-02-2000", "carrer kalea 2",
                    "666555444", "111222333444", "********", 1, false, "2023-02-10");
            order = Order.getInstance(1, "10/02/2023-09:10:15", "Esto es una descripción breve", client);
        } catch (BuildException ex) {
            result += ex.getMessage();
        }
        boolean detected = false;

        for (String word : expectedResult) {
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
    public void testIsFragile() throws BuildException {
        String physics = "h:10.0,w:5.0,d:3.0,W:50.0,f:true";
        this.instance.setPackageDimensions(physics);

        assertTrue(this.instance.isFragile());
    }
    @Test
    public void testSetPackageDimensions() {
        Order order = new Order();
        String physics = "h:10,w:20,d:5,W:15,f:true";

        try {
            order.setPackageDimensions(physics);
        } catch (BuildException e) {
            fail("No debería lanzar una excepción");
        }

        PhysicalData packageData = order.orderPackage;
        assertEquals(10.0, packageData.getHeigth(), 0.01);
        assertEquals(20.0, packageData.getWidth(), 0.01);
        assertEquals(5.0, packageData.getDepth(), 0.01);
        assertEquals(15.0, packageData.getWeigth(), 0.01);
        assertTrue(packageData.getFragile());

    }
    
    /**
     * Test of getClientId method, of class Order.
     */
    @Test
    public void testGetClientId() {
        assertEquals(this.c.getCode(), 2);
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
    public void test_set_detail_with_wrong_order_status() throws Exception {
        int expectedResult = -2;
        int result = 0;

        Book testBook = Book.getInstance(103, "C# intro", "CEFPNuria", "Programacion", "C# basico",
                "John Williams", 24.95, "5234567891013", 3, "12-12-2020",
                12.0, 18.0, 2.0, 0.3, false);

        this.instance.orderConfirmation();
        result = this.instance.setDetail(testBook, 1);

        assertEquals(expectedResult, result);
    }
    @Test
    public void testSetDetailNullProduct() throws BuildException, ServiceException {
        int result = this.instance.setDetail(null, 1);
        assertEquals(-1, result); // Verificar que el código de error es -1 para producto nulo
    }

    /**
     * Test of getDetail method, of class Order.
     */
    @Test
    public void testGetDetail_int() throws Exception {
        assertEquals(this.instance.getDetail(2), "203,C# avanzado,34.95,6,0.0");
    }
    @Test
    public void testGetDetail_() throws Exception {
        assertEquals(this.instance.getDetail(1), "202,Java para expertos,29.95,2,0.0");
    }

    /**
     * Test of getDetail method, of class Order.
     */
    @Test
    public void testGetDetail_String() throws Exception {
        assertEquals(this.instance.getDetail("203"), "203,C# avanzado,34.95,6,0.0");
    }

    /**
     * Test of getDetail method, of class Order.
     */
    @Test
    public void testGetDetail_OrderDetail() throws Exception {
        assertEquals(this.instance.getDetail(this.instance.shopCart.get(0)), "201,PHP avanzado II,15.95,3,0.0");
    }

    /*
     * Test of updateDetail method, of class Order.
     * Test the updateDetail method with a wrong order status
     */
    @Test
    public void test_update_detail_order_status_wrong() throws ServiceException {
        int expectedResult = -1;

        this.instance.orderConfirmation();
        int result = this.instance.updateDetail(0, 1);

        assertEquals(expectedResult, result);
    }

    /*
     * Test of updateDetail method, of class Order.
     * Test the updateDetail method with a non-existent detail by position
     */
    @Test
    public void test_update_detail_order_non_existent_by_position() {
        String expectedResult = "Detail not found";
        String result = null;

        try {
            this.instance.updateDetail(10, 1);
            fail("Expected a ServiceException to be thrown when the detail does not exist.");
        } catch (ServiceException e) {
            result = e.getMessage();
        }

        assertEquals(expectedResult, result);
    }

    /*
     * Test of updateDetail method, of class Order.
     * Test the updateDetail method with a non-existent detail by reference
     */
    @Test
    public void test_update_detail_order_non_existent_by_reference() {
        String expectedResult = "Detail not found";
        String result = null;

        try {
            this.instance.updateDetail("999", 1);
            fail("Expected a ServiceException to be thrown when the detail does not exist.");
        } catch (ServiceException e) {
            result = e.getMessage();
        }

        assertEquals(expectedResult, result);
    }

    /*
     * Test of updateDetail method, of class Order.
     * Test the updateDetail method with a less than 0 amount
     */
    @Test
    public void test_update_detail_order_zero_amount() {
        String expectedResult = "Amount can be greatter than 0";
        String result = "";

        try {
            this.instance.updateDetail(0, -1);
            fail("Expected a ServiceException to be thrown when the amount is zero.");
        } catch (ServiceException e) {
            result = e.getMessage();
        }

        assertEquals(expectedResult, result);
    }

    /*
     * Test of updateDetail method, of class Order.
     * Test the updateDetail method with a correct amount and position
     */
    @Test
    public void test_update_detail_order_correct_amount_position() throws ServiceException {
        int expectedResult = 0;
        int result = this.instance.updateDetail(0, 1);

        assertEquals(expectedResult, result);
    }

    /*
     * Test of deleteDetail method, of class Order.
     * Test the deleteDetail method with a wrong order status
     */
    @Test
    public void test_delete_detail_order_status_wrong() throws ServiceException {
        int expectedResult = -1;

        this.instance.orderConfirmation();
        int result = this.instance.deleteDetail(0);

        assertEquals(expectedResult, result);
    }

    /*
     * Test of deleteDetail method, of class Order.
     * Test the deleteDetail method with a non-existent detail by position
     */
    @Test
    public void test_delete_detail_order_non_existent_by_position() {
        String expectedResult = "Detail not found";
        String result = null;

        try {
            this.instance.deleteDetail(10);
            fail("Expected a ServiceException to be thrown when the detail does not exist.");
        } catch (ServiceException e) {
            result = e.getMessage();
        }

        assertEquals(expectedResult, result);
    }

    /*
     * Test of deleteDetail method, of class Order.
     * Test the deleteDetail method with a non-existent detail by reference
     */
    @Test
    public void test_delete_detail_order_non_existent_by_reference() {
        String expectedResult = "Detail not found";
        String result = null;

        try {
            this.instance.deleteDetail("999");
            fail("Expected a ServiceException to be thrown when the detail does not exist.");
        } catch (ServiceException e) {
            result = e.getMessage();
        }

        assertEquals(expectedResult, result);
    }

    /*
     * Test of deleteDetail method, of class Order.
     * Test the deleteDetail method with a non-existent detail by orderDetail object
     */
    @Test
    public void test_delete_detail_order_non_existent_by_orderDetail() {
        String expectedResult = "Detail not found";
        String result = "";

        try {
            OrderDetail od = null;
            this.instance.deleteDetail(od);
            fail("Expected a ServiceException to be thrown when the detail does not exist.");
        } catch (ServiceException e) {
            result = e.getMessage();
        }

        assertEquals(expectedResult, result);
    }

    /*
     * Test of deleteDetail method, of class Order.
     * Test the deleteDetail method with a correct detail by position
     */
    @Test
    public void test_delete_detail_order_correct_by_position() throws ServiceException {
        int expectedResult = 0;
        int result = this.instance.deleteDetail(0);

        assertEquals(expectedResult, result);
    }

    /**
     * Test of findByPos method, of class Order.
     */
    @Test
    public void testFindByPos() {
        assertEquals(this.instance.findByPos(1).toString(), "202,Java para expertos,29.95,2,0.0");
    }
    @Test
    public void testFindByPosNegative() {
        OrderDetail result = this.instance.findByPos(-1);
        assertNull(result);
    }
    
    /**
     * Test of findByRef method, of class Order.
     */
    @Test
    public void testFindByRef() {
        assertEquals(this.instance.findByRef("201").toString(), "201,PHP avanzado II,15.95,3,0.0");
    }
    @Test
    public void testFindByRefNull() {
        OrderDetail result = this.instance.findByRef(null);
        assertNull(result);
    }

    @Test
    public void testFindByRefEmpty() {
        OrderDetail result = this.instance.findByRef("    ");
        assertNull(result);
    }
    /**
     * Test of orderConfirmation method, of class Order.
     */
    @Test
    public void test_order_confirmation() {
        this.instance.orderConfirmation();

        assertEquals("CONFIRMED", this.instance.getStatus());
        assertEquals(317.45, this.instance.getTotalCost(), 0.001);
    }

    /**
     * Test of orderCanceled method, of class Order.
     */
    @Test
    public void test_order_canceled() {
        this.instance.orderCanceled();

        assertEquals("CANCELED", this.instance.getStatus());
    }
    /**
     * Test of getTotalCost method, of class Order.
     */
    @Test
    public void testGetTotalCost() {
        assertEquals(this.instance.getTotalCost(), 317.45, 0.0001);
    }

    /**
     * Test of getClientData method, of class Order.
     */
    @Test
    public void testGetClientData() {
        assertEquals(this.instance.getClientData(), "name:Juan Pérez;phone:666999888;address:calle San Juan 10");
    }

    /**
     * Test of getShopCart method, of class Order.
     */
    @Test
    public void testGetShopCart() {
        assertEquals(this.instance.getShopCart(), "201,PHP avanzado II,15.95,3,0.0;202,Java para expertos,29.95,2,0.0;203,C# avanzado,34.95,6,0.0;");
    }


}