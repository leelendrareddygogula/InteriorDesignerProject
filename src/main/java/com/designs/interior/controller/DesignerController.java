package com.designs.interior.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.designs.interior.entity.Bill;
import com.designs.interior.entity.BillSummary;
import com.designs.interior.entity.Customer;
import com.designs.interior.entity.Design;
import com.designs.interior.entity.DesignType;
import com.designs.interior.entity.Feedback;
import com.designs.interior.entity.Imports;
import com.designs.interior.entity.ImportsQuotation;
import com.designs.interior.entity.ImportsQuotationSummary;
import com.designs.interior.entity.Material;
import com.designs.interior.entity.NQBill;
import com.designs.interior.entity.NQBillSummary;
import com.designs.interior.entity.OnlineCustomer;
import com.designs.interior.entity.Quotation;
import com.designs.interior.entity.QuotationImage;
import com.designs.interior.remote.BillRemote;
import com.designs.interior.remote.BillSummaryRemote;
import com.designs.interior.remote.CustomerRemote;
import com.designs.interior.remote.DesignRemote;
import com.designs.interior.remote.DesignTypeRemote;
import com.designs.interior.remote.FeedbackRemote;
import com.designs.interior.remote.ImportsQuotationRemote;
import com.designs.interior.remote.ImportsQuotationSummaryRemote;
import com.designs.interior.remote.ImportsRemote;
import com.designs.interior.remote.MaterialRemote;
import com.designs.interior.remote.NQBillRemote;
import com.designs.interior.remote.NQBillSummaryRemote;
import com.designs.interior.remote.OnlineCustomerRemote;
import com.designs.interior.remote.QuotationImagesRemote;
import com.designs.interior.remote.QuotationRemote;

@Controller
@RequestMapping(path = "/designer")
@Async
public class DesignerController 
{
	@Autowired
	private DesignTypeRemote designTypeRemote;
	
	@Autowired
	private DesignRemote designRemote;
	
	@Autowired
	private QuotationRemote quotationRemote;
	
	@Autowired
	private CustomerRemote customerRemote;
	
	@Autowired
	private QuotationImagesRemote quotationImagesRemote;
	
	@Autowired
	private BillRemote billRemote;
	
	@Autowired
	private BillSummaryRemote billSummaryRemote;
	
	@Autowired
	private NQBillRemote nqBillRemote;
	
	@Autowired
	private NQBillSummaryRemote nqBillSummaryRemote;
	
	@Autowired
	private MaterialRemote materialRemote;
	
	@Autowired
	private OnlineCustomerRemote onlineCustomerRemote;
	
	@Autowired
	private FeedbackRemote feedbackRemote;
	
	@Autowired
	private ImportsRemote importsRemote;
	
	@Autowired
	private ImportsQuotationRemote importsQuotationRemote;
	
	@Autowired
	private ImportsQuotationSummaryRemote importsQuotationSummaryRemote;
	
	@GetMapping("/")
	public String designerHome()
	{
		return "adminHome";
	}
	
	@GetMapping("/designerHome")
	public String deignerHomeNavigation()
	{
//		return "redirect:";
		return "adminHome";
	}
	
	@GetMapping("/addNewImageType")
	public ModelAndView navigateToAddNewImageType()
	{
		ModelAndView modelAndView = new ModelAndView("addImageType");
		List<DesignType> designTypes = designTypeRemote.getAllDesignTypes();
		modelAndView.addObject("designtypes", designTypes);
		return modelAndView;
	}
	
	@PostMapping("/addImageType")
	public ModelAndView addNewImageComponent(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addImageType");
		String component = request.getParameter("newcomponent");
		component.toLowerCase();
		component = StringUtils.capitalize(component);
		DesignType designType = new DesignType();
		designType.setName(component);
		String s = designTypeRemote.addNewImageComponent(designType);
		modelAndView.addObject("msg", s);
		List<DesignType> designTypes = designTypeRemote.getAllDesignTypes();
		modelAndView.addObject("designtypes", designTypes);
		return modelAndView;
	}
	
	@GetMapping("/deleteComponent")
	public String designTypeComponentDeletion(@RequestParam("compid") int cid)
	{
		designTypeRemote.deleteComponent(cid);
		return "redirect:addNewImageType";
	}
	
	@GetMapping("/imageupload")
	public ModelAndView navigateToImageUpload()
	{
		 ModelAndView modelAndView =  new ModelAndView("newImageUpload");
		 modelAndView.addObject("imageTypesList", designTypeRemote.getAllDesignTypes());
		 return modelAndView;
	}
	
	
	@PostMapping("/addImage")
	public ModelAndView uploadAImage(@RequestParam("designimage") MultipartFile multipartFile, HttpServletRequest request) throws IOException, SerialException, SQLException
	{
		ModelAndView modelAndView = new ModelAndView("newImageUpload");
		modelAndView.addObject("imageTypesList", designTypeRemote.getAllDesignTypes());
		Design design = new Design();
		String name = request.getParameter("designname");
		name.toLowerCase();
		name = StringUtils.capitalize(name);
		String type = request.getParameter("imagedesignType");
		if(type.equals("---select---"))
		{
			modelAndView.addObject("ermsg", "Invalid image type, please select valid image type");
			return modelAndView;
		}
//		System.out.println(multipartFile.getSize());
		if(multipartFile.getSize() > 1048570)
		{
			
			modelAndView.addObject("ermsg", "File size is too big, Try with image size less than 1 MB");
			return modelAndView;
		}
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String date = localDateTime.format(pattern); 
		Date date2 = Date.valueOf(date);
		byte[] bytes = multipartFile.getBytes();
		Blob blob = new SerialBlob(bytes);
		
		design.setName(name);
		design.setType(type);
		design.setDateUploaded(date2);
		design.setImage(blob);
		
		String s = "";
		try
		{
			s = designRemote.insertNewDesign(design);
		}
		catch (FileSizeLimitExceededException fileSizeLimitExceededException) 
		{
			s = "File size is too big, Try with image size less than 1 MB";
		}
		catch (MaxUploadSizeExceededException maxUploadSizeExceededException) {
			s = "File size is too big, Try with image size less than 1 MB";
		}
		catch(MultipartException multipartException)
		{
			s = "File size is too big, Try with image size less than 1 MB";
		}
		catch(IllegalStateException illegalStateException)
		{
			s = "File size is too big, Try with image size less than 1 MB";
		}
		modelAndView.addObject("imagemsg", s);
		return modelAndView;
	}
	
	@GetMapping("/viewAllImages")
	public ModelAndView navigateToImagesHome() 
	{
		ModelAndView modelAndView = new ModelAndView("designerSideImages");
		List<Design> designs = designRemote.getAllDesigns();
		modelAndView.addObject("allimages", designs);
		return modelAndView;
	}
	
	@GetMapping("/displayImage")
	public ResponseEntity<byte[]> displayprodimagedemo(@RequestParam("iid") int id) throws IOException, SQLException
	{
	  Design design =  designRemote.getDesignTuple(id);
	  byte [] imageBytes = null;
	  imageBytes = design.getImage().getBytes(1,(int) design.getImage().length());

	  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}
	
	@GetMapping("/deleteImage")
	public String deleteAnImage(@RequestParam("imgid") int id)
	{
		designRemote.deleteDesign(id);
		return "redirect:viewAllImages";
	}
	
	private List<Quotation> quotationsSaved = new ArrayList<Quotation>();
	
