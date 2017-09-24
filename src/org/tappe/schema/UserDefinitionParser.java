package org.tappe.schema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class UserDefinitionParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected Class getBeanClass(Element element) {
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String namec = element.getAttribute("namec");
		String email = element.getAttribute("email");

		String url = element.getNamespaceURI();
		if (StringUtils.hasText(namec)) {
			builder.addPropertyValue("namec", namec);
		}

		if (StringUtils.hasText(email)) {
			builder.addPropertyValue("email", email);
		}

	}

}
