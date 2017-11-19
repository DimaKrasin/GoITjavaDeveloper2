package Main.CRUD;

import Main.Utils;

import java.sql.Statement;

public class Update {


    public void updateDeveloper(Statement statement) {
        String first_name;
        String second_name;

        System.out.println("Введите имя разрабочтика которого хотите изменить");
        first_name = Utils.consoleReader();
        System.out.println("Введите фамилию");
        second_name = Utils.consoleReader();

        int DeveloperId = Utils.Select.getId(statement, "id", "developers", "FIRST_NAME", "SECOND_NAME", first_name, second_name);

        if (DeveloperId == 0) {
            System.out.println("такого разраба нет!");
        } else {

            System.out.println("Введите новое имя");
            first_name = Utils.consoleReader();
            System.out.println("Введите новую фамилию");
            second_name = Utils.consoleReader();
            Utils.Update.doUpdate(statement, "developers", "first_name", first_name, "second_name", second_name, DeveloperId);
        }

    }

    public void updateSkill(Statement statement) {
        String skill;


        System.out.println("Введите название скилла который хотите изменить");
        skill = Utils.consoleReader();


        int skillId = Utils.Select.getId(statement, "id", "skills", "skill", skill);

        if (skillId == 0) {
            System.out.println("такого скила нет!");
        } else {

            System.out.println("Введите новое название скилла");
            skill = Utils.consoleReader();
            Utils.Update.doUpdate(statement, "skills", "skill", skill, skillId);
        }

    }

    public void updateCompany(Statement statement) {
        String companie_name;


        System.out.println("Введите имя компании которое хотите изменить");
        companie_name = Utils.consoleReader();


        int companyId = Utils.Select.getId(statement, "id", "companies", "companie_name", companie_name);

        if (companyId == 0) {
            System.out.println("такой компании нет!");
        } else {

            System.out.println("Введите новое название компании");
            companie_name = Utils.consoleReader();
            Utils.Update.doUpdate(statement, "companies", "companie_name", companie_name, companyId);
        }


    }

    public void updateCustomer(Statement statement) {
        String customer_name;


        System.out.println("Введите имя клиента которого хотите изменить");
        customer_name = Utils.consoleReader();


        int customerId = Utils.Select.getId(statement, "id", "customers", "customer_name", customer_name);

        if (customerId == 0) {
            System.out.println("такого клиента нет!");
        } else {
            System.out.println("Введите новое имя");
            customer_name = Utils.consoleReader();
            Utils.Update.doUpdate(statement, "customers", "customer_name", customer_name, customerId);
        }

    }

    public void updateProject(Statement statement) {
        String projet_name;
        String project_description;

        System.out.println("Введите имя проэкта которого хотите изменить");
        projet_name = Utils.consoleReader();
        System.out.println("Введите описание");
        project_description = Utils.consoleReader();

        int ProjetsId = Utils.Select.getId(statement, "id", "Projects", "project_name", "project_description", projet_name, project_description);

        if (ProjetsId == 0) {
            System.out.println("такого разраба нет!");
        } else {

            System.out.println("Введите новое имя");
            projet_name = Utils.consoleReader();
            System.out.println("Введите новую описание");
            project_description = Utils.consoleReader();
            Utils.Update.doUpdate(statement, "projects", "project_name", projet_name, "project_description", project_description, ProjetsId);
        }
    }
}