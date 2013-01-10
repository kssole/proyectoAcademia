
package app.beans;

import app.sql.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class BeanLogin {
    
    private String usuario;
    private String pass;
    private String tipoUsuario;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public String login() throws SQLException{
        if(loginAccion()){
            //crear sesion 
            return "correcto";
        }else{
            FacesContext.getCurrentInstance().addMessage("form1",new FacesMessage("Credenciales Incorrectas"));
            return "incorrecto";
        }  
    }
    
    private boolean loginAccion() throws SQLException{
        conexion cone = new  conexion();
        Statement Sentencias = null;
        ResultSet tabla = null;
        Sentencias = cone.getConnection().createStatement();
        tabla = Sentencias.executeQuery("select * from estudiantes where user='"+usuario+"'and contra='"+pass+"'");
        while(tabla.next()){
             tipoUsuario = tabla.getString("id_usuario");
             return true;
        }
        return false;
    }
    
    public String cerrarSesion(){
      HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
      session.removeAttribute("LoginBean");
      return "cerrar";
    }
}
