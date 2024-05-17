/*
 * Clase que implementa la interface IPersona
 */
package donantes;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DonanteDAO implements IDonante {

    private Connection con = null;

    public DonanteDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<DonanteVO> getAll() throws SQLException {
        List<DonanteVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from Donantes");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                DonanteVO d = new DonanteVO();
                // Recogemos los datos de la persona, guardamos en un objeto
                d.setId_paciente(res.getInt("id_paciente"));
                d.setNombre(res.getString("nombre"));
                d.setFechaNacimiento(res.getString("fechaNacimiento"));
                d.setGrupoSanguineo(res.getString("grupoSanguineo"));
                d.setRh(res.getString("rh"));
                d.setNumeroDonaciones(res.getInt("numeroDonaciones"));

                //Añadimos el objeto a la lista
                lista.add(d);
            }
        }

        return lista;
    }

    @Override
    public DonanteVO findByPk(int pk) throws SQLException {

        ResultSet res = null;
        DonanteVO d = new DonanteVO();

        String sql = "select * from Donantes where id_paciente=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, pk);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                d.setId_paciente(res.getInt("id_paciente"));
                d.setNombre(res.getString("nombre"));
                d.setFechaNacimiento(res.getString("fechaNacimiento"));
                d.setGrupoSanguineo(res.getString("grupoSanguineo"));
                d.setRh(res.getString("rh"));
                d.setNumeroDonaciones(res.getInt("numeroDonaciones"));
                
                return d;
            }

            return null;
        }
    }

    @Override
    public int insertDonante(DonanteVO donante) throws SQLException {

        int numFilas = 0;
        String sql = "insert into Donantes values (?,?,?,?,?,?)";

        if (findByPk(donante.getId_paciente()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1,donante.getId_paciente());
                prest.setString(2, donante.getNombre());
                prest.setString(3, donante.getFechaNacimiento());
                prest.setString(4, donante.getGrupoSanguineo());
                prest.setString(5, donante.getRh());
                prest.setInt(6,donante.getNumeroDonaciones());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }

    }

    @Override
    public int insertDonante(List<DonanteVO> lista) throws SQLException {
        int numFilas = 0;

        for (DonanteVO tmp : lista) {
            numFilas += DonanteDAO.this.insertDonante(tmp);
        }

        return numFilas;
    }

    @Override
    public int deleteDonante() throws SQLException {

        String sql = "delete from Donantes";

        int nfilas = 0;

        // Preparamos el borrado de datos  mediante un Statement
        // No hay parámetros en la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecución de la sentencia
            nfilas = st.executeUpdate(sql);
        }

        // El borrado se realizó con éxito, devolvemos filas afectadas
        return nfilas;

    }

    @Override
    public int deleteDonante(DonanteVO donante) throws SQLException {
        int numFilas = 0;

        String sql = "delete from Donantes where id_paciente = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, donante.getId_paciente());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int updateDonante(int pk, DonanteVO donante) throws SQLException {

        int numFilas = 0;
        String sql = "update Donantes set nombre = ?, fechaNacimiento = ?, grupoSanguineo = ?, rh = ?,  numeroDonaciones = ?  where id_paciente=?";

        if (findByPk(pk) == null) {
            // La persona a actualizar no existe
            JOptionPane.showMessageDialog(null, "no encontrado");
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(6,donante.getId_paciente());
                prest.setString(1, donante.getNombre());
                prest.setString(2, donante.getFechaNacimiento());
                prest.setString(3, donante.getGrupoSanguineo());
                prest.setString(4, donante.getRh());
                prest.setInt(5,donante.getNumeroDonaciones());
                
                numFilas = prest.executeUpdate();
                
            }
            return numFilas;
        }
    }
}

