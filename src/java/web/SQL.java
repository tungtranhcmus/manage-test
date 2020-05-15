package web;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class SQL {

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        String user ="nguyen";
        //insert(user,"f");
        if(KiemTraUser(user)){
            insertUser(user,"f");
            
        }else{
            
        }
        if(KiemDangNhap("tungtran","f")){
            System.out.println("Dang nhap thanh cong");
        }
        System.out.println(DemCauHoi());
        ArrayList<String>t= getAllUser();
        for (String t1 : t) {
            System.out.println(t1);
        }
        CauhoiTraloi pp = LayCauHoi(1);
        System.out.println(pp.Stt + pp.a +pp.b);
        
        
        CauhoiTraloi p = LayCauTraLoi(1,"tungtran");
        System.out.println(p.Stt + p.a +p.b);
        
        if(KiemTraCauTL("tungtran",1)){
             System.out.println("co");
        }
        
        inserCautraloi("tungtran",2,"khongbiet");
        p = LayCauTraLoi(2,"tungtran");
        System.out.println(p.Stt + p.a +p.b);
    }
    */
    /**
     *
     * @return
     */
    static public Connection getConnection() {
        Connection conn = null;
        try {
            
            Properties connectionProps = new Properties();
            connectionProps.put("user", "root");
            connectionProps.put("password", "");
            String ConnectionString ="jdbc:mysql://localhost:3306/db_cauhoi";
            conn = DriverManager.getConnection(ConnectionString,connectionProps);
        } catch (SQLException e) {
        }
        return conn;
    }
    
    static public ArrayList<String> getAllUser() {
        Connection conn = Conect.getConnection();
        String query = "SELECT DISTINCT Username FROM traloi";
        ResultSet rs = null;
        ArrayList<String>  lst;
        lst = new ArrayList<>();
        try {
            if (conn != null) {
                Statement st = conn.createStatement();
                rs = st.executeQuery(query);

                while (rs.next()) {
                    String lc = rs.getString("Username");
                    lst.add(lc);
                }
            }
        } catch (SQLException e) {
        } finally {
        if (conn != null) {
            try {
            rs.close();
            conn.close();
            } catch (SQLException ex) {
                
            }
            }
        }
        return lst;
    }
    
    static public int DemCauHoi() {
        Connection conn = Conect.getConnection();
        String query = "SELECT STTCauHoi FROM cauhoi";
        ResultSet rs = null;
        ArrayList<String>  lst;
        lst = new ArrayList<>();
        try {
            if (conn != null) {
                Statement st = conn.createStatement();
                rs = st.executeQuery(query);

                while (rs.next()) {
                    String lcs = rs.getString("STTCauHoi");
                    lst.add(lcs);
                }
            }
        } catch (SQLException e) {
        } finally {
        if (conn != null) {
            try {
            rs.close();
            conn.close();
            } catch (SQLException ex) {
                
            }
            }
        }
        return lst.size();
    }
    
    
    
    static public CauhoiTraloi LayCauHoi(int stt){
        CauhoiTraloi tl = new CauhoiTraloi();
        Connection conn = Conect.getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM cauhoi WHERE STTCauHoi =? ";
        ResultSet rs = null;
        try {
            if (conn != null) {
                
             ps = conn.prepareStatement(query); 
             ps.setString(1, String.valueOf(stt));

             rs = ps.executeQuery();
             if (rs.next()) {
              //Hiển thị dữ liệu vào các textfield
              String a = rs.getString("NoiDungCauHoi");
              String b = rs.getString("CauTraLoiChinhXac");
              tl = new CauhoiTraloi(stt,a,b);
              
             } 
            }
        } catch (SQLException e) {
        } finally {
        if (conn != null) {
            try {
            rs.close();
            conn.close();
            } catch (SQLException ex) {
                
            }
            }
        }
        return tl;
    }
    static public CauhoiTraloi LayCauTraLoi(int stt, String user){
        CauhoiTraloi tl = new CauhoiTraloi();
        Connection conn = Conect.getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM traloi WHERE STTCauHoi =? AND Username =? ";
        ResultSet rs = null;
        try {
            if (conn != null) {
                
             ps = conn.prepareStatement(query); 
             ps.setString(1, String.valueOf(stt));
             ps.setString(2, user);

             rs = ps.executeQuery();
             if (rs.next()) {
                String b = rs.getString("CauTraLoi");
                tl = new CauhoiTraloi(stt,user,b);
             }
            }
        } catch (SQLException e) {
        } finally {
        if (conn != null) {
            try {
            rs.close();
            conn.close();
            } catch (SQLException ex) {
                
            }
            }
        }
        return tl;
    }
    static public boolean KiemDangNhap(String user, String pass){
        int lc =0;
        Connection conn = Conect.getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM taikhoan WHERE Username =? AND Password =?";
        ResultSet rs = null;
        try {
            if (conn != null) {
                
             ps = conn.prepareStatement(query); 
             ps.setString(1, user);
             ps.setString(2, pass);

             rs = ps.executeQuery();
             if (rs.next()) {
                  lc=1;
             } 
            }
        } catch (SQLException e) {
        } finally {
        if (conn != null) {
            try {
            rs.close();
            conn.close();
            } catch (SQLException ex) {
                
            }
            }
        }
        return !(lc == 0);
    }
    static public boolean KiemTraCauTL(String user, int stt){
        int lc =0;
        Connection conn = Conect.getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM traloi WHERE Username =? AND STTCauHoi =? ";
        ResultSet rs = null;
        try {
            if (conn != null) {
                
             ps = conn.prepareStatement(query); 
             ps.setString(1, user);
             ps.setInt(2, stt);

             rs = ps.executeQuery();
             if (rs.next()) {
                  lc++;
             } 
            }
        } catch (SQLException e) {
        } finally {
        if (conn != null) {
            try {
            rs.close();
            conn.close();
            } catch (SQLException ex) {
                
            }
            }
        }
        return lc !=0;
    }
    static public boolean KiemTraUser(String user){
        int lc = 0;
        Connection conn = Conect.getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM taikhoan WHERE Username = ? ";
        ResultSet rs = null;
        try {
            if (conn != null) {
                
             ps = conn.prepareStatement(query); 
             ps.setString(1, user);

             rs = ps.executeQuery();
             if (rs.next()) {
                 rs.getString("Username");
                  lc++;
             } 
            }
        } catch (SQLException e) {} 
        finally {
            if (conn != null) {
                try {
                    rs.close();
                    conn.close();
                } 
                catch (SQLException ex) {}
            }
        }
        return lc == 0;
    }
    static public int insertUser(String a, String b) {
        Connection conn = Conect.getConnection();
        int result = 0;
        String query = "INSERT INTO taikhoan (Username,Password) values(?,?)";
        try {
            if (conn != null) {
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1, a);
                pre.setString(2, b);
                result = pre.executeUpdate();
                if (result > 0) {
                    return result;
                }
            }
        } catch (SQLException e) {
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                   
                }
            }       
        }
        return result;
    }
    static public int inserCautraloi(String a, int b, String c) {
        Connection conn = Conect.getConnection();
        int result = 0;
        String query = "INSERT INTO traloi (Username,STTCauHoi,CauTraLoi) values(?,?,?)";
        try {
            if (conn != null) {
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1, a);
                pre.setInt(2, b);
                pre.setString(3, c);
                result = pre.executeUpdate();
                if (result > 0) {
                    return result;
                }
            }
        } catch (SQLException e) {
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                   
                }
            }       
        }
        return result;
    }
    static public int updateCTL(String name, int stt, String ctl) {
        Connection conn = getConnection();
        int result = 0;
        String query = "UPDATE traloi SET CauTraLoi = ? WHERE STTCauHoi=? AND Username=?";
        try {
            if (conn != null) {
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1, ctl);
                pre.setInt(2, stt);
                pre.setString(3, name);
                
                result = pre.executeUpdate();
                if (result > 0) {
                    return result;
                }
            }
        } catch (SQLException e) {
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        }
        return result;
    }
    
}