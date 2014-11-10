package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by George on 11/4/2014.
 */
public class EmployeeDao {
    public ArrayList<Employee> getAllEmployees(Connection con){

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            String selectAllFromTableString = "select * from employees";
            preparedStatement = con.prepareStatement(selectAllFromTableString);
            preparedStatement.setMaxRows(3);
            rs = preparedStatement.executeQuery();

            return ResultSetToPojoConverter.convertToEmployee(rs, con);
        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Employee>();
    }

    public Employee getEmployeeById(Connection con, Long id) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ArrayList<Employee> employees = null;

        try {
            String selectAllFromTableString = "select * from employees where employee_id = ?";
            preparedStatement = con.prepareStatement(selectAllFromTableString);
            preparedStatement.setLong(1, id);
            rs = preparedStatement.executeQuery();
            employees = ResultSetToPojoConverter.convertToEmployee(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees.size() > 0 ? employees.get(0) : null;
    }


    /**
     * Insert into employees
     * @param con   - connection
     * @param employee employee
     */

    public void insertIntoEmployees(Connection con, Employee employee){
        PreparedStatement preparedStatement = null;
        String tableName = "employees";

/*
        private Long id;
        private String firstName;
        private String lasName;
        private Employee manager;
        private String email;
        private Date hireDate;
        private Double salary;
        private Double commissionPoints;
        private String PhoneNumber;
        private Job job;
        private Department department;
        */

        try{
            String command = "insert into " + tableName + "(employee_id," +
                    "first_name," +
                    "last_name," +
                    "manager_id," +
                    "email," +
                    "hire_date," +
                    "salary," +
                    "commission_pct," +
                    "phone_number," +
                    "job_id," +
                    "department_id)"
                    + "values (TAB_EMPLOYEES_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = con.prepareStatement(command);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLasName());

            if (employee.getManager() == null)
                preparedStatement.setNull(3,  Types.NULL);
            else preparedStatement.setLong(3, employee.getManager().getId());

            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setDate(5, (Date) employee.getHireDate());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setDouble(7, employee.getCommissionPoints());
            preparedStatement.setString(8, employee.getPhoneNumber());
            preparedStatement.setString(9, employee.getJob().getId());

            if (employee.getDepartment() == null)
                preparedStatement.setNull(10, Types.NULL);
            else preparedStatement.setLong(10, employee.getDepartment().getId());

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Employee with name: " + employee.getFirstName() + " " + employee.getLasName()
                        + " are inserted into table employees \n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    /**
     * Update an employee from employees table
     *
     * @param con   - connection
     * @param employee    - employee
     */
    public void updateEmployee(Connection con, Employee employee){
        PreparedStatement preparedStatement = null;
        String tableName = "employees";

        try{
            String command = "update " + tableName +
                    " set first_name=?," +
                    "last_name=?," +
                    "manager_id=?," +
                    "email=?," +
                    "hire_date=?," +
                    "salary=?," +
                    "commission_pct=?," +
                    "phone_number=?," +
                    "job_id=?," +
                    "department_id=?" +
                    " where employee_id=?";

            preparedStatement = con.prepareStatement(command);


            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLasName());

            if (employee.getManager() == null)
                preparedStatement.setNull(3,  Types.NULL);
            else preparedStatement.setLong(3, employee.getManager().getId());

            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setDate(5, (Date) employee.getHireDate());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setDouble(7, employee.getCommissionPoints());
            preparedStatement.setString(8, employee.getPhoneNumber());
            preparedStatement.setString(9, employee.getJob().getId());

            if (employee.getDepartment() == null)
                preparedStatement.setNull(10, Types.NULL);
            else preparedStatement.setLong(10, employee.getDepartment().getId());

            preparedStatement.setLong(11, employee.getId());

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Update employee with name: " + employee.getFirstName() + "\n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    /**
     * Delete employee by id
     *
     * @param con - connection
     * @param idEmployee - id of employee
     */
    public void deleteEmployee(Connection con, Long idEmployee){
        PreparedStatement preparedStatement = null;
        String tableName = "employees";

        try{
            String command = "delete from " + tableName + " where employee_id=?";
            preparedStatement = con.prepareStatement(command);
            preparedStatement.setLong(1, idEmployee);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Deleted employee with id: " + idEmployee + "\n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
