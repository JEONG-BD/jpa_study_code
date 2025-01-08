package com.example.chapter00;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {

         //엔티티 매니저 팩토리 생성
        /*EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin();
            logic(em);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        */
        Member member = createMember("memberA", "회원1");
        member.setUsername("회원명 변경");

        mergeMember(member);

        emf.close();
    }
    public static void logic(EntityManager em) {

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("Test");
        member.setAge(2);
        System.out.println("member = " + member);
        System.out.println("member = " + member);

        em.persist(member);

    }

    public static void persistType(){
        Member member = new Member();
        member.setId("id2");
        member.setUsername("회원1");

    }


    static Member createMember(String id, String userName){
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        Member member = new Member();
        member.setId(id);
        member.setUsername(userName);

        em1.persist(member);
        tx1.commit();

        em1.close();

        return member;
    }

    static void mergeMember(Member member){
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();

        tx2.begin();
        Member mergeMember = em2.merge(member);
        member = em2.merge(member);
        tx2.commit();

        //준영속 상태
        System.out.println("member =" + member.getUsername()) ;

        //영속 상태
        System.out.println("mergeMember =" + mergeMember.getUsername()) ;


        System.out.println("em2 contains2 member = " + em2.contains(member));
        System.out.println("em2 contains2 mergeMember = " + em2.contains(mergeMember));

        em2.close();
    }


}