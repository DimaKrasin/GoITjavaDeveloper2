package Main;

import Main.CRUD.Create;
import Main.CRUD.Delete;
import Main.CRUD.Read;
import Main.CRUD.Update;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class UI {

    public static void startUi(Statement statement,Connection connection) throws SQLException,NullPointerException{

        String operationdone = "Следующя операция\n";

        Create createOb = new Create();
        Update updateOb = new Update();
        Delete deleteOb = new Delete();
        Read readOb = new Read();

        UI ui = new UI();

        System.out.println("Закрытие програмы по команде 'end'\n" +
                "для просмотра списка команд введите 'help' \n" +
                "Програма запушена и ждет команды :");

        while (true) {
            String input = Utils.consoleReader();
            switch (input) {
                case "help":
                    ui.helpInfo();
                    break;
                case "end":
                    statement.close();
                    connection.close();
                    System.out.println("Успешно закрыто");

                    System.exit(0);
                    break;
                case "C.developer":
                    createOb.createDeveloper(statement);
                    break;
                case "C.skill":
                    createOb.createSkill(statement);
                    break;
                case "C.project":
                    createOb.createProject(statement);
                    break;
                case "C.Customer":
                    createOb.createCustomer(statement);
                    break;
                case "C.Companie":
                    createOb.createCompany(statement);
                    break;
                case "R.developer":
                    readOb.readDeveloper(statement);
                    break;
                case "R.skill":
                    readOb.readSkill(statement);
                    break;
                case "R.project":
                    readOb.readProject(statement);
                    break;
                case "R.Customer":
                    readOb.readCustomer(statement);
                    break;
                case "R.Companie":
                    readOb.readCompany(statement);
                    break;
                case "U.developer":
                    updateOb.updateDeveloper(statement);
                    break;
                case "U.skill":
                    updateOb.updateSkill(statement);
                    break;
                case "U.project":
                    updateOb.updateProject(statement);
                    break;
                case "U.Customer":
                    updateOb.updateCustomer(statement);
                    break;
                case "U.Companie":
                    updateOb.updateCompany(statement);
                    break;
                case "D.developer":
                    deleteOb.deleteDeveloper(statement);
                    break;
                case "D.skill":
                    deleteOb.deleteSkill(statement);
                    break;
                case "D.project":
                    deleteOb.deleteProject(statement);
                    break;
                case "D.Customer":
                    deleteOb.deleteCustomer(statement);
                    break;
                case "D.Companie":
                    deleteOb.deleteCompany(statement);
                    break;
                default:
                    break;
            }
            System.out.println("Ждем следующию команду:\n");
        }
    }

    private void helpInfo() {
        System.out.println(
                "\nВсего есть есть четыри действия(CRUD)\n" +
                        "и пять сушностей (developer skill company customer project)\n" +
                        "Для вызова любого действия ипользуйте большую английськую" +
                        " заглавную букву ('C','R','U','D')\n" +
                        "далее через точку сущность \n\n" +
                        "Пример:\n" +
                        "'C.developer'"
        );
    }
}
