package utp.misiontic2022.c2.p21.reto4.vista;

import java.util.ArrayList;

import utp.misiontic2022.c2.p21.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_3;

public class VistaRequerimientos {

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static void requerimiento1(){
        try {
            var requerimiento1v = controlador.consultarRequerimiento1();
            for (Requerimiento_1 requerimiento_1 : requerimiento1v) {
                System.out.printf("%s %d %n", requerimiento_1.getNombreMaterial(), 
                requerimiento_1.getPrecioUnidad());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento2(){
        try {
            var requerimiento2v = controlador.consultarRequerimiento2();
            for (Requerimiento_2 requerimiento_2 : requerimiento2v) {
                System.out.printf("%s %s %n", requerimiento_2.getConstructora(), 
                requerimiento_2.getCiudad());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento3(){
        try {
            var requerimiento3v = controlador.consultarRequerimiento3();
            for (Requerimiento_3 requerimiento_3 : requerimiento3v) {
                System.out.printf("%s %s %s %d %d %n", requerimiento_3.getProveedor(), 
                requerimiento_3.getnombreMaterial(), 
                requerimiento_3.getImportado(), 
                requerimiento_3.getPrecioUnidad(), 
                requerimiento_3.getCantidad());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}