package dwz.common.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExportUtil {
	
	/**
	 * Excel导出
	 * @param fileName excel名称
	 * @param sheetName 
	 * @param headers  表头标题
	 * @param dataset  数据内容
	 * @param response
	 */
	public static void exportToExcel(String fileName,String sheetName, String[] headers, Collection dataset, HttpServletResponse response) {  
		exportToExcel(null, fileName, sheetName, headers, dataset, response);
	}
	
	/**
	 * Excel导出
	 * @param fileName excel名称
	 * @param sheetName 
	 * @param headers  表头标题
	 * @param dataset  数据内容
	 * @param response
	 * @param remark   备注内容
	 */
	public static void exportToExcel(String subject,String fileName,String sheetName, String[] headers, Collection dataset, HttpServletResponse response) {  
		exportToExcel(subject,fileName, sheetName, headers, dataset, response, null, null,null);
	}
	
	/**
	 * Excel导出
	 * @param fileName excel名称
	 * @param sheetName 
	 * @param headers  表头标题
	 * @param dataset  数据内容
	 * @param response
	 * @param remark   备注内容
	 * @param rowspanIndex  跨行索引
	
	public static void exportToExcel(String fileName,String sheetName, String[] headers, Collection dataset, HttpServletResponse response,String remark,Integer rowspanIndex[]) {  
		exportToExcel(null,fileName, sheetName, headers, dataset, response, remark,rowspanIndex, "yyyy-MM-dd");
	} */
	
	/**
	 * Excel导出(属性反射生成)
	 * @param fileName excel名称
	 * @param sheetName 
	 * @param headers  表头标题
	 * @param dataset  数据内容
	 * @param response
	 * @param remark   备注内容
	 * @param rowspanIndex  跨行索引
	 * @param pattern  时间转换格式
	 */
	public static void exportToExcel(String subject,String fileName,String sheetName, String[] headers, Collection dataset, 
			HttpServletResponse response,String remark,Integer rowspanIndex[], String pattern) {  
	    // 声明一个工作薄  
	    HSSFWorkbook workbook = new HSSFWorkbook();  
	    // 生成一个表格  
	    HSSFSheet sheet = workbook.createSheet(sheetName);  
	    // 设置表格默认列宽度为15个字节  
	    sheet.setDefaultColumnWidth( 15);  
	    
	    int index = 0;  
	    
	    HSSFRow row = null;
	    //主题栏
	    if(subject!=null){
	    	 //主题栏样式
		    /*HSSFCellStyle subjectStyle = workbook.createCellStyle();  
		    subjectStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
		    subjectStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
		    subjectStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
		    subjectStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
		    subjectStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  
		    subjectStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  
		    subjectStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
		    subjectStyle.setWrapText(true);
		    
		    // 主题栏字体  
		    HSSFFont subjectfont = workbook.createFont();  
		    subjectfont.setColor(HSSFColor.VIOLET.index);  
		    subjectfont.setFontHeightInPoints((short) 15);  
		    subjectfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
		    // 把字体应用到当前的样式  
		    subjectStyle.setFont(subjectfont); 
		    
		    row = sheet.createRow(index);  
		    row.setHeight((short)1200);
		    
		    HSSFCell cell = row.createCell(0);  
	        cell.setCellStyle(subjectStyle);  
	     
	        HSSFRichTextString text = new HSSFRichTextString(subject);  
	        cell.setCellValue(text);  
	        
	        //sheet.addMergedRegion(new Region(0, (short)0, 0,  (short)(headers.length-1)));
	        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length-1));*/
		    index++;
	    }
	    
	    //表头栏样式
	    HSSFCellStyle headstyle = workbook.createCellStyle();  
	    /*headstyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
	    headstyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	    headstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
	    headstyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
	    headstyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  
	    headstyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  
	    headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	    // 表头栏字体  
	    HSSFFont headfont = workbook.createFont();  
	    headfont.setColor(HSSFColor.VIOLET.index);  
	    headfont.setFontHeightInPoints((short) 13);  
	    headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
	    // 把字体应用到当前的样式  
	    headstyle.setFont(headfont);*/
	    
	    // 正文栏样式  
	    HSSFCellStyle bodyStyle = workbook.createCellStyle();  
	    /*bodyStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);  
	    bodyStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	    bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
	    bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
	    bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  
	    bodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  
	    bodyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	    bodyStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
	    // 正文栏字体  
	    HSSFFont bodyFont = workbook.createFont();  
	    bodyFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
	    bodyFont.setFontHeightInPoints((short) 12);  
	    bodyStyle.setFont(bodyFont);*/
	  
	    // 声明一个画图的顶级管理器  
	   // HSSFPatriarch patriarch = sheet.createDrawingPatriarch();  
	    // 定义注释的大小和位置,详见文档  
	   // HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,  0, 0, 0, (short) 4, 2, (short) 6, 5));  
	    // 设置注释内容  
	    //comment.setString(new HSSFRichTextString(remark==null?"":"备注："+remark));  
	    // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.  
	   // comment.setAuthor("航天电子");  
	  
	    // 产生表格标题行  
	    row = sheet.createRow(index);  
	    for (int i = 0; i < headers.length; i++) {  
	        HSSFCell cell = row.createCell(i);  
	        cell.setCellStyle(headstyle);  
	        HSSFRichTextString text = new HSSFRichTextString(headers[i]);  
	        HSSFFont font = workbook.createFont();  
	        font.setColor(HSSFColor.BLUE.index);  
            text.applyFont(font);  
	        cell.setCellValue(text);  
	    }  
	  
	    // 遍历集合数据，产生数据行  
	    Iterator it = dataset.iterator();  
	  
	    while (it.hasNext()) {  
	        index++;  
	        row = sheet.createRow(index);  
	        row.setHeight((short) 350);//行哥
	        Object t = it.next(); //这里不要使用泛型强制转换  
	        // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值  
	        Field[] fields = t.getClass().getDeclaredFields();  
	        for (int i = 0; i < fields.length; i++) {  
	            HSSFCell cell = row.createCell(i);  
	            cell.setCellStyle(bodyStyle);  
	            Field field = fields[i];  
	            String fieldName = field.getName();  
	            String getMethodName = "get"  + fieldName.substring(0, 1).toUpperCase()  + fieldName.substring(1);  
	            try {  
	                Method getMethod = t.getClass().getMethod(getMethodName,  new Class[] {});  
	                Object value = getMethod.invoke(t, new Object[] {});  
	                // 判断值的类型后进行强制类型转换  
	                String textValue = "";  
	                value= value==null?"":value;
	                if (value instanceof Date) {  
	                    textValue = new SimpleDateFormat(pattern).format((Date) value);  
	                }else {  
	                    textValue = value.toString();  
	                }  
                    HSSFRichTextString richString = new HSSFRichTextString(textValue);  
                    HSSFFont font3 = workbook.createFont();  
                    font3.setColor(HSSFColor.BLUE.index);  
                    richString.applyFont(font3);  
                    cell.setCellValue(richString);  
	            }catch (NoSuchMethodException e) {  
	                e.printStackTrace();  
	            } catch (IllegalArgumentException e) {  
	                e.printStackTrace();  
	            } catch (IllegalAccessException e) {  
	                e.printStackTrace();  
	            } catch (InvocationTargetException e) {  
	                e.printStackTrace();  
	            } finally {  
	                // 清理资源  
	            }  
	        }  
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
	
	/**
	 *  Excel导出 (自定义属性)
	 * @param fileName
	 * @param sheetName
	 * @param headers
	 * @param property 属性名称
	 * @param dataset
	 * @param response
	 */
	public static void exportToExcel2(String fileName,String sheetName, String[] headers,String [] property, Collection dataset, HttpServletResponse response) {  
		exportToExcel2(fileName, sheetName, headers, property, dataset, response, null, "yyyy-MM-dd");
	}
	/**
	 * Excel导出 (自定义属性)
	 * @param fileName excel名称
	 * @param sheetName 
	 * @param headers  表头标题
	 * @param property 属性名称
	 * @param dataset  数据内容
	 * @param response
	 * @param remark   备注内容
	 * @param rowspanIndex  跨行索引
	 * @param pattern  时间转换格式
	 */
	@SuppressWarnings( { "rawtypes" })  
	public static void exportToExcel2(String fileName,String sheetName, String[] headers,String [] property, Collection dataset, 
			HttpServletResponse response,String remark, String pattern) {  
	    // 声明一个工作薄  
	    HSSFWorkbook workbook = new HSSFWorkbook();  
	    // 生成一个表格  
	    HSSFSheet sheet = workbook.createSheet(sheetName);  
	    // 设置表格默认列宽度为15个字节  
	    sheet.setDefaultColumnWidth( 15);  
	    
	    //表头栏样式
	    HSSFCellStyle headstyle = workbook.createCellStyle();  
	    headstyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
	    headstyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	    headstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
	    headstyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
	    headstyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  
	    headstyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  
	    headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	    // 表头栏字体  
	    HSSFFont headfont = workbook.createFont();  
	    headfont.setColor(HSSFColor.VIOLET.index);  
	    headfont.setFontHeightInPoints((short) 13);  
	    headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
	    // 把字体应用到当前的样式  
	    headstyle.setFont(headfont);  
	    
	    // 正文栏样式  
	    HSSFCellStyle bodyStyle = workbook.createCellStyle();  
	    bodyStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);  
	    bodyStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	    bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
	    bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
	    bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  
	    bodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  
	    bodyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	    bodyStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
	    // 正文栏字体  
	    HSSFFont bodyFont = workbook.createFont();  
	    bodyFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
	    bodyFont.setFontHeightInPoints((short) 12);  
	    bodyStyle.setFont(bodyFont);  
	  
	    // 声明一个画图的顶级管理器  
	    HSSFPatriarch patriarch = sheet.createDrawingPatriarch();  
	    // 定义注释的大小和位置,详见文档  
	    HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,  0, 0, 0, (short) 4, 2, (short) 6, 5));  
	    // 设置注释内容  
	    comment.setString(new HSSFRichTextString(remark==null?"":"备注："+remark));  
	    // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.  
	    comment.setAuthor("航天电子");  
	  
	    // 产生表格标题行  
	    HSSFRow row = sheet.createRow(0);  
	    for (int i = 0; i < headers.length; i++) {  
	        HSSFCell cell = row.createCell(i);  
	        cell.setCellStyle(headstyle);  
	        HSSFRichTextString text = new HSSFRichTextString(headers[i]);  
	        cell.setCellValue(text);  
	    }  
	  
	    // 遍历集合数据，产生数据行  
	    Iterator it = dataset.iterator();  
	    int index = 0;  
	    while (it.hasNext()) {  
	        index++;  
	        row = sheet.createRow(index);  
	        row.setHeight((short) 350);//行哥
	        Object t = it.next(); //这里不要使用泛型强制转换  
	        // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值  
	        for (int i = 0; i < property.length; i++) {  
	            HSSFCell cell = row.createCell(i);  
	            cell.setCellStyle(bodyStyle);  
	            String fieldName = property[i];  
	            String getMethodName = "get"  + fieldName.substring(0, 1).toUpperCase()  + fieldName.substring(1);  
	            try {  
	                Method getMethod = t.getClass().getMethod(getMethodName,  new Class[] {});  
	                Object value = getMethod.invoke(t, new Object[] {});  
	                // 判断值的类型后进行强制类型转换  
	                String textValue = "";  
	                value= value==null?"":value;
	                if (value instanceof Date) {  
	                    textValue = new SimpleDateFormat(pattern).format((Date) value);  
	                }else {  
	                    textValue = value.toString();  
	                }  
                    HSSFRichTextString richString = new HSSFRichTextString(textValue);  
                    HSSFFont font3 = workbook.createFont();  
                    font3.setColor(HSSFColor.BLUE.index);  
                    richString.applyFont(font3);  
                    cell.setCellValue(richString);  
	            }catch (NoSuchMethodException e) {  
	                e.printStackTrace();  
	            } catch (IllegalArgumentException e) {  
	                e.printStackTrace();  
	            } catch (IllegalAccessException e) {  
	                e.printStackTrace();  
	            } catch (InvocationTargetException e) {  
	                e.printStackTrace();  
	            } finally {  
	                // 清理资源  
	            }  
	        }  
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
