package net.mwgr.pga.arch.business.model;

import lombok.Builder;
import lombok.Data;
import net.mwgr.pga.arch.business.exceptions.BookNotAvailableException;
import net.mwgr.pga.arch.business.exceptions.BookNotBorrowedException;

@Data
@Builder
public class Book {

  private Long id;
  private String isbn;
  private String title;
  private String author;
  private Status status;

  public void borrowMe() {
    if (status != Status.AVAILABLE) throw new BookNotAvailableException();
    status = Status.BORROWED;
  }

  public void returnMe() {
    if (status != Status.BORROWED) throw new BookNotBorrowedException();
    status = Status.AVAILABLE;
  }

  public enum Status {
    AVAILABLE,
    BORROWED
  }
}
