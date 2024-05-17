package daw;

import conexion.LeerFichero;
import donantes.DonanteDAO;
import donantes.DonanteVO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaDonantes {

    private List<DonanteVO> listaDonantes;
    private donantes.DonanteDAO daoDonante = new DonanteDAO();

    public ListaDonantes() throws SQLException {
        try {
            daoDonante.insertDonante(LeerFichero.leer("donantes.json"));
        } catch (IOException ex) {
            Logger.getLogger(ListaDonantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaDonantes= daoDonante.getAll();

    }

    public List<DonanteVO> getLista() {
        return listaDonantes;
    }

    public DonanteVO getDonante(int id) {

// Habría que controlar que si el id no es valido, hay excepción
        
        
        
        return listaDonantes.stream().filter(p-> p.equals(new DonanteVO(id, "", "", "", "", 0))).
                findFirst().get();
    }

}
