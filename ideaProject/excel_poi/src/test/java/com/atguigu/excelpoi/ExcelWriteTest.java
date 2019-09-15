package com.atguigu.excelpoi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriteTest {
    @Test
    public void testWrite03() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("会员统计表");

        HSSFRow row1 = sheet.createRow(0);
        HSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("今日人数");
        HSSFCell cell2 = row1.createCell(1);
        cell2.setCellValue(666);

        HSSFRow row2 = sheet.createRow(1);
        HSSFCell cell3 = row2.createCell(0);
        cell3.setCellValue("时间");
        HSSFCell cell4 = row2.createCell(1);
        String dateTime = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell4.setCellValue(dateTime);

        FileOutputStream outputStream = new FileOutputStream("e:/excel-poi/test-write03.xls");

        workbook.write(outputStream);

        outputStream.close();

        System.out.println("文件生成成功");


    }
    @Test
    public void testWrite07() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("会员统计表");

        Row row1 = sheet.createRow(0);
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("今日人数");
        Cell cell2 = row1.createCell(1);
        cell2.setCellValue(666);

        Row row2 = sheet.createRow(1);
        Cell cell3 = row2.createCell(0);
        cell3.setCellValue("时间");
        Cell cell4 = row2.createCell(1);
        String dateTime = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell4.setCellValue(dateTime);

        FileOutputStream outputStream = new FileOutputStream("e:/excel-poi/test-write07.xlsx");

        workbook.write(outputStream);

        outputStream.close();

        System.out.println("文件生成成功");

    }

    @Test
    public void testWrite03BigData() throws IOException {
        long begin = System.currentTimeMillis();

        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream outputStream = new FileOutputStream("e:/excel-poi/test-write03-bigdata.xls");

        workbook.write(outputStream);

        outputStream.close();

        long end = System.currentTimeMillis();

        System.out.println("使用时间"+(end-begin));
    }

    @Test
    public void testWrite07BigData() throws IOException {
        long begin = System.currentTimeMillis();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream outputStream = new FileOutputStream("e:/excel-poi/test-write07-bigdata.xlsx");

        workbook.write(outputStream);

        outputStream.close();

        long end = System.currentTimeMillis();

        System.out.println("使用时间"+(end-begin));
    }

    @Test
    public void testWrite03BigDataFast() throws IOException {
        long begin = System.currentTimeMillis();

        Workbook workbook = new SXSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream outputStream = new FileOutputStream("e:/excel-poi/test-write07-bigdata-fast.xlsx");

        workbook.write(outputStream);

        outputStream.close();

        ((SXSSFWorkbook)workbook).dispose();

        long end = System.currentTimeMillis();

        System.out.println("使用时间"+(end-begin));
    }
}
