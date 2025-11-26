package net.mwgr.pga.arch.business.ports;

import java.util.List;
import java.util.Optional;
import lombok.Builder;
import net.mwgr.pga.arch.business.model.BookStatus;

public interface LoadBookPort {

  List<LoadBookData> loadAllBooks();

  Optional<LoadBookData> loadSingleBook(long id);

  @Builder
  record LoadBookData(Long id, String isbn, String title, String author, BookStatus status) {}
}
