/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donantes;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IDonante {
    
    // Método para obtener todos los registros de la tabla
    List<DonanteVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    DonanteVO findByPk(int pk) throws SQLException;
    
    // Método para insertar un registro
    int insertDonante (DonanteVO persona) throws SQLException;
    
    // Método para insertar varios registros
    int insertDonante (List<DonanteVO> lista) throws SQLException;
    
    // Método para borrar una persona
    int deleteDonante (DonanteVO p) throws SQLException;
    
    // Método para borrar toda la tabla
    int deleteDonante() throws SQLException;
    
    // Método para modificar una persona. Se modifica a la persona que tenga esa 'pk'
    // con los nuevos datos que traiga la persona 'nuevosDatos'
    int updateDonante (int pk, DonanteVO nuevosDatos) throws SQLException;
    
}

