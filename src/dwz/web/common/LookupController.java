package dwz.web.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dwz.business.common.LookupServiceMgr;
import dwz.business.goods.Product;
import dwz.business.partner.Provider;
import dwz.web.BaseController;

@Controller
@RequestMapping(value="/lookup")
public class LookupController extends BaseController {
	
	@Autowired
	private LookupServiceMgr lookupServiceMgr;
	
	@RequestMapping("/lookupProduct")
	public String lookupUsableProduct(Model model) {
		List<Product> productList = lookupServiceMgr.lookupProduct(getSessionOper());
		model.addAttribute("productList", productList);
		return "/lookup/product";
	}
	
	@RequestMapping("/lookupProvider")
	public String lookupProvider(Model model) {
		List<Provider> providerList = lookupServiceMgr.lookupProvider(getSessionOper());
		model.addAttribute("providerList", providerList);
		return "/lookup/provider";
	}

}
