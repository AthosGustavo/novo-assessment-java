package br.novo.Model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {

  private String nome;
  private String rg;
  private String cpf;
  private String endereco;
}