	@GetMapping("/newQuotation")
	public ModelAndView navigateToNewQuotation()
	{
		ModelAndView modelAndView = new ModelAndView("newQuotationPage");
		quotationsSaved = new ArrayList<Quotation>();
		return modelAndView;
	}
	
	public List<Quotation> allQuotationComponents(Quotation quotation) 
	{
		quotationsSaved.add(quotation);
		return quotationsSaved;
	}
	
	@PostMapping("/addComponent")
	public ModelAndView addNewComponent(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		String name = request.getParameter("componentname");
		name = name.toUpperCase();
		int height = Integer.parseInt(request.getParameter("height"));
		int width = Integer.parseInt(request.getParameter("width"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		double area = (height * width) / 144.0;
		int rounded_area = (int) Math.ceil(area);
		int total = rounded_area * quantity * price;
		Quotation quotation = new Quotation();
		quotation.setArea(rounded_area);
		quotation.setHeight(height);
		quotation.setName(name);
		quotation.setPrice(price);
		quotation.setQuantity(quantity);
		quotation.setTotal(total);
		quotation.setWidth(width);
		List<Quotation> q = allQuotationComponents(quotation);
		modelAndView.addObject("previousComponents", q);
		modelAndView.setViewName("continueQuotation");
		return modelAndView;
	}
	
	@GetMapping("/saveQuotation")
	public ModelAndView saveQuotationTillNow()
	{
		ModelAndView modelAndView = new ModelAndView("customerDetails");
		int quotationId  = customerRemote.maxQuotationIdTillNow();
		int totalSum = 0;
		for(Quotation quotation : quotationsSaved)
		{
			quotation.setQuotationId(quotationId);
			totalSum += quotation.getTotal();
		}
		
		modelAndView.addObject("quotid", quotationId);
		modelAndView.addObject("totSum", totalSum);
		modelAndView.addObject("savedquotns", quotationsSaved);
		return modelAndView;
	}
	
	@PostMapping("/mapCustomer")
	public ModelAndView addCustomerToQuotation(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("viewQuotations");
		String name = request.getParameter("custname");
		name = name.toUpperCase();
		long phnNum = Long.parseLong(request.getParameter("custcontact"));
		String address = request.getParameter("custaddress");
		address = StringUtils.capitalize(address);
		String panorgstin = request.getParameter("custpan");
		panorgstin = panorgstin.toUpperCase();
		String contactPer = request.getParameter("contactperson");
		contactPer = contactPer.toUpperCase();
		int finalizedAmount = Integer.parseInt(request.getParameter("finalizedTotal"));
		int qid = Integer.parseInt(request.getParameter("quotationid"));
		int totalSum = Integer.parseInt(request.getParameter("grandTotal"));
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String d = localDateTime.format(pattern); 
		Date date = Date.valueOf(d);
		for(Quotation quotation : quotationsSaved)
		{
			quotationRemote.addAQuotationComponent(quotation);
		}
		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setContact(phnNum);
		customer.setCalculatedTotal(totalSum);
		customer.setEstimatedTotal(finalizedAmount);
		customer.setName(name);
		customer.setOnBoardedBy(contactPer);
		customer.setPANOrGSTIN(panorgstin);
		customer.setQuotationDate(date);
		customer.setQuotationId(qid);
		customer.setRemainingBalance(finalizedAmount);
		String s = customerRemote.addNewCustomer(customer);
		modelAndView.addObject("quotAndCustMsg", s);
		List<Customer> customers = customerRemote.allCustomersSorted();
		modelAndView.addObject("customersList", customers);
		return modelAndView;
	}
	
	@GetMapping("/allQuotations")
	public ModelAndView getAllQuotations()
	{
		ModelAndView modelAndView = new ModelAndView("viewQuotations");
		List<Customer> customers = customerRemote.allCustomersSorted();
		modelAndView.addObject("customersList", customers);
		return modelAndView;
	}
	
	@GetMapping("/printQuotation/{quotid}")
	public ModelAndView printQuotation(@PathVariable("quotid") int quotId)
	{
		ModelAndView modelAndView = new ModelAndView();
		List<Quotation> quotations = quotationRemote.getCustomerQuotationBasedOnQId(quotId);
		modelAndView.addObject("quotList", quotations);
		Customer customer = customerRemote.getCustomerDetailsOnQuotationId(quotId);
		modelAndView.addObject("customerDetails", customer);
		modelAndView.setViewName("printQuotation");
		return modelAndView;
	}
	
	@GetMapping("/viewQuotation/{quotid}")
	public ModelAndView operationsOnQuotation(@PathVariable("quotid") int id)
	{
		ModelAndView modelAndView = new ModelAndView("quotationOperations");
		List<Quotation> quotations = quotationRemote.getCustomerQuotationBasedOnQId(id);
		modelAndView.addObject("qid", id);
		Customer customer = customerRemote.getCustomerDetailsOnQuotationId(id);
		modelAndView.addObject("customerDetails", customer);
		modelAndView.addObject("quotComponents", quotations);
		return modelAndView;
	}
	
	@GetMapping("/deleteComponent/{cid}/{qid}")
	public String deleteQuotationComponent(@PathVariable("cid") int compId, @PathVariable("qid") int quotId)
	{
		Quotation quotation = quotationRemote.findQuotationBasedOnComponentId(compId);
		int componentTotal = quotation.getTotal();
		Customer customer = customerRemote.getCustomerDetailsOnQuotationId(quotId);
		int balance = customer.getRemainingBalance() - componentTotal;
		int totalPrice = customer.getEstimatedTotal() - componentTotal;
		int calculatedTotal = customer.getCalculatedTotal() - componentTotal;
		customer.setEstimatedTotal(totalPrice);
		customer.setRemainingBalance(balance);
		customer.setCalculatedTotal(calculatedTotal);
		customerRemote.addNewCustomer(customer); //Updates Customer Record with new balance and total
		quotationRemote.deleteComponent(compId);
		return "redirect:/designer/viewQuotation/" + Integer.toString(quotId);  
	}
	
	@GetMapping("/modifyQuotationComponent/{cid}/{qid}")
	public ModelAndView modifyAQuotationComponent(@PathVariable("cid") int compId, @PathVariable("qid") int quotId)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("modifyQuotationComponent");
		Quotation quotation = quotationRemote.findQuotationBasedOnComponentId(compId);
		modelAndView.addObject("quotComponent", quotation);
		return modelAndView;
	}
	
	@PostMapping("/saveModifiedComponent/{cid}/{qid}")
	public String saveModifiedQuotationComponent(HttpServletRequest request, @PathVariable("cid") int compId, @PathVariable("qid") int quotId) 
	{
		int height = Integer.parseInt(request.getParameter("compheight"));
		int width = Integer.parseInt(request.getParameter("compwidth"));
		int quantity = Integer.parseInt(request.getParameter("compquantity"));
		int price = Integer.parseInt(request.getParameter("compprice"));
		double area = (height * width) / 144.0;
		int rounded_area = (int) Math.ceil(area);
		int total = rounded_area * quantity * price;
		Quotation quotation = quotationRemote.findQuotationBasedOnComponentId(compId);
		Customer customer = customerRemote.getCustomerDetailsOnQuotationId(quotId);
		int previousTotal = quotation.getTotal();
		int customerUpdatedTotal = customer.getEstimatedTotal() - previousTotal + total;
		int customerRemainingBalance = customer.getRemainingBalance() - previousTotal + total;
		int customerFinalTotal = customer.getCalculatedTotal() - previousTotal + total;
		quotation.setArea(rounded_area);
		quotation.setHeight(height);
		quotation.setPrice(price);
		quotation.setQuantity(quantity);
		quotation.setTotal(total);
		quotation.setWidth(width);
		customer.setEstimatedTotal(customerUpdatedTotal);
		customer.setRemainingBalance(customerRemainingBalance);
		customer.setCalculatedTotal(customerFinalTotal);
		quotationRemote.addAQuotationComponent(quotation);
		customerRemote.addNewCustomer(customer);
		return "redirect:/designer/viewQuotation/" + quotId;
	}
	
	@GetMapping("/addComponentToQuot/{qid}")
	public ModelAndView addNewComponentToQuotation(@PathVariable("qid") int quotationId) 
	{
		ModelAndView modelAndView = new ModelAndView("addingComponentsToQuot");
		modelAndView.addObject("quotId", quotationId);
		return modelAndView;
	}
	
	@PostMapping("/saveComponentToQuotation/{qid}")
	public String saveComponentToQuotation(@PathVariable("qid") int quotId, HttpServletRequest request)
	{
		String name = request.getParameter("compname");
		name = name.toUpperCase();
		int height = Integer.parseInt(request.getParameter("compheight"));
		int width = Integer.parseInt(request.getParameter("compwidth"));
		int quantity = Integer.parseInt(request.getParameter("compquantity"));
		int price = Integer.parseInt(request.getParameter("compprice"));
		double area = (height * width) / 144.0;
		int rounded_area = (int) Math.ceil(area);
		int total = rounded_area * quantity * price;
		Quotation quotation = new Quotation();
		quotation.setArea(rounded_area);
		quotation.setHeight(height);
		quotation.setName(name);
		quotation.setPrice(price);
		quotation.setQuantity(quantity);
		quotation.setTotal(total);
		quotation.setWidth(width);
		quotation.setQuotationId(quotId);
		quotationRemote.addAQuotationComponent(quotation);
		Customer customer = customerRemote.getCustomerDetailsOnQuotationId(quotId);
		int totalBalance = customer.getEstimatedTotal() + total;
		int remainingBalance = customer.getRemainingBalance() + total;
		int calculatedTotal = customer.getCalculatedTotal() + total;
		customer.setCalculatedTotal(calculatedTotal);
		customer.setEstimatedTotal(totalBalance);
		customer.setRemainingBalance(remainingBalance);
		customerRemote.addNewCustomer(customer);
		return "redirect:/designer/viewQuotation/" + quotId;
	}
	
	@GetMapping("/newQuotationImage")
	public ModelAndView navigateToQuotationImages()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("quotationImages");
		List<QuotationImage> quotationImages = quotationImagesRemote.getAllQuotationImages();
		modelAndView.addObject("allImages", quotationImages);
		return modelAndView;
	}
	
