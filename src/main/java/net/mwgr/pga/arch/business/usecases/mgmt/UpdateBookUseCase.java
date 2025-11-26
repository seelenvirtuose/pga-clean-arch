package net.mwgr.pga.arch.business.usecases;

public interface UpdateBookUseCase {
  void updateBook(long id, UpdateBookCommand book);

  record UpdateBookCommand(String isbn, String title, String author) {}
}
