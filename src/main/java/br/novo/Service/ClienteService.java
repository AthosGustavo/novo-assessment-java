package br.novo.Service;

import br.novo.Model.Cliente;
import br.novo.Repository.ClienteRepository;
import org.json.JSONObject;
import spark.Request;

public class ClienteService {

  private ClienteRepository clienteRepository;

  public ClienteService() {
    this.clienteRepository = new ClienteRepository();
  }

  public String cadastraClienteService(Request req){
    String request = req.body();
    JSONObject responseObject = new JSONObject(request);

    Cliente cliente = new Cliente(responseObject.getJSONObject("Cliente").getString("nome"), responseObject.getJSONObject("Cliente").getString("rg"), responseObject.getJSONObject("Cliente").getString("cpf"), responseObject.getJSONObject("Cliente").getString("endereco"));
    clienteRepository.save(cliente);
    return "Cliente adicionado com sucesso!";
  }

  public String alugaLivroService(Request req){


    return "Cliente pegou livro emprestado";
  }
}
