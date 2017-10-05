package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import org.hibernate.HibernateException;

import negocio.sectorPersonal.*;
import datos.sectorPersonal.*;

public class ControladorMostrarCliente extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		procesarPeticion(request,response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		procesarPeticion(request,response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		try {
			String dni = request.getParameter("dni");
			PersonaABM abmPersona = new PersonaABM();
			Cliente cliente = (Cliente)abmPersona.traerPersonaPorDni(dni);
			
			response.setStatus(200);
			PrintWriter salida = response.getWriter();
			
			salida.println("");
			salida.println("<!DOCTYPE 4.01 Transitional//EN\">");
			salida.println("<HTML>");
			salida.println("<HEAD>");
			salida.println("<TITLE>Gestión Restaurant</TITLE>");
			salida.println("<BODY>");
			
			salida.println("APELLIDO: "+cliente.getApellido()+"<BR>");
			salida.println("NOMBRE: "+cliente.getNombre()+"<BR>");
			salida.println("DNI: "+cliente.getDni()+"<BR>");
			salida.println("ID: "+cliente.getIdPersona()+"<BR>");
			
			salida.println("<A href=\"/GestionRestaurant/cliente.html\">Volver...</A>");
			
			salida.println("</BODY>");
			salida.println("</HTML>");
			
			
		}
		catch(Exception e){
			response.sendError(500,"El DNI Ingresado no existe en la base de datos.");
		}
	}
}
