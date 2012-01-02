package com.zy.action.location;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.zy.common.model.ZySchool;
import com.zy.facade.LocationFacade;

public class SchoolAction {
	
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
		List<ZySchool> schoolList = locationFacade.getSchoolsByKey(term);
		request.setAttribute("suggested", schoolList);
		return "location.school";
	}
}
