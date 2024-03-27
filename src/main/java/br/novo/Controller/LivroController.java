package br.novo.Controller;

import br.novo.Service.LivroService;
import spark.Request;
import spark.Response;
import spark.Route;

public class LivroController {


  private LivroService livroService;

  public LivroController(){
    livroService = new LivroService();
  }

  public Route cadastraLivroController = (Request req, Response res ) -> livroService.cadastraLivroService(req);
  public Route exibirLivroController = (Request req, Response res) -> livroService.exibirLivroService();

  public Route removerLivroController = (Request req, Response res) -> livroService.removeLivroService(req);
}
