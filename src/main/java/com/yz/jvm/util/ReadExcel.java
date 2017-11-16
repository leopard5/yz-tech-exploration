package com.yz.jvm.util;

import com.alibaba.fastjson.JSON;
import com.yz.jvm.as.ASASConsts;
import com.yz.jvm.as.AsCalcTools;
import com.yz.jvm.as.vo.AsCeeDataVO;
import com.yz.jvm.as.vo.AsResultVO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadExcel.class);

//    public static void read(InputStream inputStream) throws IOException {
//        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//
//        int sheetNum = workbook.getNumberOfSheets();
//        //for循环遍历单元格内容
//        for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
//            //根据下标获取sheet
//            XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
//            //workbook.getSheetName(sheetIndex) 根据下标获取sheet 名称
//            System.out.println("sheet序号：" + sheetIndex + "，sheet名称：" + workbook.getSheetName(sheetIndex));
//            //循环该sheet页中的有数据的每一行
//            //打印行号，某人起始是0  System.out.println(sheet.getLastRowNum());
//            //打印行数
//            System.out.println(sheet.getPhysicalNumberOfRows());
//            //遍历每行内容从行号为0开始
//            for (int rowIndex = 0; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
//                //System.out.println(rowIndex);打印遍历行号
//                //根据行号，遍历该行
//                XSSFRow row = sheet.getRow(rowIndex);
//                //如果该行为空，则结束本次循环
//                if (row == null) {
//                    continue;
//                }
//                //num 为该行 有效单元格个数，取 num的话，取值会不全。   lastnum为 有效单元格最后各个单元格的列号，这样可以遍历取到该行所有的单元格
//                //System.out.println("num  " + row.getPhysicalNumberOfCells());
//                //System.out.println("lastnum " + row.getLastCellNum());
//                for (int cellnum = 0; cellnum < row.getLastCellNum(); cellnum++) {
//                    XSSFCell cell = row.getCell(cellnum);
//                    if (cell != null) {
//
//                        cell.setCellType(Cell.CELL_TYPE_STRING);
//                        //cell.setCellType(Cell.CELL_TYPE_STRING); 是为了修改数据类型，因为我的单元格中有数字类型。如果不这样写会出现下面的错误。
//                /*        Exception in thread "main" java.lang.IllegalStateException:
//                         Cannot get a text value from a numeric cell
//                        at org.apache.poi.xssf.usermodel.XSSFCell.typeMismatch(XSSFCell.java:991)
//                        at org.apache.poi.xssf.usermodel.XSSFCell.getRichStringCellValue(XSSFCell.java:399)
//                        at net.oschina.excel.ReadExcel.read(ReadExcel.java:55)
//                        at net.oschina.excel.ReadExcel.main(ReadExcel.java:68)
//
//                        POI操作Excel时数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串并写入数据库时，
//                        就会出现Cannot get a text value from a numeric cell的异常错误，解决办法就是先设置Cell的类型，
//                        然后就可以把纯数字作为String类型读进来了：
//
//                        */
//                        //打印出读出的数据。
//                        System.out.println("第" + rowIndex + "行      第" + cellnum + "列    内容为：" + cell.getRichStringCellValue().getString());
//                    }
//                }
//            }
//            System.out.println("------------------+++++++++++++++++++--------------------");
//        }
//    }

    public static void readASASData(InputStream inputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        int sheetNum = workbook.getNumberOfSheets();
        //for循环遍历单元格内容
        for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
            //根据下标获取sheet
            XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
            System.out.println("sheet序号：" + sheetIndex + "，sheet名称：" + workbook.getSheetName(sheetIndex));
            System.out.println(sheet.getPhysicalNumberOfRows());

            //遍历每行内容从行号为0开始
            for (int rowIndex = 0; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                XSSFRow row = sheet.getRow(rowIndex);
                if (row == null || rowIndex == 0) {
                    continue;
                }
                List<AsResultVO> difResult = new ArrayList<>();
                AsCeeDataVO baseLine = new AsCeeDataVO();

                AsCeeDataVO data1 = new AsCeeDataVO();
                AsCeeDataVO data2 = new AsCeeDataVO();
                AsCeeDataVO data3 = new AsCeeDataVO();
                AsCeeDataVO data4 = new AsCeeDataVO();
                AsCeeDataVO data5 = new AsCeeDataVO();
                AsCeeDataVO data6 = new AsCeeDataVO();
                AsCeeDataVO data7 = new AsCeeDataVO();

                AsResultVO rawData1 = new AsResultVO();
                AsResultVO rawData2 = new AsResultVO();
                AsResultVO rawData3 = new AsResultVO();
                AsResultVO rawData4 = new AsResultVO();
                AsResultVO rawData5 = new AsResultVO();
                AsResultVO rawData6 = new AsResultVO();
                AsResultVO rawData7 = new AsResultVO();

                AsResultVO vo1 = new AsResultVO();
                AsResultVO vo2 = new AsResultVO();
                AsResultVO vo3 = new AsResultVO();
                AsResultVO vo4 = new AsResultVO();
                AsResultVO vo5 = new AsResultVO();
                AsResultVO vo6 = new AsResultVO();
                AsResultVO vo7 = new AsResultVO();

                for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
                    XSSFCell cell = row.getCell(cellNum);
                    if (cell != null) {
                       switch (cellNum) {
                           case 0:
                               vo1.setDataNo(Long.valueOf(new Double(cell.getNumericCellValue()).longValue()));
                               vo2.setDataNo(Long.valueOf(new Double(cell.getNumericCellValue()).longValue()));
                               vo3.setDataNo(Long.valueOf(new Double(cell.getNumericCellValue()).longValue()));
                               vo4.setDataNo(Long.valueOf(new Double(cell.getNumericCellValue()).longValue()));
                               vo5.setDataNo(Long.valueOf(new Double(cell.getNumericCellValue()).longValue()));
                               vo6.setDataNo(Long.valueOf(new Double(cell.getNumericCellValue()).longValue()));
                               vo7.setDataNo(Long.valueOf(new Double(cell.getNumericCellValue()).longValue()));
                               break;
                           case 1:
                               vo1.setCenterNo(Integer.valueOf(new Double(cell.getNumericCellValue()).intValue()));
                               vo2.setCenterNo(Integer.valueOf(new Double(cell.getNumericCellValue()).intValue()));
                               vo3.setCenterNo(Integer.valueOf(new Double(cell.getNumericCellValue()).intValue()));
                               vo4.setCenterNo(Integer.valueOf(new Double(cell.getNumericCellValue()).intValue()));
                               vo5.setCenterNo(Integer.valueOf(new Double(cell.getNumericCellValue()).intValue()));
                               vo6.setCenterNo(Integer.valueOf(new Double(cell.getNumericCellValue()).intValue()));
                               vo7.setCenterNo(Integer.valueOf(new Double(cell.getNumericCellValue()).intValue()));
                               break;
                           case 2:
                               baseLine.setPainScore(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 3:
                               baseLine.setPga(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 4:
                               baseLine.setInflammatoryReact(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 5:
                               baseLine.setBasfi(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 6:
                               baseLine.setSpinalMobility(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 7:
                               baseLine.setCrp(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;

                           // dif1 start
                           case 8:
                               data1.setPainScore(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 9:
                               data1.setPga(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 10:
                               data1.setInflammatoryReact(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 11:
                               data1.setBasfi(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 12:
                               data1.setSpinalMobility(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 13:
                               data1.setCrp(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;

                           case 14:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData1.setAsas20(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData1.setAsas20(false);
                               }
                               break;
                           case 15:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData1.setAsas40(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData1.setAsas40(false);
                               }
                               break;
                           case 16:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData1.setAsasPr(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData1.setAsasPr(false);
                               }
                               break;
                           case 17:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData1.setAsas56(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData1.setAsas56(false);
                               }
                               break;
                            // dif1 end

                            // dif2 start
                           case 18:
                               data2.setPainScore(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 19:
                               data2.setPga(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 20:
                               data2.setInflammatoryReact(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 21:
                               data2.setBasfi(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 22:
                               data2.setSpinalMobility(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 23:
                               data2.setCrp(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;

                           case 24:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData2.setAsas20(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData2.setAsas20(false);
                               }
                               break;
                           case 25:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData2.setAsas40(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData2.setAsas40(false);
                               }
                               break;
                           case 26:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData2.setAsasPr(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData2.setAsasPr(false);
                               }
                               break;
                           case 27:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData2.setAsas56(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData2.setAsas56(false);
                               }
                               break;
                           // dif2 end

                           // dif3 start
                           case 28:
                               data3.setPainScore(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 29:
                               data3.setPga(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 30:
                               data3.setInflammatoryReact(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 31:
                               data3.setBasfi(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 32:
                               data3.setSpinalMobility(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 33:
                               data3.setCrp(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;

                           case 34:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData3.setAsas20(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData3.setAsas20(false);
                               }
                               break;
                           case 35:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData3.setAsas40(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData3.setAsas40(false);
                               }
                               break;
                           case 36:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData3.setAsasPr(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData3.setAsasPr(false);
                               }
                               break;
                           case 37:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData3.setAsas56(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData3.setAsas56(false);
                               }
                               break;
                           // dif2 end

                           // dif4 start
                           case 38:
                               data4.setPainScore(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 39:
                               data4.setPga(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 40:
                               data4.setInflammatoryReact(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 41:
                               data4.setBasfi(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 42:
                               data4.setSpinalMobility(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 43:
                               data4.setCrp(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;

                           case 44:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData4.setAsas20(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData4.setAsas20(false);
                               }
                               break;
                           case 45:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData4.setAsas40(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData4.setAsas40(false);
                               }
                               break;
                           case 46:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData4.setAsasPr(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData4.setAsasPr(false);
                               }
                               break;
                           case 47:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData4.setAsas56(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData4.setAsas56(false);
                               }
                               break;
                            // dif4 end

                           // dif5 start
                           case 48:
                               data5.setPainScore(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 49:
                               data5.setPga(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 50:
                               data5.setInflammatoryReact(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 51:
                               data5.setBasfi(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 52:
                               data5.setSpinalMobility(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 53:
                               data5.setCrp(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;

                           case 54:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData5.setAsas20(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData5.setAsas20(false);
                               }
                               break;
                           case 55:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData5.setAsas40(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData5.setAsas40(false);
                               }
                               break;
                           case 56:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData5.setAsasPr(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData5.setAsasPr(false);
                               }
                               break;
                           case 57:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData5.setAsas56(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData5.setAsas56(false);
                               }
                               break;
                           // dif5 end

                           // dif6 start
                           case 58:
                               data6.setPainScore(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 59:
                               data6.setPga(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 60:
                               data6.setInflammatoryReact(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 61:
                               data6.setBasfi(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 62:
                               data6.setSpinalMobility(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 63:
                               data6.setCrp(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;

                           case 64:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData6.setAsas20(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData6.setAsas20(false);
                               }
                               break;
                           case 65:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData6.setAsas40(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData6.setAsas40(false);
                               }
                               break;
                           case 66:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData6.setAsasPr(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData6.setAsasPr(false);
                               }
                               break;
                           case 67:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData6.setAsas56(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData6.setAsas56(false);
                               }
                               break;
                           // dif6 end

                           // dif7 start
                           case 68:
                               data7.setPainScore(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 69:
                               data7.setPga(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 70:
                               data7.setInflammatoryReact(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 71:
                               data7.setBasfi(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 72:
                               data7.setSpinalMobility(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;
                           case 73:
                               data7.setCrp(BigDecimal.valueOf(cell.getNumericCellValue()));
                               break;

                           case 74:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData7.setAsas20(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData7.setAsas20(false);
                               }
                               break;
                           case 75:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData7.setAsas40(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData7.setAsas40(false);
                               }
                               break;
                           case 76:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData7.setAsasPr(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData7.setAsasPr(false);
                               }
                               break;
                           case 77:
                               if (BigDecimal.ONE.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData7.setAsas56(true);
                               } else if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(cell.getNumericCellValue())) == 0){
                                   rawData7.setAsas56(false);
                               }
                               break;
                           // dif7 end

                           default:
                       }

                        /**
                         * PAINSC01    夜间背痛和总体背痛
                         * PGA01       受试者对自我疾病总体状况的评估(PGA)
                         * BASDAI07    炎症反应评分
                         * BASFI       BASFI
                         * BASMIS03    腰部侧弯
                         * CRP01       CRP
                         */

                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        System.out.println("第" + rowIndex + "行      第" + cellNum + "列    内容为：" + cell.getRichStringCellValue().getString());
                    }
                }

                vo1.setAsas20(AsCalcTools.calcASAS20(baseLine, data1));
                vo1.setAsas40(AsCalcTools.calcASAS40(baseLine, data1));
                vo1.setAsasPr(AsCalcTools.calcASASpr(baseLine, data1));
                vo1.setAsas56(AsCalcTools.calcASAS56(baseLine, data1));
                if (!rawData1.equals(vo1)) {
                    LOGGER.info("dif1=false, calc={},raw={}", JSON.toJSONString(vo1), JSON.toJSONString(rawData1));
                }

                vo2.setAsas20(AsCalcTools.calcASAS20(baseLine, data2));
                vo2.setAsas40(AsCalcTools.calcASAS40(baseLine, data2));
                vo2.setAsasPr(AsCalcTools.calcASASpr(baseLine, data2));
                vo2.setAsas56(AsCalcTools.calcASAS56(baseLine, data2));
                if (!rawData2.equals(vo2)) {
                    LOGGER.info("dif2=false, calc={},raw={}", JSON.toJSONString(vo2), JSON.toJSONString(rawData2));
                }

                vo3.setAsas20(AsCalcTools.calcASAS20(baseLine, data3));
                vo3.setAsas40(AsCalcTools.calcASAS40(baseLine, data3));
                vo3.setAsasPr(AsCalcTools.calcASASpr(baseLine, data3));
                vo3.setAsas56(AsCalcTools.calcASAS56(baseLine, data3));
                if (!rawData3.equals(vo3)) {
                    LOGGER.info("dif3=false, calc={},raw={}", JSON.toJSONString(vo3), JSON.toJSONString(rawData3));
                }

                vo4.setAsas20(AsCalcTools.calcASAS20(baseLine, data4));
                vo4.setAsas40(AsCalcTools.calcASAS40(baseLine, data4));
                vo4.setAsasPr(AsCalcTools.calcASASpr(baseLine, data4));
                vo4.setAsas56(AsCalcTools.calcASAS56(baseLine, data4));
                if (!rawData4.equals(vo4)) {
                    LOGGER.info("dif4=false, calc={},raw={}", JSON.toJSONString(vo4), JSON.toJSONString(rawData4));
                }

                vo5.setAsas20(AsCalcTools.calcASAS20(baseLine, data5));
                vo5.setAsas40(AsCalcTools.calcASAS40(baseLine, data5));
                vo5.setAsasPr(AsCalcTools.calcASASpr(baseLine, data5));
                vo5.setAsas56(AsCalcTools.calcASAS56(baseLine, data5));
                if (!rawData5.equals(vo5)) {
                    LOGGER.info("dif5=false, calc={},raw={}", JSON.toJSONString(vo5), JSON.toJSONString(rawData5));
                }

                vo6.setAsas20(AsCalcTools.calcASAS20(baseLine, data6));
                vo6.setAsas40(AsCalcTools.calcASAS40(baseLine, data6));
                vo6.setAsasPr(AsCalcTools.calcASASpr(baseLine, data6));
                vo6.setAsas56(AsCalcTools.calcASAS56(baseLine, data6));
                if (!rawData6.equals(vo6)) {
                    LOGGER.info("dif6=false, calc={},raw={}", JSON.toJSONString(vo6), JSON.toJSONString(rawData6));
                }

                vo7.setAsas20(AsCalcTools.calcASAS20(baseLine, data7));
                vo7.setAsas40(AsCalcTools.calcASAS40(baseLine, data7));
                vo7.setAsasPr(AsCalcTools.calcASASpr(baseLine, data7));
                vo7.setAsas56(AsCalcTools.calcASAS56(baseLine, data7));
                if (!rawData7.equals(vo7)) {
                    LOGGER.info("dif7=false, calc={},raw={}", JSON.toJSONString(vo7), JSON.toJSONString(rawData7));
                }
            }
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            //获取文件标识符。
            inputStream = new FileInputStream(new File("D:\\lt_calc\\BIAO9_modify.xlsx"));
            readASASData(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
