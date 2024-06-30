package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    //    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }


//    @Override
//    public String toString() {
//        return "Member{" +
//            "id=" + id +
//            ", username='" + username + '\'' +
//            ", team=" + team + // 여기서 team을 출력하면 무한 루프에 빠질 수 있다. team의 toString에서도 member의 toString을 호출하기 때문.
//            '}';
//    }
}
