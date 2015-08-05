import java.sql.*;
import java.util.*;
import java.io.*;

public class connect_java_with_mysql {
    public static void main (String args[])
    {

    try {
        InputStream fileInput = new FileInputStream("config.properties");
        Properties properties = new Properties();
        properties.load(fileInput);
        fileInput.close();

        String url = properties.getProperty("url");
        String dbname = properties.getProperty("database");
        String username = properties.getProperty("dbusername");
        String passwd = properties.getProperty("dbpassword");
        String driver = properties.getProperty("driver");

        System.out.println("Enter the name to be queried");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        // String roll_nos[] = new String[100];

            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url+dbname, username, passwd);
            PreparedStatement st = conn.prepareStatement("SELECT roll_no FROM  test2 WHERE first_name = ?");
            st.setString(1, name);
            ResultSet res = st.executeQuery();

            while (res.next()) {
                String roll_no = res.getString("roll_no");
                PreparedStatement st2 = conn.prepareStatement("SELECT cgpa FROM test1 WHERE roll_no = ?");
                st2.setString(1, roll_no);
                ResultSet fuck = st2.executeQuery();

                while(fuck.next()) {
                    String cgpa = fuck.getString("cgpa");
                    System.out.println(name + "\t" + roll_no + "\t" + cgpa);
                }

            }

            conn.close();
         } catch (Exception e) {
                e.printStackTrace();
         }


    }
}
