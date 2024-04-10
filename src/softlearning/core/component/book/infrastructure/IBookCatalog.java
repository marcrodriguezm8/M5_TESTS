package softlearning.core.component.book.infrastructure;

import softlearning.core.component.book.domain.services.BookDTO;

public interface IBookCatalog {
    public BookDTO getByID (String id);
    public int add (BookDTO dto);
}
