package com.primusbank.testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtills {
	
	public static FileInputStream fi;
	public static Workbook wb;
	public static Sheet ws;
	public static Row row;
	public static Cell cell;
	public static FileOutputStream fo;
	
	
	public static int getrowCount(String xlfile, String xlsheet) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
	    int rowcount=ws.getLastRowNum();
	   
	    
	    wb.close();
	    fi.close();
	    return rowcount;
	 			
	}
	public static int getcolCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row=ws.getRow(rownum);
	    int colcount=row.getLastCellNum();
	    
	    wb.close();
	    fi.close();
	    return colcount;
		 
	}
	public static String getCelldata(String xlfile, String xlsheet,int rownum, int colnum ) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		String data;
		try {
			cell=row.getCell(colnum);
			data=cell.getStringCellValue();
		} catch (Exception e) {
			data=" ";
		}
		wb.close();
		fi.close();
		return data;
					
		
	}
	
	public static void setCelldata(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
	    wb.write(fo);
	    wb.close();
	    fi.close();
	    fo.close();
	    		
	}
	
	public static void fillGreeencolor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		
	    CellStyle style=wb.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    cell.setCellStyle(style);
	    
	    fo=new FileOutputStream(xlfile);
	    wb.write(fo);
	    wb.close();
	    fi.close();
	    fo.close();
	    						
	}
	
	public static void fillRedcolor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		
	    CellStyle style=wb.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.RED.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    cell.setCellStyle(style);
	    
	    fo=new FileOutputStream(xlfile);
	    wb.write(fo);
	    wb.close();
	    fi.close();
	    fo.close();

	}

}
