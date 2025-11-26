package net.mwgr.pga.arch.business.services;

import lombok.RequiredArgsConstructor;
import net.mwgr.pga.arch.business.exceptions.BookNotAvailableException;
import net.mwgr.pga.arch.business.exceptions.BookNotBorrowedException;
import net.mwgr.pga.arch.business.exceptions.BookNotFoundException;
import net.mwgr.pga.arch.business.model.Book;
import net.mwgr.pga.arch.business.ports.LoadBooksPort;
import net.mwgr.pga.arch.business.ports.PersistBookPort;
import net.mwgr.pga.arch.business.usecases.lib.BorrowBookUseCase;
import net.mwgr.pga.arch.business.usecases.lib.ReturnBookUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookLibService implements BorrowBookUseCase, ReturnBookUseCase {

  private final LoadBooksPort loadBooksPort;
  private final PersistBookPort persistBookPort;

  @Override
  public void borrowBook(long id) throws BookNotFoundException, BookNotAvailableException {
    var book = lookupBookOrThrow(id);
    book.borrowMe();
    persistBookPort.persistBook(book);
  }

  @Override
  public void returnBook(long id) throws BookNotFoundException, BookNotBorrowedException {
    var book = lookupBookOrThrow(id);
    book.returnMe();
    persistBookPort.persistBook(book);
  }

  private Book lookupBookOrThrow(long id) throws BookNotFoundException {
    return loadBooksPort.loadSingleBook(id).orElseThrow(BookNotFoundException::new);
  }
}
