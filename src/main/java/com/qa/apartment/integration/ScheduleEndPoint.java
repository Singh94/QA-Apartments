package com.qa.apartment.integration;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.apartment.business.ScheduleDBImple;
import com.qa.apartment.util.JSONUtil;

@Path("/schedule")
public class ScheduleEndPoint {

	@Inject
	private ScheduleDBImple impl;
	@Inject
	private JSONUtil util;
	
	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getAllSchedules() {
		return impl.findAllSchedules();
	}
	
	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getSchedule(@PathParam("id") Long id) {
		return impl.findSchedule(id);
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewBookToMap(String schedule) {
		return impl.createScheduleFromString(schedule);
	}

	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteSchedule(@PathParam("id") Integer id) {
		return impl.deleteSchedule(id);
	}
	
	@PUT
	@Path("/json")
	@Produces({"application/json"})
	public String updateSchedule(@PathParam("id") Long id,String schedule) {
		return updateSchedule(id, schedule);
	}
	
}
