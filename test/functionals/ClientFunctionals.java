package functionals;

import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.client.domain.model.Client;
import softlearning.core.component.client.domain.model.CompanyClient;
import softlearning.core.component.client.domain.services.ClientDTO;
import softlearning.core.component.client.domain.services.ClientMapper;

public class ClientFunctionals {  
    public static void main(String[] args) {        
        try {
            
            System.out.println("CREACION DE UN DTO A PARTIR DE UN CLIENTE DEL DOMINIO");    
            Client c = Client.getInstance("Jose Meseguer", "12345456X", "22-02-2000", "carrer kalea 2", 
                    "666555444", "111222333444", "********", 1, false, "2023-02-10");
            ClientDTO cdto = ClientMapper.dtoFromClient(c);
            System.out.println("ID Cliente: " + cdto.getCode());        
            Client ccopy = ClientMapper.clientFromDTO(cdto);
            System.out.println("ID Cliente: " + ccopy.getCode());
        } catch (BuildException ex) {
            System.out.println("Error al crear el objeto Client: " + ex.getMessage());
        }
        try {
            System.out.println("CREACION DE UN CLIENT A PARTIR DE UN DTO NO VALIDADO DE LA VISTA"); 
            ClientDTO cdto = new ClientDTO("", "12345456X", "22-22-2000", "carrer kalea 2", 
                    "666555444", "111222333444", "********", 1, false, "2023-12-40");
            Client c = ClientMapper.clientFromDTO(cdto);            
        } catch (BuildException ex) {
            System.out.println("Error al crear el objeto Client: " + ex.getMessage());
        }        
    }
}
