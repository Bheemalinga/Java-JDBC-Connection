import java.sql.*;

class First_JDBC{
    public static void main(String[] args) {
        System.out.println("\nTrying the JDBC connection\n\n");
        
        // Loading the driver.
        // But it gives Exception So...
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");

            // Creating a connection.
            // url, username, password.

            String url = "jdbc:mysql://localhost:3306/teacher";
            String username = "root";
            String password = "Asdf@1234";
            
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();

            if(con.isClosed()){
                System.out.println("Connection is closed");
            }
            else{
                System.out.println("Connection is open");
            }

        }
        catch(Exception e){
            System.err.println("Driver is Not Loaded\n");
            e.printStackTrace();
        } 
    }
}