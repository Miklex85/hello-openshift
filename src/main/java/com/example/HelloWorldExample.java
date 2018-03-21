package com.example;
 
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class HelloWorldExample extends HttpServlet {

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      Configuration configuration = new Configuration();
      Map properties = configuration.getProperties();

      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title> OpenShit Hello World App</title></head>");
         out.println("<body>");
         out.println("<h1>" + properties.get("saludo") + " " + properties.get("nombre") + "</h1>");

         out.println("<p>" + properties.get("mensaje") + "</p>");
         out.println("<p> Ejecutando desde el POD: " + System.getenv().get("OPENSHIFT_PRUEBA_MIKE") + " # ${HOSTNAME}  # ${OPENSHIFT_PRUEBA_MIKE} </p>");

         Map<String, String> env = System.getenv();
         for (String envName : env.keySet()) {
            out.println("<p>" + envName + " = " + env.get(envName) + "</p>");
         }
         out.println("</body></html>");
      } finally {
         out.close();
      }
   }
}
