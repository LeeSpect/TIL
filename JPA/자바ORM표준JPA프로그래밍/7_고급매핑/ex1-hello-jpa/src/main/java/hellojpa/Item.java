package hellojpa;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) // JOINED: 각각 테이블로 만들어줌: 조인전략
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // SINGLE_TABLE: 한 테이블로 만들어줌: 단일 테이블 전략
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // TABLE_PER_CLASS: 각각 테이블로 만들어줌: 구현 클래스마다 테이블 전략
@DiscriminatorColumn // DTYPE이라는 컬럼이 생김, SINGLE_TABLE 전략에서는 없어도 자동으로 만들어짐
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
