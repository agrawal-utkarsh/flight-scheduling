package agrawal.utkarsh.flight_schedulling;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;
@Path("by")
public class by 
{
/*
 * the purpose of this class is to provide a url that enables lookup of all flights on that day just like codechef allows
 * user lookups
 * */
	
	
	record r=new record();
	@GET
	@Path("view")
	@Produces(MediaType.APPLICATION_JSON)
	public List<record> view()
	{
		return r.viewall();
	}	

	@GET
	@Path("view/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<record> view(@PathParam("date")String date)
	{
		return r.view(date);
		//do i need servlet from here on since i can do my work from normal java class ??
					//and how do i call servlet from here
		//ans - i don't
	}	
	@POST
	@Path("insert")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertt(record rr)
	{
		int res=r.insert(rr.getDate(),rr.getTime(),rr.getName(),rr.getPhone());
		if(res==1)return "success";
		else return "failure";
	}
	
}

