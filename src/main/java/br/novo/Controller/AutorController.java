package br.novo.Controller;

import br.novo.Service.AutorService;
import spark.Request;
import spark.Response;
import spark.Route;

public class AutorController {

  private AutorService autorService;

  public AutorController(){
    autorService = new AutorService();
  }

  public Route cadastraAutorController = (Request req, Response res) -> autorService.cadastraAutorService(req);

  public Route cadastraLivroParaAutorExistenteController = (Request req, Response res) -> {
    return autorService.cadastraLivroParaAutorExistenteService(req);
  };
  public Route exibirAutorController = (Request req, Response res) -> autorService.exibirAutorService();

  public Route editarAutorController = (Request req, Response res) -> {
    String id = req.params(":id");
    return autorService.editarAutorService(id, req);
  };

  public Route removerAutorController = (Request req, Response res) -> autorService.removerAutorService(req);



}
