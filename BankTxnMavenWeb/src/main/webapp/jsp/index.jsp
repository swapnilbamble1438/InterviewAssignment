<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<br></br>
<center>
<h1> Assignment </h1>
<br></br>
From: <input type="date" id="fromDate">
To: <input type="date" id="toDate">
<br></br>
Status:
<select id="status">
  <option value="">ALL</option>
  <option value="SUCCESS">SUCCESS</option>
  <option value="FAILED">FAILED</option>
</select>
<br></br>
Bank:
<select id="bank">
  <option value="">ALL</option>
  <option>HDFC</option>
  <option>ICICI</option>
  <option>SBI</option>
</select>
<br></br>
Corporate: <input id="corporateId">

<button onclick="search()">Search</button>
<button onclick="download('xlsx')">Excel</button>
<button onclick="download('pdf')">PDF</button>

<br></br>
<div id="result"></div>


</center>

<script>
function search(){
 $.get("transactions",{
  fromDate:$("#fromDate").val(),
  toDate:$("#toDate").val(),
  status:$("#status").val(),
  bank:$("#bank").val(),
  corporateId:$("#corporateId").val()
 },function(data){
   $("#result").html(data);
 });
}

function download(type){
 window.location =
   "export?type="+type+
   "&fromDate="+$("#fromDate").val()+
   "&toDate="+$("#toDate").val()+
   "&status="+$("#status").val()+
   "&bank="+$("#bank").val()+
   "&corporateId="+$("#corporateId").val();
}
</script>
