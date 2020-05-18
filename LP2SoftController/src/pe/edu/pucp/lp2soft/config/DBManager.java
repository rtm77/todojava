package pe.edu.pucp.lp2soft.config;

public class DBManager {
    public static String urlMSSQL = "jdbc:sqlserver://" +
                "inf282mssql.cx9ws7aw0g5e.us-east-1.rds.amazonaws.com:1433;"+
                "databaseName=lp2;";
    public static String urlMySQL = "jdbc:mysql://"+
         "inf28220201.cx9ws7aw0g5e.us-east-1.rds.amazonaws.com"+
                  ":3306/lp2";
    public static String user = "admin";
    public static String password = "abcd1234";
}
