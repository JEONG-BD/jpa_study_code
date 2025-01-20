package com.example.chapter04;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            tx.commit();

        }catch (Exception ex){

            ex.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        entityManagerFactory.close();
    }
}
