/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prueba {
    
    public static void main(String[] arg) throws SQLException{
        String usuario = "tu";
        String pass = "tu";
        conexion cone = new  conexion();
        Statement Sentencias = null;
        ResultSet tabla = null;
        Sentencias = cone.getConnection().createStatement();
        tabla = Sentencias.executeQuery("select * from estudiantes where user='"+usuario+"'and contra='"+pass+"'");
        if(tabla.first()){
            System.out.println("si se encontro usuario");
        }else{
            System.out.println("no se encontro usuario");
        }
    }
    
}
