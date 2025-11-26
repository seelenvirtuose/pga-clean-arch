package net.mwgr.pga.arch.business.ports;

import java.util.List;
import java.util.Optional;
import net.mwgr.pga.arch.business.model.Book;

public interface LoadBooksPort {
  List<Book> loadAllBooks();

  Optional<Book> loadSingleBook(long id);
}
