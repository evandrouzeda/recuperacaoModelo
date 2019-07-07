/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evandrouzeda.testes.junit;

import com.evandrouzeda.modelo.Tipo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author evandrouzeda
 */
public class TestePersistirTipo {
    
    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirTipo() {
    }
    
    @Before
    public void setUp(){
        emf = Persistence.createEntityManagerFactory("modeloPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown(){
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        Tipo obj = new Tipo();
        obj.setNome("informatica");
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
}
