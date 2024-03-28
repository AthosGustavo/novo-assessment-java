package br.novo.Repository;

import br.novo.Model.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClienteRepository {
  private Session session;
  public ClienteRepository(){
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    this.session = sessionFactory.openSession();
  }
  public void save(Cliente cliente){
    Transaction iniciaTransacao = null;

    try{
      iniciaTransacao = this.session.beginTransaction();
      this.session.save(cliente);
      iniciaTransacao.commit();
    }catch (Exception e) {
      if (iniciaTransacao != null) {
        iniciaTransacao.rollback();
      }
      System.out.println(e.getMessage());
      throw e;
    }
  }
}
