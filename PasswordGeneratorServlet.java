import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PasswordGeneratorServlet")
public class PasswordGeneratorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the integer value from the form
        int n = Integer.parseInt(request.getParameter("number1"));

        String res = "";
        char[] a = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] c = "!@#$%^&*?.".toCharArray();
        char[] d = "1234567890".toCharArray();

        if (n == 8) {
            for (int i = 0; i < 2; i++) {
                res = res + b[(int) (Math.random() * 26)];
            }
            for (int i = 0; i < 2; i++) {
                res = res + a[(int) (Math.random() * 26)];
            }
            for (int i = 0; i < 2; i++) {
                res = res + c[(int) (Math.random() * 10)];
            }
            for (int i = 0; i < 2; i++) {
                res = res + d[(int) (Math.random() * 10)];
            }
        }

        request.setAttribute("result", res);

        // Forward the request and response to a result JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
