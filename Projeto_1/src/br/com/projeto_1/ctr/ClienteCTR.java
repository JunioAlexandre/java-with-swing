package br.com.projeto_1.ctr;
import java.sql.ResultSet;
import br.com.projeto_1.dto.ClienteDTO;
import br.com.projeto_1.dao.ClienteDAO;
import br.com.projeto_1.dao.ConexaoDAO;

public class ClienteCTR {
    ClienteDAO clienteDAO = new ClienteDAO();
    
    
    public ClienteCTR(){ 
     
      }
    
    public String inserirCliente(ClienteDTO clienteDTO){
        try{
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true0 or (false)
            if (clienteDAO.inserirCliente(clienteDTO)) {
                return "Cliente cadastrado com sucesso!!";
            }else {
                return "Cliente não cadastrado!!!";
            }
        }//Caso tenha algum erro no codgo acima é enviado uma mensagem no
        //console com o que esta acontecendo.
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Cliente não cadastrado";
        }
    }
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){
        //É criado um atributo do tipo ResultSet, pois este metodo receve o resultado de uma consulta
        ResultSet rs = null;
        
        //O atributo rs recebe a consulta realizada pelo metodo da classe DAO
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);
        
        return rs;
    }
    
    public String alterarCliente(ClienteDTO clienteDTO){
        try{
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true0 or (false)
            if (clienteDAO.alterarCliente(clienteDTO)) {
                return "Cliente alterado com sucesso!!";
            }else {
                return "Cliente não alterado!!!";
            }
        }//Caso tenha algum erro no codgo acima é enviado uma mensagem no
        //console com o que esta acontecendo.
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Cliente não alterado";
        }
    }
    
    public String excluirCliente(ClienteDTO clienteDTO){
        try{
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true0 or (false)
            if (clienteDAO.excluirCliente(clienteDTO)) {
                return "Cliente excluido com sucesso!!";
            }else {
                return "Cliente não excluido!!!";
            }
        }//Caso tenha algum erro no codgo acima é enviado uma mensagem no
        //console com o que esta acontecendo.
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Cliente não excluido";
        }
    }
    
    //Metodo utilizado para fechar o banco de dados
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
    
}
