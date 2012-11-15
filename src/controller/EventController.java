package controller;

import data.*;
import model.*;
import java.util.*;
import java.io.IOException;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.servlet.http.HttpSession;

/**
* Clase controladora para la entidad Event.
* Se encarga de procesar todas las solicitudes de una entidad Event, Insert, Update, Delete y List.
* @see Event
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public class EventController implements Controller
{
	private EventDAO eventDAO;
	private EventTypeDAO eventTypeDAO;
	private LocationTypeDAO locationTypeDAO;
	private LocationDAO locationDAO;
	private TicketDAO ticketDAO;
	
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
	* @param eventTypeDAO nuevo valor para el DAO
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void setEventTypeDAO(EventTypeDAO eventTypeDAO)
	{
		this.eventTypeDAO = eventTypeDAO;
	}
	
	/**
	* Obtiene el valor de un DAO, este metodo es requerido por el inicializador context
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public EventTypeDAO getEventTypeDAO()
	{
		return this.eventTypeDAO;
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
	* Metodo que sirve de enrutador para todas las peticiones relacionadas con event's, es necesario que el request tenga 
	* el parametro mode valido
	* @param request Objeto que representa la peticion al servidor
	* @param response Objeto que representa la respuesta del servidor
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		switch (request.getParameter("mode"))
		{
			case "new": return New(request);
			case "detail": return Detail(request);
			case "update": return Update(request);
			case "insert": return Insert(request);
			case "delete": return Delete(request);
			case "byPromoter": return ListByPromoter(request);
			default: return List();
		}
	}
	
	/**
	* Metodo para manejar la petición de obtener todos los eventos del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public ModelAndView List() throws ServletException, IOException
	{
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("events", eventDAO.find());
		myModel.put("eventTypes", eventTypeDAO.find());
		return new ModelAndView("eventsListAll", "model", myModel);
	}
	
	/**
	* Metodo para manejar la petición de listar los eventos de un promotor
	* @param request Objeto que representa la peticion al servidor
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public ModelAndView ListByPromoter(HttpServletRequest request) throws ServletException, IOException
	{
		Map<String, Object> myModel = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		Object promoter = session.getAttribute("Promoter");
		if (promoter != null && (Boolean)promoter)
		{
			int codigoPromotor = (Integer)request.getSession(false).getAttribute("PromoterCode");
			myModel.put("events", eventDAO.findByPromoter(codigoPromotor));
			myModel.put("eventTypes", eventTypeDAO.find());
			return new ModelAndView("eventsListByPromoter", "model", myModel);
		}
		else
		{
			myModel.put("error", "Acceso denegado");
			return new ModelAndView("login", "model", myModel);
		}
	}

	/**
	* Metodo que permite manejar la petición para insertar un Evento
	* @param request Objeto que representa la peticion al servidor
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public ModelAndView Insert(HttpServletRequest request) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		int eventCode = new Random().nextInt();
		eventDAO.save(new EventFactory().create(eventCode, request.getParameter("name"), Integer.parseInt(request.getParameter("eventType")), request.getParameter("artists"), request.getParameter("date"), request.getParameter("place"), (Integer)session.getAttribute("PromoterCode")));
		InsertLocations(request, eventCode);
		return ListByPromoter(request);
	}

	/**
	* Metodo que permite insertar las localidades de un evento a partir del request.
	* @param request Objeto que representa la peticion al servidor
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void InsertLocations(HttpServletRequest request, int eventCode) throws ServletException, IOException 
	{
		Collection locationTypes = locationTypeDAO.find();
		Location location;
		for (Object object : locationTypes)
		{
			LocationType locationType = (LocationType)object;
			if (request.getParameter("locationType" + locationType.getCode()) != null)
			{
				locationDAO.save(new LocationFactory().create(locationType.getCode(), eventCode, Integer.parseInt(request.getParameter("locationPrice" + locationType.getCode())), Integer.parseInt(request.getParameter("locationQuantity" + locationType.getCode())), request.getParameter("locationNumbered" + locationType.getCode()) != null));
			}
		}
	}

	/**
	* Metodo que permite manejar la petición de obtener la información de un Evento
	* @param request Objeto que representa la peticion al servidor
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public ModelAndView Detail(HttpServletRequest request) throws ServletException, IOException
	{
		int eventCode = Integer.parseInt(request.getParameter("code"));
		Event event = eventDAO.findByCode(eventCode);		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("event", event);
		myModel.put("eventTypes", eventTypeDAO.find());
		myModel.put("locationTypes", locationTypeDAO.find());
		myModel.put("locationsEvent", locationDAO.findByEvent(eventCode));
		myModel.put("ticketsEvent", ticketDAO.findByEvent(eventCode));
		return new ModelAndView("eventsDetail", "model", myModel);
	}
	
	/**
	* Metodo para manejar la petición de actualizar un evento.
	* @param request Objeto que representa la peticion al servidor
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public ModelAndView Update(HttpServletRequest request) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		int eventCode = Integer.parseInt(request.getParameter("code"));
		eventDAO.save(new EventFactory().create(eventCode, request.getParameter("name"), Integer.parseInt(request.getParameter("eventType")), request.getParameter("artists"), request.getParameter("date"), request.getParameter("place"), (Integer)session.getAttribute("PromoterCode")));
		locationDAO.deleteByEvent(eventCode);
		InsertLocations(request, eventCode);
		return ListByPromoter(request);
	}

	/**
	* Metodo que maneja la petición de eliminar un Evento
	* @param request Objeto que representa la peticion al servidor
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public ModelAndView Delete(HttpServletRequest request) throws ServletException, IOException
	{
		int eventCode = Integer.parseInt(request.getParameter("code"));
		locationDAO.deleteByEvent(eventCode);
		eventDAO.delete(new EventFactory().create(eventCode, null, 0, null, null, null, 0));
		return ListByPromoter(request);
	}

	/**
	* Maneja la peticion de crear el formulario para ingresar un nuevo Evento
	* @param request Objeto que representa la peticion al servidor
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public ModelAndView New(HttpServletRequest request) throws ServletException, IOException
	{
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("eventTypes", eventTypeDAO.find());
		myModel.put("locationTypes", locationTypeDAO.find());
		return new ModelAndView("eventsNew", "model", myModel);
	}
}