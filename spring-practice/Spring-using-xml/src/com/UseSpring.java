package com;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 
 * @author omalve This class is demonstration of basic spring
 *
 */

public class UseSpring {

	public static void main(String[] args) {
		Resource rs = new ClassPathResource("applicationContext.xml");
		BeanFactory bf = new XmlBeanFactory(rs);
		Student st = (Student)	bf.getBean("studentbean");
		st.displayInfo();
	}

}
