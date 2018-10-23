package com.yantianpeng.jdbcUtils;


import java.sql.*;

public class JdbcDemo {
    private static String StringDirve = "com.mysql.jdbc.Driver";//数据库驱动
    private static String Ulr = "jdbc:mysql://127.0.0.1:3306/yantianpeng1";//数据库地址
    private static String username = "root";//账户名
    private static String pwd = "Yantianpeng@123_";//密码
    private static Connection connection = null;

    public static void main(String[] args) {
        //InsertUserName();//插入一条数据；
        //InsertUserNameByPrepareStament();
       // QueryForByName();
        //UpdateById();
        //deleteById();
        vagueByName();
    }
    
    //模糊查询
    public static void vagueByName(){
      try{
          Statement statement = DriverMysql();
          String VagueSql ="select * from user2 where name like '%n%'";
          ResultSet resultSet = statement.executeQuery(VagueSql);
          while (resultSet.next()){
              System.out.print("id: "+resultSet.getInt("id"));
              System.out.print(" name: "+resultSet.getString("name"));
              System.out.print(" pwd:"+resultSet.getString("pwd"));
              System.out.println();
          }
      }catch (Exception ex){
          ex.printStackTrace();
      }
    }

    //删除数据
    public static void deleteById(){
       try{
           Statement statement = DriverMysql();
           String DeleteSql="delete from user2 where id = 3 ";
           int i = statement.executeUpdate(DeleteSql);
           connection.close();
       }catch (Exception ex){
           ex.printStackTrace();
       }
    }

    //更新数据
    public static void UpdateById(){
        try{
            Statement statement = DriverMysql();
            String updateById="update user2 set name=\"updatezhangsan\",pwd=\"update00022\" where id=1";
            statement.executeUpdate(updateById);
            connection.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //查询数据
    public static void QueryForByName() {
        try {
            Statement statement = DriverMysql();
            String querySql = "select * from user2";
            ResultSet resultSet = statement.executeQuery(querySql);
            while (resultSet.next()){
                System.out.print("id: "+resultSet.getInt("id"));
                System.out.print("  name: "+resultSet.getString("name"));
                System.out.println("  pwd: "+resultSet.getString("pwd"));
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    //使用PreparedStatement 新增数据
    public static void InsertUserNameByPrepareStament(){
      try{
          Statement statement = DriverMysql();
          String inserSqlByPrepareStament ="insert into user2 (id,name,pwd) values(?,?,?)";
          PreparedStatement preparedStatement = connection.prepareStatement(inserSqlByPrepareStament);
          preparedStatement.setInt(1,3);
          preparedStatement.setString(2,"lisi");
          preparedStatement.setString(3,"test0223446");
          int i = preparedStatement.executeUpdate();
          connection.close();
      }catch (Exception ex){
            ex.printStackTrace();
      }
    }

    //插入操作
    public static void InsertUserName() {
        try {
            Statement statement = DriverMysql();
            String insertSql = "insert into user2 values (2,\"zhanhgsan\",\"test123456\");";
            long l = statement.executeLargeUpdate(insertSql);
            System.out.println(l);
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private static Statement DriverMysql() {
        try {
            Class.forName(StringDirve);
            connection = DriverManager.getConnection(Ulr, username, pwd);
            return connection.createStatement();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

}
