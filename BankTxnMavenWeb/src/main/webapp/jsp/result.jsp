<%@page import="com.entity.Transaction"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
%>

<table border="1" width="100%" cellpadding="5" cellspacing="0">
<tr>
    <th>ID</th>
    <th>Corporate ID</th>
    <th>Unique ID</th>
    <th>Beneficiary Name</th>
    <th>Account Number</th>
    <th>IFSC</th>
    <th>Bank Name</th>
    <th>Amount</th>
    <th>Currency</th>
    <th>Transaction Type</th>
    <th>Status</th>
    <th>Channel</th>
    <th>Remarks</th>
    <th>Created By</th>
    <th>Created Date</th>
    <th>Updated Date</th>
</tr>

<%
List<Transaction> list =
    (List<Transaction>) request.getAttribute("list");

if(list != null && !list.isEmpty()){
    for(Transaction t : list){
%>
<tr>
    <td><%=t.getId()%></td>
    <td><%=t.getCorporateId()%></td>
    <td><%=t.getUniqueId()%></td>
    <td><%=t.getBeneficiaryName()%></td>
    <td><%=t.getAccountNumber()%></td>
    <td><%=t.getIfsc()%></td>
    <td><%=t.getBankName()%></td>
    <td><%=t.getAmount()%></td>
    <td><%=t.getCurrency()%></td>
    <td><%=t.getTransactionType()%></td>
    <td><%=t.getTransactionStatus()%></td>
    <td><%=t.getChannel()%></td>
    <td><%=t.getRemarks()%></td>
    <td><%=t.getCreatedBy()%></td>
    <td><%= t.getCreatedDate() != null ? sdf.format(t.getCreatedDate()) : "" %></td>
    <td><%= t.getUpdatedDate() != null ? sdf.format(t.getUpdatedDate()) : "" %></td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="16" align="center">No records found</td>
</tr>
<% } %>
</table>
