package com.sv.dao;

import com.sv.data.AbstractEntity;

/**
 * @author serg
 *
 */
public class DefaultDao<T extends AbstractEntity<?>> {
//  @PersistenceUnit
//  EntityManagerFactory emf;
//  
//  public T get(T obj){
//    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//    
//    @SuppressWarnings("unchecked")
//    T res = (T)session.get(obj.getClass(), obj.getPK());
//    return res;
//  }
//  
//  public void save(T obj) {
//    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//    
//    session.saveOrUpdate(obj);
//  }  
}
