package net.mwgr.pga.arch.dataaccess;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.mwgr.pga.arch.business.model.Book;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

  @Id @GeneratedValue private Long id;

  @Nonnull private String isbn;

  @Nonnull private String title;

  @Nonnull private String author;

  @Nonnull
  @Enumerated(EnumType.STRING)
  private Book.Status status;

  public static BookEntity fromBook(Book book) {
    return BookEntity.builder()
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
