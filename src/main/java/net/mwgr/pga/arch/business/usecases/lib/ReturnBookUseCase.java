package net.mwgr.pga.arch.business.usecases.lib;

import net.mwgr.pga.arch.business.exceptions.BookNotBorrowedException;
import net.mwgr.pga.arch.business.exceptions.BookNotFoundException;

public interface ReturnBookUseCase {
  void returnBook(long id) throws BookNotFoundException, BookNotBorrowedException;
}
