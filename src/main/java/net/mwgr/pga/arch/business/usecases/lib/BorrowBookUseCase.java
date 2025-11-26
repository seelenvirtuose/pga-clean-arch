package net.mwgr.pga.arch.business.usecases.lib;

import net.mwgr.pga.arch.business.exceptions.BookNotAvailableException;
import net.mwgr.pga.arch.business.exceptions.BookNotFoundException;

public interface BorrowBookUseCase {
  void borrowBook(long id) throws BookNotFoundException, BookNotAvailableException;
}
