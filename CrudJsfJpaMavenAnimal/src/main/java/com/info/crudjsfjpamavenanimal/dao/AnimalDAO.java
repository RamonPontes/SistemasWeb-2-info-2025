/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info.crudjsfjpamavenanimal.dao;

import com.info.crudjsfjpamavenanimal.model.Animal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AnimalDAO {
    @PersistenceContext(unitName = "AnimalPU")
    private EntityManager em;

    public void salvar(Animal animal) {
        if (animal.getId() == 0) {
            em.persist(animal);
        } else {
            em.merge(animal);
        }
    }

    public void excluir(Animal animal) {
        animal = localiza(animal.getId());
        em.remove(animal);
    }

    public Animal localiza(int id) {
        return em.find(Animal.class, id);
    }

    public List<Animal> pesquisa(String parcial) {
        Query q = em.createQuery("select l from Animal l where l.nome like :parcial");
        q.setParameter("parcial", "%" + parcial + "%");
    
        return q.getResultList();
    }
}