/**
 * 
 */
package com.sv.dao.client;

import java.util.List;

import com.sv.data.Client;

/**
 * @author serg
 *
 */
public interface ClientDao {

  Client findById(String clientId);
  
  Client findByName(String name);

  void save(Client cl);

  List<Client> findAll();
  
}
