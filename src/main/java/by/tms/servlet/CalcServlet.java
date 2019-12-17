package by.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet(name = "CalcServlet", urlPatterns = "/calc")
public class CalcServlet extends HttpServlet {
     
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          String title = request.getParameter("title");
          String value1 = request.getParameter("a");
          String value2 = request.getParameter("b");
          String result = "";
     
          if (value1.matches("(-|\\+)?\\d*") && value2.matches("(-|\\+)?\\d*")) {
               double a = Integer.parseInt(value1);
               double b = Integer.parseInt(value2);
               switch (title) {
                    case "add":
                         result = String.valueOf(a + b);
                         break;
                    case "sub":
                         result = String.valueOf(a - b);
                         break;
                    case "multi":
                         result = String.valueOf(a * b);
                         break;
                    case "div":
                         result = String.valueOf(a / b);
                         break;
               }
     
               request.setAttribute("result", result);
               response.sendRedirect("/calc" + "?result=" + result);
     
               ArrayList<String> history = (ArrayList<String>) request.getSession().getAttribute("history");
               history.add(LocalDateTime.now() + " - Result = " + result);
               request.setAttribute("history", history);
          }
          else
               response.getWriter().println("You entered not a number");
     }
     
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.getRequestDispatcher("/calculation.jsp").forward(req, resp);
     }
}
