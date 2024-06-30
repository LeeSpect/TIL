package hellojpa;

import jakarta.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // EntityManagerFactory는 애플리케이션 전체에서 딱 하나만 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml에 설정한 name
        EntityManager em = emf.createEntityManager(); // 고객이 요청할 때마다 생성, 쓰레드간에 공유 불가

        EntityTransaction tx = em.getTransaction(); // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.
        tx.begin(); // 트랜잭션 시작

        Member member = null;
        try {
            // 생성
//            member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member); // DB에 저장

            // 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            // 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            // 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA"); // em.persist 필요 없음

            // JPQL
            // 전체 회원 조회
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                .setFirstResult(5)
//                .setMaxResults(8) // 페이징 5번부터 8개
//                .getResultList(); // JPQL은 SQL과 다르게 테이블을 대상으로 쿼리하는 것이 아니라 엔티티 객체를 대상으로 쿼리한다.
//            for (Member m : result) {
//                System.out.println("member.name = " + m.getName());
//            }

            // 나이가 18살 이상인 회원을 모두 검색
//            List<Member> result2 = em.createQuery("select m from Member as m where m.age >= 18", Member.class)
//                .getResultList();



            tx.commit(); // 트랜잭션 커밋
        } catch (Exception e) {
            tx.rollback(); // 트랜잭션 롤백
        } finally {
            em.close(); // em은 꼭 닫아줘야 한다.
        }

        emf.close();
    }
}
