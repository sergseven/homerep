/**
 * 
 */
package com.sv.data;

import java.io.Serializable;

/**
 * @author serg
 *
 */
public abstract class AbstractEntity<PK extends Serializable> {
  public abstract PK getPK();
  public abstract void setPK(PK pk);
  
}
