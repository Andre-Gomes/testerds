package br.com.testerd.binding;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalBindingInitializer {
  
	
  @InitBinder
  public void registerCustomEditors(WebDataBinder binder, WebRequest request) {
	//Binder para valores monetários BigDecimal
	binder.registerCustomEditor(BigDecimal.class, new  CustomNumberEditor(BigDecimal.class, NumberFormat.getNumberInstance(new Locale("pt", "BR")), true));
  }
}
