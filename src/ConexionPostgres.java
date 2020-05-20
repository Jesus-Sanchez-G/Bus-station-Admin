package bus.station.admin.GUI;




import java.sql.*;
import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionPostgres {
Connection cConexion;
java.sql.Statement st;
    
    
public void Conectar() {
       String sUrl = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"StationAdmin";
       String sUsr = "postgres"; // Usuario
       String sPwd = "chucho10";  // Contraseña
       
        try 
	{
            Class.forName ("org.postgresql.Driver");
              // La conexión
            cConexion = DriverManager.getConnection(sUrl, sUsr, sPwd);
            st = cConexion.createStatement();
           
            String sql = "SELECT * FROM chofer";
            ResultSet result = st.executeQuery(sql);
           
            while (result.next()){
                int rfc = result.getInt("rfc");
                String nombre = result.getString("nombre");
                int edad = result.getInt("edad");
                String direc = result.getString("direccion");
                int telefono=result.getInt("telefono");
                String placas=result.getString("placas_autobus");
                System.out.println("RFC: "+ rfc + " Nombre: "+nombre+" Edad: " + edad + " Dirección: " + direc + " Telefono: "+telefono+
                        " Placas: "+placas);
            }    
            
            
            result.close();
            //st.close();
            
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }
          catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"No se encontro el driver");
        }

    }


public void registrarSupervisor(int RFC, String nombre, int edad, String direccion ,long telefono, String correo,String contraseña,int terminal_a_cargo){

    try{
    st.executeUpdate("insert into supervisor values ('"+RFC+"','"+nombre+"','"+edad+"','"+direccion+"','"+telefono+"','"+correo+"','"+contraseña+"','"+terminal_a_cargo+"')");
    
    JOptionPane.showMessageDialog(null,"Registrado correctamente");    
    
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
}
        
    
}

public void registrarAdministrador(int RFC, String nombre, int edad, String direccion ,long telefono, String correo,String contraseña){

    try{
    st.executeUpdate("insert into administrador values ('"+RFC+"','"+nombre+"','"+edad+"','"+direccion+"','"+telefono+"','"+correo+"','"+contraseña+"')");
    
    JOptionPane.showMessageDialog(null,"Registrado correctamente");    
    
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
}
    
    
}

public int monto_total(String nombre,String fecha1,String fecha2){
 int monto_total=0; 
    try{
        
            CallableStatement cs = cConexion.prepareCall("{?=call monto_total(?,?,?)}");
            
            cs.registerOutParameter(1,Types.INTEGER);
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        
            java.util.Date utilDate = formatter.parse(fecha1); 
            long lnMilisegundos = utilDate.getTime();
            java.sql.Date sqlDate1 = new java.sql.Date(lnMilisegundos);
            
            java.util.Date utilDate2 = formatter.parse(fecha2); 
            long lnMilisegundos2 = utilDate2.getTime();
            java.sql.Date sqlDate2 = new java.sql.Date(lnMilisegundos2);
           
            System.out.println(""+sqlDate1);
            
            cs.setString(2,nombre);
            cs.setDate(3, sqlDate1);
            cs.setDate(4, sqlDate2);
           
            cs.execute();
            monto_total=cs.getInt(1);
            
            System.out.println("Monto total: " + monto_total);
           
            
    }catch(SQLException e) {
             JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
     }
    catch(Exception e){
         JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
    
    }
    return monto_total;
}

