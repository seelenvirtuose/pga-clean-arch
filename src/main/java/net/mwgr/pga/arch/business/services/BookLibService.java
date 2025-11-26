package net.mwgr.pga.arch.business.services;

import lombok.RequiredArgsConstructor;
import net.mwgr.pga.arch.business.usecases.BorrowBookUseCase;
import net.mwgr.pga.arch.business.usecases.ReturnBookUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookLibraryService implements BorrowBookUseCase, ReturnBookUseCase {

  @Override
  public void borrowBook(long id) {}

  @Override
  public void returnBook(long id) {}
}
