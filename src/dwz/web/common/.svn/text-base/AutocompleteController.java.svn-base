package dwz.web.common;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dwz.business.common.AutocompleteServiceMgr;
import dwz.persistence.beans.ParConsumer;
import dwz.persistence.beans.ParProvider;
import dwz.persistence.beans.ProProduct;
import dwz.web.BaseController;

@Controller
@RequestMapping(value="/autocomplete")
public class AutocompleteController extends BaseController {
	
	@Autowired
	private AutocompleteServiceMgr autocompleteServiceMgr;
	
	@RequestMapping("/consumer")
	public String loadAccountNo(Model model, HttpServletResponse response) {
		List<ParConsumer> list = autocompleteServiceMgr.loadConsumer(getSessionOper());
		responseJson(list, response);
		return null;
	}
	
	@RequestMapping("/loadConsumer")
	public String loadConsumerName(Model model, HttpServletResponse response) {
		List<ParConsumer> list = autocompleteServiceMgr.loadConsumer(getSessionOper());
		responseJson(list, response);
		return null;
	}
	
	@RequestMapping("/loadProvider")
	public String loadProviderName(Model model, HttpServletResponse response) {
		List<ParProvider> list = autocompleteServiceMgr.loadProvider(getSessionOper());
		responseJson(list, response);
		return null;
	}
	
	@RequestMapping("/loadProductModel")
	public String loadProductModel(Model model, HttpServletResponse response) {
		List<String> list = autocompleteServiceMgr.loadProductModel(getSessionOper());
		responseJson(list, response);
		return null;
	}
	
	@RequestMapping("/loadProductName")
	public String loadProductName(Model model, HttpServletResponse response) {
		List<ProProduct> list = autocompleteServiceMgr.loadProductName(getSessionOper());
		responseJson(list, response);
		return null;
	}
	
	@RequestMapping("/loadProduct")
	public String loadProduct(Model model, HttpServletResponse response) {
		List<ProProduct> list = autocompleteServiceMgr.loadProduct(getSessionOper());
		responseJson(list, response);
		return null;
	}
	
}
