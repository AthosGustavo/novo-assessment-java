package br.novo.Service;

import br.novo.Model.Cliente;
import br.novo.Model.Livro;
import br.novo.Repository.ClienteRepository;
import br.novo.Repository.LivroRepository;
import org.json.JSONObject;
import spark.Request;

import java.util.List;

public class ClienteService {

  private ClienteRepository clienteRepository;
  private LivroRepository livroRepository;

  public ClienteService() {
    this.clienteRepository = new ClienteRepository();
    this.livroRepository = new LivroRepository();
  }

  public List<Cliente> exibirClienteService(){
    return clienteRepository.exibirCliente();
  }

  public String cadastraClienteService(Request req){
    String request = req.body();
    JSONObject responseObject = new JSONObject(request);

    Cliente cliente = new Cliente(responseObject.getJSONObject("Cliente").getString("nome"), responseObject.getJSONObject("Cliente").getString("rg"), responseObject.getJSONObject("Cliente").getString("cpf"), responseObject.getJSONObject("Cliente").getString("endereco"));
    clienteRepository.save(cliente);
    return "Cliente adicionado com sucesso!";
  }

  public String alugaLivroService(Request req){
    String request = req.body();
    JSONObject responseObject = new JSONObject(request);

    Long idCliente = responseObject.getLong("idCliente");
    Long idLivro = responseObject.getLong("idLivro");

    Cliente cliente = clienteRepository.getCliente(idCliente);
    Livro livro = livroRepository.getLivro(idLivro);

    if(cliente != null && livro != null){
      cliente.setLivros(livro);
      clienteRepository.editaCliente(cliente);
      return "Cliente pegou livro emprestado";
    } else {
      return "Cliente ou Livro não encontrado";
    }
  }
}
