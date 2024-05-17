/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw;

import donantes.DonanteDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author daniel
 */
public class P81DanielNavarro {

    public static void main(String[] args) throws SQLException {
       donantes.DonanteDAO daoDonante = new DonanteDAO();
       List<donantes.DonanteVO> nuevaLista = daoDonante.getAll();
       
       for(donantes.DonanteVO d : nuevaLista){
           System.out.println(d.toString());
       }
        
        
    }
}
