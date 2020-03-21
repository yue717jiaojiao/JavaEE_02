package com.java.code.jdbc;


import com.java.code.model.Homework;
import com.java.code.model.Student;
import com.java.code.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentHomeworkJdbc
 *
 * @author wangkm
 * @date 2020-03-05
 * @since 0.0.1
 */
public class StudentHomeworkJdbc {

    private static String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";

    private static String driverName = "com.mysql.cj.jdbc.Driver";

    public static boolean addStudentHomework(StudentHomework sh){

        int resultSet = 0;
        try {
            Class.forName(driverName);
            String sqlString = "insert into s_student_homework (student_id,homework_id,homework_title,homework_content,student_answer,create_time) values(?,?,?,?,?,?)";

            Connection connection = DriverManager.getConnection(url, "root", "123456");
            PreparedStatement ps = connection.prepareStatement(sqlString);

            ps.setLong(1,sh.getStudentId());
            ps.setLong(2,sh.getHomeworkId());
            ps.setString(3,sh.getHomeworkTitle());
            ps.setString(4,sh.getHomeworkContent());
            ps.setString(5,sh.getStudentAnswer());
            ps.setTimestamp(6,new Timestamp(sh.getCreateTime().getTime()));
            resultSet = ps.executeUpdate();


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet != 0;

    }

    public static List<StudentHomework> selectAll(){

        String sqlString = "SELECT * FROM s_student_homework";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        StudentHomework sh = new StudentHomework();

                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static boolean addStudent(Student student) {
        int resultSet = 0;
        try {
            Class.forName(driverName);
            String sqlString = "insert into student (id,sname,create_time) values(?,?,?)";

        Connection connection = DriverManager.getConnection(url, "root", "123456");
        PreparedStatement ps = connection.prepareStatement(sqlString);
                ps.setLong(1,student.getId());
                ps.setString(2,student.getName());
                ps.setTimestamp(3,new Timestamp(student.getCreateTime().getTime()));
                resultSet = ps.executeUpdate();


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet != 0;
    }

    public static boolean addHomework(Homework homework) {
        int resultSet = 0;
        try {
            Class.forName(driverName);
            String sqlString = "insert into homework (h_id,title,content,create_time) values(?,?,?,?)";

            Connection connection = DriverManager.getConnection(url, "root", "123456");
            PreparedStatement ps = connection.prepareStatement(sqlString);
            ps.setLong(1,homework.getId());
            ps.setString(2,homework.getTitle());
            ps.setString(3,homework.getContent());
            ps.setTimestamp(4,new Timestamp(homework.getCreateTime().getTime()));

            resultSet = ps.executeUpdate();


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet != 0;
    }

    public static List<Homework> selectAllhw() {
        String sqlString = "SELECT * FROM homework";

        try {
            // 加载驱动
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Homework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        Homework homework = new Homework();
                        homework.setId(resultSet.getLong("h_id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(homework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<StudentHomework> selectStudentHomeworkbyid(String id) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id=" + id;

        List<StudentHomework> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    while (resultSet.next()) {
                        StudentHomework sh = new StudentHomework();

                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setstudentAnswer(resultSet.getString("student_answer"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        sh.setUpdateTime(resultSet.getTimestamp("update_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
    public static Homework selectHomeworkbyid(String id) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM homework WHERE h_id=" + id;

        Homework homework = new Homework();
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        homework.setId(resultSet.getLong("h_id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return homework;
    }

    public static List<Student> selectAllstudent() {
        String sqlString = "SELECT * FROM student";

        try {
            // 加载驱动
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Student> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        Student sdu = new Student();
                        sdu.setId(resultSet.getLong("id"));
                        sdu.setName(resultSet.getString("sname"));
                        sdu.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(sdu);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
