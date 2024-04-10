package softlearning.core.component.client.infrastructure;

import softlearning.core.component.client.domain.services.ClientDTO;

public interface IClientCatalog {
    public ClientDTO getByID (String id);
    public int add (ClientDTO dto);
}
