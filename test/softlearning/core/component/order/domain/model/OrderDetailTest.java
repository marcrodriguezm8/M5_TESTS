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
        //assertEquals(result, expectedResult);
    }


}