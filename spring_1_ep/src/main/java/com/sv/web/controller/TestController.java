/**
 * 
 */
package com.sv.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sv.dao.client.ClientDao;
import com.sv.data.Auto;
import com.sv.data.Client;

/**
 * @author serg
 * 
 */
@Controller
public class TestController {
  
  private int visitorCount = 0;
  
//  public void setClientDao(ClientDao clientDaoc) {
//    this.clientDao = clientDaoc;
//  }

  @Autowired
  private ClientDao clientDao;
  
  @RequestMapping("/index.do")
  public String index(Model model) {
    model.addAttribute("visitorCount", visitorCount++);
    return "WEB-INF/jsp/index.jsp";
  }
  
  /** http://localhost:8080/spring_1_ep/client/loadByName/Вася 
   * @throws ServletException */
  @RequestMapping("/client/load")
  @Transactional(readOnly=true)
  public String cliens(Model model) throws ServletException{
    List<Client> cls = clientDao.findAll();
    
    model.addAttribute("clients", cls);
    
    return "/WEB-INF/jsp/client/clients.jsp";
  }
  
  /** http://localhost:8080/spring_1_ep/client/loadByName/Вася 
   * @throws ServletException */
  @RequestMapping("/client/loadByName/{name}")
  @Transactional(readOnly=true)
  public String clientByName(Model model, @PathVariable(value="name") String name) throws ServletException{
    Client cl = clientDao.findByName(name);
    
    if(cl == null)
      throw new ServletException("Client name="+name+" not found.");
    
    model.addAttribute("client", cl);
    model.addAttribute("autos", cl.getAutos());
    
    return "/WEB-INF/jsp/client/client.jsp";
  }
  
  /** http://localhost:8080/spring_1_ep/client/load/40288182480c206f01480c2070360000 
   * @throws ServletException */
  @RequestMapping("/client/load/{clientId}")
  @Transactional(readOnly=true)
  public String client(Model model, @PathVariable(value="clientId") String clientId) throws ServletException{
    Client cl = clientDao.findById(clientId);
    
    if(cl == null)
      throw new ServletException("Client id="+clientId+" not found.");
    
    model.addAttribute("client", cl);
    model.addAttribute("autos", cl.getAutos());
    
    return "/WEB-INF/jsp/client/client.jsp";
//    EntityManager mainDb = EMF.getEntityManagerFactory("mainDB").createEntityManager();
//    
//    Client cl = mainDb.find(Client.class, clientId);
//    
//    model.addAttribute("client", cl);
//    model.addAttribute("autos", cl.getAutos());
//    
//    return "/WEB-INF/jsp/client/client.jsp";
//    Client defClient = clientDao.get(new Client(clientId));
//    
//    model.addAttribute("client", defClient);
//    
//    return "/WEB-INF/jsp/client/client.jsp";
  }
  
  /** http://localhost:8081/spring_1_ep/client/save?name=Юра&sex=M&address=Паторжинского, 1&phone=0567557788 
   * @throws Exception */
  @RequestMapping("/client/save")
  @Transactional
  public String save(Model model, 
      @RequestParam(value="clientId", required = false) String clientId,
      @RequestParam(value="name") String name,
      @RequestParam(value="birthdate", required = false) String birthdate,
      @RequestParam(value="sex") String sex,
      @RequestParam(value="phone", required = false) String phone,
      @RequestParam(value="address", required = false) String address) throws Exception{
    
    Client cl = new Client(clientId);
    cl.setName(name);
    cl.setBirthdate(new Date());
    cl.setSex(sex);
    cl.setPhone(phone);
    cl.setAddress(address);
    
    clientDao.save(cl);
    
//    Client cl = new Client(clientId);
//    cl.setName(name);
//    cl.setBirthdate(new Date());
//    cl.setSex(sex);
//    cl.setPhone(phone);
//    cl.setAddress(address);
//    
//    EntityManager mainDb = EMF.getEntityManagerFactory("mainDB").createEntityManager();
//    
//    try{
//      mainDb.getTransaction().begin();
//      
//      mainDb.persist(cl);
//      
//      mainDb.getTransaction().commit();
//    } catch(Exception e){
//      mainDb.getTransaction().rollback();
//      throw e;
//    } finally {
//      mainDb.close();
//    }
    
    model.addAttribute("client", cl);
    model.addAttribute("autos", cl.getAutos());
    return "/WEB-INF/jsp/client/client.jsp";
//    clientDao.save(cl);
//    
//    model.addAttribute("client", cl);
//    return "/WEB-INF/jsp/client/client.jsp";
  }
  
  /** http://localhost:8080/spring_1_ep/client/appendAuto?clientId=40288182480c206f01480c2070360000&markName=Daewoo&modelName=Espero
   * @throws Exception */
  @RequestMapping("/client/appendAuto")
  @Transactional
  public String appendAuto(Model model, 
      @RequestParam(value="clientId") String clientId,
      @RequestParam(value="markName") String markName,
      @RequestParam(value="modelName") String modelName
      ) throws Exception{
    
//    EntityManager mainDb = EMF.getEntityManagerFactory("mainDB").createEntityManager();
//    
//    Client cl = mainDb.find(Client.class, clientId);
//    
//    if(cl == null)
//      throw new ServletException("Client id="+clientId+" not found.");
//    
//    Auto auto = new Auto();
//    auto.setMarkName (markName);
//    auto.setModelName(modelName);
//    cl.getAutos().add(auto);
//    
//    try{
//      mainDb.getTransaction().begin();
//      
//      mainDb.persist(cl);
//      
//      mainDb.getTransaction().commit();
//    } catch(Exception e){
//      mainDb.getTransaction().rollback();
//      throw e;
//    } finally {
//      mainDb.close();
//    }
    
    
    
//    HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//    Client cl = clientDao.get(new Client(clientId));
//    if(cl == null)
//      throw new ServletException("Client id="+clientId+" not found.");
//    Auto auto = new Auto();
//    auto.setMarkName (markName);
//    auto.setModelName(modelName);
//    cl.getAutos().add(auto);
//    
//    clientDao.save(cl);
//    HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    
//    ModelAndView mv = new ModelAndView("/WEB-INF/jsp/client/client.jsp");
//    mv.a
    
    Client cl = clientDao.findById(clientId);
    if(cl == null)
      throw new ServletException("Client id="+clientId+" not found.");
    
    Auto auto = new Auto();
    auto.setMarkName (markName);
    auto.setModelName(modelName);
    cl.getAutos().add(auto);
    
    clientDao.save(cl);
    
    System.out.println("cl="+cl.getAutos().getClass().getName());
    
    model.addAttribute("client", cl);
    model.addAttribute("autos", cl.getAutos());
    return "/WEB-INF/jsp/client/client.jsp";
  }
  
}
