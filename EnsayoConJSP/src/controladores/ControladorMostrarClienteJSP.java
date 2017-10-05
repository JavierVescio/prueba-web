package controladores;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import negocio.sectorPersonal.*;
import datos.sectorPersonal.*;

public class ControladorMostrarClienteJSP extends HttpServlet {
	
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
			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("/vistacliente.jsp").forward(request, response);
		}
		catch(Exception e){
			response.sendError(500, "El DNI Ingresado no existe en la base de datos.");
		}
	}
}
