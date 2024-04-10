package functionals;

import softlearning.core.component.order.domain.model.Order;
import softlearning.core.component.book.domain.model.Book;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.ServiceException;
import softlearning.core.component.client.domain.model.Client;
import softlearning.core.component.shared.exceptions.GeneralDateTimeException;

public class OrderFunctionals {

    public static void main(String[] args) {
        try {
            Client c = Client.getInstance("Jose Meseguer", "12444456X", "22-02-2000", "carrer kalea 2",
                    "666555444", "111222333444", "********", 1, false, "2023-02-10");
            Book b1 = Book.getInstance(101, "PHP avanzado", "CEFPNuria", "Programacion", "PHP",
                    "Richard Stallman", 14.95, "7234567891013", 2, "23-10-2021",
                    12.0, 18.0, 2.0, 0.3, false);
            Book b2 = Book.getInstance(102, "Java para todos", "CEFPNuria", "Programacion", "Java basico",
                    "Uncle Bob", 19.95, "1234567891013", 4, "22-10-2019",
                    12.0, 18.0, 2.0, 0.3, false);
            Book b3 = Book.getInstance(103, "C# intro", "CEFPNuria", "Programacion", "C# basico",
                    "John Williams", 24.95, "5234567891013", 3, "12-12-2020",
                    12.0, 18.0, 2.0, 0.3, false);
            Order o = Order.getInstance(1991, "10/02/2023-09:10:15", null, c);
            //System.out.println(o.getStartDate());
            o.setDetail(b1, 2);            
            System.out.println("Producto seleccionado: " + o.getDetail(0));
            System.out.println("Producto seleccionado: " + o.getDetail("101"));
            o.setDetail(b1, 3);
            o.setDetail(b2, 2);
            o.setDetail(b3, 4);
            for (int i = 0; i < o.getNumDetails(); i++) {
                System.out.println("Producto seleccionado: " + o.getDetail(i));
            }            
            System.out.println("Order Cost: " + o.getTotalCost());           
            o.updateDetail(0, 4);
            o.updateDetail("102", 1);
            for (int i = 0; i < o.getNumDetails(); i++) {
                System.out.println("Producto seleccionado: " + o.getDetail(i));
            }            
            System.out.println("Order Cost: " + o.getTotalCost());            
            o.deleteDetail(0);
            o.deleteDetail("102");            
            for (int i = 0; i < o.getNumDetails(); i++) {
                System.out.println("Producto seleccionado: " + o.getDetail(i));
            }            
            System.out.println("Order Cost: " + o.getTotalCost()); 
            
            o.orderConfirmation();
            o.setPackageDimensions("h:120.0,w:80.0,d:60.0,W:12.50,f:true");
            try {
                o.setFinishDate("16/02/2023-19:30:15");
            } catch (GeneralDateTimeException ex) {
                System.out.println("ERROR " + ex.getMessage());
            }
            System.out.println("Order Size: " + o.getSize());

        } catch (BuildException ex) {
            System.out.println(ex.getMessage());
        } catch (ServiceException ex) {
            System.out.println("ERROR " + ex.getMessage());
        }
    }
}
