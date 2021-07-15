package servletBasicoSalida;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class BasicoController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date ahora = new Date();
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<!DOCTYPE HTML>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Hola Mundo</title>");
		pw.println("</head>");
		
		String cadena="<body>\r\n" + 
				"Hola Mundo\r\n" +
				ahora +
				"</body>\r\n" + 
				"</html>";
		pw.print(cadena);
		
		pw.close();
		
		
	}

}
