package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion c= new Conexion();
    Connection con;
    
    public List listar(){
        List<Persona>lista=new ArrayList<>();
        String sql = "select * from persona";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getString(1));
                p.setNom(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTel(rs.getString(4));
                lista.add(p);  
            } 
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Persona p){
        int r=0;
        String sql = "insert into persona (id, nombres, correo, telefono) values(?,?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getId());
            ps.setString(2, p.getNom());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getTel());
            r = ps.executeUpdate();
            if (r==1) {
                r=1;
            }else{
                r=0;
            }
        } catch (Exception e) {
        }
        return r;
    }
    public Persona listarId(String id){
        String sql = "select * from persona where id="+id;
        Persona p = new Persona();
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                p.setId(rs.getString(1));
                p.setNom(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTel(rs.getString(4));
            }
        } catch (Exception e) {
        }
        return p;
    }
    public int actualizar(Persona p){
        int r =0;
        String sql = "update persona set nombres=?, correo=?, telefono=? where id=?";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getTel());
            ps.setString(4, p.getId());
            r=ps.executeUpdate();
            if (r==1) {
                r=1;
            }else{
                r=0;
            }
            
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(String id){
        String sql = "delete from persona where id="+id;
        try {
            con=c.conectar();
            ps=con.prepareCall(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
