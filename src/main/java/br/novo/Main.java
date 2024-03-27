package br.novo;

import br.novo.Controller.AutorController;
import br.novo.Controller.LivroController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spark.Spark;

public class Main {
  public static void main(String[] args) {

    LivroController livroController = new LivroController();
    AutorController autorController = new AutorController();

    Spark.port(8080);
    //contratoAtivo sem valor

    //Livro
    Spark.post("/cadastro/livro", livroController.cadastraLivroController);
    Spark.get("/livro", livroController.exibirLivroController);
    Spark.delete("remove/livro/:idLivro", livroController.removerLivroController);
    //fazer um metodo para cadastrar um livro para um autor existente

    //Autor
    Spark.get("/autor", autorController.exibirAutorController);
    Spark.post("/cadastro/autor", autorController.cadastraAutorController);
    Spark.post("/cadastro/livro/autor", autorController.cadastraLivroParaAutorExistenteController);
    Spark.put("/editar/autor/:id", autorController.editarAutorController);
    Spark.delete("/excluir/autor/:id", autorController.removerAutorController);
    
    //Fazer um método para cadastrar autor sem livro


  }
}