package com.designs.interior.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.designs.interior.entity.ClientQuotation;
import com.designs.interior.entity.Customer;
import com.designs.interior.entity.Design;
import com.designs.interior.entity.Designer;
import com.designs.interior.entity.Feedback;
import com.designs.interior.entity.Material;
import com.designs.interior.entity.OnlineCustomer;
import com.designs.interior.entity.SuperAdmin;
import com.designs.interior.remote.CustomerRemote;
import com.designs.interior.remote.DesignRemote;
import com.designs.interior.remote.DesignerRemote;
import com.designs.interior.remote.FeedbackRemote;
import com.designs.interior.remote.MaterialRemote;
import com.designs.interior.remote.OnlineCustomerRemote;
import com.designs.interior.remote.SuperAdminRemote;

@Controller
public class ClientController 
{
	@Autowired
	private DesignerRemote designerRemote;
	
	@Autowired
	private DesignRemote designRemote;
	
	@Autowired
	private MaterialRemote materialRemote;
	
	@Autowired
	private OnlineCustomerRemote onlineCustomerRemote;
	
	@Autowired
	private CustomerRemote customerRemote;
	
	@Autowired
	private FeedbackRemote feedbackRemote;
	
	@Autowired
	private SuperAdminRemote superAdminRemote;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/")
	public String homePage() 
	{
		return "redirect:home";
	}

	
	@GetMapping("/home")
	public ModelAndView navigateToHome() 
	{
		ModelAndView modelAndView = new ModelAndView("home");
		List<String> distinctDesigns = designRemote.getDistinctDesigns();
		modelAndView.addObject("allImageTypes", distinctDesigns);
		return modelAndView;
	}
	
	private String message;
	
	public String setValue(String m)
	{
		message = m;
		return "redirect:checkdesigner";
	}
	
	@GetMapping("/checkdesigner")
	public ModelAndView navigateToDesignerLoginPage()
	{
		ModelAndView modelAndView = new ModelAndView("designerLogin");
		modelAndView.addObject("msg", message);
		message = null;
		return modelAndView;
	}
//	
	@GetMapping("/loginErrorControl")
	public String loginErrorControllerMethod(@RequestParam("error") boolean condition)
	{
		setValue("Invalid Credentials");
		return "redirect:checkdesigner";
	}
	
	@GetMapping("logoutSuccessfull")
	public String logoutHandler(@RequestParam("error") boolean condition)
	{
		setValue("Log out successfull !");
		return "redirect:checkdesigner";
	}
	
//	@PostMapping("/designer")
//	public ModelAndView checkDesignerLogin(HttpServletRequest request)
//	{
//		ModelAndView modelAndView = new ModelAndView();
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		Designer designer = designerRemote.getDesignerDetails(username, password);
//		if(designer != null)
//		{
//			modelAndView.setViewName("adminHome");
//		}
//		else
//		{
//			modelAndView.addObject("errormsg", "Invalid Combination, please try again");
//			modelAndView.setViewName("designerLogin");
//		}
//		return modelAndView;
//	}
	
	@GetMapping("/images/{type}")
	public ModelAndView clientSideImageRendering(@PathVariable("type") String type) 
	{
		ModelAndView modelAndView = new ModelAndView("clientImages");
		List<Design> designs = designRemote.getImageTypeDesigns(type);
		modelAndView.addObject("typeDesigns", designs);
		modelAndView.addObject("thisDesign", type);
		List<String> distinctDesigns = designRemote.getDistinctDesigns();
		modelAndView.addObject("allImageTypes", distinctDesigns);
		return modelAndView;
	}
	
	@GetMapping("/image/view")
	public ResponseEntity<byte[]> displayprodimagedemo(@RequestParam("image") int id) throws IOException, SQLException
	{
	  Design design =  designRemote.getDesignTuple(id);
	  byte [] imageBytes = null;
	  imageBytes = design.getImage().getBytes(1,(int) design.getImage().length());

	  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}
	
	List<ClientQuotation> clientQuotations = new ArrayList<ClientQuotation>();
	
	@GetMapping("/customer/quotation/new")
	public ModelAndView navigateToCustomerQuotationHome()
	{
		ModelAndView modelAndView = new ModelAndView("onlineCustomerQuotation");
		List<Material> materials = materialRemote.getAllMaterials();
		clientQuotations = new ArrayList<ClientQuotation>();
		modelAndView.addObject("materialList", materials);
		return modelAndView;
	}
	
	@PostMapping("/customer/quotation/continue")
	public ModelAndView saveAOnlineQuotationComponent(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("onlineCustomerQuotationContd");
		List<Material> materials = materialRemote.getAllMaterials();
		modelAndView.addObject("materialList", materials);
		String name = request.getParameter("compname");
		name = name.toUpperCase();
		int height = Integer.parseInt(request.getParameter("compheight"));
		int width = Integer.parseInt(request.getParameter("compwidth"));
		int quantity = Integer.parseInt(request.getParameter("compquantity"));
		int area = (int) Math.ceil((height * width) / 144.0);
		int type = Integer.parseInt(request.getParameter("comptype"));
		Material material = materialRemote.findById(type);
		String materialType = material.getName();
		int price = material.getPrice();
		int minTotal = 0, maxTotal = 0;
		ClientQuotation quotation = new ClientQuotation();
		if(material.isVariesWithMeasurements())
		{
			quotation.setHeight(height);
			quotation.setWidth(width);
			quotation.setArea(area);
			minTotal = quantity * area * (material.getPrice() - 10);
			maxTotal = quantity * area * (material.getPrice() + 10);
		}
		else
		{
			quotation.setHeight(-1);
			quotation.setWidth(-1);
			quotation.setArea(-1);
			minTotal = quantity * (material.getPrice() - 1000);
			maxTotal = quantity * (material.getPrice() + 1000);
		}
		quotation.setMaterial(materialType);
		quotation.setMaxAmount(maxTotal);
		quotation.setMinAmount(minTotal);
		quotation.setName(name);
		quotation.setPrice(price);
		quotation.setQuantity(quantity);
		clientQuotations.add(quotation);
		modelAndView.addObject("addedList", clientQuotations);
		return modelAndView;
	}
	
