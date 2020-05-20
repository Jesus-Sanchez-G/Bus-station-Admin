package bus.station.admin.GUI.FORMS;




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
       String sUrl = "jdbc:postgresql://"+"ec2-3-231-16-122.compute-1.amazonaws.com"+":"+"5432"+"/"+"ddim3smsjjr6ac";
       String sUsr = "jejixkfbvzumcp"; // Usuario
       String sPwd = "322c2164d70e3bcc810fe8f77e086210d7a14aa0e541e639402c53823e5d25f4";  // Contraseña
       
        try 
	{
            Class.forName ("org.postgresql.Driver");
              // La conexión
            cConexion = DriverManager.getConnection(sUrl, sUsr, sPwd);
            st = cConexion.createStatement();
            
           
          /*  String sql = "SELECT * FROM chofer";
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
            
            
            result.close();*/
            //st.close();
            
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }
          catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"No se encontro el driver");
        }

    }

public int consultaAdmin(String sql){
int rfc=0;
try{
     ResultSet result = st.executeQuery(sql);
           
           
            while (result.next()){
                 rfc = result.getInt("rfc");
                                
            }    
            
            
        result.close();
}catch(SQLException e){
    JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
}
return rfc;
}

public String[][] consultalist(String sql){
String [][]nombres=new String[100][2];
int i=0;
   try{
            ResultSet result = st.executeQuery(sql);
           
            while (result.next()){
                nombres[i][0] = result.getString("nombre");
                nombres[i][1]=""+result.getInt("rfc");
                i=i+1;
            }    
            
            
            result.close();
   }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
   
   return nombres;
         
}
public int[] consultaT(String sql){
int []numeros=new int[100];
int i=0;
   try{
            ResultSet result = st.executeQuery(sql);
           
            while (result.next()){
                numeros[i] = result.getInt("numero_terminal");
                i=i+1;
            }    
            
            
            result.close();
   }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
   
   return numeros;
         
}

