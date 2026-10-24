package ORM.entitys;

import ORM.tables.EnderecoTable;
import ORM.values.Cpf;
import ORM.values.Email;
import ORM.values.Telefone;

import java.util.Date;

public class Usuario {

    public Integer id;
    public String nome;
    public Cpf cpf;
    public Email email;
    public Telefone telefone;
    public Date data_nascimento;
    public Endereco endereco;

    public Usuario(){}
    public Usuario(Integer id, String nome, String cpf, String email, String telefone, Date data_nascimento, Integer endereco){
        this.nome = nome;
        this.cpf = new Cpf(cpf);
        this.email = new Email(email);
        this.telefone = new Telefone(telefone);
        this.data_nascimento = data_nascimento;
        this.id = id;
        this.endereco = EnderecoTable.get_id(endereco);
    }
}
