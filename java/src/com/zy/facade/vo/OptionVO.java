package com.zy.facade.vo;

import java.util.List;

import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyProfile;

public class OptionVO {
	private ZyAnsweroption option;
	private List<ZyProfile> optionProfiles;
	private boolean selected;
	public ZyAnsweroption getOption() {
		return option;
	}
	public List<ZyProfile> getOptionProfiles() {
		return optionProfiles;
	}
	public void setOption(ZyAnsweroption option) {
		this.option = option;
	}
	public void setOptionProfiles(List<ZyProfile> optionProfiles) {
		this.optionProfiles = optionProfiles;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}


}
