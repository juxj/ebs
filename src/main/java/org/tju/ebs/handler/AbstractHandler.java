package org.tju.ebs.handler;

import static org.tju.ebs.utils.ErrorMessageBundle.getString;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.tju.ebs.utils.PageHeader;
import org.tju.ebs.utils.StringUtil;


public abstract class AbstractHandler {

	private final String PAGE_HEADER_PREFIX="header.";
	private final String PAGE_HEADER_TITLE = ".title";
	private final String PAGE_HEADER_KEYWORDS = ".keywords";
	private final String PAGE_HEADER_DESCRPTION= ".desc";
	protected final int PAGE_SIZE = 20;
	
	protected ModelAndView getModelAndView(String pageName) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageHeader", this.getHeader(pageName));
		return mav;
	}
	
	private PageHeader getHeader(String pageName) {
		// set return value;
		PageHeader header = new PageHeader();
		// get value from message.properties
		pageName = this.PAGE_HEADER_PREFIX+ pageName.toLowerCase();
		
		String title = getString(pageName + this.PAGE_HEADER_TITLE);
		String keywords = getString(pageName+this.PAGE_HEADER_KEYWORDS);
		String description = getString(pageName + this.PAGE_HEADER_DESCRPTION);
		
		header.setDescription(description);
		header.setKeywords(keywords);
		header.setTitle(title);
		
		return header;
	}
}
