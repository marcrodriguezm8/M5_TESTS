package functionals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import static functionals.StakeHoldersFunctionals.showData;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.client.domain.model.Client;
import softlearning.core.component.client.domain.model.CompanyClient;
import softlearning.core.component.shared.stakeholders.Stakeholder;

public class ArrayFunctionals {

    public static void showData(Stakeholder sh) {
        System.out.println(sh.getIdent() + "\n"
                + sh.getName() + "\n"
                + sh.getContactData() + "\n"
                + sh.getDetails());
    }

    public static void main(String[] args) {
        /*
        ArrayList<String> ciutats = new ArrayList();
        ciutats.add("Barcelona");
        ciutats.add("Madrid");
        ciutats.add("Valencia");
        ciutats.add("Barcelona");
        ciutats.add("Barcelona");
        for (int i = 0; i < ciutats.size(); i++) { //accés seqüencial (però també podria ser aleatori) per posició
            System.out.println(ciutats.get(i));
        }
        for (String ciutat : ciutats) {
            System.out.println(ciutat);
        }
        Iterator<String> iter = ciutats.iterator();
        for (; iter.hasNext();) { // accés seqüencial amb un iterator
            System.out.println(iter.next());
        }
        
        Set<String> ciutats = new HashSet();
        ciutats.add("Barcelona");
        ciutats.add("Madrid");
        ciutats.add("Valencia");
        ciutats.add("Barcelona");
        ciutats.add("Barcelona");
        for (String ciutat : ciutats) {
            System.out.println(ciutat);
        }
         */
        try {
            Client c = Client.getInstance("Jose Meseguer", "12444456X", "22-02-2000", "carrer kalea 2",
                    "666555444", "111222333444", "********", 1, false, "2023-02-10");
            CompanyClient cc = CompanyClient.getInstance("Jose Meseguer", "12345456X", "22-02-2000", "carrer kalea 2",
                    "666555444", "111222333444", "********", 2, false, "2023-02-10", "S.A.", "Libro 123 pag 83");
            ArrayList<Stakeholder> shArray = new ArrayList();
            shArray.add(c);
            shArray.add(cc);
            for (Stakeholder sh : shArray){
                if (sh.getIdent().equals("12444456X")){
                    showData(sh);
                }                
            }           
            Map<String, Stakeholder> shMap = new TreeMap();
            shMap.put(c.getIdent(), c);
            shMap.put(cc.getIdent(), cc);
            showData (shMap.get("12444456X"));
        } catch (BuildException ex) {
            System.out.println("Error al crear el objeto Client: " + ex.getMessage());
        }

    }
}
