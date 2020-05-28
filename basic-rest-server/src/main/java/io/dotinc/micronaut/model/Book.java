package io.dotinc.micronaut.model;

import io.micronaut.core.annotation.Introspected;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author vbulimac on 28/05/2020.
 */

@Introspected
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {

    int id;
    String isbn;
    String name;
    Double price;
    String author;

}
