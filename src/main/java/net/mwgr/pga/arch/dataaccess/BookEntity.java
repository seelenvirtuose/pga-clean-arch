package net.mwgr.pga.arch.dataaccess;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

  @Id @GeneratedValue private Long id;

  @Nonnull private String isbn;

  @Nonnull private String title;

  @Nonnull private String author;

  @Nonnull
  @Enumerated(EnumType.STRING)
  private BookStatus status;
}
