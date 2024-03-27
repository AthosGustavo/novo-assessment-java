package br.novo.Service;

import br.novo.Model.Autor;
import br.novo.Model.Livro;
import br.novo.Repository.LivroRepository;
import org.json.JSONObject;
import spark.Request;

import java.util.List;

public class LivroService {

  private LivroRepository livroRepository;
  public LivroService(){
    this.livroRepository = new LivroRepository();
  }
  public String cadastraLivroService(Request req){
    String request = req.body();
    JSONObject responseObject = new JSONObject(request);
    String nomeAutor = responseObject.getJSONObject("Autor").getString("nome");
    JSONObject livroJson = responseObject.getJSONObject("Livro");
    Autor autor = new Autor(nomeAutor);
    Livro livro = new Livro(livroJson.getString("nome"), livroJson.getString("genero"),livroJson.getInt("paginas"), autor);
    livroRepository.save(livro);
    return "Livro adicionado";
  }

  public List<Livro> exibirLivroService(){
    return livroRepository.exibirLivros();
  }

  public Long removeLivroService(Request req){
    Long idLivro = Long.valueOf(req.params(":idLivro"));
    livroRepository.removerLivro(idLivro);
    return idLivro;
  }


}
