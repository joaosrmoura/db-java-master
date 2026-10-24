import ORM.entitys.Usuario;
import ORM.tables.UsuarioTable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Object>  dados = new HashMap<>();
        ArrayList<String> campos = new ArrayList<>();
        while (true){
            System.out.println("Escolha uma opção\n1 - Criar Produto\n2 - Listar Produtos\n3 - Atualizar um Produto\n4 - Deletar um produto\n");
            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();

            try{
                switch(opcao){
                    case 1:
                        System.out.println("Opção " + opcao);

                        campos.add("nome");
                        campos.add("valor");
                        campos.add("categoria");


                        for (String campo : campos){
                            System.out.println("Defina o valor de " + campo);
                            if (!campo.equals("valor")){
                                dados.put(campo, scanner.next());
                            }else{
                                dados.put(campo, scanner.nextInt());
                            }
                        }

                        ProdutoTable.create(dados);
                        break;
                    case 2:
                        System.out.println("Opção " + opcao);
                        ResultSet resultado = ProdutoTable.find();
                        while(resultado.next()){
                            System.out.println("ID: " + resultado.getInt("id") + "| Nome: " + resultado.getString("nome") + "| Valor: " + resultado.getFloat("valor") + "| Categoria: " + resultado.getString("categoria"));
                        }
                        break;
                    case 3:
                        System.out.println("Opção " + opcao);
                        int id = scanner.nextInt();
                        campos.add("nome");
                        campos.add("valor");
                        campos.add("categoria");

                        for (String campo : campos){
                            if (!campo.equals("valor")){
                                dados.put(campo, scanner.next());
                            }else{
                                dados.put(campo, scanner.nextInt());
                            }
                        }

                        ProdutoTable.update(dados, id);
                        break;
                    case 4:
                        System.out.println("Opção " + opcao);
                        break;
                    default:
                        System.out.println("Digite um valor válido");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        HashMap<String, Object> novoUsuario = new HashMap<>();
        novoUsuario.put("nome", "Teste 123");
        novoUsuario.put("cpf", "123.456.789-10");
        novoUsuario.put("email", "teste@email.com");
        novoUsuario.put("telefone", "67 99999-9999");
        novoUsuario.put("data_nascimento", "2002-12-15");
        UsuarioTable.create(novoUsuario);

        ArrayList<Usuario> listaUsuarios = UsuarioTable.find();

        if (listaUsuarios != null){
            for (Usuario usuario : listaUsuarios){
                System.out.println("Usuario: " + usuario.nome);
            }
        }
    }
}
