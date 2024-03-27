package br.novo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente extends Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "livro_id", referencedColumnName = "id")
  private Livro livros;
}