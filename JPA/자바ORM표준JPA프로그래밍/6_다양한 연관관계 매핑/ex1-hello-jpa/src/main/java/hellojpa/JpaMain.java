package hellojpa;

import jakarta.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team); // 여기서 member에 team을 넣으면 DB에는 영향을 주지 않는다.

            //회원 저장
            Member member = new Member();
            member.setUsername("member1");
//            member.changeTeam(team); // member에서 team을 넣어야 DB에 영향을 준다.
            em.persist(member);

            team.addMember(member);

//            team.getMembers().add(member);
            // 원래대로라면, 위처럼 해도 DB에 반영이 되지 않기 때문에, 위 코드는 필요 없다고 느껴진다.
            // 하지만, 양방향 매핑을 할 때는, 양쪽에 값을 넣어주는 것이 좋다.
            // 1. 만약 em.flush()를 하지 않았을 때, team에 member를 넣어주지 않았다면, team에 member가 들어가지 않는다.
            // 2. em.flush()를 하지 않으면, 영속성 컨텍스트에는 처음 Team을 조회했을 때의 값만 올라가 있고,
            //    member에서 setTeam을 한 결과값은 영속성 컨텍스트에 있는 해당 Team 값에 들어가지 않기 때문이다.
            // 3. 따라서 team.getMembers().add(member);를 하지 않으면, 밑의 for문에서 members 값이 null이 나온다.
            // 4. 위 코드가 불편하다면, Member의 SetTeam메서드에서 Team을 넣어주는 코드를 작성하면 된다.

            em.flush();
            em.clear();
            
            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