	@GetMapping("/quotationImage")
	public ResponseEntity<byte[]> displayQuotationImage(@RequestParam("id") int id) throws SQLException 
	{
		QuotationImage quotationImage = quotationImagesRemote.getImageById(id);
		byte[] qByte = null;
		qByte = quotationImage.getImage().getBytes(1, (int) quotationImage.getImage().length());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(qByte);
	}
	
	@PostMapping("/saveQuotationImage")
	public String saveQuotationImage(@RequestParam("imagefile") MultipartFile multipartFile, HttpServletRequest request) throws IOException, SerialException, SQLException
	{
		byte[] bytes = multipartFile.getBytes();
		Blob blob = new SerialBlob(bytes);
		String name = request.getParameter("imagename");
		name = name.toUpperCase();
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String d = localDateTime.format(pattern); 
		Date date = Date.valueOf(d);
		QuotationImage quotationImage = new QuotationImage();
		quotationImage.setImage(blob);
		quotationImage.setName(name);
		quotationImage.setUploadedDate(date);
		quotationImagesRemote.addNewImage(quotationImage);
		return "redirect:newQuotationImage";
	}
	
	@GetMapping("/deleteQuotationImage/{id}")
	public String deleteQuotationImage(@PathVariable("id") int id)
	{
		quotationImagesRemote.deleteImageById(id);
		return "redirect:/designer/newQuotationImage";
	}
	
	
	@GetMapping("/printQuotationImages")
	public ModelAndView navigateToPrintQuotationImages()
	{
		ModelAndView modelAndView = new ModelAndView("selectPrintingImages");
		List<QuotationImage> quotationImages = quotationImagesRemote.getAllQuotationImages();
		modelAndView.addObject("images", quotationImages);
		return modelAndView;
	}
	
	@PostMapping("/quotationImagesPrinting")
	public ModelAndView printImages(HttpServletRequest request, @RequestParam("selectimage") int[] checkBoxValues) 
	{
		ModelAndView modelAndView = new ModelAndView("printSelectedQuotationImages");
//		for(int s : checkBoxValues)
//		{
//			System.out.println(s);
//		}
		List<QuotationImage> quotationImages = new ArrayList<QuotationImage>();
		for(int value : checkBoxValues)
		{
			quotationImages.add(quotationImagesRemote.getImageById(value));
		}
		modelAndView.addObject("selectedImages", quotationImages);
		return modelAndView;
	}
	
	private List<Bill> billComponents = new ArrayList<Bill>();
	
	@GetMapping("/generateBill")
	public String navigateToGenerateBillPage() 
	{
		billComponents = new ArrayList<Bill>();
		return "newBill";
	}
	
	@PostMapping("/addBillComponent")
	public ModelAndView continueBilling(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("continueBilling");
		
		String name = request.getParameter("billCompName");
		int price = Integer.parseInt(request.getParameter("billCompPrice"));
		Bill bill = new Bill();
		bill.setComponentName(name);
		bill.setAmount(price);
		billComponents.add(bill);
		modelAndView.addObject("availableComponents", billComponents);
		return modelAndView;
	}
	
	@GetMapping("/saveBilling")
	public ModelAndView mapBillToCustomer()
	{
		ModelAndView modelAndView = new ModelAndView("saveBill");
		List<Customer> customers = customerRemote.allCustomersSorted();
		modelAndView.addObject("customerList", customers);
		return modelAndView;
	}
	
	@PostMapping("/billGeneration")   //Implementation not done
	public ModelAndView saveBill(HttpServletRequest request) 
	{
		ModelAndView modelAndView = new ModelAndView("redirect:allYourQuotationBills");
		int cid = Integer.parseInt(request.getParameter("customerSelection"));
		Customer customer = customerRemote.getCustomerDetailsOnCustomerId(cid);
		int sum = 0;
//		int billId = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
//		System.out.println(billId);
		String paymentMethod = request.getParameter("customerbillingmethod");
		String gst = request.getParameter("gstpercent");
		int gstPercent;
		if(gst.isEmpty())
		{
			gstPercent = 0;
		}
		else
		{
			gstPercent = Integer.parseInt(gst);
		}
		int billId = billSummaryRemote.nextBillId();
		for(Bill bill : billComponents)
		{
			bill.setCustomerId(cid);
			bill.setBillId(billId);
			bill.setQuotationId(customer.getQuotationId());
			sum += bill.getAmount();
//			System.out.println(bill.toString());
			billRemote.addBillComponent(bill);
		}
		BillSummary billSummary = new BillSummary();
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String date = localDateTime.format(pattern);
		Date current = Date.valueOf(date);
		int billAmount = (int) Math.ceil(sum * (gstPercent / 100.0)) + sum;
		billSummary.setCustomerId(cid);
		billSummary.setBillId(billId);
		billSummary.setBillingMethod(paymentMethod);
		billSummary.setBillDate(current);
		billSummary.setCustomerName(customer.getName());
		billSummary.setGstPercentage(gstPercent);
		billSummary.setQuotationId(customer.getQuotationId());
		billSummary.setTotalPrice(sum);
		billSummary.setTotalAmount(billAmount);
		int modifiedBalance = customer.getRemainingBalance() - sum;
		customer.setRemainingBalance(modifiedBalance);
		customerRemote.addNewCustomer(customer);
//		String s = 
		billSummaryRemote.insertBillSummary(billSummary);
//		modelAndView.addObject("billingMsg", s);
//		List<BillSummary> billSummaries = billSummaryRemote.getAllBillRecords();
//		modelAndView.addObject("allQuotationBills", billSummaries);
		return modelAndView;
	}
	
