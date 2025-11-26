package net.mwgr.pga.arch.dataaccess;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import net.mwgr.pga.arch.business.model.Book;
import net.mwgr.pga.arch.business.ports.DeleteBookPort;
import net.mwgr.pga.arch.business.ports.LoadBooksPort;
import net.mwgr.pga.arch.business.ports.PersistBookPort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDbAdapter implements LoadBooksPort, PersistBookPort, DeleteBookPort {

  private final BookRepository bookRepository;

  @Override
  public List<Book> loadAllBooks() {
    return bookRepository.findAll().stream().map(BookEntity::toBook).toList();
  }

  @Override
  public Optional<Book> loadSingleBook(long id) {
    return bookRepository.findById(id).map(BookEntity::toBook);
  }

  @Override
  public Book persistBook(Book book) {
    return bookRepository.save(BookEntity.fromBook(book)).toBook();
  }

  @Override
  public void deleteBook(long id) {
    bookRepository.deleteById(id);
  }
}
