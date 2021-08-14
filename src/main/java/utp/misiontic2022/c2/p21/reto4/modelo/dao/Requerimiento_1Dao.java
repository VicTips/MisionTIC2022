package utp.misiontic2022.c2.p21.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p21.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException {
        var response = new ArrayList<Requerimiento_1>();
        String consulta = "SELECT Nombre_Material, Precio_Unidad FROM MaterialConstruccion mc WHERE Importado = 'Si' ORDER BY Precio_Unidad DESC;";
        try (var conn = JDBCUtilities.getConnection(); 
            var stmt = conn.prepareStatement(consulta); 
            var rset = stmt.executeQuery();) {
            
                while(rset.next()){
                    var Requerimiento_1vo = new Requerimiento_1();
                    Requerimiento_1vo.setNombreMaterial(rset.getString("Nombre_Material"));
                    Requerimiento_1vo.setPrecioUnidad(rset.getInt("Precio_Unidad"));

                    response.add(Requerimiento_1vo);
                }
            }
        return response;
    }
}