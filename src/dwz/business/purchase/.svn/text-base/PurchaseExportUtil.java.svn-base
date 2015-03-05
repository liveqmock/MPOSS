package dwz.business.purchase;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.ibm.icu.text.SimpleDateFormat;

import dwz.business.common.SessionOper;
import dwz.common.util.CellStyle;
import dwz.common.util.ParameterUtil;

public class PurchaseExportUtil {
	
	private static void formatCell(HSSFWorkbook workbook, HSSFCell cell, Enum<CellStyle> cellStyle, boolean border, int fontSize, boolean bold ){
		
		HSSFCellStyle style = workbook.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
		style.setWrapText(true);
		
		if(cellStyle.name() == "NUMBER"){
			style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
        }else if(cellStyle.name() == "PRICE"){
        	style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        }else if(cellStyle.name() == "WEIGHT"){
        	style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        }else if(cellStyle.name() == "VOLUME"){
        	style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000000"));
        }else if(cellStyle.name() == "DATE"){
         	style.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-dd"));
        }else if(cellStyle.name() == "DATETIME"){
        	style.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
        }
		
		if(border){
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		}
		
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) fontSize);
		if(bold){
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		}
		
		style.setFont(font); 
		cell.setCellStyle(style);
	}
	
	public static void exportToExcel(Purchase purchase, List<PurchaseDetail> purchaseDetailList, SessionOper sessionOper, HttpServletResponse response) {
		
		String fileName = "采购单"+purchase.getPurchaseNo();
		String compName = sessionOper.getOrgName();
		String compEngName = sessionOper.getEngName();
		String tel = "Tel（电话）："+sessionOper.getTel()+"  Fax（传真）："+sessionOper.getFax();
		String address = "ADD（地址）："+sessionOper.getAddress();
		String title = "采购订货单\r\n"+purchase.getPurchaseNo();
		String contractNo = purchase.getContractNo();
		String name = purchase.getProviderName();
		String date = new SimpleDateFormat("yyyy-MM-dd").format(purchase.getCreateTime());
		int index = 8;
		
		String[] headers ={"编号\r\nNO.","产品型号\r\nMODEL","产品名称\r\nITEM ","规格\r\nSTANDARD","单位\r\nUNIT","数量\r\nQUANTITY","单价\r\nPRICE","金额\r\nAMOUNT","图片\r\nPIC"};
		int[] columeWidths = {13,13,13,14,8,12,10,13,13};
		CellStyle[] styles = {CellStyle.NUMBER, CellStyle.STRING, CellStyle.STRING, CellStyle.STRING, CellStyle.STRING, CellStyle.NUMBER, CellStyle.PRICE, CellStyle.PRICE, CellStyle.STRING}; 
		
		List<PurchaseRptBO> dataList = new ArrayList<PurchaseRptBO>();
		int no = 1;
		int totalPurchaseQuantity = 0;
		int totalPurchasePrice = 0;
		for(PurchaseDetail purchaseDetail : purchaseDetailList){
			if(purchaseDetail.getPurchaseQuantity() == 0) continue;
			
			PurchaseRptBO data = new PurchaseRptBO();
			data.setNo(no);
			data.setProductModel(purchaseDetail.getProductModel());
			data.setProductName(purchaseDetail.getProductName());
			data.setStandard(purchaseDetail.getStandard());
			data.setUnit(purchaseDetail.getUnit());
			data.setPurchaseQuantity(purchaseDetail.getPurchaseQuantity());
			int purchaseUnitPrice = purchaseDetail.getPurchaseUnitPrice();
			data.setInputPurchaseUnitPrice(ParameterUtil.fromF2Y(purchaseUnitPrice));
			int purchasePrice = purchaseDetail.getPurchasePrice();
			data.setInputPurchasePrice(ParameterUtil.fromF2Y(purchasePrice));
			data.setPic(purchaseDetail.getPic());
			dataList.add(data);
			
			totalPurchaseQuantity += purchaseDetail.getPurchaseQuantity();
			totalPurchasePrice += purchasePrice;
			
			no++;
		}
		
		HSSFWorkbook workbook = new HSSFWorkbook();  
		HSSFSheet sheet = workbook.createSheet();  
		for(int i =0;i<columeWidths.length;i++){
			sheet.setColumnWidth(i, columeWidths[i] * 256);
		}
		sheet.setDefaultRowHeight((short)350);
		
		
		//-------------------------------第一行：公司名----------------------------
		HSSFRow row = sheet.createRow(0);  
		row.setHeightInPoints((float)50);//设置行高
		
		HSSFCell cell = row.createCell(0);
		formatCell(workbook, cell, CellStyle.STRING, false, 24, true);
		HSSFRichTextString text = new HSSFRichTextString(compName);  
		cell.setCellValue(text);

		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length-1));
		
		//-------------------------------第二行：公司英文名----------------------------
		row = sheet.createRow(1);  
		row.setHeightInPoints((float)25);//设置行高
		
		cell = row.createCell(0);
		formatCell(workbook, cell, CellStyle.STRING, false, 12, true);
		text = new HSSFRichTextString(compEngName);  
		cell.setCellValue(text);

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, headers.length-1));
		
		//-------------------------------第三行：联系电话---------------------
		row = sheet.createRow(2);  
		row.setHeightInPoints((float)25);//设置行高
		
		cell = row.createCell(0);
		formatCell(workbook, cell, CellStyle.STRING, false, 12, false);
		text = new HSSFRichTextString(tel);  
		cell.setCellValue(text);

		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, headers.length-1));
		
		//-------------------------------第四行：地址--------------------------
		row = sheet.createRow(3);  
		row.setHeightInPoints((float)25);//设置行高
		
		cell = row.createCell(0);
		formatCell(workbook, cell, CellStyle.STRING, false, 12, false);
		text = new HSSFRichTextString(address);  
		cell.setCellValue(text);

		sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, headers.length-1));
		
		//-------------------------------第五行：标题------------------------------------
		row = sheet.createRow(4);  
		row.setHeightInPoints((float)50);//设置行高
		
		cell = row.createCell(0);
		formatCell(workbook, cell, CellStyle.STRING, false, 16, true);
		text = new HSSFRichTextString(title);  
		cell.setCellValue(text);

		sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, headers.length-1));
		
		//-------------------------------第六行：合同编号------------------------------------
		row = sheet.createRow(5);  
		row.setHeightInPoints((float)25);//设置行高
		
		cell = row.createCell(0);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		text = new HSSFRichTextString("合同编号：");
		cell.setCellValue(text);
		
		cell = row.createCell(1);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		text = new HSSFRichTextString(contractNo);
		cell.setCellValue(text);
		
		cell = row.createCell(2);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(3);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(4);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(5);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(6);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(7);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(8);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		
		//-------------------------------第七行：小信息--------------------------------
		row = sheet.createRow(6);  
		row.setHeightInPoints((float)25);//设置行高
		
		cell = row.createCell(0);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		text = new HSSFRichTextString("NAME：");
		cell.setCellValue(text);
		
		cell = row.createCell(1);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		text = new HSSFRichTextString(name);
		cell.setCellValue(text);
		
		cell = row.createCell(2);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(3);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(4);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(5);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(6);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(7);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		text = new HSSFRichTextString("DATE：");
		cell.setCellValue(text);
		
		cell = row.createCell(8);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		text = new HSSFRichTextString(date);
		cell.setCellValue(text);
		
		
		//------------------------------表头-------------------------------
		row = sheet.createRow(7);  
		row.setHeightInPoints((float)30);//设置行高
		
		for(int i =0; i < headers.length; i++){
			cell = row.createCell(i);
			formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
			text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		
		
		//------------------------------数据-------------------------------
		int totalQuantity = 0;
		double totalPrice = 0;
		Iterator it = dataList.iterator();
		
		while (it.hasNext()) {
			
			row = sheet.createRow(index);
			
			Object t = it.next();
			Field[] fields = t.getClass().getDeclaredFields();
			
			for (int i = 0; i < fields.length; i++) {  
	            cell = row.createCell(i); 
	            formatCell(workbook, cell,styles[i], true, 12, false);
	            
	            Field field = fields[i];  
	            String fieldName = field.getName();  
	            String methodName = "get"  + fieldName.substring(0, 1).toUpperCase()  + fieldName.substring(1);  
	            try {  
	                Method method = t.getClass().getMethod(methodName,  new Class[] {});  
	                Object value = method.invoke(t, new Object[] {});  
	                value = (value == null ? "" : value);
	                
                    text = new HSSFRichTextString(value.toString());  
                    cell.setCellValue(text);
                    
	            }catch (NoSuchMethodException e) {  
	                e.printStackTrace();  
	            } catch (IllegalArgumentException e) {  
	                e.printStackTrace();  
	            } catch (IllegalAccessException e) {  
	                e.printStackTrace();  
	            } catch (InvocationTargetException e) {  
	                e.printStackTrace();  
	            } finally {  
	                
	            }  
	        }
			
			index++;
		}
		
		//-------------------------------末尾行：统计--------------------------------
		row = sheet.createRow(index);  
		row.setHeightInPoints((float)25);//设置行高
		
		cell = row.createCell(0);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(1);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(2);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(3);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(4);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		text = new HSSFRichTextString("合计：");
		cell.setCellValue(text);
		
		cell = row.createCell(5);
		formatCell(workbook, cell, CellStyle.NUMBER, true, 12, false);
		text = new HSSFRichTextString(String.valueOf(totalPurchaseQuantity));
		cell.setCellValue(text);
		
		cell = row.createCell(6);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		cell = row.createCell(7);
		formatCell(workbook, cell, CellStyle.PRICE, true, 12, false);
		text = new HSSFRichTextString(ParameterUtil.fromF2Y(totalPurchasePrice));
		cell.setCellValue(text);
		
		cell = row.createCell(8);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		
		
		//导出文件
		try {  
			fileName+=".xls";
			   // 设置输出的格式
			    response.setContentType("application/vnd.ms-excel;charset=GBK"); 
		    response.addHeader("Content-Disposition", "attachment; filename=\"" +  new String(fileName.getBytes("GBK"), "ISO8859-1") + "\"");
		    workbook.write(response.getOutputStream());  
		    response.getOutputStream().flush();
		} catch (IOException e) {  
		    e.printStackTrace();  
		}
	}
	
}
