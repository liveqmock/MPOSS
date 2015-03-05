package dwz.web.goods;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.goods.Product;
import dwz.business.goods.ProductImportVO;
import dwz.business.goods.ProductServiceMgr;
import dwz.business.goods.ProviderProductServiceMgr;
import dwz.business.sale.SaleServiceMgr;
import dwz.business.sale.SearchProductVO;
import dwz.common.util.ExcelImportUtil;
import dwz.persistence.beans.ProProduct;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/goods/product")
public class ProductController extends BaseController {
	
	@Autowired
	private ProductServiceMgr productServiceMgr;
	@Autowired
	private ProviderProductServiceMgr providerProductServiceMgr;
	@Autowired
	private SaleServiceMgr saleServiceMgr;
	
	@RequestMapping("/list")
	public String list(SearchProductVO vo, Model model) {
		
		int totalCount = productServiceMgr.searchProductCount(vo, getSessionOper());
		List<Product> productList = productServiceMgr.searchProduct(vo, getSessionOper());
		model.addAttribute(productList);
		model.addAttribute("product", vo.getProduct());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/goods/product/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		return "/goods/product/add";
	}
	
	@SystemLog("添加基础产品")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Product product) {
		
		ProProduct po = productServiceMgr.getProProduct(product.getProProduct(), getSessionOper());
		if(po != null){
			return ajaxDoneError("本基础产品已存在，拒绝重复添加！");
		}
		productServiceMgr.addProduct(product,getSessionOper());
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/edit/{productId}")
	public String edit(@PathVariable("productId") int productId, Model model) {
		Product product = productServiceMgr.getProduct(productId);
		model.addAttribute("product", product);
		return "/goods/product/edit";
	}
	
	@SystemLog("修改基础产品")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Product product) {
		productServiceMgr.upd(product,getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
	@SystemLog("删除基础产品")
	@RequestMapping("/del/{productId}")
	public ModelAndView del(@PathVariable("productId") int productId, Model model) {
		
		int saleCount = saleServiceMgr.getSaleCountByProduct(productId);
		if(saleCount >0){
			return ajaxDoneError("此基础产品被销售单引用过，为保证数据的完整性，拒绝删除！");
		}
		int providerProductCount = providerProductServiceMgr.getProviderProductCount(productId);
		if(providerProductCount > 0){
			return ajaxDoneError("此基础产品已被厂家所引用，为保证数据的完整性，拒绝删除！");
		}
		productServiceMgr.del(productId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
	String inputStream2String(InputStream is) throws Exception{
	    BufferedReader in = new BufferedReader(new InputStreamReader(is));
	    StringBuffer buffer = new StringBuffer();
	    String line = "";
	    while ((line = in.readLine()) != null){
	        buffer.append(line);
	    }
	    return buffer.toString();
	}
	
	@SystemLog("上传基础产品图片")
	@RequestMapping(value="/upload" ,method=RequestMethod.POST)
	public ModelAndView upload(UploadBO uploadBO, @RequestParam MultipartFile[] myfiles, HttpServletRequest request) throws Exception{
		int i = 0;
		List<String> overLimitSizeList = new ArrayList<String>();
		List<String> extNotMatchList = new ArrayList<String>();
		for(MultipartFile myfile : myfiles){ 
			if(!myfile.isEmpty()){
				
				int productId = uploadBO.getProductList().get(i).getProductId();//PRODUCT_ID
				String originalFilename = myfile.getOriginalFilename();
				String fileName_prefix = String.valueOf(productId);
				String fileName_suffix = originalFilename.substring(originalFilename.indexOf("."), originalFilename.length());
				String saveFileName = fileName_prefix + fileName_suffix;//PIC
				File file=null;
				
				if(myfile.getSize()>20000){
			        overLimitSizeList.add(originalFilename);
				}
				
				if(!checkImg(originalFilename.substring(originalFilename.indexOf(".") + 1, originalFilename.length()))){//符合
					extNotMatchList.add(originalFilename);
		        	continue;
		        }
				
				file=creatFolder(saveFileName, request);
	        	myfile.transferTo(file);     
	        	
				productServiceMgr.updPic(productId, saveFileName);
			}
			i++;
		}
		if(overLimitSizeList.isEmpty() && extNotMatchList.isEmpty()){
			return ajaxDoneSuccess("图片上传成功");
		}else{
			StringBuffer sb = new StringBuffer();
			if(!overLimitSizeList.isEmpty()){
				sb.append("如下图片因为大小超过20K而上传失败：\n"+overLimitSizeList);
			}
			if(!extNotMatchList.isEmpty()){
				sb.append("如下图片因为类型不符而上传失败：\n"+extNotMatchList);
			}
			return ajaxDoneError(sb.toString());
		}
	}
	
	private boolean checkImg(String ext) {
		List fileTypes = new ArrayList();  
        fileTypes.add("jpg");  
        fileTypes.add("jpeg");  
        fileTypes.add("bmp");  
        fileTypes.add("gif");  
      //对扩展名进行小写转换  
        ext = ext.toLowerCase(); 
        return fileTypes.contains(ext);//符合条件的图片   
	}
	
    private File creatFolder(String fileName, HttpServletRequest request) {  
         File file = null;  
         String address = request.getSession().getServletContext().getRealPath("/styles/theme/img/product/")+"/"+fileName;
         file=new File(address);  
         return file;  
    }
    
    @RequestMapping("/goImport")
    public String goImport(){
    	return "/goods/product/import";
    }
    
    @RequestMapping(value="/import")
	public String importProduct(@RequestParam(value="file", required=false) MultipartFile file, Model model) throws Exception {
    	if(file != null){
    		List<String[]> infoList = ExcelImportUtil.read(file.getInputStream(), file.getOriginalFilename(), 7, false);
        	List<Product> productList = productServiceMgr.buildProductList(infoList, getSessionOper());
        	model.addAttribute("productList", productList);
    	}
		return "/goods/product/import";
	}
    
    @SystemLog("导入基础产品")
    @RequestMapping(value="/doImport", method=RequestMethod.POST)
	public ModelAndView doImport(ProductImportVO vo, Model model) {
    	
    	List<Product> productList = vo.getProductList();
		if(productList == null) return ajaxDoneError("没有可以提交的数据！");
		
		productServiceMgr.importData(productList, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
    
}
