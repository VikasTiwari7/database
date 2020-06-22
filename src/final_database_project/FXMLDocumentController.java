
package final_database_project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class FXMLDocumentController implements Initializable { 

    @FXML
    private TextField columtextfiled;

    @FXML
    private AnchorPane dbpane;

    @FXML
    private VBox tablepane;
    @FXML
    private VBox columnpane;
    TextField tf1=new TextField();
    TextField tf=new TextField();
    @FXML
    private Button dbname;
    @FXML
    private Button tablename;
    @FXML
    private Button columnname;
    @FXML
    void clmaction(ActionEvent event) throws IOException {
    String str = columtextfiled.getText();
    if(!str.equals("")) {
    int num = Integer.parseInt(str);
    for(int i = 1; i <=num; i++) {
        Label lb=new Label("Column No"+i);
        //String tab=Integer.toString(i)
        //BufferedReader bf = new BufferedReader(new InputStreamReader((columtextfiled.getText()))); 
        columnpane.getChildren().add(lb);
        TextField tf=new TextField();
      //String s1 = bf.readLine();  
        //System.out.println(s1);
        columnpane.getChildren().add(tf);
        String textfieldvar = Integer.toString(i); 
        tf.setId(textfieldvar);
        System.out.println("Id is  "+textfieldvar);
         String strr = null; 
//        System.out.println("Column name"+String());
//        String var=textfieldvar.get;
//        System.out.println(var);
//        String vis=0.getText();
//        System.out.println(vis);
//        System.out.println(textfieldvar);
if (strr == null) {  
   //  strr = s1;  

    } else {  
   //  strr = strr + s1;
  //    sb.append(',');  

    }  
//       
      
    }
    }
    }                
    @FXML
    void dbaction(ActionEvent event) {
    dbpane.getChildren().addAll(tf1);
      
    }
    @FXML
    void tableaction(ActionEvent event) {
       TextField tf2=new TextField();
         tablepane.getChildren().addAll(tf2);
         //System.out.println("TextFiled make");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
      
    }
    
    public void db() throws ClassNotFoundException
    {
    try {
      Class.forName("com.mysql.jdbc.Driver");  
        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root")) {
            java.sql.Statement st = con.createStatement();
            System.out.println("connection has been made "); 
        }
    }
        catch(ClassNotFoundException | SQLException e)
        {   
            System.out.println(e);
        }
    }
    @FXML
    private void dbgoaction(ActionEvent event) throws ClassNotFoundException {
        String database=tf1.getText();
        System.out.println(database);
        try{
         Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
            java.sql.Statement st = con.createStatement();
            st.executeUpdate(("create database "+database));
            st.executeUpdate(("use "+database));
    }catch(ClassNotFoundException | SQLException e)
    {
        System.out.println("vikas"+e);
    }}
            
    @FXML
    private void clgo(ActionEvent event) throws IOException {
        String table=tf.getText();
        try{
             columnpane.getChildren().removeAll(columnpane.getChildren());
            System.out.println("akas");
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
            java.sql.Statement st = con.createStatement();
            String strr = null;  

            System.out.println("vibhuti");
   BufferedReader bf = new BufferedReader(new InputStreamReader(  
      System.in));  
            System.out.println("ashu");
    String s1 = bf.readLine();  
   if (strr == null) {  
       System.out.println("prink");
     strr = s1;  

    } else {  
     strr = strr + s1;
      //sb.append(',');  

    }  
System.out.println("vikas");
  
   st.executeUpdate("create table " + table + "("+ strr +")");  
   System.out.println("your table " + table  
     + " has been created!!!"); 
            
    }catch(ClassNotFoundException | SQLException e)
            {
                System.out.println(e);
            }
    }
    }


