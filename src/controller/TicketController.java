package controller;

import data.*;
import model.*;
import java.util.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Controlador de la pantalla de ticket's, todas las acciones que tengan que ver con la compra de ticket's son manejadas por esta
 * clase
 * @see EventDAO
 * @see TicketDAO
 * @see CustomerDAO
 * @see LocationDAO
 * @see LocationTypeDAO
 * @see NumberedLocationDAO
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class TicketController implements Controller
{
	private EventDAO eventDAO;
	private TicketDAO ticketDAO;
	private CustomerDAO customerDAO;
	private LocationDAO locationDAO;
	private LocationTypeDAO locationTypeDAO;
	private NumberedLocationDAO numberedLocationDAO;

	/**
	 * Establece un nuevo valor para el DAO, el metodo es requerido por el inicializador context
	 * @param eventDAO nuevo valor para el DAO
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setEventDAO(EventDAO eventDAO)
	{
		this.eventDAO = eventDAO;
	}
	
	/**
	 * Obtiene el valor de un DAO, este metodo es requerido por el inicializador context
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public EventDAO getEventDAO()
	{
		return this.eventDAO;
	}
	
	/**
	 * Establece un nuevo valor para el DAO, el metodo es requerido por el inicializador context
	 * @param ticketDAO nuevo valor para el DAO
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setTicketDAO(TicketDAO ticketDAO)
	{
		this.ticketDAO = ticketDAO;
	}
	
	/**
	 * Obtiene el valor de un DAO, este metodo es requerido por el inicializador context
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public TicketDAO getTicketDAO()
	{
		return this.ticketDAO;
	}
	
	/**
	 * Establece un nuevo valor para el DAO, el metodo es requerido por el inicializador context
	 * @param customerDAO nuevo valor para el DAO
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setCustomerDAO(CustomerDAO customerDAO)
	{
		this.customerDAO = customerDAO;
	}
	
	/**
	 * Obtiene el valor de un DAO, este metodo es requerido por el inicializador context
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public CustomerDAO getCustomerDAO()
	{
		return this.customerDAO;
	}
	
	/**
	 * Establece un nuevo valor para el DAO, el metodo es requerido por el inicializador context
	 * @param locationDAO nuevo valor para el DAO
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setLocationDAO(LocationDAO locationDAO)
	{
		this.locationDAO = locationDAO;
	}
	
	/**
	 * Obtiene el valor de un DAO, este metodo es requerido por el inicializador context
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public LocationDAO getLocationDAO()
	{
		return this.locationDAO;
	}
	
	/**
	 * Establece un nuevo valor para el DAO, el metodo es requerido por el inicializador context
	 * @param locationTypeDAO nuevo valor para el DAO
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setLocationTypeDAO(LocationTypeDAO locationTypeDAO)
	{
		this.locationTypeDAO = locationTypeDAO;
	}
	
	/**
	 * Obtiene el valor de un DAO, este metodo es requerido por el inicializador context
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public LocationTypeDAO getLocationTypeDAO()
	{
		return this.locationTypeDAO;
	}
	
	/**
	 * Establece un nuevo valor para el DAO, el metodo es requerido por el inicializador context
	 * @param numberedLocationDAO nuevo valor para el DAO
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setNumberedLocationDAO(NumberedLocationDAO numberedLocationDAO)
	{
		this.numberedLocationDAO = numberedLocationDAO;
	}
	
	/**
	 * Obtiene el valor de un DAO, este metodo es requerido por el inicializador context
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public NumberedLocationDAO getNumberedLocationDAO()
	{
		return this.numberedLocationDAO;
	}
	
	/**
	 * Metodo que sirve de enrutador para todas las peticiones relacionadas con ticket's, es necesario que el request tenga 
	 * el parametro mode valido
	 * @param request Objeto que representa la peticion al servidor
	 * @param response Objeto que representa la respuesta del servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HashMap<String, Object> myModel = new HashMap<String, Object>();
		switch (request.getParameter("mode"))
		{
			default: return newForm(myModel, request, response);
			case "insert": return insert(myModel, request, response);
			case "invoice": return invoice(myModel, request, response, Integer.parseInt(request.getParameter("code")));
		}
	}
	
	/**
	 * Maneja la peticion de crear el formulario para ingresar (comprar) un nuevo ticket
	 * @param myModel Objeto que representa el modelo de la aplicacion
	 * @param request Objeto que representa la peticion al servidor
	 * @param response Objeto que representa la respuesta del servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView newForm(HashMap<String, Object> myModel, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HashMap<String, Object> param;
		ArrayList<HashMap<String, Object>> params = new ArrayList<HashMap<String, Object>>();
		for (Object locationObject : locationDAO.findByEvent(Integer.parseInt(request.getParameter("event"))))
		{
			for (Object locationTypeObject : locationTypeDAO.find())
			{
				Location location = (Location)locationObject;
				LocationType locationType = (LocationType)locationTypeObject;
				if(location.getLocationTypeId() == locationType.getCode())
				{
					param = new HashMap<String, Object>();
					param.put("code", locationType.getCode());
					param.put("description", locationType.getDescription());
					param.put("numbered", location.getNumbered() ? " numerada" : "");
					param.put("quantity", location.getQuantity());
					param.put("available", location.getQuantity() - getNumberOfTicketsByEventAndLocation(location.getEvent(), location.getLocationTypeId()));
					params.add(param);
					break;
				}
			}
		}
		myModel.put("locations", params);
		myModel.put("event", eventDAO.findByCode(Integer.parseInt(request.getParameter("event"))));
		return new ModelAndView("ticketsNew", "model", myModel);
	}
	
	/**
	 * Maneja la peticion de ingresar (comprar) un nuevo ticket
	 * @param myModel Objeto que representa el modelo de la aplicacion
	 * @param request Objeto que representa la peticion al servidor
	 * @param response Objeto que representa la respuesta del servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView insert(HashMap<String, Object> myModel, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		customerDAO.save(new CustomerFactory().create(request.getParameter("txtCostumerId"), request.getParameter("txtCostumerName"), request.getParameter("txtCostumerAddress"), request.getParameter("txtCostumerTelephone"), request.getParameter("txtCostumerCardNumber"), request.getParameter("txtCostumerCardType")));
		Ticket ticket = new TicketFactory().create(new Random().nextInt(), Integer.parseInt(request.getParameter("txtLocationTypeId")), Integer.parseInt(request.getParameter("txtTicketEventId")), request.getParameter("txtCostumerId"), (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(Calendar.getInstance().getTime()), Integer.parseInt(request.getParameter("txtTicketQuantity")), 0);
		Location location = locationDAO.findById(ticket.getLocationTypeId(), ticket.getEventId());
		if (ticket.getQuantity() + getNumberOfTicketsByEventAndLocation(ticket.getEventId(), ticket.getLocationTypeId()) <= location.getQuantity())
		{
			ticket.setAmount(ticket.getQuantity() * location.getPrice());
			ticketDAO.save(ticket);
			if (location.getNumbered())
			{
				int offset = Integer.parseInt(request.getParameter("txtNumberedTicked"));
				if (offset > 1 && offset <= location.getQuantity())
				{
					int up = offset, down = offset - 1, needed = ticket.getQuantity();
					while (needed > 0)
					{
						if (up <= location.getQuantity())
						{
							if (!ticketExists(up, ticket.getEventId(), ticket.getLocationTypeId()))
							{
								numberedLocationDAO.save(new NumberedLocationFactory().create(up, ticket.getCode()));
								needed--;
							}
							up++;
							if (needed <= 0) break;
						}
						if (down > 0)
						{
							if (!ticketExists(down, ticket.getEventId(), ticket.getLocationTypeId()))
							{
								numberedLocationDAO.save(new NumberedLocationFactory().create(down, ticket.getCode()));
								needed--;
							}
							down--;
						}
					}
				}
			}
			
		}
		return invoice(myModel, request, response, ticket.getCode());
	}
	
	/**
	 * Mostrar la factura de un ticket ya comprado
	 * @param myModel Objeto que representa el modelo de la aplicacion
	 * @param request Objeto que representa la peticion al servidor
	 * @param response Objeto que representa la respuesta del servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView invoice(HashMap<String, Object> myModel, HttpServletRequest request, HttpServletResponse response, int ticketCode) throws ServletException, IOException
	{
		String eventCode = request.getParameter("event");
		Ticket ticket = ticketDAO.findByCode(ticketCode);
		myModel.put("ticket", ticket);
		myModel.put("customer", customerDAO.findById(ticket.getCustomerId()));
		myModel.put("event", eventDAO.findByCode(ticket.getEventId()));
		myModel.put("numberedLocations", numberedLocationDAO.findByTicketCode(ticketCode));
		myModel.put("link", eventCode == null ? "/event.htm?mode=listAll" : "/event.htm?mode=detail&code=" + eventCode);
		return new ModelAndView("ticketsInvoice", "model", myModel);
	}
	
	/**
	 * Obtiene el numero de ticket's ya comprados segun el evento y tipo de localidad
	 * @param eventId Codigo del evento a buscar
	 * @param locationId Id del tipo de localidad a buscar
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public int getNumberOfTicketsByEventAndLocation(int eventId, int locationId) throws ServletException, IOException
	{
		int numberOfTickets = 0;
		for (Object object : ticketDAO.findByEventAndLocation(eventId, locationId))
		{
			numberOfTickets += ((Ticket)object).getQuantity();
		}
		return numberOfTickets;
	}
	
		
	/**
	* Método que permite obtener la existencia de un ticket numerado
	* @return true si hay un ticket con la misma numeracion
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public boolean ticketExists(int locationNumber, int eventCode, int locationType)
	{
		for (Object ticket : ticketDAO.findByEventAndLocation(eventCode, locationType))
		{
			if (numberedLocationDAO.findById(locationNumber, ((Ticket)ticket).getCode()) != null)
			{
				return true;
			}
		}
		return false;
	}
}