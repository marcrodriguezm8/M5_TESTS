package softlearning.core.component.order.domain.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import softlearning.core.component.book.domain.model.Book;
import softlearning.core.component.order.domain.*;
import softlearning.core.component.client.domain.model.Client;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.ServiceException;
import softlearning.core.component.shared.physics.PhysicalData;
import softlearning.core.component.shared.products.Marketable;

import static org.junit.Assert.*;
public class OrderDetailTest {

    private OrderDetail orderDetail;

    //private final ArrayList<OrderDetail> shopCart;

    public OrderDetailTest() {}

    // Para inicializar los objetos que se van a utilizar en los tests, se deben insertar en el método setUp.
    // El método setUp se ejecuta antes de cada test y nos asegura que los objetos son creados correctamente
    // y sin alteraciones entre tests.
    @Before
    public void setUp() throws BuildException, ServiceException {
        Book b1 = Book.getInstance(201, "PHP avanzado II", "CEFPNuria", "Programacion", "PHP",
                "Richard Stallman", 15.95, "7234567891013", 3, "23-10-2022",
                15.0, 20.0, 3.0, 0.4, false);

        this.orderDetail = OrderDetail.getInstance(b1, 10, 10);
    }
    

    // El método tearDown() sirve para limpiar los objetos que se han utilizado en los tests.
    // En el caso de este proyecto, no es necesario limpiar nada, pero es una buena práctica ya que facilita la
    // limpieza de memoria por parte del Garbage Collector.
    @After
    public void tearDown() throws Exception {
        this.orderDetail = null;
    }
    /**
     * Test of badAmount method, of class OrderDetail.
     */
    @Test
    public void testGetInstanceOrderClientBadAmount() throws BuildException {
        OrderDetail orderDetail = null;
        String expectedResult = "Bad amount;";
        String result = "";
        Book book = Book.getInstance(201, "PHP avanzado II", "CEFPNuria", "Programacion", "PHP",
                "Richard Stallman", 15.95, "7234567891013", 3, "23-10-2022",
                15.0, 20.0, 3.0, 0.4, false);
        try {
            orderDetail = OrderDetail.getInstance(book, -1, 10);
        } catch (BuildException ex) {
            result += ex.getMessage();
        }
        assertEquals(result, expectedResult);
    }
    /**
     * Test of badDiscount method, of class OrderDetail.
     */
    @Test
    public void testGetInstanceOrderClientBadDiscount() throws BuildException {
        OrderDetail orderDetail = null;
        String expectedResult = "Bad discount;";
        String result = "";
        Book book = Book.getInstance(201, "PHP avanzado II", "CEFPNuria", "Programacion", "PHP",
                "Richard Stallman", 15.95, "7234567891013", 3, "23-10-2022",
                15.0, 20.0, 3.0, 0.4, false);
        try {
            orderDetail = OrderDetail.getInstance(book, 10, -5);
        } catch (BuildException ex) {
            result += ex.getMessage();
        }
        assertEquals(result, expectedResult);
    }
    @Test
    public void testGetAmount() {
        assertEquals(this.orderDetail.getAmount(), 10);
    }
    @Test
    public void testSetAmount() {
        assertEquals(this.orderDetail.setAmount(20), 0);
    }
    @Test
    public void testSetAmountNegative() {
        assertEquals(this.orderDetail.setAmount(-6), -1);
    }
    @Test
    public void testSetAmountZero() {
        assertEquals(this.orderDetail.setAmount(0), -1);
    }
    @Test
    public void testGetDiscount() {
        assertEquals(this.orderDetail.getDiscount(), 10, 0.01);
    }
    @Test
    public void testSetDiscount() {
        assertEquals(this.orderDetail.setDiscount(50), 0);
    }
    @Test
    public void testSetDiscountZero() {
        assertEquals(this.orderDetail.setDiscount(0), 0);
    }
    @Test
    public void testSetDiscountNegative() {
        assertEquals(this.orderDetail.setDiscount(-10), -1);
    }
    @Test
    public void testSetMarketable() throws BuildException{
        Book b = Book.getInstance(203, "C# avanzado", "CEFPNuria", "Programacion", "C# intermedio",
        "John Williams", 34.95, "5234567891013", 4, "12-12-2022",
        15.0, 20.0, 3.0, 0.4, false);

        assertEquals(this.orderDetail.setMarketable(b), 0);
    }
    @Test
    public void testSetMarketableNull() throws BuildException{
        assertEquals(this.orderDetail.setMarketable(null), -1);
    }

    @Test
    public void testGetDetailCost() {
        assertEquals(this.orderDetail.getDetailCost(), -1435.5, 0.01);
    }
    @Test
    public void testGetDetail() {
        assertEquals(this.orderDetail.getDetail(), "201,PHP avanzado II,15.95,10,10.0");
    }
    @Test
    public void testToString() {
        assertEquals(this.orderDetail.toString(), "201,PHP avanzado II,15.95,10,10.0");
    }

}