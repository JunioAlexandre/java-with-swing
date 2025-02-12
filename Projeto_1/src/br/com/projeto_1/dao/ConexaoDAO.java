package br.com.projeto_1.dao;
import java.sql.*;

//Essa classe contém os métodos para abrie e fechar o banco de dados...
public class ConexaoDAO {
    
    //Criando um atributo do tipo Connection que servira para guardar a conexao
    // com o banco de dados
    public  static Connection con = null;
    
    
    //Método construtor de classe...
    public ConexaoDAO(){
        
        
    }
    
    //Método que abre a conexão com o banco de dados é do tipo static...
     public static void ConnectDB(){
         try{
             //Dados para conectar com o banco de dados Postgres
             String dsn = "projeto_1";
             String user = "postgres";
             String senha = "postdba";
             
             DriverManager.registerDriver(new org.postgresql.Driver());
             
             String url = "jdbc:postgresql://localhost:5432/" + dsn;
             
             con = DriverManager.getConnection(url, user, senha);
             
             con.setAutoCommit(false);
             if (con == null){
                 System.out.println("erro ao abrir o banco");
             }
             
         }//Fecha o try
         
         //Caso ocorra problemas para abrir o banco de dados é emitido a mensagem no console.
         catch (Exception e){
             System.out.println("Problema ao abrir a base de dados! " +
                     e.getMessage());
         }
    }
     
     public static void CloseDB(){
         try{
             con.close();
         }//Fecha o try.

         catch (Exception e){
             System.out.println("Problema ao fechar a base de dados! " +
                     e.getMessage());
         }//Fecha o catch
     }//Fecha o metodo CLoseDB
     
}//FEcha a classe ConexaoDAO