	@GetMapping("/allYourQuotationBills")
	public ModelAndView billsMappedToQuotation()
	{
		ModelAndView modelAndView = new ModelAndView("quotationBills");
		List<BillSummary> billSummaries = billSummaryRemote.getAllBillRecords();
		modelAndView.addObject("allQuotationBills", billSummaries);
		return modelAndView;
	}
	
	@GetMapping("/printBill/{bid}")
	public ModelAndView navigateToPrintBill(@PathVariable("bid") int bid)
	{
		ModelAndView modelAndView = new ModelAndView("printBill");
		List<Bill> bills = billRemote.getAllBillsOnBillId(bid);
		BillSummary billSummary = billSummaryRemote.getBillDetailsUsingBillId(bid);
		modelAndView.addObject("billDetail", billSummary);
		modelAndView.addObject("billComponents", bills);
		return modelAndView;
	}
	
	@GetMapping("/viewBill/{bid}")
	public ModelAndView navigateToBillOperations(@PathVariable("bid") int bid)
	{
		ModelAndView modelAndView = new ModelAndView("viewAndModifyBill");
		List<Bill> bills = billRemote.getAllBillsOnBillId(bid);
		BillSummary billSummary = billSummaryRemote.getBillDetailsUsingBillId(bid);
		modelAndView.addObject("billDetail", billSummary);
		modelAndView.addObject("billComponents", bills);
		return modelAndView;
	}
	
	@GetMapping("/deleteBillComponent/{bcid}/{bid}")
	public String deleteABillComponent(@PathVariable("bcid") int billComponentId, @PathVariable("bid") int billId)
	{ 
		BillSummary billSummary = billSummaryRemote.getBillDetailsUsingBillId(billId);
		Bill bill = billRemote.getBillComponentBasedOnId(billComponentId);
		int customerId = billSummary.getCustomerId();
		Customer customer = customerRemote.getCustomerDetailsOnCustomerId(customerId);
		int billComponentAmount = bill.getAmount();
		int billGst = billSummary.getGstPercentage();
		int billTotal = billSummary.getTotalPrice();
		int modifiedBillTotal = billTotal - billComponentAmount;
		int modifiedTotalAmount = (int) Math.ceil(modifiedBillTotal * (billGst/100.0)) + modifiedBillTotal;
		int remainingBalance = customer.getRemainingBalance() + billComponentAmount;
		customer.setRemainingBalance(remainingBalance);
		customerRemote.addNewCustomer(customer);
		billSummary.setTotalPrice(modifiedBillTotal);
		billSummary.setTotalAmount(modifiedTotalAmount);
		billSummaryRemote.insertBillSummary(billSummary);
		billRemote.deleteBasedOnId(billComponentId);
		return "redirect:/designer/viewBill/" + billId;
	}
	
	@GetMapping("/modifyBillComponent/{bcid}/{bid}")
	public ModelAndView navigateToBillComponentModification(@PathVariable("bcid") int billComponentId, @PathVariable("bid") int billId)
	{
		ModelAndView modelAndView = new ModelAndView("modifyBillComponent");
		Bill bill = billRemote.getBillComponentBasedOnId(billComponentId);
		modelAndView.addObject("billComponent", bill);
		return modelAndView;
	}
	
	@PostMapping("/saveModifiedBillComponent/{bcid}/{bid}")
	public String modifyBillComponentPrice(@PathVariable("bcid") int billComponentId, @PathVariable("bid") int billId, HttpServletRequest request)
	{
		String name = request.getParameter("componentName");
		int modifiedPrice = Integer.parseInt(request.getParameter("modifiedAmount"));
		Bill bill = billRemote.getBillComponentBasedOnId(billComponentId);
		BillSummary billSummary = billSummaryRemote.getBillDetailsUsingBillId(billId);
		int gst = billSummary.getGstPercentage();
		int oldBillComponentPrice = bill.getAmount();
		bill.setAmount(modifiedPrice);
		bill.setComponentName(name);
		int oldBillPrice = billSummary.getTotalPrice();
		int modifiedBillPrice = oldBillPrice - oldBillComponentPrice + modifiedPrice;
		int modifiedBillAmount = (int) Math.ceil(modifiedBillPrice * (gst / 100.0)) + modifiedBillPrice;
		billSummary.setTotalPrice(modifiedBillPrice);
		billSummary.setTotalAmount(modifiedBillAmount);
		Customer customer = customerRemote.getCustomerDetailsOnQuotationId(billSummary.getQuotationId());
		int customerBalance = customer.getRemainingBalance() + oldBillPrice - modifiedBillPrice;
		customer.setRemainingBalance(customerBalance);
		billRemote.addBillComponent(bill);	
		customerRemote.addNewCustomer(customer);
		billSummaryRemote.insertBillSummary(billSummary);
		return "redirect:/designer/viewBill/" + billId;
	}
	
	private List<NQBill> nqBillsList = new ArrayList<NQBill>();
	
	@GetMapping("/nonQuotationBill")
	public String navigateToGenerateNQuotationBill()
	{
		nqBillsList = new ArrayList<NQBill>();
		return "newNQBill";
	}
	
	@PostMapping("/addNQBillComponent")
	public ModelAndView addNonQuotationBillComponent(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("continueNQBilling");
		String compName = request.getParameter("nqbillcompname");
		int price = Integer.parseInt(request.getParameter("nqbillcompvalue"));
		NQBill nqBill = new NQBill();
		nqBill.setName(compName);
		nqBill.setAmount(price);
		nqBillsList.add(nqBill);
		modelAndView.addObject("addedComponents", nqBillsList);
		return modelAndView;
	}
	
	@GetMapping("/saveNQbill")
	public String navigateToMapCustomerToNQBill()
	{
		return "customerDetailsNQBilling";
	}
	
	@PostMapping("/saveNQBillingAndCustomer")
	public ModelAndView saveNQBillingDetails(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("redirect:allNQBills");
		String name = request.getParameter("customername");
		long mobileNumber = Long.parseLong(request.getParameter("customermobile"));
		String contactedBy = request.getParameter("customerreffered");
		String panorgstin = request.getParameter("customergstin");
		String paymentMethod = request.getParameter("customerbillingmethod");
		int gst = Integer.parseInt(request.getParameter("customergstpercent"));
		int nqbid = nqBillSummaryRemote.getMaxNQBillSummaryId();
		int price = 0;
		for(NQBill bill : nqBillsList)
		{
			bill.setNbid(nqbid);
			price += bill.getAmount();
			nqBillRemote.addNQBillComponent(bill);
		}
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String d = localDateTime.format(pattern);
		Date date = Date.valueOf(d);
		int amount = price + (int) Math.ceil(price * (gst/100.0));
		NQBillSummary nqBillSummary = new NQBillSummary();
		nqBillSummary.setAmount(amount);
		nqBillSummary.setBillDate(date);
		nqBillSummary.setCustomerName(name);
		nqBillSummary.setGst(gst);
		nqBillSummary.setId(nqbid);
		nqBillSummary.setMobileNumber(mobileNumber);
		nqBillSummary.setPanOrGstin(panorgstin);
		nqBillSummary.setPrice(price);
		nqBillSummary.setRefferedBy(contactedBy);
		nqBillSummary.setBillingMethod(paymentMethod);
		nqBillSummaryRemote.addBNQBillSummary(nqBillSummary);
		return modelAndView;
	}
	
