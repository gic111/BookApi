package org.example.workshop.model;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;
}