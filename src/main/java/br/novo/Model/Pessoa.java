package br.novo.Model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {

  public Pessoa(String nome, String rg, String cpf, String endereco) {
    this.nome = nome;
    this.rg = rg;
    this.cpf = cpf;
    this.endereco = endereco;
  }

  public Pessoa(){}

  private String nome;
  private String rg;
  private String cpf;
  private String endereco;

  @Override
  public String toString() {
    return "Pessoa{" +
      "nome='" + nome + '\'' +
      ", rg='" + rg + '\'' +
      ", cpf='" + cpf + '\'' +
      ", endereco='" + endereco + '\'' +
      '}';
  }
}
