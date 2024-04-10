package softlearning.core.component.order.domain.services;

import softlearning.core.component.book.domain.services.BookMapper;
import softlearning.core.component.book.infrastructure.IBookCatalog;
import softlearning.core.component.client.domain.services.ClientDTO;
import softlearning.core.component.client.domain.services.ClientMapper;
import softlearning.core.component.client.infrastructure.IClientCatalog;
import softlearning.core.component.order.domain.model.Order;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.ServiceException;
import softlearning.core.component.shared.products.Marketable;

public class OrderMapper {

    public static Order orderFromDTO(OrderDTO odto, IClientCatalog icc, IBookCatalog ibc) throws BuildException, ServiceException {  
        ClientDTO c = icc.getByID(odto.getClientId());
        Order o = Order.getInstance(odto.getIdent(), odto.getStartDate(), odto.getDescription(), ClientMapper.clientFromDTO(c));
        String details[] = odto.getShopCart().split(";");
        
        for (String detail : details){
            if ( detail != null && detail.length() > 0 ){
                String fields[] = detail.split(",");
                Marketable m = BookMapper.bookFromDTO(ibc.getByID(fields[0]));
                o.setDetail(m, Integer.valueOf(fields[3]));
            }          
        }
        o.orderConfirmation();
        o.setPackageDimensions("h:"+odto.getHeigth()+",w:"+odto.getWidth()+",d:"+odto.getDepht()+",W:"+odto.getWeigth()+",f:"+ (odto.isFragile()?"true":"false"));
        return o;
    }

    public static OrderDTO dtoFromOrder(Order o) throws ServiceException {
        double heigth = 0, width = 0, depth = 0;
        String dims[] = o.getSize().split(";");
        for (String dim : dims) {
            String[] keyValue = dim.split(":");
            switch (keyValue[0]) {
                case "heigth":
                    heigth = Double.valueOf(keyValue[1]);
                    break;
                case "width":
                    width = Double.valueOf(keyValue[1]);
                    break;
                case "depth":
                    depth = Double.valueOf(keyValue[1]);
                    break;
            }
        }
        
        String phone = "", address = "", email = "", name = "";
        String data[] = o.getClientData().split(";");
        for (String data1 : data) {
            String[] keyValue = data1.split(":");
            switch (keyValue[0]) {
                case "phone":
                    phone = keyValue[1];
                    break;
                case "address":
                    address = keyValue[1];
                    break;
                case "name":
                    name = keyValue[1];
                    break;
            }
        }

        return new OrderDTO(o.getIdent(),
                o.getDescription(),
                o.getStartDate(),
                o.getFinishDate(),
                o.getStatus(),
                o.getShopCart(),
                address,
                phone,
                email,
                String.valueOf(o.getClientId()),
                name,
                o.getPrice(),
                heigth,
                width,
                depth,
                o.getWeight(),
                o.isFragile()
        );
    }
}
