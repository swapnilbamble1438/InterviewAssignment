package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dao.TransactionDAO;
import com.entity.Transaction;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date fromDate = (req.getParameter("fromDate") != null && !req.getParameter("fromDate").isEmpty())
                    ? sdf.parse(req.getParameter("fromDate"))
                    : null;

            Date toDate = (req.getParameter("toDate") != null && !req.getParameter("toDate").isEmpty())
                    ? sdf.parse(req.getParameter("toDate"))
                    : null;

            String status = req.getParameter("status");
            String bank = req.getParameter("bank");
            String corporateId = req.getParameter("corporateId");

            TransactionDAO dao = new TransactionDAO();
            List<Transaction> list =
                    dao.search(fromDate, toDate, status, bank, corporateId);

            String type = req.getParameter("type");

            if ("xlsx".equalsIgnoreCase(type)) {
                exportExcel(list, res);
            } else if ("pdf".equalsIgnoreCase(type)) {
                exportPdf(list, res);
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    /* ============================ XLSX EXPORT ============================ */

    private void exportExcel(List<Transaction> list, HttpServletResponse res)
            throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Transactions");

        String[] headers = {
            "ID", "Corporate ID", "Unique ID", "Beneficiary Name",
            "Account Number", "IFSC", "Bank Name", "Amount",
            "Currency", "Transaction Type", "Status",
            "Channel", "Remarks", "Created By",
            "Created Date", "Updated Date"
        };

        XSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        int rowNum = 1;
        for (Transaction t : list) {
            XSSFRow row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(t.getId());
            row.createCell(1).setCellValue(t.getCorporateId());
            row.createCell(2).setCellValue(t.getUniqueId());
            row.createCell(3).setCellValue(t.getBeneficiaryName());
            row.createCell(4).setCellValue(t.getAccountNumber());
            row.createCell(5).setCellValue(t.getIfsc());
            row.createCell(6).setCellValue(t.getBankName());
            row.createCell(7).setCellValue(t.getAmount());
            row.createCell(8).setCellValue(t.getCurrency());
            row.createCell(9).setCellValue(t.getTransactionType());
            row.createCell(10).setCellValue(t.getTransactionStatus());
            row.createCell(11).setCellValue(t.getChannel());
            row.createCell(12).setCellValue(t.getRemarks());
            row.createCell(13).setCellValue(t.getCreatedBy());
            row.createCell(14).setCellValue(String.valueOf(t.getCreatedDate()));
            row.createCell(15).setCellValue(String.valueOf(t.getUpdatedDate()));
        }

        res.setContentType(
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        res.setHeader("Content-Disposition",
            "attachment; filename=transactions.xlsx");

        workbook.write(res.getOutputStream());
        workbook.close();
    }

    /* ============================ PDF EXPORT ============================ */

    private void exportPdf(List<Transaction> list, HttpServletResponse res)
            throws Exception {

        res.setContentType("application/pdf");
        res.setHeader("Content-Disposition",
            "attachment; filename=transactions.pdf");

        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, res.getOutputStream());
        document.open();

        PdfPTable table = new PdfPTable(16);
        table.setWidthPercentage(100);

        String[] headers = {
            "ID", "Corporate ID", "Unique ID", "Beneficiary",
            "Account", "IFSC", "Bank", "Amount",
            "Currency", "Type", "Status",
            "Channel", "Remarks", "Created By",
            "Created Date", "Updated Date"
        };

        for (String h : headers) {
            table.addCell(new PdfPCell(new Phrase(h)));
        }

        for (Transaction t : list) {
            table.addCell(String.valueOf(t.getId()));
            table.addCell(t.getCorporateId());
            table.addCell(t.getUniqueId());
            table.addCell(t.getBeneficiaryName());
            table.addCell(t.getAccountNumber());
            table.addCell(t.getIfsc());
            table.addCell(t.getBankName());
            table.addCell(String.valueOf(t.getAmount()));
            table.addCell(t.getCurrency());
            table.addCell(t.getTransactionType());
            table.addCell(t.getTransactionStatus());
            table.addCell(t.getChannel());
            table.addCell(t.getRemarks());
            table.addCell(t.getCreatedBy());
            table.addCell(String.valueOf(t.getCreatedDate()));
            table.addCell(String.valueOf(t.getUpdatedDate()));
        }

        document.add(table);
        document.close();
    }
}
