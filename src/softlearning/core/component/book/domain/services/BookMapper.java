package softlearning.core.component.book.domain.services;

import softlearning.core.component.book.domain.model.Book;
import softlearning.core.component.shared.exceptions.BuildException;

public class BookMapper {
    public static Book bookFromDTO(BookDTO bookDTO) throws BuildException {       
        return Book.getInstance(
                bookDTO.getId(),
                bookDTO.getName(),
                bookDTO.getOwner(), 
                bookDTO.getType(),
                bookDTO.getDescription(),
                bookDTO.getResponsible(),
                bookDTO.getPrice(),
                bookDTO.getIsbn(),
                bookDTO.getEdition(),
                bookDTO.getPublicationDate(),
                bookDTO.getWeight(),
                bookDTO.getHeight(),
                bookDTO.getWidth(),
                bookDTO.getDepth(),
                bookDTO.getFragile()
        );
    }
    
    public static BookDTO dtoFromBook(Book book) {
        return new BookDTO(
                book.getName(),
                book.getOwner(),
                book.getDescription(),
                book.getType(),
                book.getResponsable(),
                book.getIsbn(),
                book.getReleaseDate(),
                book.getId(),
                book.getEdition(),
                book.getPrice(),
                book.getWeight(),
                book.getHeight(),
                book.getWidth(),
                book.getDepth(),
                book.getAvailability(),
                book.isFragile()
        );
    }
}