	@GetMapping("/customer/details")
	public String getCustomerDetails()
	{
		return "onlineCustomer";
	}
	
	@PostMapping("/customer/quotationGeneration")
	public ModelAndView printCustomerQuotation(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("printOnlineCustomerQuotation");
		String name = request.getParameter("customerName");
		long number = Long.parseLong(request.getParameter("customerMobile"));
		String language = request.getParameter("language");
		OnlineCustomer onlineCustomer = new OnlineCustomer();
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String d = localDateTime.format(pattern);
		Date date = Date.valueOf(d);
		onlineCustomer.setName(name);
		onlineCustomer.setMobile(number);
		onlineCustomer.setLanguage(language);
		onlineCustomer.setDateQuotatedOn(date);
		onlineCustomer.setContacted(false);
		onlineCustomerRemote.addOnlineCustomer(onlineCustomer);
		modelAndView.addObject("customerDetails", onlineCustomer);
		modelAndView.addObject("allAdded", clientQuotations);
		int totalMin = 0, totalMax = 0;
		for(ClientQuotation clientQuotation : clientQuotations)
		{
			totalMax += clientQuotation.getMaxAmount();
			totalMin += clientQuotation.getMinAmount();
		}
		modelAndView.addObject("mintotal", totalMin);
		modelAndView.addObject("maxtotal", totalMax);
		return modelAndView;
	}
	
	@GetMapping("/customer/feedback")
	public ModelAndView navigateToCustomerFeedback()
	{
		ModelAndView modelAndView = new ModelAndView("feedback");
		List<Customer> customers = customerRemote.allCustomersSorted();
		List<Customer> customers2 = feedbackRemote.customersWithoutFeedback(customers);
		modelAndView.addObject("customerList", customers2);
		return modelAndView;
	}
	
	@PostMapping("/customer/submitfeedback")
	public ModelAndView takeFeedback(HttpServletRequest request)
	{
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String d = localDateTime.format(formatter);
		Date date = Date.valueOf(d);
		String cDetails = request.getParameter("customerdetails");
		String[] details = cDetails.split("™");
		int cid = Integer.parseInt(details[0]);
		String customerDetails = details[1];
		int quality = Integer.parseInt(request.getParameter("workquality"));
		int design = Integer.parseInt(request.getParameter("designsavail"));
		int colour = Integer.parseInt(request.getParameter("colourprecesion"));
		int changes = Integer.parseInt(request.getParameter("changesimpl"));
		int communication = Integer.parseInt(request.getParameter("communication"));
		String projectTimeline = request.getParameter("projecttimeline");
		String comments = request.getParameter("customerinput");
		comments = (comments.length() != 0) ? comments : null;
		Feedback feedback = new Feedback();
		feedback.setChangesRating(changes);
		feedback.setColourPrecesion(colour);
		feedback.setComments(comments);
		feedback.setCommunication(communication);
		feedback.setCustomerDetails(customerDetails);
		feedback.setCustomerId(cid);
		feedback.setDesignRating(design);
		feedback.setQuality(quality);
		feedback.setTimeLine(projectTimeline);
		feedback.setDate(date);
		feedbackRemote.addFeedback(feedback);
		ModelAndView modelAndView = new ModelAndView("feedbackSuccess");
		return modelAndView;
	}
	
	@GetMapping("/builtBy")
	public String navigateToMadeBy() 
	{
		return "madeBy";
	}
	
	@GetMapping("/superuser/home")
	public ModelAndView navigateToSuperUserPage()
	{
		ModelAndView modelAndView = new ModelAndView("superUserHome");
		modelAndView.addObject("msg", msg);
		msg = null;
		return modelAndView;
	}
	
	private String msg = null;
	
	public void addMessage(String m)
	{
		msg = m;
	}
	
	@PostMapping("/superuser/add/admin")
	public String addSuperAdmin(HttpServletRequest request)
	{
		String suname = request.getParameter("superadminuname");
		String spwd = request.getParameter("superadminpwd");
		String nuname = request.getParameter("newadminuname");
		String npwd = request.getParameter("newadminpwd");
//		spwd = new BCryptPasswordEncoder().encode(spwd);
		System.out.println(spwd);
		SuperAdmin superAdmin = superAdminRemote.getSuperAdminDetails(suname, spwd);
		if(superAdmin == null)
		{
			addMessage("Invalid Super User");
			return "redirect:/superuser/home";
		}
		Designer designer = new Designer();
		designer.setUsername(nuname);
		designer.setPassword(npwd);
		designerRemote.addNewDesigner(designer);
		addMessage("New Added Successfully");
		return "redirect:/superuser/home";
	}
}
