package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.dao.TransactionDAO;
import com.entity.Transaction;

public class TransactionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date fromDate = req.getParameter("fromDate")!=null && !req.getParameter("fromDate").isEmpty()
                    ? sdf.parse(req.getParameter("fromDate")) : null;

            Date toDate = req.getParameter("toDate")!=null && !req.getParameter("toDate").isEmpty()
                    ? sdf.parse(req.getParameter("toDate")) : null;

            List<Transaction> list =
                new TransactionDAO().search(
                    fromDate,
                    toDate,
                    req.getParameter("status"),
                    req.getParameter("bank"),
                    req.getParameter("corporateId"));

            req.setAttribute("list", list);
            req.getRequestDispatcher("/jsp/result.jsp").forward(req, res);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
