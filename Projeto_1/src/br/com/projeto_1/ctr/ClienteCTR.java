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
}
