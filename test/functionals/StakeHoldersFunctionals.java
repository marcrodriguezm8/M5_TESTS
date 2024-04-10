package functionals;

import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.client.domain.model.Client;
import softlearning.core.component.client.domain.model.CompanyClient;
import softlearning.core.component.shared.stakeholders.Stakeholder;

public class StakeHoldersFunctionals {

    public static void showData(Stakeholder sh){
        System.out.println(sh.getIdent() + "\n" +
                sh.getName() + "\n" +
                sh.getContactData() + "\n" +
                sh.getDetails());
    }
    
    public static void main(String[] args) {        
        try {
            CompanyClient cc = CompanyClient.getInstance("Jose Meseguer", "12345456X", "22-02-2000", "carrer kalea 2", 
                    "666555444", "111222333444", "********", 1, false, "2023-02-10", "S.A.", "Libro 123 pag 83");
            showData(cc);
            //System.out.println(cc.getName()+";"+cc.getSince()+";"+cc.getCode()+";"+cc.getType());
        } catch (BuildException ex) {
            System.out.println("Error al crear el objeto Client: " + ex.getMessage());
        }        
        try {
            CompanyClient cc = CompanyClient.getInstance("J", "12345456X", "22-02-2000", "carrer kalea 2", 
                    "666555444", "111222333444", "********", 1, false, "2023-22-10", "", "Libro 123 pag 83");
            System.out.println(cc.getName()+";"+cc.getSince()+";"+cc.getCode()+";"+cc.getType());
        } catch (BuildException ex) {
            System.out.println("Error al crear el objeto CClient: " + ex.getMessage());
        }        
        try {
            Client c = Client.getInstance("Jose Meseguer", "12345456X", "22-02-2000", "carrer kalea 2", 
                    "666555444", "111222333444", "********", 1, false, "2023-02-10");
            showData(c);
            //System.out.println(c.getName() + ":" + c.getSince());
        } catch (BuildException ex) {
            System.out.println("Error al crear el objeto Client: " + ex.getMessage());
        }
        try {
            Client c = Client.getInstance("", "12345456X", "22-22-2000", "carrer kalea 2", 
                    "666555444", "111222333444", "********", 1, false, "2023-12-40");
            System.out.println(c.getName() + ":" + c.getSince());
        } catch (BuildException ex) {
            System.out.println("Error al crear el objeto Client: " + ex.getMessage());
        }
        try {
            Client c = Client.getInstance("", "d", "22-02-2000", "car", 
                    "666", "12", "*", 0, false, "2023-02-10");
            System.out.println(c.getName() + ":" + c.getSince());
        } catch (BuildException ex) {
            System.out.println("Error al crear el objeto Client: " + ex.getMessage());
        }        
    }
}
