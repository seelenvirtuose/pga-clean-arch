package net.mwgr.pga.arch.business.usecases.mgmt;

import net.mwgr.pga.arch.business.exceptions.BookNotFoundException;

public interface RemoveBookUseCase {
  void removeBook(long id) throws BookNotFoundException;
}
