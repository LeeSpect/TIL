package hellojpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A") // DTYPE에 들어갈 값, 기본값은 클래스명
public class Album extends Item{

    private String artist;

}