	@GetMapping("/allNQBills")
	public ModelAndView allNonQuotationBills()
	{
		ModelAndView modelAndView = new ModelAndView("nonQuotationBills");
		List<NQBillSummary> nqBillSummaries = nqBillSummaryRemote.getAllNQBillSummaries();
		modelAndView.addObject("allBills", nqBillSummaries);
		return modelAndView;
	}
	
	@GetMapping("/printNQBill/{nqid}")
	public ModelAndView printNQBilling(@PathVariable("nqid") int id)
	{
		ModelAndView modelAndView = new ModelAndView("printNQBill");
		NQBillSummary nqBillSummary = nqBillSummaryRemote.getSummaryBasedOnId(id);
		List<NQBill> nqBills = nqBillRemote.getBillsBasedOnId(id);
		modelAndView.addObject("billsList", nqBills);
		modelAndView.addObject("billSummary", nqBillSummary);
		return modelAndView;
	}
	
	@GetMapping("/viewNQBill/{nqid}")
	public ModelAndView checkNQBilling(@PathVariable("nqid") int id)
	{
		ModelAndView modelAndView = new ModelAndView("modifyNQBill");
		NQBillSummary nqBillSummary = nqBillSummaryRemote.getSummaryBasedOnId(id);
		List<NQBill> nqBills = nqBillRemote.getBillsBasedOnId(id);
		modelAndView.addObject("billsList", nqBills);
		modelAndView.addObject("billSummary", nqBillSummary);
		return modelAndView;
	}
	
	@GetMapping("/deleteNQBillComponent/{bcid}/{bid}")
	public String deleteNQBillComponent(@PathVariable("bcid") int componentId, @PathVariable("bid") int billId)
	{
		NQBill nqBill = nqBillRemote.getComponentOnId(componentId);
		nqBillRemote.deleteNQBillComponent(componentId);
		NQBillSummary billSummary = nqBillSummaryRemote.getSummaryBasedOnId(billId);
		int price = billSummary.getPrice() - nqBill.getAmount();
		int gst = billSummary.getGst();
		int amount = price + (int) Math.ceil(price * (gst/100.0));
		billSummary.setAmount(amount);
		billSummary.setPrice(price);
		nqBillSummaryRemote.addBNQBillSummary(billSummary);
		return "redirect:/designer/viewNQBill/"+billId;
	}
	
	@GetMapping("/addNQBillComponent/{bid}")
	public ModelAndView navigateToAddNQBillComponent(@PathVariable("bid") int billId)
	{
		ModelAndView modelAndView = new ModelAndView("addNewNQBillComponent");
		modelAndView.addObject("billId", billId);
		return modelAndView;
	}
	
	@PostMapping("/saveNQBillComponent/{bid}")
	public String saveNQBillComponent(@PathVariable("bid") int bid, HttpServletRequest request)
	{
		String name = request.getParameter("nqcompname");
		int val = Integer.parseInt(request.getParameter("nqcompvalue"));
		NQBill nqBill = new NQBill();
		NQBillSummary nqBillSummary = nqBillSummaryRemote.getSummaryBasedOnId(bid);
		int sum = nqBillSummary.getPrice() + val;
		int gst = nqBillSummary.getGst();
		int amount = sum + (int) Math.ceil(sum * (gst/100.0));
		nqBillSummary.setAmount(amount);
		nqBillSummary.setPrice(sum);
		nqBill.setAmount(val);
		nqBill.setName(name);
		nqBill.setNbid(bid);
		nqBillRemote.addNQBillComponent(nqBill);
		nqBillSummaryRemote.addBNQBillSummary(nqBillSummary);
		return "redirect:/designer/viewNQBill/"+bid;
	}
	
