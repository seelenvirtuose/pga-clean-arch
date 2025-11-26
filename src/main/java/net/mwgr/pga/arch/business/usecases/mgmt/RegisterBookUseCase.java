package net.mwgr.pga.arch.business.usecases;

import lombok.Builder;

public interface RegisterBookUseCase {
  long registerBook(RegisterBookCommand book);

  @Builder
  record RegisterBookCommand(String isbn, String title, String author) {}
}
