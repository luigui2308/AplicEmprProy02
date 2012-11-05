package controller;

import java.util.*;
import java.io.IOException;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import model.*;
import javax.servlet.http.HttpSession;

public class EventController implements Controller
{
	private EventDAO eventDAO;
	private EventTypeDAO eventTypeDAO;
	private LocationTypeDAO locationTypeDAO;
	private LocationDAO locationDAO;
	private TicketDAO ticketDAO;
	
	public void setEventDAO(EventDAO eventDAO)
	{
		this.eventDAO = eventDAO;
	}
	public EventDAO getEventDAO()
	{
		return this.eventDAO;
	}
	
	public void setEventTypeDAO(EventTypeDAO eventTypeDAO)
	{
		this.eventTypeDAO = eventTypeDAO;
	}
	public EventTypeDAO getEventTypeDAO()
	{
		return this.eventTypeDAO;
	}
	
	public void setLocationTypeDAO(LocationTypeDAO locationTypeDAO)
	{
		this.locationTypeDAO = locationTypeDAO;
	}
	public LocationTypeDAO getLocationTypeDAO()
	{
		return this.locationTypeDAO;
	}
	
	public void setLocationDAO(LocationDAO locationDAO)
	{
		this.locationDAO = locationDAO;
	}
	public LocationDAO getLocationDAO()
	{
		return this.locationDAO;
	}
	
	public void setTicketDAO(TicketDAO ticketDAO)
	{
		this.ticketDAO = ticketDAO;
	}
	public TicketDAO getTicketDAO()
	{
		return this.ticketDAO;
	}
	
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
	
	public ModelAndView List() throws ServletException, IOException
	{
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("events", eventDAO.find());
		myModel.put("eventTypes", eventTypeDAO.find());
		return new ModelAndView("eventsListAll", "model", myModel);
	}
	
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

	public ModelAndView Insert(HttpServletRequest request) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		int promoterCode = (Integer)session.getAttribute("PromoterCode");			
		Event event = new Event();
		Random generator = new Random();
		event.setCode(generator.nextInt());
		event.setName(request.getParameter("name"));
		event.setEventTypeCode(Integer.parseInt(request.getParameter("eventType")));
		event.setArtists(request.getParameter("artists"));
		event.setDate(request.getParameter("date"));
		event.setPlace(request.getParameter("place"));
		event.setPromoterId(promoterCode);
		eventDAO.save(event);
		InsertLocations(request, event.getCode());
		return ListByPromoter(request);
	}
	
	public void InsertLocations(HttpServletRequest request, int eventCode)
	{
		try
		{
			Collection locationTypes = locationTypeDAO.find();
			Location location;
			for (Object object : locationTypes)
			{
				LocationType locationType = (LocationType)object;
				if (request.getParameter("locationType" + locationType.getCode()) != null)
				{
					location = new Location();
					location.setLocationTypeId(locationType.getCode());
					location.setEvent(eventCode);
					location.setPrice(Integer.parseInt(request.getParameter("locationPrice" + locationType.getCode())));
					location.setQuantity(Integer.parseInt(request.getParameter("locationQuantity" + locationType.getCode())));
					location.setNumbered(request.getParameter("locationNumbered" + locationType.getCode()) != null);
					locationDAO.save(location);
				}
			}
		}
		catch(Exception e){}
	}

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
	
	public ModelAndView Update(HttpServletRequest request) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		Event event = new Event();	
		int eventCode = Integer.parseInt(request.getParameter("code"));
		event.setCode(eventCode);
		event.setName(request.getParameter("name"));
		event.setEventTypeCode(Integer.parseInt(request.getParameter("eventType")));
		event.setArtists(request.getParameter("artists"));
		event.setDate(request.getParameter("date"));
		event.setPlace(request.getParameter("place"));
		event.setPromoterId((Integer)session.getAttribute("PromoterCode"));
		eventDAO.save(event);
		locationDAO.deleteByEvent(eventCode);
		InsertLocations(request, eventCode);
		return ListByPromoter(request);
	}

	public ModelAndView Delete(HttpServletRequest request) throws ServletException, IOException
	{
		Event event = new Event();
		int eventCode = Integer.parseInt(request.getParameter("code"));
		event.setCode(eventCode);
		locationDAO.deleteByEvent(eventCode);
		eventDAO.delete(event);
		return ListByPromoter(request);
	}

	public ModelAndView New(HttpServletRequest request) throws ServletException, IOException
	{
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("eventTypes", eventTypeDAO.find());
		myModel.put("locationTypes", locationTypeDAO.find());
		return new ModelAndView("eventsNew", "model", myModel);
	}
}