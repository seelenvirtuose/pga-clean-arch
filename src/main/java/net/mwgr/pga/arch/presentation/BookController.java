package net.mwgr.pga.arch.presentation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.mwgr.pga.arch.business.BookService;
import net.mwgr.pga.arch.dataaccess.BookEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  @GetMapping
  public List<BookResource> listAllBooks() {
    return bookService.listAllBooks().stream().map(BookController::resourceFromEntity).toList();
  }

  @PostMapping
  public long create(@RequestBody BookResource resource) {
    return bookService.create(resource);
  }

  @GetMapping("/{id}")
  public BookResource read(@PathVariable long id) {
    return resourceFromEntity(bookService.read(id));
  }

  @PutMapping("/{id}")
  public void update(@PathVariable long id, @RequestBody BookResource resource) {
    bookService.update(id, resource);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable long id) {
    bookService.delete(id);
  }

  @PostMapping("/{id}/borrow")
  public void borrowBook(@PathVariable long id) {
    bookService.borrowBook(id);
  }

  @PostMapping("/{id}/return")
  public void returnBook(@PathVariable long id) {
    bookService.returnBook(id);
  }

  private static BookResource resourceFromEntity(BookEntity entity) {
    return BookResource.builder()
        .id(entity.getId())
        .isbn(entity.getIsbn())
        .title(entity.getTitle())
        .author(entity.getAuthor())
        .status(entity.getStatus())
        .build();
  }
}
