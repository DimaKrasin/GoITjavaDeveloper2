package Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    //для создания и заполнения таблиц ЕДИНОЖДЫ вызовите метод initAndPopulateDB из psvm
    //для удаления всех таблиц ЕДИНОЖДЫ вызовите метод dropAllTables из psvm

    //Изменить эти строки в соответствии с Вашими данными
    private static String connectionURL = "jdbc:mysql://localhost/homework2";
    private static String user = "root";
    private static String pass = "root";
    private static String pathtToDropFile = "D:/Repository/GoITjavaDeveloper2/src/main/resources/dropAllTables.sql";
    private static String pathtToInitFile ="D:/Repository/GoITjavaDeveloper2/src/main/resources/initDataBase.sql";
    private static String pathtToPopulateFile = "D:/Repository/GoITjavaDeveloper2/src/main/resources/populateDataBase.sql";

    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = DriverManager.getConnection(connectionURL, user, pass);
        Statement statement=connection.createStatement();

        Main mainob = new Main();

        //для создание и заполнения таблиц в бд (запустить Единожды!)
        //mainob.initAndPopulateDB(mainob,statement);
        //для удаления таблиц
        //mainob.dropAllTables(mainob,statement);

        UI.startUi(statement,connection);
    }

    private void initAndPopulateDB(Main mainob,Statement statement)throws IOException {
        try {
            //Создать все таблицы
            mainob.executeSqlFile(pathtToInitFile,statement);
            //Заполнить все таблицы
            mainob.executeSqlFile(pathtToPopulateFile,statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dropAllTables(Main mainob,Statement statement){

        //Удалить все таблицы

        try {
            try {
                mainob.executeSqlFile(pathtToDropFile,statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void executeSqlFile(String path,Statement statement) throws IOException, SQLException {

        String sql = Utils.readFile(path);
        System.out.println(sql);

        String[] sqls = sql.split(";");
        for (int i = 0; i < sqls.length; i++) {
            statement.addBatch(sqls[i]);
        }
        statement.executeBatch();
    }


}
