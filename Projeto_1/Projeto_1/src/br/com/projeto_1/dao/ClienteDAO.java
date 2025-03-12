package br.com.projeto_1.dao;

import java.sql.*;
import br.com.projeto_1.dto.ClienteDTO;

public class ClienteDAO {


    public ClienteDAO() {
    }
    
    private ResultSet rs = null;
    
    private Statement stmt = null;
    
    public boolean inserirCliente (ClienteDTO clienteDTO){
        try{
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Insert into cliente (nome_cli, numero_cli, logradouro_cli, "
                    + "bairro_cli, cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli) values ( "
                    + "'" + clienteDTO.getNome_cli() + "', "
                    + clienteDTO.getNumero_cli()+ ", "
                    + "'" + clienteDTO.getLogradouro_cli()+"', "
                    + "'" + clienteDTO.getBairro_cli()+"', "
                    + "'" + clienteDTO.getCidade_cli()+"', "
                    + "'" + clienteDTO.getEstado_cli()+"', "
                    + "'" + clienteDTO.getCep_cli()+"', "
                    + "'" + clienteDTO.getCpf_cli()+"', "
                    + "'" + clienteDTO.getRg_cli()+"') ";
            
            //Executa o comando SQL no banco de dados.
            stmt.execute(comando.toUpperCase());
            
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            
            //Fecha o statement
            stmt.close();
            return true;
        }//Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }//Independente de dar erro ou nao ele vai fechar o banco de dados.
        finally{
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o metodo inserirCliente
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){
        try{
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            //Cria o Statement que é responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            
            switch (opcao){
                case 1:
                    comando = "Select c.* "+
                              "from cliente c "+
                              "where nome_cli like '" + clienteDTO.getNome_cli()+ "%'"+
                              "order by c.nome_cli";
                break;
                case 2:
                    comando = "Select c.* "+
                              "from cliente c " +
                              "where c.id_cli = " + clienteDTO.getId_cli();
                break;
                case 3:
                    comando = "Select c.id_cli, c.nome_cli "+
                              "from cliente c ";
                break;
            }
            //Executa o comando SQL no banco de dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }
        //Caso hé´ algum erro no codigo acima, é enviado uma msg no console com o que esté
         catch (Exception e){
             System.out.println(e.getMessage());
             return rs;
         }
    }
    
}//Fecha classe ClienteDAO
