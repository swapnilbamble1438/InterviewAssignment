package com.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.entity.Transaction;
import com.util.DBUtil;

public class TransactionDAO {

    public List<Transaction> search(
            Date fromDate,
            Date toDate,
            String status,
            String bank,
            String corporateId) throws Exception {

        List<Transaction> list = new ArrayList<Transaction>();

        String sql = "SELECT * FROM transactions WHERE 1=1";

        if(fromDate != null) sql += " AND created_date >= ?";
        if(toDate != null) sql += " AND created_date <= ?";
        if(status != null && !status.isEmpty()) sql += " AND transaction_status=?";
        if(bank != null && !bank.isEmpty()) sql += " AND bank_name=?";
        if(corporateId != null && !corporateId.isEmpty()) sql += " AND corporate_id=?";

        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        int i = 1;
        if(fromDate != null) ps.setDate(i++, new java.sql.Date(fromDate.getTime()));
        if(toDate != null) ps.setDate(i++, new java.sql.Date(toDate.getTime()));
        if(status != null && !status.isEmpty()) ps.setString(i++, status);
        if(bank != null && !bank.isEmpty()) ps.setString(i++, bank);
        if(corporateId != null && !corporateId.isEmpty()) ps.setString(i++, corporateId);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            Transaction t = new Transaction();
            t.setId(rs.getLong("id"));
            t.setCorporateId(rs.getString("corporate_id"));
            t.setUniqueId(rs.getString("unique_id"));
            t.setBeneficiaryName(rs.getString("beneficiary_name"));
            t.setAccountNumber(rs.getString("account_number"));
            t.setIfsc(rs.getString("ifsc"));
            t.setBankName(rs.getString("bank_name"));
            t.setAmount(rs.getDouble("amount"));
            t.setCurrency(rs.getString("currency"));
            t.setTransactionType(rs.getString("transaction_type"));
            t.setTransactionStatus(rs.getString("transaction_status"));
            t.setChannel(rs.getString("channel"));
            t.setRemarks(rs.getString("remarks"));
            t.setCreatedBy(rs.getString("created_by"));
            t.setCreatedDate(rs.getDate("created_date"));
            t.setUpdatedDate(rs.getDate("updated_date"));
            list.add(t);
        }

        con.close();
        return list;
    }
}
