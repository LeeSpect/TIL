package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "USER") // 테이블명을 지정하고 싶을 때
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
//@TableGenerator(
//    name = "MEMBER_SEQ_GENERATOR",
//    table = "MY_SEQUENCES",
//    pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {

    // 직접 할당은 @Id만 사용
    // 자동 생성은 @GeneratedValue 사용
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY는 DB에 위임하는 방식
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator") // SEQUENCE는 DB 시퀀스를 사용하는 방식
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR") // TABLE은 테이블을 사용하는 방식
    private Long id;

    @Column(name = "name", nullable = false) // 컬럼명을 지정하고 싶을 때
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) // EnumType.ORDINAL은 숫자로 저장되므로 꼭 STRING으로 지정
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // 날짜와 시간을 모두 저장
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate; // Java 8 이상에서 사용 가능
    private LocalDateTime testLocalDateTime; // Java 8 이상에서는 Temporal하지 않고, LocalDate와 LocalDateTime을 사용

    @Lob // CLOB, BLOB을 사용할 때
    private String description;

    public Member() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public RoleType getRoleType() { return roleType; }
    public void setRoleType(RoleType roleType) { this.roleType = roleType; }
    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }
    public Date getLastModifiedDate() { return lastModifiedDate; }
    public void setLastModifiedDate(Date lastModifiedDate) { this.lastModifiedDate = lastModifiedDate; }
    public LocalDate getTestLocalDate() { return testLocalDate; }
    public void setTestLocalDate(LocalDate testLocalDate) { this.testLocalDate = testLocalDate; }
    public LocalDateTime getTestLocalDateTime() { return testLocalDateTime; }
    public void setTestLocalDateTime(LocalDateTime testLocalDateTime) { this.testLocalDateTime = testLocalDateTime; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
