package Main.CRUD;

import Main.Utils;

import java.sql.Statement;

public class Delete {

    public void deleteDeveloper(Statement statement){
        String first_name;
        String second_name;

        System.out.println("Введите имя разрабочтика которого хотите удалить");
        first_name = Utils.consoleReader();
        System.out.println("Введите фамилию");
        second_name = Utils.consoleReader();

        int DeveloperId = Utils.Select.getId(statement, "id", "developers", "FIRST_NAME", "SECOND_NAME", first_name, second_name);

        if (DeveloperId == 0) {
            System.out.println("такого разраба нет!");
        } else {

            Utils.Delete.doDelete(statement, "developers", DeveloperId);
            Utils.Delete.doDelete(statement, "developers_projects","developer_id", DeveloperId);
            Utils.Delete.doDelete(statement, "developers_skills","developer_id", DeveloperId);
        }
        System.out.println("Удалён " + "\n");

    }

    public void deleteSkill(Statement statement) {
        String skill;


        System.out.println("Введите название скилла который хотите удалить");
        skill = Utils.consoleReader();


        int skillId = Utils.Select.getId(statement, "id", "skills", "skill", skill);

        if (skillId == 0) {
            System.out.println("такого скила нет!");
        } else {


            Utils.Delete.doDelete(statement, "skills", skillId);
            Utils.Delete.doDelete(statement, "developers_skills","skill_id",skillId);
        }

        System.out.println("Удалён " + "\n");
    }

    public void deleteCompany(Statement statement) {
        String companie_name;


        System.out.println("Введите имя компании которое хотите удалить");
        companie_name = Utils.consoleReader();


        int companyId = Utils.Select.getId(statement, "id", "companies", "companie_name", companie_name);

        if (companyId == 0) {
            System.out.println("такой компании нет!");
        } else {


            Utils.Delete.doDelete(statement, "companies", companyId);
            Utils.Delete.doDelete(statement, "companies_projects","companie_id", companyId);
        }

        System.out.println("Удалён " + "\n");
    }

    public void deleteCustomer(Statement statement) {
        String customer_name;


        System.out.println("Введите имя клиента которого хотите удалить");
        customer_name = Utils.consoleReader();


        int customerId = Utils.Select.getId(statement, "id", "customers", "customer_name", customer_name);

        if (customerId == 0) {
            System.out.println("такого клиента нет!");
        } else {
            Utils.Delete.doDelete(statement, "customers", customerId);
            Utils.Delete.doDelete(statement, "customers_projects","customer_id",customerId);

        }

        System.out.println("Удалён " + "\n");
    }

    public void deleteProject(Statement statement) {
        String projet_name;
        String project_description;

        System.out.println("Введите имя проэкта которого хотите удалить");
        projet_name = Utils.consoleReader();
        System.out.println("Введите описание");
        project_description = Utils.consoleReader();

        int ProjetsId = Utils.Select.getId(statement, "id", "Projects", "project_name", "project_description", projet_name, project_description);

        if (ProjetsId == 0) {
            System.out.println("такого проэкта нет!");
        } else {


            Utils.Delete.doDelete(statement, "projects", ProjetsId);
            Utils.Delete.doDelete(statement, "developers_projects","project_id", ProjetsId);
            Utils.Delete.doDelete(statement, "customers_projects","project_id", ProjetsId);
            Utils.Delete.doDelete(statement, "companies_projects","project_id", ProjetsId);
        }
        System.out.println("Удалён " + "\n");
    }
}

