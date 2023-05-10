package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadReg")
public class ReadReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ReadReg() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("HI");
			out.println("<hr>");
			
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>");
			out.println("NAME");
			out.println("</th>");
			out.println("<th>");
			out.println("EMAIL");
			out.println("</th>");
			out.println("<th>");
			out.println("CITY");
			out.println("</th>");
			out.println("<th>");
			out.println("PNUMBER");
			out.println("</th>");
			out.println("</tr>");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my_data","root","g00gle33");
				Statement St= con.createStatement();
				ResultSet result = St.executeQuery("select * from details");
				while(result.next()) {
					
					out.println("<tr>");
					out.println("<td>");
					out.println(result.getString(1));
					out.println("</td>");
					out.println("<td>");
					out.println(result.getString(2));
					out.println("</td>");
					out.println("<td>");
					out.println(result.getString(3));
					out.println("</td>");
					out.println("<td>");
					out.println(result.getString(4));
					out.println("</td>");
					out.println("</tr>");
					
				}
				//Stmnt.executeUpdate("delete from details where name='mahi'");
				//Stmnt.executeUpdate("insert into marks values('45','35','25','15')");
				//Stmnt.executeUpdate("update details set phone='1010101010' where name='mahi'");
				//Stmnt.executeUpdate("select name from details where city='hosur'");
				con.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
			
			out.println("</table>");
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
