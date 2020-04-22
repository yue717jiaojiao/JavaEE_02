package code.jdbc;


import code.model.Homework;
import code.model.Student;
import code.model.StudentHomework;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static code.jdbc.DatabasePool.getHikariDataSource;

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
    private static HikariDataSource dataSource = getHikariDataSource();

    public static boolean addStudentHomework(StudentHomework sh) throws SQLException {
        Connection connection = null;
        int resultSet = 0;
        try {
            Class.forName(driverName);
            String sqlString = "insert into s_student_homework (student_id,homework_id,homework_title,homework_content,student_answer,create_time) values(?,?,?,?,?,?)";

            connection = dataSource.getConnection();
            //不自动commit
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(sqlString);

            ps.setLong(1,sh.getStudentId());
            ps.setLong(2,sh.getHomeworkId());
            ps.setString(3,sh.getHomeworkTitle());
            ps.setString(4,sh.getHomeworkContent());
            ps.setString(5,sh.getStudentAnswer());
            ps.setTimestamp(6,new Timestamp(sh.getCreateTime().getTime()));
            resultSet = ps.executeUpdate();

            connection.commit();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            connection.rollback();
        }

        return resultSet != 0;

    }

    public static List<StudentHomework> selectAll()throws SQLException {

        String sqlString = "SELECT * FROM s_student_homework";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        List<StudentHomework> list = new ArrayList<>();
        try{
            connection =  dataSource.getConnection();
            connection.setAutoCommit(false);
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
                    connection.commit();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }

        return list;
    }

    public static boolean addStudent(Student student) throws SQLException {
        int resultSet = 0;
        Connection connection =null;
        try {
            Class.forName(driverName);
            String sqlString = "insert into student (id,sname,create_time) values(?,?,?)";

        connection = dataSource.getConnection();
            connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement(sqlString);
                ps.setLong(1,student.getId());
                ps.setString(2,student.getName());
                ps.setTimestamp(3,new Timestamp(student.getCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            connection.rollback();
        }

        return resultSet != 0;
    }

    public static boolean addHomework(Homework homework) throws SQLException {
        int resultSet = 0;
        Connection connection =null;
        try {
            Class.forName(driverName);
            String sqlString = "insert into homework (h_id,title,content,create_time) values(?,?,?,?)";

            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(sqlString);
            ps.setLong(1,homework.getId());
            ps.setString(2,homework.getTitle());
            ps.setString(3,homework.getContent());
            ps.setTimestamp(4,new Timestamp(homework.getCreateTime().getTime()));

            resultSet = ps.executeUpdate();

            connection.commit();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            connection.rollback();
        }

        return resultSet != 0;
    }

    public static List<Homework> selectAllhw() throws SQLException {
        String sqlString = "SELECT * FROM homework";
        Connection connection =null;
        try {
            // 加载驱动
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Homework> list = new ArrayList<>();
        try{
            connection =  dataSource.getConnection();
            connection.setAutoCommit(false);
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
                    connection.commit();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }

        return list;
    }

    public static List<StudentHomework> selectStudentHomeworkbyid(String id) throws SQLException {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection =null;
        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id=" + id;

        List<StudentHomework> list = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
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
                    connection.commit();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }


        return list;
    }
    public static Homework selectHomeworkbyid(String id) throws SQLException {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM homework WHERE h_id=" + id;
        Connection connection =null;
        Homework homework = new Homework();
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        homework.setId(resultSet.getLong("h_id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                    }
                    connection.commit();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }


        return homework;
    }

    public static List<Student> selectAllstudent() throws SQLException {
        String sqlString = "SELECT * FROM student";

        try {
            // 加载驱动
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        List<Student> list = new ArrayList<>();
        try{
            connection =  dataSource.getConnection();
            connection.setAutoCommit(false);
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
                    connection.commit();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }

        return list;
    }
}
