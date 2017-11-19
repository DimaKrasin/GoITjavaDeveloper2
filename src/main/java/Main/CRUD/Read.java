package Main.CRUD;

import Main.Utils;

import java.sql.*;

public class Read {
    private ResultSet resultSet = null;
    private StringBuilder stringBuilder = new StringBuilder();
    private String object_name;
    private int object_id;

    public void readDeveloper(Statement statement) {
        ResultSet resultSet = null;

        String first_name;
        String second_name;
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println("Введите имя разрабочтика про которого хотите узнать");
        first_name = Utils.consoleReader();
        System.out.println("Введите фамилию");
        second_name = Utils.consoleReader();

        int DeveloperId = Utils.Select.getId(statement, "id", "developers", "FIRST_NAME", "SECOND_NAME", first_name, second_name);

        if (DeveloperId == 0) {
            System.out.println("такого разраба нет!");
        } else {
            String sqlDeveloperSkill = "Select skill\n" +
                    " From (developers left join developers_skills ON developers.id = developers_skills.developer_id)\n" +
                    " left join skills ON developers_skills.skill_id = skills.id\n" +
                    " where developers.id =" + DeveloperId + ";";
            String sqlDeveloperProject = "Select projects.project_name,projects.project_description\n" +
                    " From (developers left join developers_projects ON developers.id = developers_projects.developer_id)\n" +
                    " left join projects ON developers_projects.project_id = projects.id\n" +
                    " where developers.id = " + DeveloperId + ";";

            System.out.println(first_name + " " + second_name + "\n");

            try {
                resultSet = statement.executeQuery(sqlDeveloperSkill);

                while (resultSet.next()) {
                    stringBuilder.append(resultSet.getString("skill") + "\n");
                }

                System.out.println("Skills:");
                System.out.println(stringBuilder);

                resultSet = statement.executeQuery(sqlDeveloperProject);
                stringBuilder.delete(0, stringBuilder.length());

                while (resultSet.next()) {
                    stringBuilder.append(resultSet.getString("project_name") + "\n");
                }

                System.out.println("Projects:");
                System.out.println(stringBuilder);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void readProject(Statement statement) {

        stringBuilder.delete(0, stringBuilder.length());
        object_name = null;
        object_id = 0;

        System.out.println("Введите название проекта про которого хотите узнать");
        object_name = Utils.consoleReader();

        object_id = Utils.Select.getId(statement, "id", "projects", "project_name",object_name);

        if (object_id == 0) {
            System.out.println("такого проекта  нет!");
        } else {
            String sqlProjectDescroptionDeveloper = "Select project_description,developers.first_name,developers.second_name\n" +
                    "From (projects left join developers_projects On projects.id = developers_projects.project_id)\n" +
                    "left join developers ON developers_projects.developer_id = developers.id\n" +
                    "where projects.id =" + object_id + ";";
            String sqlCustumer = "Select customers.customer_name\n" +
                    "from (customers_projects left join customers On customers_projects.custumer_id = customers.id)\n" +
                    "where customers_projects.project_id =" + object_id;
            String sqlCompanies = "Select companies.companie_name\n" +
                    "from (companies_projects left join companies On companies_projects.companie_id = companies.id)\n" +
                    "where companies_projects.project_id=" + object_id;

            System.out.println("Ваш проект : " + "\n" + object_name + " ");

            try {
                resultSet = statement.executeQuery(sqlProjectDescroptionDeveloper);

                if (resultSet.first()) {
                    stringBuilder.append(resultSet.getString("project_description"));
                }

                System.out.println(stringBuilder);
                stringBuilder.delete(0, stringBuilder.length());

                while (resultSet.next()) {
                    stringBuilder.append(resultSet.getString("developers.first_name") + "\n" + " ");
                    stringBuilder.append(resultSet.getString("developers.second_name") + "\n" + " ");
                }
                System.out.println(stringBuilder.toString());

                stringBuilder.delete(0, stringBuilder.length());


                resultSet = statement.executeQuery(sqlCustumer);
                while (resultSet.next()) {
                    stringBuilder.append(resultSet.getString("customer_name") + "\n");
                }

                System.out.println("Custumers:");
                System.out.println(stringBuilder);
                stringBuilder.delete(0, stringBuilder.length());

                resultSet = statement.executeQuery(sqlCompanies);
                while (resultSet.next()) {
                    stringBuilder.append(resultSet.getString("companie_name") + "\n");
                }

                System.out.println("Companies:");
                System.out.println(stringBuilder);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void readSkill(Statement statement) {
        stringBuilder.delete(0, stringBuilder.length());
        object_name = null;
        object_id = 0;

        System.out.println("Введите название скила про который хотите узнать");
        object_name = Utils.consoleReader();

        object_id = Utils.Select.getId(statement, "id", "skills", "skill",object_name);

        if (object_id == 0) {
            System.out.println("такого скила  нет!");
        } else {
            String sqlSkillDeveloper = "SELECT skill,first_name,second_name\n" +
                    "From (skills left join developers_skills ON skills.id = developers_skills.skill_id)\n" +
                    "left join developers On developers.id= developers_skills.developer_id\n" +
                    "Where skills.id = "+object_id;

            System.out.println("Ваш навык : " + "\n" + object_name + " "+"\n Разроботчики: \n");

            try {
                resultSet = statement.executeQuery(sqlSkillDeveloper);

                while (resultSet.next()) {
                    stringBuilder.append(resultSet.getString("developers.first_name") + " ");
                    stringBuilder.append(resultSet.getString("developers.second_name") + "\n" + " ");
                }
                System.out.println(stringBuilder.toString());

                stringBuilder.delete(0, stringBuilder.length());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void readCompany(Statement statement) {
        stringBuilder.delete(0, stringBuilder.length());
        object_name = null;
        object_id = 0;

        System.out.println("Введите название компании про которую хотите узнать");
        object_name = Utils.consoleReader();

        object_id = Utils.Select.getId(statement, "id", "companies", "companie_name",object_name);

        if (object_id == 0) {
            System.out.println("такой компании  нет!");
        } else {
            String sqlCompanieProjects = "Select project_name\n" +
                    "From companies_projects left join projects ON companies_projects.project_id = projects.id\n" +
                    "Where companies_projects.companie_id ="+object_id;

            System.out.println("Ваша компания : " + "\n" + object_name +"\n Проекты компании:");

            try {
                resultSet = statement.executeQuery(sqlCompanieProjects);

                while (resultSet.next()) {
                    stringBuilder.append(resultSet.getString("project_name") + "\n");
                }
                System.out.println(stringBuilder.toString());

                stringBuilder.delete(0, stringBuilder.length());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void readCustomer(Statement statement) {
        stringBuilder.delete(0, stringBuilder.length());
        object_name = null;
        object_id = 0;

        System.out.println("Введите имя покупателя про которого хотите узнать");
        object_name = Utils.consoleReader();

        object_id = Utils.Select.getId(statement, "id", "customers", "customer_name",object_name);

        if (object_id == 0) {
            System.out.println("такого покупца  нет!");
        } else {
            String sqlCostumerProjects = "Select project_name\n" +
                    "From customers_projects left join projects On customers_projects.project_id = projects.id\n" +
                    "Where customers_projects.custumer_id = "+object_id;

            System.out.println("Ваш покупец : " + "\n" + object_name +"\n Проекты покупца:");

            try {
                resultSet = statement.executeQuery(sqlCostumerProjects);

                while (resultSet.next()) {
                    stringBuilder.append(resultSet.getString("project_name") + "\n");
                }
                System.out.println(stringBuilder.toString());

                stringBuilder.delete(0, stringBuilder.length());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

