package com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import com.getTimings;

@SupportedAnnotationTypes("com.getTimings")
public class AnnotattionProcessor extends AbstractProcessor {

	public AnnotattionProcessor() {
	}
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		if (roundEnv.getElementsAnnotatedWith(getTimings.class) != null) {
			String name = annotations.getClass().getName();
			System.out.println("Name:" + name);
			processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, String.format("HEy"));
		}

		for (Element element : roundEnv.getElementsAnnotatedWith(getTimings.class)) {
			for (Method m : element.getClass().getDeclaredMethods()) {
				m.setAccessible(true);
				if (m.isAnnotationPresent(getTimings.class)) {
					System.out.println("Yse anooo present _Name:" + m);
					//saveStatusToFile("Do", LocalTime.now());
				}
			}
		}
		//saveStatusToFile("End", LocalTime.now());
		return true;
	}

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		saveStatusToFile("Started in pro", LocalTime.now());
	}

	public static void saveStatusToFile(String msg, LocalTime dt) {
		FileWriter fw = null;
		BufferedWriter be = null;
		try {
			fw = new FileWriter("C:\\Users\\omalve\\eclipse-workspace\\Assignment_CustomAnnotation\\src\\com\\data.txt", true);
			be = new BufferedWriter(fw);
			fw.write(msg + ":" + dt + "\nData Added\n");
			be.close();

		} catch (IOException e) {
			try {
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}