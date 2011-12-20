package com.zy.action.location;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.zy.common.model.ZyCity;
import com.zy.facade.LocationFacade;

public class LocationAction {
	
	private LocationFacade locationFacade;
	
	public LocationFacade getLocationFacade() {
		return locationFacade;
	}

	public void setLocationFacade(LocationFacade locationFacade) {
		this.locationFacade = locationFacade;
	}

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String term = request.getParameter("term");
		System.out.println("------auto complete: " + term);
		List<ZyCity> cityList = locationFacade.getCitiesByKey(term);
		request.setAttribute("suggested", cityList);
		return "location.city";
	}
}
