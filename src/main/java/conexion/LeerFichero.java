/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.fasterxml.jackson.databind.ObjectMapper;
import donantes.DonanteVO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class LeerFichero {
    
    public static  ArrayList<DonanteVO> leer(String ruta) throws IOException{
            ObjectMapper mapeador = new ObjectMapper();
        
        
        ArrayList<DonanteVO> catalogo = mapeador.readValue(new File(ruta),
                    mapeador.getTypeFactory().
                constructCollectionType
        (ArrayList.class, DonanteVO.class));
        
        ArrayList<DonanteVO> devolver = new ArrayList<DonanteVO>(catalogo.stream().limit(25).toList());
        
        
        
        return devolver;
        
        
    }
    
}
