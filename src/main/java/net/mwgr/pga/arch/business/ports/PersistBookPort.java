package net.mwgr.pga.arch.business.ports;

import net.mwgr.pga.arch.business.model.Book;

public interface PersistBookPort {
  Book persistBook(Book book);
}
