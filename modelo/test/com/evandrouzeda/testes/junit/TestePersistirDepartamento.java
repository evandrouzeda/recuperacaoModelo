/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evandrouzeda.testes.junit;

import com.evandrouzeda.modelo.Departamento;
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
public class TestePersistirDepartamento {
    
    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirDepartamento() {
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
        Departamento obj = new Departamento();
        obj.setNome("TI");
        obj.setResponsavel("Evandro");
        obj.setTelefone("54999999999");
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
}
