/**
 * 
 */
package com.sv.dao.client.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sv.dao.client.ClientDao;
import com.sv.data.Client;

/**
 * @author serg
 *
 */
@Repository(value="clientDao")
public class ClientDaoImpl implements ClientDao {
  
  @PersistenceContext/*(unitName="mainDBJTA")*/
  private EntityManager em;

  @Override
  @Transactional(readOnly=true)
  public Client findById(String clientId) {
    System.out.println("em_prop="+em.getProperties().entrySet());
    return em.find(Client.class, clientId);
  }

  @Override
  @Transactional(propagation=Propagation.MANDATORY)
  public void save(Client cl) {
    em.persist(cl);
    System.out.println("1 clId="+cl.getClientId());
    em.flush();
    System.out.println("2 clId="+cl.getClientId());
  }

  @Override
  @Transactional(readOnly=true)
  public Client findByName(String name) {
    List<Client> res = em.createNamedQuery(Client.NQN_FIND_BY_NAME, Client.class)
        .setParameter("name", name)
        .getResultList();
    return res.size() > 0 ? res.get(0) : null;
  }

  @Override
  public List<Client> findAll() {
    List<Client> res = em.createNamedQuery(Client.NQN_FIND_ALL, Client.class)
        .getResultList();
    return res;
  }
  
}
