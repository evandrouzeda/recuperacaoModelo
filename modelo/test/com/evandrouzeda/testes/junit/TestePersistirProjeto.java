/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evandrouzeda.testes.junit;

import com.evandrouzeda.modelo.Departamento;
import com.evandrouzeda.modelo.Projeto;
import com.evandrouzeda.modelo.Tipo;
import java.util.Calendar;
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
public class TestePersistirProjeto {
    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirProjeto() {
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
        Projeto obj = new Projeto();
        Tipo t = em.find(Tipo.class, 1);
        Departamento d = em.find(Departamento.class, 1);
        obj.setNome("Pagamento com QrCode");
        obj.setDescricao("Criar uma forma de pagamento com QrCode");
        obj.setDataInicio(Calendar.getInstance());
        obj.setDataFim(Calendar.getInstance());
        obj.setValor(1000.00);
        obj.setAtivo(Boolean.TRUE);
        obj.setDepartamento(d);
        obj.setTipo(t);
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
}
