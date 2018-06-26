package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.Common;
import model.User;


public class UserDao {

    /**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public User findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, Common.convertMD5(password));
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }





    public User findByLoginInfo1(String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            int idData = rs.getInt("id");
            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            Date birthdateData = rs.getDate("birth_date");
            String passwordData = rs.getString("password");
            String create_dateData = rs.getString("create_date");
            String update_dateData = rs.getString("update_date");
            return new User(idData,loginIdData, nameData,birthdateData,passwordData,create_dateData,update_dateData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user where login_id <> 'admin'";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

    public List<User> findSearch(String loginIdP , String nameP , String dateP , String dateQ) {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user where login_id <> 'admin'";

            if(!loginIdP.equals("")) {
            	sql = sql +  " and login_id = '" + loginIdP + "'";
            }

            if(!nameP.equals("")) {
            	sql += " and name like " + "'%"+ nameP + "%'";
            }

            if(!dateP.equals("")) {
            	sql += " and birth_date >= '" + dateP + "'";
            }
            if(!dateQ.equals("")) {
                	sql += " and birth_date <= '" + dateQ + "'";
            }

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

    public boolean userCreate(String loginId,String name,String birthDate,String password) {
    	 Connection conn = null;
         try {
             // データベースへ接続
             conn = DBManager.getConnection();

             // SELECT文を準備
             String sql = "insert into user(login_id,name,birth_date,password,create_date,update_date) values (?,?,?,?,now(),now())";

              // SELECTを実行し、結果表を取得
             PreparedStatement pStmt = conn.prepareStatement(sql);
             pStmt.setString(1, loginId);
             pStmt.setString(2, name);
             pStmt.setString(3, birthDate);
             pStmt.setString(4, Common.convertMD5(password));


             pStmt.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         } finally {
             // データベース切断
             if (conn != null) {
                 try {
                     conn.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
        }

 return true;
 }
    public boolean userUpdate(String id , String password , String name , String birthDate) {
   	 Connection conn = null;
     try {
         // データベースへ接続
         conn = DBManager.getConnection();

         // SELECT文を準備
         String sql = "update user set name = ? , birth_date = ? , password = ? , update_date = now() where id = ?";

          // SELECTを実行し、結果表を取得
         PreparedStatement pStmt = conn.prepareStatement(sql);
         pStmt.setString(1, name);
         pStmt.setString(2, birthDate);
         pStmt.setString(3, Common.convertMD5(password));
         pStmt.setString(4, id);


         pStmt.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
         return false;
     } finally {
         // データベース切断
         if (conn != null) {
             try {
                 conn.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }

    }

return true;
}


    public boolean userDelete(String id) {


		Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "delete from user where id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);


            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
      return true;
      }



    }





