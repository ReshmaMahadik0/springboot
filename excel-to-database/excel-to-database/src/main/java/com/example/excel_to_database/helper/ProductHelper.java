package com.example.excel_to_database.helper;

import com.example.excel_to_database.entity.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductHelper {

    public static boolean checkExcelFormat(MultipartFile file){

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }else {
            return false;
        }


    }
    public static List<Product> convertExcelToListOfProduct(InputStream inputStream){
        List<Product> list = new ArrayList<>();
        try{
           XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
           XSSFSheet sheets = workbook.getSheet("data");
           int rowNumber = 0;

           Iterator<Row> iterator = sheets.iterator();
           while (iterator.hasNext()){
               Row row = iterator.next();
               if (rowNumber == 0){
                   rowNumber++;
                   continue;
               }
               Iterator<Cell> cells = row.iterator();
               int cid = 0;
               Product p = new Product();
               DataFormatter formatter = new DataFormatter();

               while (cells.hasNext()){
                   Cell cell = cells.next();

                   switch (cid){
                       case 0 :
                           p.setProductId((long) cell.getNumericCellValue());
                           break;
                       case 1:
                           p.setProductName(formatter.formatCellValue(cell));
                           break;
                       case 2:
                           p.setProductDesc(formatter.formatCellValue(cell));
                           break;
                       case 3:
                           p.setPrice(cell.getNumericCellValue());
                           break;
                       default:
                           break;
                   }
                   cid++;
               }
               list.add( p);
           }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
