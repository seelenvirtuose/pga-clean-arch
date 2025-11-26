package net.mwgr.pga.arch.presentation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.mwgr.pga.arch.business.usecases.lib.BorrowBookUseCase;
import net.mwgr.pga.arch.business.usecases.lib.ReturnBookUseCase;
import net.mwgr.pga.arch.business.usecases.mgmt.ListBooksUseCase;
import net.mwgr.pga.arch.business.usecases.mgmt.RegisterBookUseCase;
import net.mwgr.pga.arch.business.usecases.mgmt.RemoveBookUseCase;
import net.mwgr.pga.arch.business.usecases.mgmt.UpdateBookUseCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final ListBooksUseCase listBooksUseCase;
  private final RegisterBookUseCase registerBookUseCase;
  private final UpdateBookUseCase updateBookUseCase;
  private final RemoveBookUseCase removeBookUseCase;

  private final BorrowBookUseCase borrowBookUseCase;
  private final ReturnBookUseCase returnBookUseCase;

  @GetMapping
  public List<BookResource> listAllBooks() {
    return listBooksUseCase.listAllBooks().stream().map(BookResource::fromBook).toList();
  }

  @PostMapping
  public long create(@RequestBody BookResource resource) {
    return registerBookUseCase.registerBook(resource.toBook());
  }

  @GetMapping("/{id}")
  public BookResource read(@PathVariable long id) {
    return BookResource.fromBook(listBooksUseCase.listSingleBook(id));
  }

  @PutMapping("/{id}")
  public void update(@PathVariable long id, @RequestBody BookResource resource) {
    updateBookUseCase.updateBook(id, resource.toBook());
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable long id) {
    removeBookUseCase.removeBook(id);
  }

  @PostMapping("/{id}/borrow")
  public void borrowBook(@PathVariable long id) {
    borrowBookUseCase.borrowBook(id);
  }

  @PostMapping("/{id}/return")
  public void returnBook(@PathVariable long id) {
    returnBookUseCase.returnBook(id);
  }
}
