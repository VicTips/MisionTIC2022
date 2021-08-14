package utp.misiontic2022.c2.p21.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p21.reto4.util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException {
        var response = new ArrayList<Requerimiento_2>();
        String consulta = "SELECT DISTINCT Constructora, Ciudad FROM Proyecto WHERE Ciudad LIKE 'B%' ORDER BY Ciudad;";
        try (var conn = JDBCUtilities.getConnection();
            var stmt = conn.prepareStatement(consulta);
            var rset = stmt.executeQuery();) {

                while(rset.next()){
                    var Requerimiento_2vo = new Requerimiento_2();
                    Requerimiento_2vo.setCiudad(rset.getString("Ciudad"));
                    Requerimiento_2vo.setConstructora(rset.getString("Constructora"));

                    response.add(Requerimiento_2vo);
                }
            }
        return response;
    }
}