public String[] pagos_vencidos(){
String[] a={};
    try{
    st = cConexion.createStatement();
           
            String sql = "SELECT * FROM empleados_vencidos()";
            ResultSet result = st.executeQuery(sql);
            String Nombre="";
            String Numero="";
            int i=0;
              while (result.next()){
                 
                Nombre= result.getString("nombre");
                Numero = result.getString("numero");
               
                i=i+2;
              }
              
          String[] b = new String[i];
          a=b;
          result = st.executeQuery(sql);
          i=0;
          while (result.next()){
                 
                Nombre= result.getString("nombre");
                Numero = result.getString("numero");
                a[i]=Nombre;
                a[i+1]=Numero;
                i=i+2;
              }
          
  
              
    }catch(Exception e){
     JOptionPane.showMessageDialog(null,""+e.getMessage());
    }
    
    return a;

}
public void cerrarconexion() throws SQLException{
    st.close();
    cConexion.close();
}
public String[] trigger_saldo(String nocta, String fecha, String tipo_op, double cantidad){
    String[] a={};
    try {
          
        st.executeUpdate("insert into operacion values ('"+nocta+"','"+fecha+"','"+tipo_op+"','"+cantidad+"')");
        
         st = cConexion.createStatement();
           
            String sql = "SELECT * FROM operacion";
            ResultSet result = st.executeQuery(sql);
            String noc="";
            String fec="";
            String tipo="";
            String cant="";
            int i=0;
              while (result.next()){
                          
                i=i+4;
              }
              
          String[] b = new String[i];
          a=b;
          result = st.executeQuery(sql);
          i=0;
          while (result.next()){
                 
                noc= result.getString("nocta");
                fec =""+ result.getDate("fecha");
                tipo= result.getString("tipo_op");
                cant=""+result.getDouble("cantidad");
                a[i]=noc;
                a[i+1]=fec;
                a[i+2]=tipo;
                a[i+3]=cant;
                i=i+4;
              }
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
}

return a;
}

public String[] trigger_fecha(String numprestamo, Double montopago, String fechavencimiento, String fechapago){
    String a[]={};
    
    try {
        
        st.executeUpdate("update cuotas set fechapago= '"+fechapago+"' where montopago= '"+montopago+"' and fechavencimiento= '"+fechavencimiento+"'");    
        JOptionPane.showMessageDialog(null,""+st.getWarnings());
        st = cConexion.createStatement();
           
            String sql = "SELECT * FROM cuotas";
            ResultSet result = st.executeQuery(sql);
            String nombre="";
            String numcuot="";
            String montopag="";
            String fechavenci="";
            String fechapag="";
            int i=0;
              while (result.next()){
                          
                i=i+5;
              }
              
          String[] b = new String[i];
          a=b;
          result = st.executeQuery(sql);
          i=0;
          while (result.next()){
                 
                nombre= result.getString("nombreprestamo");
                numcuot =""+ result.getInt("numcuota");
                montopag=""+result.getDouble("montopago");
                fechavenci=""+result.getDate("fechavecimiento");
                fechapag=""+result.getDate("fechapago");
                a[i]=nombre;
                a[i+1]=numcuot;
                a[i+2]=montopag;
                a[i+3]=fechavenci;
                a[i+4]=fechapag;
                i=i+5;
              }
    } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch(Exception e)
    {
         JOptionPane.showMessageDialog(null,""+e.getMessage());
    }
 
 return a;   
}

public String[] clientes(String cvecli, String nombrecli,String dircli,String telcli,String empresacli,String telempresa){
String a[]={};
    try {
        st.executeUpdate("insert into cliente values ('"+cvecli+"','"+nombrecli+"','"+dircli+"','"+telcli+"','"+empresacli+"','"+telempresa+"')");
    st = cConexion.createStatement();
           
            String sql = "SELECT * FROM cliente";
            ResultSet result = st.executeQuery(sql);
            String cvecl="";
            String nombre="";
            String dir, telc, empr, telemp ="";
            
            int i=0;
              while (result.next()){
                          
                i=i+6;
              }
              
          String[] b = new String[i];
          a=b;
          result = st.executeQuery(sql);
          i=0;
          while (result.next()){
                cvecl=result.getString("cvecli");
                nombre=result.getString("nombrecli");
                dir=result.getString("dircli");
                telc=result.getString("telcli");
                empr= result.getString("empresacli");
                telemp =result.getString("telempresa");
                
                a[i]=cvecl;
                a[i+1]=nombre;
                a[i+2]=dir;
                a[i+3]=telc;
                a[i+4]=empr;
                a[i+5]=telemp;
                i=i+6;
              }
    
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    return a;
}


public static void main(String args[]){

    ConexionPostgres c = new ConexionPostgres();
    c.Conectar();
    c.registrarSupervisor(1234, "Prueba", 20, "av4 tomatlan ver", 2731000, "@GMAIL.COM", "chucho10", 1);

}

}