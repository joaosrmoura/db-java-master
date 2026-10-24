package ORM.entitys;

public class Produto {
    public Integer id;
    public String nome;
    public Float valor;
    public String categoria;

    public Produto(Integer id, String nome, Float valor, String categoria){
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
    }
}