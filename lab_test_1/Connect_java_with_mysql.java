/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_java_with_mysql;

/**
 *
 * @author vivek
 */
import java.sql.*;
import java.util.*;
import java.io.*;

public class Connect_java_with_mysql {
    
    String url;
    String dbname;
    String username;
    String passwd;
    String driver;

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Connect_java_with_mysql() throws FileNotFoundException, IOException
    {
        Properties properties;
        try (InputStream fileInput = new FileInputStream("config.properties")) {
            properties = new Properties();
            properties.load(fileInput);
        }
        
        url = properties.getProperty("url");
        dbname = properties.getProperty("database");
        username = properties.getProperty("dbusername");
        passwd = properties.getProperty("dbpassword");
        driver = properties.getProperty("driver");
        
        System.out.println(url);
    }
        
    String query(String roll_no) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        String solution;
        
        Class.forName(driver).newInstance();
        Connection conn;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_test_1", username, passwd);
        PreparedStatement st;
        st = conn.prepareStatement("Select * from student where roll_no = ?");
        st.setString(1, roll_no);
        System.out.println(st);
        ResultSet res = st.executeQuery();
        res.next();
        String name_ = res.getString("name");
        String course_ = res.getString("course");
        solution = "The details of the queried student are \n" + "Roll:\t" + roll_no + "\n" + "Name: \t" + name_ +"\n" + "Course: \t" + course_ + "\n";
        return solution;
    }
    
    void insert(String roll_no_, String name_, String course_) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        if (roll_no_.matches("[a-zA-Z]{3}.[0-9]{6}")) {
            Class.forName(driver).newInstance();
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_test_1", username, passwd);
            PreparedStatement st;
            st = conn.prepareStatement("INSERT into student values (?, ?, ?)");
            st.setString(1, name_);
            st.setString(2, roll_no_);
            st.setString(3, course_);
            st.execute();
        } else {
            System.out.println("Wrong roll no");
        }
    }
    

}