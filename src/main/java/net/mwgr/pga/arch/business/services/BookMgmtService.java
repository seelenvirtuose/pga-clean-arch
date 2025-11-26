package net.mwgr.pga.arch.business;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.mwgr.pga.arch.dataaccess.BookEntity;
import net.mwgr.pga.arch.dataaccess.BookRepository;
import net.mwgr.pga.arch.business.model.BookStatus;
import net.mwgr.pga.arch.presentation.BookResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  public List<BookEntity> listAllBooks() {
    return bookRepository.findAll();
  }

  public long create(BookResource resource) {
    return bookRepository.save(entityFromResource(resource)).getId();
  }

  public BookEntity read(long id) {
    return bookRepository.findById(id).orElseThrow();
  }

  public void update(long id, BookResource resource) {
    var entity = read(id);
    entity.setIsbn(resource.getIsbn());
    entity.setTitle(resource.getTitle());
    entity.setAuthor(resource.getAuthor());
  }

  public void delete(long id) {
    bookRepository.deleteById(id);
  }

  public void borrowBook(long id) {
    var entity = read(id);
    if (entity.getStatus() != BookStatus.AVAILABLE)
      throw new IllegalStateException("Book %d is not available".formatted(id));
    entity.setStatus(BookStatus.BORROWED);
  }

  public void returnBook(long id) {
    var entity = read(id);
    if (entity.getStatus() != BookStatus.BORROWED)
      throw new IllegalStateException("Book %d is not borrowed".formatted(id));
    entity.setStatus(BookStatus.AVAILABLE);
  }

  private static BookEntity entityFromResource(BookResource resource) {
    return BookEntity.builder()
        .isbn(resource.getIsbn())
        .title(resource.getTitle())
        .author(resource.getAuthor())
        .status(BookStatus.AVAILABLE)
        .build();
  }
}
