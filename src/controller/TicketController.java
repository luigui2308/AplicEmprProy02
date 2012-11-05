package controller;

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
import model.*;

public class TicketController implements Controller
{
	private EventDAO eventDAO;
	private TicketDAO ticketDAO;
	private CustomerDAO customerDAO;
	private LocationDAO locationDAO;
	private LocationTypeDAO locationTypeDAO;
	private NumberedLocationDAO numberedLocationDAO;

	public void setEventDAO(EventDAO eventDAO)
	{
		this.eventDAO = eventDAO;
	}
	public EventDAO getEventDAO()
	{
		return this.eventDAO;
	}
	
	public void setTicketDAO(TicketDAO ticketDAO)
	{
		this.ticketDAO = ticketDAO;
	}
	public TicketDAO getTicketDAO()
	{
		return this.ticketDAO;
	}
	
	public void setCustomerDAO(CustomerDAO customerDAO)
	{
		this.customerDAO = customerDAO;
	}
	public CustomerDAO getCustomerDAO()
	{
		return this.customerDAO;
	}
	
	public void setLocationDAO(LocationDAO locationDAO)
	{
		this.locationDAO = locationDAO;
	}
	public LocationDAO getLocationDAO()
	{
		return this.locationDAO;
	}
	
	public void setLocationTypeDAO(LocationTypeDAO locationTypeDAO)
	{
		this.locationTypeDAO = locationTypeDAO;
	}
	public LocationTypeDAO getLocationTypeDAO()
	{
		return this.locationTypeDAO;
	}
	
	public void setNumberedLocationDAO(NumberedLocationDAO numberedLocationDAO)
	{
		this.numberedLocationDAO = numberedLocationDAO;
	}
	public NumberedLocationDAO getNumberedLocationDAO()
	{
		return this.numberedLocationDAO;
	}
	
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
	
	public ModelAndView newForm(HashMap<String, Object> myModel, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HashMap param;
		List<HashMap> params = new ArrayList<HashMap>();
		for (Object locationObject : locationDAO.findByEvent(Integer.parseInt(request.getParameter("event"))))
		{
			for (Object locationTypeObject : locationTypeDAO.find())
			{
				Location location = (Location)locationObject;
				LocationType locationType = (LocationType)locationTypeObject;
				if(location.getLocationTypeId() == locationType.getCode())
				{
					param = new HashMap();
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
	
	public ModelAndView insert(HashMap<String, Object> myModel, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		customerDAO.save(new Customer(request.getParameter("txtCostumerId"), request.getParameter("txtCostumerName"), request.getParameter("txtCostumerAddress"), request.getParameter("txtCostumerTelephone"), request.getParameter("txtCostumerCardNumber"), request.getParameter("txtCostumerCardType")));
		Ticket ticket = new Ticket(new Random().nextInt(), Integer.parseInt(request.getParameter("txtLocationTypeId")), Integer.parseInt(request.getParameter("txtTicketEventId")), request.getParameter("txtCostumerId"), (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(Calendar.getInstance().getTime()), Integer.parseInt(request.getParameter("txtTicketQuantity")), 0);
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
							numberedLocationDAO.save(new NumberedLocation(up, ticket.getCode()));
							needed--;
							up++;
							if (needed <= 0) break;
						}
						if (down > 0)
						{
							numberedLocationDAO.save(new NumberedLocation(down, ticket.getCode()));
							needed--;
							down--;
						}
					}
				}
			}
		}
		return invoice(myModel, request, response, ticket.getCode());
	}
	
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
	
	public int getNumberOfTicketsByEventAndLocation(int eventId, int locationId) throws ServletException, IOException
	{
		int numberOfTickets = 0;
		for (Object object : ticketDAO.findByEventAndLocation(eventId, locationId))
		{
			numberOfTickets += ((Ticket)object).getQuantity();
		}
		return numberOfTickets;
	}
}