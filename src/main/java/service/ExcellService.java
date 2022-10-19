package service;

import dao.FileDao;
import dao.FileDaoImpl;
import entity.FileEntity;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ExcellService {

    FileDao fileDao = new FileDaoImpl();

    public void createExcelFile(String path, String pathExerciseTwo) throws IOException {

        List<FileEntity> fileEntityList = loadInfo();

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet();
            sheet.setColumnWidth(0, 2800);
            sheet.setColumnWidth(1, 2800);
            sheet.setColumnWidth(2, 2800);
            sheet.setColumnWidth(3, 2800);
            sheet.setColumnWidth(4, 2800);
            sheet.setColumnWidth(5, 2800);
            sheet.setColumnWidth(6, 2800);
            sheet.setColumnWidth(7, 2800);
            sheet.setColumnWidth(8, 2800);

            createHeader(sheet, workbook.createCellStyle(), workbook.createFont());
            createRows(fileEntityList, sheet, workbook.createCellStyle(), workbook.createFont());

            fileDao.createExcelInDisk(workbook, path, pathExerciseTwo);

        } catch (IOException e) {
            System.err.println("Error en la creacion del workbook: " + e.getMessage());
        }
    }
    private List<FileEntity> loadInfo() throws IOException {

        File fileInvoice = new File("src/main/resources/invoice_202009.csv");
        List<String> lines = fileDao.getLinesInFiles(fileInvoice);
        List<FileEntity> fileEntityList = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] splitLine = lines.get(i).split(";");
            fileDao.replaceCaracters(splitLine);
            double totalCost = Double.parseDouble(splitLine[4]) + Double.parseDouble(splitLine[5]) +
                    Double.parseDouble(splitLine[6]);
            double benefit = Double.parseDouble(splitLine[3]) - totalCost;
            BigDecimal formatNumber = new BigDecimal(benefit);
            formatNumber = formatNumber.setScale(2, RoundingMode.DOWN);

            fileEntityList.add(new FileEntity(splitLine[0], splitLine[1], splitLine[2],
                    Double.parseDouble(splitLine[3]), Double.parseDouble(splitLine[4]),
                    Double.parseDouble(splitLine[5]), Double.parseDouble(splitLine[6]), formatNumber.doubleValue()));
        }
        return fileEntityList;
    }
    private void createHeader(Sheet sheet, CellStyle cellStyle, Font font) {

        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        cellStyle.setVerticalAlignment(VerticalAlignment.TOP);
        cellStyle.setWrapText(true);

        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setTopBorderColor(IndexedColors.GREEN.getIndex());
        cellStyle.setBottomBorderColor(IndexedColors.GREEN.getIndex());
        cellStyle.setLeftBorderColor(IndexedColors.GREEN.getIndex());
        cellStyle.setRightBorderColor(IndexedColors.GREEN.getIndex());

        font.setColor(IndexedColors.BLACK.getIndex());
        font.setBold(true);
        cellStyle.setFont(font);

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        RichTextString text = new XSSFRichTextString("Articulo");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);
        cell.getRow().setHeight((short) 600);

        cell = row.createCell(1);
        text = new XSSFRichTextString("Tipo");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);
        cell.getRow().setHeight((short) 600);

        cell = row.createCell(2);
        text = new XSSFRichTextString("Fecha de venta");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);
        cell.getRow().setHeight((short) 600);

        cell = row.createCell(3);
        text = new XSSFRichTextString("Precio venta");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);
        cell.getRow().setHeight((short) 600);

        cell = row.createCell(4);
        text = new XSSFRichTextString("Costes derivados");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);
        cell.getRow().setHeight((short) 600);

        cell = row.createCell(5);
        text = new XSSFRichTextString("Costes producción");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);
        cell.getRow().setHeight((short) 600);

        cell = row.createCell(6);
        text = new XSSFRichTextString("Impuestos");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);
        cell.getRow().setHeight((short) 600);

        cell = row.createCell(7);
        text = new XSSFRichTextString("Beneficio");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);
        cell.getRow().setHeight((short) 600);
    }
    private void createRows(List<FileEntity> fileEntityList, Sheet sheet, CellStyle cellStyle, Font font) {

        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setTopBorderColor(IndexedColors.GREEN.getIndex());
        cellStyle.setBottomBorderColor(IndexedColors.GREEN.getIndex());
        cellStyle.setLeftBorderColor(IndexedColors.GREEN.getIndex());
        cellStyle.setRightBorderColor(IndexedColors.GREEN.getIndex());

        font.setColor(IndexedColors.BLACK.getIndex());
        font.setBold(false);
        cellStyle.setFont(font);

        for (int i = 0; i < fileEntityList.size(); i++) {
            FileEntity fileEntity = fileEntityList.get(i);

            Row row = sheet.createRow(i + 1);

            Cell cell = row.createCell(0);
            RichTextString text = new XSSFRichTextString(fileEntity.getArticle());
            cell.setCellValue(text);
            cell.setCellStyle(cellStyle);
            cell.getRow().setHeight((short) 600);

            cell = row.createCell(1);
            text = new XSSFRichTextString(fileEntity.getType());
            cell.setCellValue(text);
            cell.setCellStyle(cellStyle);
            cell.getRow().setHeight((short) 600);

            cell = row.createCell(2);
            text = new XSSFRichTextString(fileEntity.getSaleDate());
            cell.setCellValue(text);
            cell.setCellStyle(cellStyle);
            cell.getRow().setHeight((short) 600);

            cell = row.createCell(3);
            text = new XSSFRichTextString(String.valueOf(fileEntity.getSalePrice()));
            cell.setCellValue(text);
            cell.setCellStyle(cellStyle);
            cell.getRow().setHeight((short) 600);

            cell = row.createCell(4);
            text = new XSSFRichTextString(String.valueOf(fileEntity.getDerivedCosts()));
            cell.setCellValue(text);
            cell.setCellStyle(cellStyle);
            cell.getRow().setHeight((short) 600);

            cell = row.createCell(5);
            text = new XSSFRichTextString(String.valueOf(fileEntity.getProductionCosts()));
            cell.setCellValue(text);
            cell.setCellStyle(cellStyle);
            cell.getRow().setHeight((short) 600);

            cell = row.createCell(6);
            text = new XSSFRichTextString(String.valueOf(fileEntity.getTaxes()));
            cell.setCellValue(text);
            cell.setCellStyle(cellStyle);
            cell.getRow().setHeight((short) 600);

            cell = row.createCell(7);
            text = new XSSFRichTextString(String.valueOf(fileEntity.getBenefit()));
            cell.setCellValue(text);
            cell.setCellStyle(cellStyle);
            cell.getRow().setHeight((short) 600);

            ConditionalFormattingRule rule1 = sheet.getSheetConditionalFormatting().createConditionalFormattingRule("MOD(ROW() - 1, 2) = 1");
            PatternFormatting patternFmt = rule1.createPatternFormatting();

            patternFmt.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            patternFmt.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

            CellRangeAddress[] regions = {
                    CellRangeAddress.valueOf("A1:H" + fileEntityList.size())
            };

            sheet.getSheetConditionalFormatting().addConditionalFormatting(regions, rule1);
        }
    }
}
