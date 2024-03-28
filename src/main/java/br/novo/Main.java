package br.novo;

import br.novo.Controller.AutorController;
import br.novo.Controller.ClienteController;
import br.novo.Controller.LivroController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spark.Spark;

public class Main {
  public static void main(String[] args) {

    LivroController livroController = new LivroController();
    AutorController autorController = new AutorController();
    ClienteController clienteController = new ClienteController();

    Spark.port(8080);
    //contratoAtivo sem valor

    //Livro
    Spark.post("/cadastro/livro", livroController.cadastraLivroController);
    Spark.get("/livro", livroController.exibirLivroController);
    Spark.delete("remove/livro/:idLivro", livroController.removerLivroController);
    //fazer método update

    //Autor
    Spark.get("/autor", autorController.exibirAutorController);
    Spark.post("/cadastro/autor", autorController.cadastraAutorController);
    Spark.post("/cadastro/livro/autor", autorController.cadastraLivroParaAutorExistenteController);
    Spark.put("/editar/autor/:id", autorController.editarAutorController);
    Spark.delete("/excluir/autor/:id", autorController.removerAutorController);

    //Cliente
    Spark.get("/cliente", clienteController.exibirClienteController);
    Spark.post("/cadastro/cliente", clienteController.cadastraClienteController);
    Spark.post("/aluguel/livro", clienteController.alugaLivroController);
    
    //Fazer um método para cadastrar autor sem livro


  }
}