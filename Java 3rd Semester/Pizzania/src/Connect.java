/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ public class Connect
/*    */ {
/*    */   public static Connection fungsiKoneksi()
/*    */     throws SQLException
/*    */   {
/*  9 */     Connection conn = null;
/* 10 */     String driver = "com.mysql.jdbc.Driver";
/* 11 */     String url = "jdbc:mysql://localhost:3306/pizzania";
/* 12 */     String USER = "root";
/* 13 */     String PASS = "";
/*    */     try
/*    */     {
/* 16 */       Class.forName(driver);
/* 17 */       conn = DriverManager.getConnection(url, USER, PASS);
/* 18 */       System.out.println("Koneksi Berhasil");
/*    */     } catch (ClassNotFoundException ex) {
/* 20 */       System.out.println("Koneksi Gagal");
/*    */     }
/*    */ 
/* 23 */     return conn;
/*    */   }
/*    */ }

/* Location:           D:\School binus\Semester 3\BAD\Assignment\Pizzania VER 5\PizzaniaPOS GROUP 2 BAD\dist\PizzaniaPOS_GROUP_2_BAD.jar
 * Qualified Name:     Connect
 * JD-Core Version:    0.6.2
 */