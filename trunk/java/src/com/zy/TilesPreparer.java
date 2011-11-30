package com.zy;

import org.apache.struts2.ServletActionContext;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;

import com.zy.common.util.TextUtil;

public class TilesPreparer implements ViewPreparer {

	public void execute(TilesRequestContext tilesContext, AttributeContext attributeContext) throws PreparerException {

		if (attributeContext.getAttribute("title") != null) {
			String titleKey = (String) attributeContext.getAttribute("title").getValue();

			// String title = titleKey;

			String title = "";
			try {
				// title = resource.getString(titleKey); albert modify
				title = TextUtil.getText(titleKey);
			} catch (Exception e) {
				title = titleKey + ":not found";
			}

			attributeContext.putAttribute("page.title", new Attribute(title));
			ServletActionContext.getRequest().setAttribute("page.title", title);
		}

		if (attributeContext.getAttribute("keywords") != null) {
			String keywordsKey = (String) attributeContext.getAttribute("keywords").getValue();

			// Get copy-writing from properties file
			String keywords = "";
			// Set key if copy-writing not found
			keywords = keywordsKey;
			if("page.keywords.default".equals(keywords)){
				keywords="";
			}
			attributeContext.putAttribute("page.keywords", new Attribute(keywords));
			ServletActionContext.getRequest().setAttribute("page.keywords", keywords);
		}

		if (attributeContext.getAttribute("description") != null) {
			String descriptionKey = (String) attributeContext.getAttribute("description").getValue();

			// Get copy-writing from properties file
			String description = "";
			// Set key if copy-writing not found
			description = descriptionKey;
			if("page.description.default".equals(description)){
				description="";
			}
			attributeContext.putAttribute("page.description", new Attribute(description));
			ServletActionContext.getRequest().setAttribute("page.description", description);
		}
	}

}