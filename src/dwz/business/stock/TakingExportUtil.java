package dwz.business.stock;

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

public class TakingExportUtil {
	
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
	
	public static void exportToExcel(StockTaking stockTaking, List<StockTakingDetail> stockTakingDetailList, SessionOper sessionOper, HttpServletResponse response) {
		
		String fileName = "盘库单"+stockTaking.getStockTakingNo();
		String compName = sessionOper.getOrgName();
		String compEngName = sessionOper.getEngName();
		String tel = "Tel（电话）："+sessionOper.getTel()+"  Fax（传真）："+sessionOper.getFax();
		String address = "ADD（地址）："+sessionOper.getAddress();
		String title = "盘库单\r\n"+stockTaking.getStockTakingNo();
		String name = ParameterUtil.getColumnValue("SYS_OPER.REAL_NAME", String.valueOf(stockTaking.getRegOperId()));
		String date = new SimpleDateFormat("yyyy-MM-dd").format(stockTaking.getRegTime());
		int index = 7;
		
		String[] headers ={"编号","厂家","型号","产品名","规格","锁定数","可用数","盘点可用数","可用数变化"};
		CellStyle[] styles = {CellStyle.NUMBER, CellStyle.STRING, CellStyle.STRING, CellStyle.STRING, CellStyle.STRING, CellStyle.NUMBER, CellStyle.NUMBER, CellStyle.NUMBER, CellStyle.NUMBER}; 
		
		List<TakingRptBO> dataList = new ArrayList<TakingRptBO>();
		int no = 1;
		for(StockTakingDetail stockTakingDetail : stockTakingDetailList){
			
			TakingRptBO data = new TakingRptBO();
			data.setNo(no);
			data.setProviderName(stockTakingDetail.getProviderName());
			data.setProductModel(stockTakingDetail.getProductModel());
			data.setProductName(stockTakingDetail.getProductName());
			data.setStandard(stockTakingDetail.getStandard());
			data.setLockQuantity(stockTakingDetail.getLockQuantity());
			data.setCanUseQuantity(stockTakingDetail.getTotalQuantity() - stockTakingDetail.getLockQuantity());
			data.setTakingQuantity(stockTakingDetail.getTakingQuantity());
			data.setChangeQuantity(stockTakingDetail.getTakingQuantity() - (stockTakingDetail.getTotalQuantity() - stockTakingDetail.getLockQuantity()));
			dataList.add(data);
			
			no++;
		}
		
		HSSFWorkbook workbook = new HSSFWorkbook();  
		HSSFSheet sheet = workbook.createSheet();  
		sheet.setDefaultColumnWidth(12);
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
		
		
		//-------------------------------第六行：小信息--------------------------------
		row = sheet.createRow(5);  
		row.setHeightInPoints((float)25);//设置行高
		
		cell = row.createCell(0);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		text = new HSSFRichTextString("盘库人：");
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
		text = new HSSFRichTextString("盘库日期：");
		cell.setCellValue(text);
		
		cell = row.createCell(8);
		formatCell(workbook, cell, CellStyle.STRING, true, 12, false);
		text = new HSSFRichTextString(date);
		cell.setCellValue(text);
		
		
		//------------------------------表头-------------------------------
		row = sheet.createRow(6);  
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
