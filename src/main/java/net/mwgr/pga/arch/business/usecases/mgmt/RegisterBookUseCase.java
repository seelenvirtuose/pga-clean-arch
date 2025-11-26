package net.mwgr.pga.arch.business.usecases.mgmt;

import net.mwgr.pga.arch.business.model.Book;

public interface RegisterBookUseCase {
  long registerBook(Book book);
}
