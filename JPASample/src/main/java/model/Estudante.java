package model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//criando uma entidade da classe
@Table(name = "estudante")//criando tabela para armazenamento
public class Estudante implements Serializable {

    
    private final long serialVersionUI = 1L;
    @Id//anotacao de id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gerando auto incremento do id
    @Column(name = "id")//coluna do banco 
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "morada")
    private String morada;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                '}';
    }
}
