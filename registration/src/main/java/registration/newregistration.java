package registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class newregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public newregistration() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pnumber = request.getParameter("number");
		String city = request.getParameter("city");
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(pnumber);
//		System.out.println(city);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my_data","root","g00gle33");
			Statement St= con.createStatement();
			St.executeUpdate("insert into details values('"+name+"','"+email+"','"+pnumber+"','"+city+"')");
			//Stmnt.executeUpdate("delete from details where name='mahi'");
			//Stmnt.executeUpdate("insert into marks values('45','35','25','15')");
			//Stmnt.executeUpdate("update details set phone='1010101010' where name='mahi'");
			//Stmnt.executeUpdate("select name from details where city='hosur'");
			con.close();	
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
