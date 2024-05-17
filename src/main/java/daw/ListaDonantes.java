package daw;

import donantes.DonanteDAO;
import donantes.DonanteVO;
import java.sql.SQLException;
import java.util.List;

public class ListaDonantes {

    private List<DonanteVO> listaDonantes;
    private donantes.DonanteDAO daoDonante = new DonanteDAO();

    public ListaDonantes() throws SQLException {
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
