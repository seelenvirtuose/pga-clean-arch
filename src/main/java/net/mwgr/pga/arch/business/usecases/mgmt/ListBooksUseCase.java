package net.mwgr.pga.arch.business.usecases.mgmt;

import java.util.List;
import net.mwgr.pga.arch.business.model.Book;
import net.mwgr.pga.arch.business.exceptions.BookNotFoundException;

public interface ListBooksUseCase {
  List<Book> listAllBooks();

  Book listSingleBook(long id) throws BookNotFoundException;
}
