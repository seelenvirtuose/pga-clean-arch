package net.mwgr.pga.arch.presentation;

import lombok.Builder;
import lombok.Data;
import net.mwgr.pga.arch.business.model.Book;

@Data
@Builder
public class BookResource {

  private Long id;
  private String isbn;
  private String title;
  private String author;
  private Book.Status status;

  public static BookResource fromBook(Book book) {
    return BookResource.builder()
        .id(book.getId())
        .isbn(book.getIsbn())
        .title(book.getTitle())
        .author(book.getAuthor())
        .status(book.getStatus())
        .build();
  }

  public Book toBook() {
    return Book.builder().id(id).isbn(isbn).title(title).author(author).status(status).build();
  }
}