	@GetMapping("/materials")
	public ModelAndView navigateToMaterials()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("materialsAndOperations");
		List<Material> materials = materialRemote.getAllMaterials();
		modelAndView.addObject("materialList", materials);
		return modelAndView;
	}
	
	@PostMapping("/saveNewMaterial")
	public String insertNewMaterial(HttpServletRequest request)
	{
		String name = request.getParameter("materialname");
		name = name.toLowerCase();
		name = StringUtils.capitalize(name);
		int price = Integer.parseInt(request.getParameter("materialprice"));
		String modification = request.getParameter("materialtype");
		boolean changes;
		if(modification.equals("Yes"))
		{
			changes = true;
		}
		else
		{
			changes = false;
		}
		Material material = new Material();
		material.setName(name);
		material.setPrice(price);
		material.setVariesWithMeasurements(changes);
		materialRemote.addMaterial(material);
		return "redirect:materials";
	}
	
	@GetMapping("/deleteMaterial/{id}")
	public String deleteMaterials(@PathVariable("id") int mid)
	{
		materialRemote.deleteMaterial(mid);
		return "redirect:/designer/materials";
	}
	
	@GetMapping("/getOnlineCustomersList")
	public ModelAndView getAllCustomersVisited()
	{
		ModelAndView modelAndView = new ModelAndView("visitors");
		List<OnlineCustomer> unContactedOnlineCustomer = onlineCustomerRemote.getAllOnlineCustomersByStatus(false);
		List<OnlineCustomer> contactedOnlineCustomer = onlineCustomerRemote.getAllOnlineCustomersByStatus(true);
		modelAndView.addObject("uncontactedList", unContactedOnlineCustomer);
		modelAndView.addObject("contactedList", contactedOnlineCustomer);
		return modelAndView;
	}
	
	@GetMapping("/changeOnlineCustomerStatus/{id}")
	public String changeContactStatus(@PathVariable("id") int id)
	{
		OnlineCustomer onlineCustomer = onlineCustomerRemote.getById(id);
		boolean currentStatus = onlineCustomer.isContacted();
		onlineCustomer.setContacted(! (currentStatus));
		onlineCustomerRemote.addOnlineCustomer(onlineCustomer);
		return "redirect:/designer/getOnlineCustomersList";
	}
	
	@GetMapping("/deleteOnlineCustomer/{id}")
	public String deleteOnlineVisitor(@PathVariable("id") int id)
	{
		onlineCustomerRemote.deleteOnlineCustomerById(id);
		return "redirect:/designer/getOnlineCustomersList";
	}
	
	@GetMapping("/feedbackdasboard")
	public ModelAndView viewCustomerFeedback()
	{
		ModelAndView modelAndView = new ModelAndView("feedbackDashboard");
		List<Feedback> feedbacks = feedbackRemote.allFeedbacks();
		int qualityRating1 = 0, colourPrecesionRating1 = 0, designRating1 = 0, changesRating1 = 0, communicationRating1 = 0, timeLine1 = 0, 
			qualityRating2 = 0, colourPrecesionRating2 = 0, designRating2 = 0, changesRating2 = 0, communicationRating2 = 0, timeLine2 = 0,
			qualityRating3 = 0, colourPrecesionRating3 = 0, designRating3 = 0, changesRating3 = 0, communicationRating3 = 0, timeLine3 = 0,
			qualityRating4 = 0, colourPrecesionRating4 = 0, designRating4 = 0, changesRating4 = 0, communicationRating4 = 0, timeLine4 = 0,
			qualityRating5 = 0, colourPrecesionRating5 = 0, designRating5 = 0, changesRating5 = 0, communicationRating5 = 0; 

		for(Feedback feedback : feedbacks)
		{
			if(feedback.getQuality() == 1)
				qualityRating1 += 1;
			else if(feedback.getQuality() == 2)
				qualityRating2 += 1;
			else if(feedback.getQuality() == 3)
				qualityRating3 += 1;
			else if(feedback.getQuality() == 4)
				qualityRating4 += 1;
			else if(feedback.getQuality() == 5)
				qualityRating5 += 1;
			
			if(feedback.getColourPrecesion() == 1)
				colourPrecesionRating1 += 1;
			else if(feedback.getColourPrecesion() == 2)
				colourPrecesionRating2 += 1;
			else if(feedback.getColourPrecesion() == 3)
				colourPrecesionRating3 += 1;
			else if(feedback.getColourPrecesion() == 4)
				colourPrecesionRating4 += 1;
			else if(feedback.getColourPrecesion() == 5)
				colourPrecesionRating5 += 1;
			
			if(feedback.getDesignRating() == 1)
				designRating1 += 1;
			else if(feedback.getDesignRating() == 2)
				designRating2 += 1;
			else if(feedback.getDesignRating() == 3)
				designRating3 += 1;
			else if(feedback.getDesignRating() == 4)
				designRating4 += 1;
			else if(feedback.getDesignRating() == 5)
				designRating5 += 1;
			
			if(feedback.getChangesRating() == 1)
				changesRating1 += 1;
			else if(feedback.getChangesRating() == 2)
				changesRating2 += 1;
			else if(feedback.getChangesRating() == 3)
				changesRating3 += 1;
			else if(feedback.getChangesRating() == 4)
				changesRating4 += 1;
			else if(feedback.getChangesRating() == 5)
				changesRating5 += 1;
			
			if(feedback.getCommunication() == 1)
				communicationRating1 += 1;
			else if(feedback.getCommunication() == 2)
				communicationRating2 += 1;
			else if(feedback.getCommunication() == 3)
				communicationRating3 += 1;
			else if(feedback.getCommunication() == 4)
				communicationRating4 += 1;
			else if(feedback.getCommunication() == 5)
				communicationRating5 += 1;
			
			if(feedback.getTimeLine().equals("Fully Completed"))
				timeLine1 += 1;
			else if(feedback.getTimeLine().equals("Almost completed"))
				timeLine2 += 1;
			else if(feedback.getTimeLine().equals("Only some part completed"))
				timeLine3 += 1;
			else if(feedback.getTimeLine().equals("Work stopped"))
				timeLine4 += 1;
		}
		
//		double qualityRatingD1 = 0, colourPrecesionRatingD1 = 0, designRatingD1 = 0, changesRatingD1 = 0, communicationRatingD1 = 0, timeLineD1 = 0, 
//				qualityRatingD2 = 0, colourPrecesionRatingD2 = 0, designRatingD2 = 0, changesRatingD2 = 0, communicationRatingD2 = 0, timeLineD2 = 0,
//				qualityRatingD3 = 0, colourPrecesionRatingD3 = 0, designRatingD3 = 0, changesRatingD3 = 0, communicationRatingD3 = 0, timeLineD3 = 0,
//				qualityRatingD4 = 0, colourPrecesionRatingD4 = 0, designRatingD4 = 0, changesRatingD4 = 0, communicationRatingD4 = 0, timeLineD4 = 0,
//				qualityRatingD5 = 0, colourPrecesionRatingD5 = 0, designRatingD5 = 0, changesRatingD5 = 0, communicationRatingD5 = 0;
//		
//		double eachAngle = 360.0 / feedbacks.size();
//		
//		qualityRatingD1 = qualityRating1 * eachAngle;
//		qualityRatingD2 = qualityRating2 * eachAngle;
//		qualityRatingD3 = qualityRating3 * eachAngle;
//		qualityRatingD4 = qualityRating4 * eachAngle;
//		qualityRatingD5 = qualityRating5 * eachAngle;
//		
//		colourPrecesionRatingD1 = colourPrecesionRating1 * eachAngle;
//		colourPrecesionRatingD2 = colourPrecesionRating2 * eachAngle;
//		colourPrecesionRatingD3 = colourPrecesionRating3 * eachAngle;
//		colourPrecesionRatingD4 = colourPrecesionRating4 * eachAngle;
//		colourPrecesionRatingD5 = colourPrecesionRating5 * eachAngle;
//		
//		designRatingD1 = designRating1 * eachAngle;
//		designRatingD2 = designRating2 * eachAngle;
//		designRatingD3 = designRating3 * eachAngle;
//		designRatingD4 = designRating4 * eachAngle;
//		designRatingD5 = designRating5 * eachAngle;
//		
//		changesRatingD1 = changesRating1 * eachAngle;
//		changesRatingD2 = changesRating2 * eachAngle;
//		changesRatingD3 = changesRating3 * eachAngle;
//		changesRatingD4 = changesRating4 * eachAngle;
//		changesRatingD5 = changesRating5 * eachAngle;
//		
//		communicationRatingD1 = communicationRating1 * eachAngle;
//		communicationRatingD2 = communicationRating2 * eachAngle;
//		communicationRatingD3 = communicationRating3 * eachAngle;
//		communicationRatingD4 = communicationRating4 * eachAngle;
//		communicationRatingD5 = communicationRating5 * eachAngle;
//		
//		timeLineD1 = timeLine1 * eachAngle;
//		timeLineD2 = timeLine2 * eachAngle;
//		timeLineD3 = timeLine3 * eachAngle;
//		timeLineD4 = timeLine4 * eachAngle;

//		List<Integer> qualityRating = new ArrayList<Integer>();
//		List<Integer> colourPrecesionRating = new ArrayList<Integer>();
//		List<Integer> designRating = new ArrayList<Integer>();
//		List<Integer> changesRating = new ArrayList<Integer>();
//		List<Integer> communicationRating = new ArrayList<Integer>();
//		List<Integer> timeLine = new ArrayList<Integer>();
//		
//		qualityRating.add(qualityRating1);qualityRating.add(qualityRating2);
//		qualityRating.add(qualityRating3);qualityRating.add(qualityRating4);
//		qualityRating.add(qualityRating5);
//		
//		colourPrecesionRating.add(colourPrecesionRating1);
//		colourPrecesionRating.add(colourPrecesionRating2);
//		colourPrecesionRating.add(colourPrecesionRating3);
//		colourPrecesionRating.add(colourPrecesionRating4);
//		colourPrecesionRating.add(colourPrecesionRating5);
//		
//		designRating.add(designRating1);designRating.add(designRating2);
//		designRating.add(designRating3);designRating.add(designRating4);
//		designRating.add(designRating5);
//		
//		changesRating.add(changesRating1);changesRating.add(changesRating2);
//		changesRating.add(changesRating3);changesRating.add(changesRating4);
//		changesRating.add(changesRating5);
//		
//		communicationRating.add(communicationRating1);
//		communicationRating.add(communicationRating2);
//		communicationRating.add(communicationRating3);
//		communicationRating.add(communicationRating4);
//		communicationRating.add(communicationRating5);
//		
//		timeLine.add(timeLine1);timeLine.add(timeLine2);
//		timeLine.add(timeLine3);timeLine.add(timeLine4);
//		
//		modelAndView.addObject("qualityRatingList", qualityRating);
//		modelAndView.addObject("colourPrecesionRating", colourPrecesionRating);
//		modelAndView.addObject("designRating", designRating);
//		modelAndView.addObject("changesRating", changesRating);
//		modelAndView.addObject("communicationRating", communicationRating);
//		modelAndView.addObject("timeLine", timeLine);
		
//		modelAndView.addObject("qualityRatingDegree1", qualityRatingD1);
//		modelAndView.addObject("qualityRatingDegree2", qualityRatingD2);
//		modelAndView.addObject("qualityRatingDegree3", qualityRatingD3);
//		modelAndView.addObject("qualityRatingDegree4", qualityRatingD4);
//		modelAndView.addObject("qualityRatingDegree5", qualityRatingD5);
//
//		modelAndView.addObject("colourPrecesionRatingDegree1", colourPrecesionRatingD1);
//		modelAndView.addObject("colourPrecesionRatingDegree2", colourPrecesionRatingD2);
//		modelAndView.addObject("colourPrecesionRatingDegree3", colourPrecesionRatingD3);
//		modelAndView.addObject("colourPrecesionRatingDegree4", colourPrecesionRatingD4);
//		modelAndView.addObject("colourPrecesionRatingDegree5", colourPrecesionRatingD5);
//
//		modelAndView.addObject("designRatingDegree1", designRatingD1);
//		modelAndView.addObject("designRatingDegree2", designRatingD2);
//		modelAndView.addObject("designRatingDegree3", designRatingD3);
//		modelAndView.addObject("designRatingDegree4", designRatingD4);
//		modelAndView.addObject("designRatingDegree5", designRatingD5);
//
//		modelAndView.addObject("communicationRatingDegree1", communicationRatingD1);
//		modelAndView.addObject("communicationRatingDegree2", communicationRatingD2);
//		modelAndView.addObject("communicationRatingDegree3", communicationRatingD3);
//		modelAndView.addObject("communicationRatingDegree4", communicationRatingD4);
//		modelAndView.addObject("communicationRatingDegree5", communicationRatingD5);
//
//		modelAndView.addObject("changesRatingDegree1", changesRatingD1);
//		modelAndView.addObject("changesRatingDegree2", changesRatingD2);
//		modelAndView.addObject("changesRatingDegree3", changesRatingD3);
//		modelAndView.addObject("changesRatingDegree4", changesRatingD4);
//		modelAndView.addObject("changesRatingDegree5", changesRatingD5);
//
//		modelAndView.addObject("timeLineDegree1", timeLineD1);
//		modelAndView.addObject("timeLineDegree2", timeLineD2);
//		modelAndView.addObject("timeLineDegree3", timeLineD3);
//		modelAndView.addObject("timeLineDegree4", timeLineD4);
		
		modelAndView.addObject("qualityRating1", qualityRating1);
		modelAndView.addObject("qualityRating2", qualityRating2);
		modelAndView.addObject("qualityRating3", qualityRating3);
		modelAndView.addObject("qualityRating4", qualityRating4);
		modelAndView.addObject("qualityRating5", qualityRating5);

		modelAndView.addObject("colourPrecesionRating1", colourPrecesionRating1);
		modelAndView.addObject("colourPrecesionRating2", colourPrecesionRating2);
		modelAndView.addObject("colourPrecesionRating3", colourPrecesionRating3);
		modelAndView.addObject("colourPrecesionRating4", colourPrecesionRating4);
		modelAndView.addObject("colourPrecesionRating5", colourPrecesionRating5);

		modelAndView.addObject("designRating1", designRating1);
		modelAndView.addObject("designRating2", designRating2);
		modelAndView.addObject("designRating3", designRating3);
		modelAndView.addObject("designRating4", designRating4);
		modelAndView.addObject("designRating5", designRating5);

		modelAndView.addObject("communicationRating1", communicationRating1);
		modelAndView.addObject("communicationRating2", communicationRating2);
		modelAndView.addObject("communicationRating3", communicationRating3);
		modelAndView.addObject("communicationRating4", communicationRating4);
		modelAndView.addObject("communicationRating5", communicationRating5);

		modelAndView.addObject("changesRating1", changesRating1);
		modelAndView.addObject("changesRating2", changesRating2);
		modelAndView.addObject("changesRating3", changesRating3);
		modelAndView.addObject("changesRating4", changesRating4);
		modelAndView.addObject("changesRating5", changesRating5);

		modelAndView.addObject("timeLine1", timeLine1);
		modelAndView.addObject("timeLine2", timeLine2);
		modelAndView.addObject("timeLine3", timeLine3);
		modelAndView.addObject("timeLine4", timeLine4);
		
		return modelAndView;
	}
	
	@GetMapping("/individualfeedback")
	public ModelAndView viewIndividualCustomerFeedback()
	{
		ModelAndView modelAndView = new ModelAndView("individualFeedback");
		List<Feedback> feedbacks = feedbackRemote.allFeedbacks();
		modelAndView.addObject("customerFeedbackList", feedbacks);
		return modelAndView;
	}
	
	private String msg = null;
	
	public void setMessage(String s)
	{
		msg = s;
	}
	
	@GetMapping("/importItem")  
	public ModelAndView navigateToAddNewImports()
	{
		ModelAndView modelAndView = new ModelAndView("newImportItem");
		List<Imports> imports = importsRemote.getAllImports();
		modelAndView.addObject("msg", msg);
		modelAndView.addObject("importsList", imports);
		msg = null;
		return modelAndView;
	}
	
	@PostMapping("/addImportItem")
	public ModelAndView addNewImportItem(@RequestParam("imgfile") MultipartFile multipartFile, HttpServletRequest request) throws IOException, SerialException, SQLException
	{
		ModelAndView modelAndView = new ModelAndView("redirect:importItem");
		byte[] bytes = multipartFile.getBytes();
		Blob blob = new SerialBlob(bytes);
		String id = request.getParameter("imgid");
		String name = request.getParameter("imgname");
		name = name.toUpperCase();
		List<Imports> importsList = importsRemote.getAllImports();
		modelAndView.addObject("importsList", importsList);
		Imports imports1 = importsRemote.getById(id);
		if(imports1 != null)
		{
			setMessage("A item with this ID already exists");
			return modelAndView;
		}
		Imports imports = new Imports();
		imports.setId(id);
		imports.setImage(blob);
		imports.setName(name);
		
		String s = importsRemote.addImport(imports);
		
		setMessage(s);
		return modelAndView;
	}
	
	@GetMapping("/viewImportImage/{id}")
	public ResponseEntity<byte[]> displayImportImage(@PathVariable("id") String id) throws SQLException
	{
		Imports imports = importsRemote.getById(id);
		
		byte[] bytes = imports.getImage().getBytes(1, (int) imports.getImage().length());
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}
	
	@GetMapping("/deleteImportItem")
	public ModelAndView deleteImportItem(@RequestParam("id") String id)
	{
		ModelAndView modelAndView = new ModelAndView("redirect:importItem");
		importsRemote.deleteImport(id);
		return modelAndView;
	}
	
	private List<ImportsQuotation> importsQuotations = new ArrayList<ImportsQuotation>();
	
	@GetMapping("/generateImportsQuotation")
	public ModelAndView navigateToGenerateImportsQuotationPage()
	{
		ModelAndView modelAndView = new ModelAndView("newImportsQuotation");
		importsQuotations = new ArrayList<ImportsQuotation>();
		List<Imports> imports = importsRemote.getAllImports();
		modelAndView.addObject("allItems", imports);
		return modelAndView;
	}
	
	@PostMapping("/addImportItemToQuotation")
	public ModelAndView addImportItemToQuotation(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		String reference = request.getParameter("imports");
		int price = Integer.parseInt(request.getParameter("itemprice"));
		int quantity = Integer.parseInt(request.getParameter("itemquanity"));
		int amount = price * quantity;
		Imports imports = importsRemote.getById(reference);
		ImportsQuotation importsQuotation = new ImportsQuotation();
		importsQuotation.setAmount(amount);
		importsQuotation.setImportreference(reference);
		importsQuotation.setName(imports.getName());
		importsQuotation.setPrice(price);
		importsQuotation.setQuantity(quantity);
		importsQuotations.add(importsQuotation);
		List<Imports> importslist = importsRemote.getAllImports();
		modelAndView.addObject("allItems", importslist);
		modelAndView.addObject("addedList", importsQuotations);
		modelAndView.setViewName("continueImportsQuotation");
		return modelAndView;
	}
	
	@GetMapping("/saveImportsQuotation")
	public ModelAndView customerDetailsForImportsQuotation()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("addedList", importsQuotations);
		modelAndView.setViewName("customerDetailsImportsBilling");
		int id = importsQuotationSummaryRemote.getMaxId();
		modelAndView.addObject("quotId", id);
		int total = 0;
		for(ImportsQuotation quotation : importsQuotations)
		{
			quotation.setId(id);
			total += quotation.getAmount();
		}
		modelAndView.addObject("totalamount", total);
		return modelAndView;
	}
	
	@PostMapping("/saveCustomerDetailsImportsQuotation")
	public ModelAndView mapCustomerDetailsForImportsQuotation(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("redirect:allImportsQuotations");
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String d = localDateTime.format(formatter);
		Date date = Date.valueOf(d);
		String name = request.getParameter("custname");
		name = name.toUpperCase();
		String address = request.getParameter("custaddress");
		address = address.toUpperCase();
		String contactPerson = request.getParameter("contname");
		contactPerson = contactPerson.toUpperCase();
		String pan = request.getParameter("panorgst");
		pan = pan.toUpperCase();
		int calculatedTotal = Integer.parseInt(request.getParameter("finaltotal"));
		int finalizedTotal = Integer.parseInt(request.getParameter("finalamount"));
		int id = Integer.parseInt(request.getParameter("quotId"));
		long num = Long.parseLong(request.getParameter("mobilenum"));
		
		for(ImportsQuotation quotation : importsQuotations)
		{
			importsQuotationRemote.addImportsQuotation(quotation);
		}
		
		ImportsQuotationSummary quotationSummary = new ImportsQuotationSummary();
		quotationSummary.setAddress(address);
		quotationSummary.setCalculatedAmount(calculatedTotal);
		quotationSummary.setContactNumber(num);
		quotationSummary.setContactPerson(contactPerson);
		quotationSummary.setDate(date);
		quotationSummary.setFinalizedAmount(finalizedTotal);
		quotationSummary.setId(id);
		quotationSummary.setName(name);
		quotationSummary.setPanOrGstin(pan);
		
		importsQuotationSummaryRemote.addImportsQuotationSummary(quotationSummary);
		return modelAndView;
	}
	
	@GetMapping("/allImportsQuotations")
	public ModelAndView allImportsQuotations()
	{
		ModelAndView modelAndView = new ModelAndView("importQuotations");
		List<ImportsQuotationSummary> importsQuotationSummaries = importsQuotationSummaryRemote.getAllImportsQuotations();
		modelAndView.addObject("allQuotationsList", importsQuotationSummaries);
		return modelAndView;
	}
	
	@GetMapping("/viewImportsQuotation/{id}")
	public ModelAndView viewImportsQuotation(@PathVariable("id") int id)
	{
		ModelAndView modelAndView = new ModelAndView("modifyImportsQuotation");
		List<ImportsQuotation> importsQuotations = importsQuotationRemote.getListbyId(id);
		modelAndView.addObject("quotationTuples", importsQuotations);
		ImportsQuotationSummary summary = importsQuotationSummaryRemote.getById(id);
		modelAndView.addObject("summaryRecord", summary);
		return modelAndView;
	}
	
	@GetMapping("/printImportsQuotation/{id}")
	public ModelAndView printImportsQuotation(@PathVariable("id") int id)
	{
		ModelAndView modelAndView = new ModelAndView("printImportsQuotation");
		List<ImportsQuotation> importsQuotations = importsQuotationRemote.getListbyId(id);
		modelAndView.addObject("quotationTuples", importsQuotations);
		ImportsQuotationSummary summary = importsQuotationSummaryRemote.getById(id);
		modelAndView.addObject("summaryRecord", summary);
		return modelAndView;
	}
	
	@GetMapping("/deleteImportQuotationComponent")
	public String deleteimportsQuotationComponent(@RequestParam("cid") int componentId, @RequestParam("qid") int qid)
	{
//		System.out.println(componentId + " " + qid);
		ImportsQuotationSummary quotationSummary = importsQuotationSummaryRemote.getById(qid);
		ImportsQuotation importsQuotation = importsQuotationRemote.getDetailsById(componentId);
		int amount = importsQuotation.getAmount();
		importsQuotationRemote.deleteImportsQuotationById(componentId);
		int calculatedTotal = quotationSummary.getCalculatedAmount() - amount;
		int finalAmount = quotationSummary.getFinalizedAmount() - amount;
		quotationSummary.setCalculatedAmount(calculatedTotal);
		quotationSummary.setFinalizedAmount(finalAmount);
		importsQuotationSummaryRemote.addImportsQuotationSummary(quotationSummary);
		return "redirect:/designer/viewImportsQuotation/" + qid;
	}
	
	
	@GetMapping("/addNewImportItemToQuotation/{id}")
	public ModelAndView navigateToAddNewItemToImportsQuotation(@PathVariable int id)
	{
		ModelAndView modelAndView = new ModelAndView("addImportItemToQuotation");
		List<Imports> importslist = importsRemote.getAllImports();
		modelAndView.addObject("allItems", importslist);
		modelAndView.addObject("qid", id);
		return modelAndView;
	}
	
	@PostMapping("/addImportItemToExistingQuotation/{id}")
	public String saveNewImportItem(@PathVariable int id, HttpServletRequest request)
	{
		String name = request.getParameter("imports");
		int quantity = Integer.parseInt(request.getParameter("itemquanity"));
		int price = Integer.parseInt(request.getParameter("itemprice"));
		int amount = price * quantity;
		ImportsQuotation importsQuotation = new ImportsQuotation();
		Imports imports = importsRemote.getById(name);
		
		importsQuotation.setId(id);
		importsQuotation.setAmount(amount);
		importsQuotation.setImportreference(imports.getId());
		importsQuotation.setName(imports.getName());
		importsQuotation.setPrice(price);
		importsQuotation.setQuantity(quantity);
		importsQuotationRemote.addImportsQuotation(importsQuotation);
		ImportsQuotationSummary summary = importsQuotationSummaryRemote.getById(id);
		int calculatedAmount = summary.getCalculatedAmount() + amount;
		int finalAmount = summary.getFinalizedAmount() + amount;
		summary.setCalculatedAmount(calculatedAmount);
		summary.setFinalizedAmount(finalAmount);
		importsQuotationSummaryRemote.addImportsQuotationSummary(summary);
		return "redirect:/designer/viewImportsQuotation/" + id;
	}
}
