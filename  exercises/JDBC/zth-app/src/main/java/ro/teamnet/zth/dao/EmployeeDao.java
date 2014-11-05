package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
<<<<<<< HEAD
 * Created by Dumitru on 04.11.2014.
 */
public class EmployeeDao {

    public ArrayList<Employee> getAllEmployees(Connection con) {

        PreparedStatement pstmt = null;
        String selectAllFromTableString = "SELECT employee_id, first_name, last_name, email," +
                "phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id FROM Employees";

        try {
            pstmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = pstmt.executeQuery();

            return ResultSetToPojoConverter.convertToEmployee(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Employee>();
    }

    public Employee getEmployeeById(Connection con, String id) {
        PreparedStatement pstmt = null;
        ArrayList<Employee> emp = new ArrayList<Employee>();
        String selectAllFromTableString = "SELECT employee_id, first_name, last_name, email, " +
                "phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id " +
                "FROM Employees WHERE employee_id = ?";   //?: analogie cu printf din C :D

        try {
            pstmt = con.prepareStatement(selectAllFromTableString);
            pstmt.setString(1, id); //pentru ?
            ResultSet rs = pstmt.executeQuery();
            emp = ResultSetToPojoConverter.convertToEmployee(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return emp.size() > 0 ? emp.get(0) : null;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    //INSERT INTO table employees
=======
 * Created by liviu.spiroiu on 11/3/14.
 */
public class EmployeeDao {

    public ArrayList<Employee> getAllEmployees(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        String selectAllFromTableString = "SELECT employee_id,first_name,last_name,email," +
                "phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id FROM Employees";
        ResultSet rs = stmt.executeQuery(selectAllFromTableString);
        try {
            return ResultSetToPojoConverter.convertToEmployee(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        stmt.close();
        return new ArrayList<Employee>();
    }

    public Employee getEmployeeById(Connection con, Long id) throws SQLException {
        Statement stmt = con.createStatement();
        PreparedStatement preparedStatement = con.prepareStatement("");
        preparedStatement.setMaxRows(5);

        String selectAllFromTableString = "SELECT employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id " +
                "FROM Employees WHERE employee_id = " + id;
        ResultSet rs = stmt.executeQuery(selectAllFromTableString);
        ArrayList<Employee> employees = ResultSetToPojoConverter.convertToEmployee(rs, con);
        stmt.close();
        return employees.size() > 0 ? employees.get(0) : null;
    }

>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
    public void saveEmployee(Employee employee, Connection con) {
=======
    /*public void saveEmployee(Employee employee, Connection con) {
>>>>>>> parent of a9b316a... add DELETE
=======
    /*public void saveEmployee(Employee employee, Connection con) {
>>>>>>> parent of a9b316a... add DELETE
        HashMap<String, String> insertIntoTableEmployees = new HashMap<String, String>();
        String tableName = "employees";

        insertIntoTableEmployees.put("employee_id", employee.getId().toString());
        insertIntoTableEmployees.put("first_name", employee.getFirstName());
        insertIntoTableEmployees.put("last_name", employee.getLastName());
        insertIntoTableEmployees.put("email", employee.getEmail());
        insertIntoTableEmployees.put("phone_number", employee.getPhoneNumber());
        insertIntoTableEmployees.put("hire_date", "TO_DATE('" + employee.getHireDate().toString() + "','yyy-mm-dd')");
        insertIntoTableEmployees.put("job_id", employee.getJob().getId());
        insertIntoTableEmployees.put("salary", employee.getSalary().toString());
<<<<<<< HEAD
        insertIntoTableEmployees.put("commission_pct", employee.getCommisionPoints().toString());
        insertIntoTableEmployees.put("manager_id", employee.getManager().getId().toString());
        insertIntoTableEmployees.put("department_id", employee.getDepartment().getId().toString());

        //PreparedStatement pstmt = null;
        Statement stmt = null;
=======
        insertIntoTableEmployees.put("commission_pct", employee.getCommissionPoints().toString());
        insertIntoTableEmployees.put("manager_id", employee.getManager().getId().toString());
        insertIntoTableEmployees.put("department_id", employee.getDepartment().getId().toString());

        Statement stmt;
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
        try {
            stmt = con.createStatement();
            String createTableString = "INSERT INTO " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer valuesCount = insertIntoTableEmployees.keySet().size();

            for(String valueName : insertIntoTableEmployees.keySet()) {
                valuesCount--;
                String columnString = valueName + (valuesCount != 0 ? " , " : ")");
                sqlStatement.append(columnString);
            }

            valuesCount = insertIntoTableEmployees.keySet().size();
            sqlStatement.append(" VALUES ( '");

            for(String valueName : insertIntoTableEmployees.keySet()) {
                valuesCount--;
                String columnString;
                if(valueName.equals("hire_date")) {
                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? " , '" : "')");
                } else if(valueName.equals("first_name")) {
                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? "' , " : "')");
                } else {
                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? "' , '" : "')");
                }
                sqlStatement.append(columnString);
            }

            stmt.executeUpdate(sqlStatement.toString());
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            System.out.println("Inserted into table " + tableName + "...");
=======
            //stmt.close();
            System.out.println("Insert into table" + tableName + "...");
            //pstmt = con.prepareStatement(sqlStatement.toString());
>>>>>>> parent of a9b316a... add DELETE
=======
            //stmt.close();
            System.out.println("Insert into table" + tableName + "...");
            //pstmt = con.prepareStatement(sqlStatement.toString());
>>>>>>> parent of a9b316a... add DELETE
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/

    public void saveEmployee(Employee employee, Connection con) {
        HashMap<String, String> insertIntoTableEmployees = new HashMap<String, String>();
        String tableName = "employees";

        insertIntoTableEmployees.put("employee_id", employee.getId().toString());
        insertIntoTableEmployees.put("first_name", employee.getFirstName());
        insertIntoTableEmployees.put("last_name", employee.getLastName());
        insertIntoTableEmployees.put("email", employee.getEmail());
        insertIntoTableEmployees.put("phone_number", employee.getPhoneNumber());
        insertIntoTableEmployees.put("hire_date", "TO_DATE('" + employee.getHireDate().toString() + "','yyyy-mm-dd')");
        insertIntoTableEmployees.put("job_id", employee.getJob().getId().toString());
        insertIntoTableEmployees.put("salary", employee.getSalary().toString());
        insertIntoTableEmployees.put("commission_pct", employee.getCommisionPoints().toString());
        insertIntoTableEmployees.put("manager_id", employee.getManager().getId().toString());
        insertIntoTableEmployees.put("department_id", employee.getDepartment().getId().toString());

        Statement stmt;
        try {
            stmt = con.createStatement();
            String createTableString = "INSERT INTO " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer valuesCount = insertIntoTableEmployees.keySet().size();

            for (String valueName : insertIntoTableEmployees.keySet()) {
                valuesCount--;
                String columnString = valueName + (valuesCount != 0 ? " , " : ")");
                sqlStatement.append(columnString);
            }
            valuesCount = insertIntoTableEmployees.keySet().size();
            sqlStatement.append(" VALUES ( '");

<<<<<<< HEAD
<<<<<<< HEAD
            String endUpdateTable = " WHERE employee_id = " + employee.getId();
            sqlStatement.append(endUpdateTable);
            System.out.println("Update an employee in table " + tableName + "...");
=======
            stmt.close();
            System.out.println("Inserted into table " + tableName + "...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(Employee employee, Connection con) {
        Statement stmt;
        String tableName = "employees";
        try {
            stmt = con.createStatement();
            String deleteStatement = "DELETE FROM " + tableName + " WHERE employee_id = " + employee.getId();
            stmt.executeUpdate(deleteStatement);
            stmt.close();
            System.out.println("Dropped table " + tableName + " from database...");
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
=======
=======
>>>>>>> parent of a9b316a... add DELETE
            for (String valueName : insertIntoTableEmployees.keySet()) {
                valuesCount--;
                String columnString;
                if (valueName.equals("hire_date")) {
                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? " , '" : "')");
                }else if (valueName.equals("first_name")) {
                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? "' , " : "')");
                }else
                {
                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? "' , '" : "')");
                }
                sqlStatement.append(columnString);
            }
            stmt.executeUpdate(sqlStatement.toString());
            stmt.close();
            System.out.println("Inserted into table " + tableName + "...");
<<<<<<< HEAD
>>>>>>> parent of a9b316a... add DELETE
=======
>>>>>>> parent of a9b316a... add DELETE
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    //DELETE FROM statement
    public void deleteEmployee(Employee employee, Connection con) {
        String tableName = "employee";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String deleteTable = "DELETE FROM " + tableName + " WHERE job_id = " + employee.getId();
            stmt.executeUpdate(deleteTable);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
=======
    public void updateEmployee(Employee employee, Connection con) {
        HashMap<String, String> insertIntoTableEmployees = new HashMap<String, String>();
        insertIntoTableEmployees.put("employee_id", employee.getId().toString());
        insertIntoTableEmployees.put("first_name", employee.getFirstName());
        insertIntoTableEmployees.put("last_name", employee.getLastName());
        insertIntoTableEmployees.put("email", employee.getEmail());
        insertIntoTableEmployees.put("phone_number", employee.getPhoneNumber());
        insertIntoTableEmployees.put("hire_date", "TO_DATE('" + employee.getHireDate().toString() + "','yyyy-mm-dd')");
        insertIntoTableEmployees.put("job_id", employee.getJob().getId().toString());
        insertIntoTableEmployees.put("salary", employee.getSalary().toString());
        insertIntoTableEmployees.put("commission_pct", employee.getCommissionPoints().toString());
        insertIntoTableEmployees.put("manager_id", employee.getManager().getId().toString());
        insertIntoTableEmployees.put("department_id", employee.getDepartment().getId().toString());


        String tableName = "employees";


        Statement stmt;
        try {
            stmt = con.createStatement();
            String createTableString = "UPDATE " + tableName + " SET ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = insertIntoTableEmployees.keySet().size();

            for (String columnName : insertIntoTableEmployees.keySet()) {
                columnsCount--;
                String columnString;
                if (columnName.equals("hire_date")) {
                    columnString = columnName + " = " + insertIntoTableEmployees.get(columnName) + (columnsCount != 0 ? " , " : "' ");
                } else {
                    columnString = columnName + " = '" + insertIntoTableEmployees.get(columnName) + (columnsCount != 0 ? "' , " : "' ");
                }

                sqlStatement.append(columnString);
            }

            sqlStatement.append("WHERE employee_id = " + employee.getId());
            stmt.executeUpdate(sqlStatement.toString());
            stmt.close();
            System.out.println("Created table " + tableName + " in database...");
        } catch (SQLException e) {
            e.printStackTrace();
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
        }
    }
=======
    //si update
    //si delete
>>>>>>> parent of a9b316a... add DELETE
=======
    //si update
    //si delete
>>>>>>> parent of a9b316a... add DELETE
}
