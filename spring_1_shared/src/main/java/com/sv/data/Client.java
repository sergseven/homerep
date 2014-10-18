/**
 * 
 */
package com.sv.data;

import java.util.Date;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SortNatural;

/**
 * @author serg
 *
 */
@Entity
@Table( name="Client")
@NamedQueries(value = {
@NamedQuery(name = Client.NQN_FIND_BY_NAME, query = "select c from Client c where c.name = :name"),
@NamedQuery(name = Client.NQN_FIND_ALL    , query = "select c from Client c")
})
public class Client extends AbstractEntity<String>{
  public static final String NQN_FIND_BY_NAME = "Client.loadByName";
  public static final String NQN_FIND_ALL     = "Client.loadAll";
  
  @Id
  @GeneratedValue(generator="uuid")
  @GenericGenerator(name="uuid", strategy="uuid")
  @Column(name="cli_clientId", length=32)
  private String clientId;
  
  @Column(name="cli_name", length=20)
  private String name;
  
  @Column(name="cli_birthdate", length=20)
  private Date birthdate;
  
  /** M - муж., F - жен. */
  @Column(name="cli_sex", length=20)
  private String sex;
  
  @Column(name="cli_phone", length=20)
  private String phone;
  
  @Column(name="cli_address", length=20)
  private String address;
  
  @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
  @JoinTable(name="clientauto", 
  joinColumns=@JoinColumn(name="cli_clientId"), 
  inverseJoinColumns=@JoinColumn(name="aut_autoId"))
  @SortNatural
  private SortedSet<Auto> autos = new TreeSet<Auto>();
  
  public Client(){
  }
  public Client(String clientId){
    this.clientId = clientId;
  }

  
  public String getClientId() {
    return clientId;
  }
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Date getBirthdate() {
    return birthdate;
  }
  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }
  public String getSex() {
    return sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  
  @Override
  public String getPK() {
    return clientId;
  }
  @Override
  public void setPK(String pk) {
    clientId = pk;
  }
  public SortedSet<Auto> getAutos() {
    return autos;
  }
  public Set<Auto> getSortedAutos() {
    return new TreeSet<Auto>(autos);
  }
  public void setAutos(TreeSet<Auto> autos) {
    this.autos = autos;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
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
    Client other = (Client) obj;
    if (clientId == null) {
      if (other.clientId != null)
        return false;
    } else if (!clientId.equals(other.clientId))
      return false;
    return true;
  }
  
}
