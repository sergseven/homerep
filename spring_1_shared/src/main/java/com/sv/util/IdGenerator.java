/**
 * 
 */
package com.sv.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author serg
 *
 */
public class IdGenerator implements IdentifierGenerator {

  @Override
  public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
    Connection con = session.connection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String id = null;
    try{
      ps = con.prepareStatement("select nextval('Auto_id_seq');");
      rs = ps.executeQuery();
      
      if(rs.next()){
        int seqValue = rs.getInt(1);
        id = "A"+StringUtils.leftPad(""+seqValue, 5, '0');
      }
    } catch(Exception e){
      throw new HibernateException("Unable to generate id "+e.getMessage(), e);
    }
    return id;
  }

}
