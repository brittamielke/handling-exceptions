//ExceptionHandlingController.java
package com.lmig.gfc.exceptionHandling.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ExceptionHandlingController {

	@GetMapping("/")
	public String showForm() {
		return "exceptionHandling/default";
	}

	@PostMapping("/handleString")
	public ModelAndView handleString(String probablySomeText) {
		ModelAndView mv = new ModelAndView("exceptionHandling/default");
		try {
			mv.addObject("stringResult", probablySomeText.substring(4));
		} catch (IndexOutOfBoundsException ioobe) {
			mv.addObject("stringResult", "string should be four characters");
		} catch (Exception e) {
			mv.addObject("stringResult", "Unspecified Error Occurred");
		}
		return mv;
	}

	@PostMapping("/handleUrl")
	public ModelAndView handleUrl(String probablyAUrl) throws MalformedURLException {
		ModelAndView mv = new ModelAndView("exceptionHandling/default");

		try {
			mv.addObject("urlResult", new URL(probablyAUrl));
		} catch (MalformedURLException mue) {
			mv.addObject("urlResult", "not a valid URL");
		} catch (Exception e) {
			mv.addObject("urlResult", "Unspecified Error Occurred");
		}
		return mv;
	}

	@PostMapping("/handleInteger")
	public ModelAndView handleInteger(String probablyAnInteger) {
		ModelAndView mv = new ModelAndView("exceptionHandling/default");
		
		 try {
		mv.addObject("integerResult", Integer.parseInt(probablyAnInteger));
		 } catch (NumberFormatException nfe) {
		 mv.addObject("integerResult", "not an integer");
		 } catch (Exception e) {
		 mv.addObject("integerResult", "Unspecified Error Occurred");
		 }
		return mv;
	}

	@PostMapping("/handleDecimal")
	public ModelAndView handleDecimal(String probablyADecimal) {
		ModelAndView mv = new ModelAndView("exceptionHandling/default");
		
		 try {
		 mv.addObject("decimalResult", Double.parseDouble(probablyADecimal));
		 } catch (NullPointerException npe) {
		 mv.addObject("decimalResult", "not a decimal");
		 } catch (NumberFormatException nfe) {
			 mv.addObject("decimalResult", "not a decimal");
		 } catch (Exception e) {
		 mv.addObject("decimalResult", "Unspecified Error Occurred");
		 }
		return mv;
	}

	@PostMapping("/handleDate")
	public ModelAndView handleDate(String probablyADate) {
		ModelAndView mv = new ModelAndView("exceptionHandling/default");
		
		 try {
			 mv.addObject("dateResult", LocalDate.parse(probablyADate));
		 } catch (DateTimeParseException  dtpe) {
		 mv.addObject("dateResult", "not a date");
		 } catch (Exception e) {
		 mv.addObject("dateResult", "Unspecified Error Occurred");
		 }
		return mv;
	}

}
