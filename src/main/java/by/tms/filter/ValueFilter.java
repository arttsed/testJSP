//package by.tms.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "ValueFilter", servletNames = {"CalcServlet"})
//public class ValueFilter extends HttpFilter {
//
//     public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
//          String value1 = req.getParameter("a");
//          String value2 = req.getParameter("b");
//
//          if (value1.matches("(-|\\+)?\\d*") && value2.matches("(-|\\+)?\\d*"))
//               chain.doFilter(req, resp);
//          else
//               resp.getWriter().println("You entered not a number");
//
//     }
//}
