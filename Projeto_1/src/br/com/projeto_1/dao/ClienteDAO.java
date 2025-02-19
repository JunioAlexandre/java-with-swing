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
    
}//Fecha classe ClienteDAO
