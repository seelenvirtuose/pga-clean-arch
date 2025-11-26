package net.mwgr.pga.arch.business.usecases.mgmt;

import net.mwgr.pga.arch.business.model.Book;
import net.mwgr.pga.arch.business.exceptions.BookNotFoundException;

public interface UpdateBookUseCase {
  void updateBook(long id, Book book) throws BookNotFoundException;
}
