package Erabilgarriak;

import java.sql.*;

public class konexioa {
    public Connection hasi() {
        Connection conexioa = null;
        try {
            conexioa = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mendiak", "root", "elorrieta");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexioa;
    }
    
    public void itxi(Connection conexioa) {
        try {
            if (conexioa != null && !conexioa.isClosed()) {
                conexioa.close();
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
    
    public Mendiak mendiaLoadbd(Connection conexioa, Mendiak mendiak) { 
		 try {
	           Statement s1 = conexioa.createStatement();
	           String sql = "select * from montes";
	           ResultSet lerroak = s1.executeQuery(sql);
	           lerroak = s1.executeQuery(sql);
	           while (lerroak.next()) {
	        	   Monte monte = new Monte();
	               monte.setAltura(lerroak.getInt("Altura"));
	               monte.setCoordenadas(lerroak.getString("Coordenadas"));
	               monte.setMacizo(lerroak.getString("Cordillera"));
	               monte.setNombre(lerroak.getString("Nombre"));
	               monte.setProvincia(lerroak.getString("Provincia"));
	               monte.setRuta(lerroak.getString("Ruta"));
	               mendiak.sartuMendia(monte);
	           }
	       } catch (Exception sqe) {
	           sqe.printStackTrace();
	       }
		 return mendiak;
	}
    
    public void gorde(Connection conexioa, Mendiak mendiak) {
        try {
            Statement s1 = conexioa.createStatement();
            String sqlSafeUpdates = "SET SQL_SAFE_UPDATES = 0";
            s1.executeUpdate(sqlSafeUpdates);
            String sqlDelete = "DELETE FROM montes";
            s1.executeUpdate(sqlDelete);

            for (int i = 0; i < mendiak.getDaude(); i++) {
                String sqlInsert = "INSERT INTO montes VALUES('" +
                        mendiak.getMendiak()[i].getNombre() + "', '" +
                        mendiak.getMendiak()[i].getProvincia() + "', " +
                        mendiak.getMendiak()[i].getAltura() + ", '" +
                        escapeString(mendiak.getMendiak()[i].getCoordenadas()) + "', '" +
                        mendiak.getMendiak()[i].getMacizo() + "', '" +
                        mendiak.getMendiak()[i].getRuta() + "')";
                s1.executeUpdate(sqlInsert);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String escapeString(String value) {
    	return value != null ? value.replace("'", "''") : "";
    }
}