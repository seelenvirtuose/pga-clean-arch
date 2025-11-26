package net.mwgr.pga.arch.business.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.mwgr.pga.arch.business.exceptions.BookNotFoundException;
import net.mwgr.pga.arch.business.model.Book;
import net.mwgr.pga.arch.business.ports.DeleteBookPort;
import net.mwgr.pga.arch.business.ports.LoadBooksPort;
import net.mwgr.pga.arch.business.ports.PersistBookPort;
import net.mwgr.pga.arch.business.usecases.mgmt.ListBooksUseCase;
import net.mwgr.pga.arch.business.usecases.mgmt.RegisterBookUseCase;
import net.mwgr.pga.arch.business.usecases.mgmt.RemoveBookUseCase;
import net.mwgr.pga.arch.business.usecases.mgmt.UpdateBookUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookMgmtService
    implements ListBooksUseCase, RegisterBookUseCase, UpdateBookUseCase, RemoveBookUseCase {

  private final LoadBooksPort loadBooksPort;
  private final PersistBookPort persistBookPort;
  private final DeleteBookPort deleteBookPort;

  @Override
  public List<Book> listAllBooks() {
    return loadBooksPort.loadAllBooks();
  }

  @Override
  public long registerBook(Book book) {
    book.setId(null);
    book.setStatus(Book.Status.AVAILABLE);
    return persistBookPort.persistBook(book).getId();
  }

  @Override
  public Book listSingleBook(long id) throws BookNotFoundException {
    return lookupBookOrThrow(id);
  }

  @Override
  public void updateBook(long id, Book book) throws BookNotFoundException {
    var lookup = lookupBookOrThrow(id);
    book.setId(id);
    book.setStatus(lookup.getStatus());
    persistBookPort.persistBook(book);
  }

  @Override
  public void removeBook(long id) throws BookNotFoundException {
    lookupBookOrThrow(id);
    deleteBookPort.deleteBook(id);
  }

  private Book lookupBookOrThrow(long id) throws BookNotFoundException {
    return loadBooksPort.loadSingleBook(id).orElseThrow(BookNotFoundException::new);
  }
}
