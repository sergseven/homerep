package com.sv.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name="Auto")
public class Auto extends AbstractEntity<String> implements Comparable<Auto> {
  @Id
  @GeneratedValue(generator="autoIdGenerator") 
  @GenericGenerator(name="autoIdGenerator", strategy="com.sv.util.IdGenerator")
  @Column(name="aut_autoId", length=6)
  private String autoId;
  @Column(name="aut_markName", length=20)
  private String markName;
  @Column(name="aut_modelName", length=20)
  private String modelName;
  
  @ManyToMany
  private Set<Client> clients = new HashSet<Client>();
  
  @Override
  public String getPK() {
    return autoId;
  }
  
  @Override
  public void setPK(String pk) {
    autoId = pk;
  }

  public String getAutoId() {
    return autoId;
  }

  public void setAutoId(String autoId) {
    this.autoId = autoId;
  }

  public String getMarkName() {
    return markName;
  }

  public void setMarkName(String markName) {
    this.markName = markName;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public Set<Client> getClients() {
    return clients;
  }

  public void setClients(Set<Client> clients) {
    this.clients = clients;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((autoId == null) ? 0 : autoId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Auto other = (Auto) obj;
    if (autoId == null) {
      if (other.autoId != null)
        return false;
    } else if (!autoId.equals(other.autoId))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Auto [autoId=" + autoId + ", markName=" + markName + ", modelName="
        + modelName + "]";
  }

  @Override
  public int compareTo(Auto o) {
    if(getAutoId() == null)
      return 1;
    if(o == null || o.getAutoId() == null)
      return -1;
    if(equals(o))
      return 0;
    
    return getAutoId().compareToIgnoreCase(o.getAutoId()) ;
  }
  
}
