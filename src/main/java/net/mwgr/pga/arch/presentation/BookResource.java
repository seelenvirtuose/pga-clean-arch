package net.mwgr.pga.arch.presentation;

import lombok.Builder;
import lombok.Data;
import net.mwgr.pga.arch.dataaccess.BookStatus;

@Data
@Builder
public final class BookResource {
  private Long id;
  private String isbn;
  private String title;
  private String author;
  private BookStatus status;
}
