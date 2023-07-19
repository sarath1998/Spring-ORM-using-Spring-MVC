package com.seleniumexpress.selexplms.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SelExpLmsInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SelExpLmsConfig.class} ;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}
