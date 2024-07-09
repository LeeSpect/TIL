package hellojpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("B") // DTYPE에 들어갈 값
public class Book extends Item{

    private String author;
    private String isbn;

}
