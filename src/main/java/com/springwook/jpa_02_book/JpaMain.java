package com.springwook.jpa_02_book;

import com.springwook.jpa_02_book.domain.Member;
import com.springwook.jpa_02_book.domain.Order;
import com.springwook.jpa_02_book.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("happy");

        EntityManager em = emf.createEntityManager();

        // 트랜잭션 안에서 작업해야 하기 때문에 트랜잭션을 시작해줘야함.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Order order = new Order();
//            order.addOrderItem(new OrderItem());
//            em.persist(order);

            /* 아래와 같은 방식으로 단 방향만으로도 설계 충분히 가능
            Order order = new Order();
            em.persist(order);
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
             */
            System.out.println("commit");
            tx.commit();

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();
    }
}
