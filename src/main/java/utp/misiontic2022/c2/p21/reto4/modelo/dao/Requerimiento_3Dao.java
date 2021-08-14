package utp.misiontic2022.c2.p21.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p21.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
        
        var response = new ArrayList<Requerimiento_3>();
        String consulta = "SELECT Proveedor, Nombre_Material, Importado, Precio_Unidad, SUM(Cantidad) AS 'Cantidad' FROM Compra INNER JOIN MaterialConstruccion ON MaterialConstruccion.ID_MaterialConstruccion = Compra.ID_MaterialConstruccion WHERE Importado = 'Si' AND Proveedor = 'Homecenter' GROUP BY Nombre_Material HAVING SUM(Cantidad) > 100 ORDER BY Nombre_Material, Proveedor;";
        try (var conn = JDBCUtilities.getConnection();
            var stmt = conn.prepareStatement(consulta);
            var rset = stmt.executeQuery();) {

                while(rset.next()){
                    var Requerimiento_3vo = new Requerimiento_3();
                    Requerimiento_3vo.setnombreMateriall(rset.getString("Nombre_Material"));
                    Requerimiento_3vo.setProveedor(rset.getString("Proveedor"));
                    Requerimiento_3vo.setImportado(rset.getString("Importado"));
                    Requerimiento_3vo.setCantidad(rset.getInt("Cantidad"));
                    Requerimiento_3vo.setPrecioUnidad(rset.getInt("Precio_Unidad"));

                    response.add(Requerimiento_3vo);
                }
            }
        return response;
    }
}