public String[][] consultaC(String sql){
   int n=0;
    
   try{
    ResultSet result1 = st.executeQuery("select count(*) as c from chofer");
    while (result1.next()){
                n = result1.getInt("c");
                
            }
    result1.close();
   }catch(SQLException e2) {
            JOptionPane.showMessageDialog(null,"Error:" + e2.getMessage());
             
                
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
     

    String []nombres=new String[n];
    String consulta[][]= new String[n][2];
    int i=0;
   try{
            ResultSet result = st.executeQuery(sql);
           
            while (result.next()){
                nombres[i] = result.getString("nombre");
               consulta[i][0]=result.getString("nombre");
               consulta[i][1]=""+result.getInt("rfc");
                i=i+1;
            }    
            
            
            result.close();
            
                       
   }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
   
   return consulta;
}
public String[] consultaCid(String sql){
   int n=0;
    
   try{
    ResultSet result1 = st.executeQuery("select count(*) as c from chofer");
    while (result1.next()){
                n = result1.getInt("c");
                
            }
    result1.close();
   }catch(SQLException e2) {
            JOptionPane.showMessageDialog(null,"Error:" + e2.getMessage());
             
                
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
     

    String []ids=new String[n];
    int i=0;
   try{
            ResultSet result = st.executeQuery(sql);
           
            while (result.next()){
                ids[i] = ""+result.getInt("rfc");
                i=i+1;
            }    
            
            
            result.close();
   }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
   
   return ids;
}

public String[] consultaA(String sql){
int n=0;
    
   try{
    ResultSet result1 = st.executeQuery("select count(*) as c from autobus");
    while (result1.next()){
                n = result1.getInt("c");
                
            }
    result1.close();
   }catch(SQLException e2) {
            JOptionPane.showMessageDialog(null,"Error:" + e2.getMessage());
             
                
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
     

    String []placas=new String[n];
    int i=0;
   try{
            ResultSet result = st.executeQuery(sql);
           
            while (result.next()){
                placas[i] = result.getString("placas");
                i=i+1;
            }    
            
            
            result.close();
   }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
   
   return placas;

} 
public String[] consultaA2(String sql){
int n=0;
    
   try{
    ResultSet result1 = st.executeQuery("select count(*) as c from autobus");
    while (result1.next()){
                n = result1.getInt("c");
                
            }
    result1.close();
   }catch(SQLException e2) {
            JOptionPane.showMessageDialog(null,"Error:" + e2.getMessage());
             
                
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
     

    String []autobuces=new String[n];
    int i=0;
   try{
            ResultSet result = st.executeQuery(sql);
           
            while (result.next()){
                autobuces[i] = ""+result.getInt("numero_autobus");
                i=i+1;
            }    
            
            
            result.close();
   }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
   
   return autobuces;

} 
public String[] consultaDatosTerminal(String sql){
    String[] consulta=new String[6];
    try{
            ResultSet result = st.executeQuery(sql);
           
            while (result.next()){
                consulta[0]=""+result.getInt("numero_terminal");
                consulta[1] = result.getString("direccion");
                consulta[2] = ""+result.getInt("capacidad_autobuses");
                consulta[3] = ""+result.getLong("telefono");
                consulta[4] = ""+result.getInt("codigo_post");
                consulta[5]=""+result.getInt("rfc_superv");
                
            }    
            
            
            result.close();
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
          
    return consulta;
}

public String[] consultaDatos_chofer(String sql){

     String[] consulta=new String[5];
    try{
            ResultSet result = st.executeQuery(sql);
           
            while (result.next()){
                consulta[0]=""+result.getInt("rfc");
                consulta[1] = result.getString("nombre");
                consulta[2] = ""+result.getInt("edad");
                consulta[3] = ""+result.getString("direccion");
                consulta[4] = ""+result.getLong("telefono");
                
            }    
            
            
            result.close();
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
          
    return consulta;
    
}
public String[] consultaDatosAutobus(String sql){
     String[] consulta=new String[8];
    try{
            ResultSet result = st.executeQuery(sql);
           
            while (result.next()){
                consulta[0]=""+result.getString("placas");
                consulta[1] = result.getString("modelo");
                consulta[2] = ""+result.getInt("año");
                consulta[3] = ""+result.getString("marca");
                consulta[4] = ""+result.getInt("numero_autobus");
                consulta[5]=""+result.getInt("numero_serie");
                consulta[6]=""+result.getInt("numero_terminal");
                consulta[7]=""+result.getInt("rfc_chofer");
                
                
            }    
            
            
            result.close();
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
          
    return consulta;
    
}

public int numTerminalPorSupervisor(int rfc){
 int num_terminal=0;
    try{
            ResultSet result = st.executeQuery("select * from supervisor where rfc='"+rfc+"'");
           
            while (result.next()){
                   num_terminal=result.getInt("terminal_a_cargo");
                
                
            }    
            
            
            result.close();
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
        }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
    return num_terminal;
}
public String consulta_contraseña(String sql){
   String contraseña="";
    try{
            ResultSet result = st.executeQuery(sql);
            while (result.next()){
            contraseña=result.getString("contraseña");
            
            }
            
    }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
            
    }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
   return contraseña;
}

public void registrarSupervisor(int RFC, String nombre, int edad, String direccion ,long telefono, String correo,String contraseña,int terminal_a_cargo){

    try{
    st.executeUpdate("insert into supervisor values ('"+RFC+"','"+nombre+"','"+edad+"','"+direccion+"','"+telefono+"','"+correo+"','"+contraseña+"','"+terminal_a_cargo+"')");
    
    JOptionPane.showMessageDialog(null,"Registrado correctamente");    
    
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
}catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
        
    
}

public void registrarAdministrador(int RFC, String nombre, int edad, String direccion ,long telefono, String correo,String contraseña){

    try{
    st.executeUpdate("insert into administrador values ('"+RFC+"','"+nombre+"','"+edad+"','"+direccion+"','"+telefono+"','"+correo+"','"+contraseña+"')");
    
    JOptionPane.showMessageDialog(null,"Registrado correctamente");    
    
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
}catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
    
    
}

public void registrarTerminal(int num, String direc, int cap,long telefono,int cod_postal,int rfcsu){
    try{
         st.executeUpdate("insert into terminal values ('"+num+"','"+direc+"','"+cap+"','"+telefono+"','"+cod_postal+"',null)");
    JOptionPane.showMessageDialog(null,"Registrada correctamente"); 
    
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
     }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
}

public void registrarAutobus(String placas,String modelo,int año,String marca,int numero_autobus,int numero_serie,int numero_terminal,int rfc_chofer){
 try{
         st.executeUpdate("insert into autobus values ('"+placas+"','"+modelo+"','"+año+"','"+marca+"','"+numero_autobus+"','"+numero_serie+"','"+numero_terminal+"','"+rfc_chofer+"')");
    JOptionPane.showMessageDialog(null,"Registrado correctamente"); 
    
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
     }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 

}

public void registrarChofer(int rfc,String nombre, int edad,String direccion,long telefono,String placas){
try{
         st.executeUpdate("insert into chofer values ('"+rfc+"','"+nombre+"','"+edad+"','"+direccion+"','"+telefono+"',null)");
    JOptionPane.showMessageDialog(null,"Registrado correctamente"); 
    
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
     }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
}

public void eliminarChofer(int rfc){
try{
     st.executeUpdate("delete from chofer where rfc="+rfc);
    JOptionPane.showMessageDialog(null,"Borrado correctamente"); 
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
     }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
}

public void eliminarAutobus(String placas){
try{
     st.executeUpdate("delete from autobus where placas='"+placas+"'");
    JOptionPane.showMessageDialog(null,"Borrado correctamente"); 
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
     }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
}


public void modificarChofer(int rfc,String nombre,int edad,String direccion, long telefono){
try{
     st.executeUpdate("update chofer set nombre='"+nombre+"', edad='"+edad+"',direccion='"+direccion+"', telefono='"+telefono+"' where rfc='"+rfc+"'");
    JOptionPane.showMessageDialog(null,"Modificado correctamente"); 
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
     }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 

}

public void modificarAutobus(String placas,String modelo,int año,String marca,int numero,int num_serie,int rfc_chofer){
try{
     st.executeUpdate("update autobus set modelo='"+modelo+"',año='"+año+"', marca='"+marca+"',numero_autobus='"+numero+"',numero_serie='"+num_serie+"',rfc_chofer='"+rfc_chofer+"' where placas='"+placas+"'");
    JOptionPane.showMessageDialog(null,"Modificado correctamente"); 
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
     }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
}

public void modificarTerminal(int numero,String direccion,int capacidad,long telefono, int codigo_p){
try{
     st.executeUpdate("update terminal set direccion='"+direccion+"',capacidad_autobuses='"+capacidad+"', telefono='"+telefono+"',codigo_post='"+codigo_p+"' where numero_terminal='"+numero+"'");
    JOptionPane.showMessageDialog(null,"Modificado correctamente"); 
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,""+ex.getMessage());
        Logger.getLogger(ConexionPostgres.class.getName()).log(Level.SEVERE, null, ex);
   
     }catch(Exception s){
        JOptionPane.showMessageDialog(null,"Error:" + s.getMessage());
    }
 
}
public void cerrarconexion() throws SQLException{
    st.close();
    cConexion.close();
}

/*
public static void main(String args[]){

    ConexionPostgres c = new ConexionPostgres();
    c.Conectar();
    c.registrarSupervisor(1234, "Prueba", 20, "av4 tomatlan ver", 2731000, "@GMAIL.COM", "chucho10", 1);

}*/

}