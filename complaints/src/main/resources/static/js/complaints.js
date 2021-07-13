

//window.onload=getComplaints;
var xhrCount=new XMLHttpRequest();

var responseRequest;

window.onload=getComplaints;
//document.getElementById("pills-tabContent").addEventListener('click',getComplaints());
	//event.preventDefault();
	function getComplaints(){
	xhrCount.open("GET","http://localhost:8080/api/v1/complaints/complaintsdesp",true);

    	xhrCount.onreadystatechange=processResponseCount;
        xhrCount.send(null);
}

    	
   function processResponseCount(){
    	 if(xhrCount.readyState == 4 && xhrCount.status == 200){
	
		//$("#table-body").empty();
				
    		  var arr = JSON.parse(xhrCount.responseText);
    		  
    		    for(var i=0;i<arr.length; i++){

 	  // creating row and data
        var trow=document.createElement('tr');
        trow.className="row-bg-style";
        trow.id="row"+i;       // addingStyle class
        var divObj = document.createElement('td');
         divObj.className="spacing2";
        divObj.id="empid"+i;
        var divObj1 = document.createElement('td');
        divObj1.className="spacing2";
        divObj1.id="empName"+i;
        var divObj2 = document.createElement('td');
        divObj2.className="spacing2";
        divObj2.id="empNumber"+i;
        var divObj3 = document.createElement('td');
        divObj3.className="spacing2";
         divObj3.id="cabNum"+i;
        var divObj4 = document.createElement('td');
        divObj4.className="spacing2";
         divObj4.id="driverName"+i;
        var divObj5 = document.createElement('td');
        divObj5.className="spacing2";
         divObj5.id="source"+i;
        var divObj6 = document.createElement('td');
        divObj6.className="spacing2";
         divObj6.id="droppoint"+i;
        var divObj7 = document.createElement('td');
        divObj7.className="spacing2";
         divObj7.id="dateoftravel"+i;
        var divObj8 = document.createElement('td');
        divObj8.className="spacing2";
         divObj8.id="timeslot"+i;
        var divObj9 = document.createElement('td');
        divObj9.className="spacing2";
         divObj9.id="complaints"+i;
        var divObj10 = document.createElement('td');
        divObj10.className="spacing2";
        var divObj11 = document.createElement('td');
        divObj11.className="spacing2";
        divObj11.style.display="none";
       
    
    
          divObj.innerText = arr[i].requests.employeeId;
          divObj1.innerText = arr[i].requests.employeeName;
          divObj2.innerText = arr[i].empNumbers;
           divObj3.innerText = arr[i].cabNumbers;
          divObj4.innerText = arr[i].driverName;
           divObj5.innerText = arr[i].requests.source;
          divObj6.innerText = arr[i].requests.droppoint;
         divObj7.innerText = arr[i].datesOfTravel;
         divObj8.innerText = arr[i].requests.timeslot;
         divObj9.innerText = arr[i].requests.complaintDescription;
         divObj10.innerHTML="<div class='dropdown show'><a href='#' title='Remarks' class='align-img' data-toggle='dropdown' aria-expanded='true'><img class='cursor' src='images/remarks.svg' alt='remarks-icon'></a><div class='dropdown-menu m-0 p-3 user-filter show' x-placement='top-start' style='position: absolute; transform: translate3d(-347px, -174px, 0px); top: 0px; left: 0px; will-change: transform;'><div class='container-fluid'><div class='row'><div class='col-md-12 mb-3'><div class='col-md-12 pb-2 border-0 mb-3'><button type='button' class='btn-close float-end close-filter' data-dismiss='user-filter' aria-label='Close'></button></div><h5 class='h-size1 mb-2'>Enter Remarks</h5><input type='text' class='form-control border-filter-style' id='remarks"+i+"'></div><div class='col-md-12'><button type='button' class='save-btn float-end' onclick='saveRemarks(this)'>Save</button><button type='button' class='cancel1-btn float-end '>Cancel</button></div><div></div></div></div>";
          divObj11.innerText = arr[i].requests.bookingId;
            
        trow.appendChild(divObj);
        trow.appendChild(divObj1);
        trow.appendChild(divObj2);
       trow.appendChild(divObj3);
        trow.appendChild(divObj4);
        trow.appendChild(divObj5);
        trow.appendChild(divObj6);
       trow.appendChild(divObj7);
        trow.appendChild(divObj8);
         trow.appendChild(divObj9);
          trow.appendChild(divObj10);
          trow.appendChild(divObj11);
         
   
        
        document.getElementById("table-body").appendChild(trow);
     
     
}
}

}

function saveRemarks(obj){
	//alert(obj.closest("input").id);
	trowId = obj.closest("tr").id;
	bookingId = document.getElementById(trowId).cells[11].innerText;
	replaceId = trowId.replace("row","");
	remarks = document.getElementById("remarks"+replaceId).value;
	
	var xhrRemark = new XMLHttpRequest();
	
	xhrRemark.open("PUT","http://localhost:8080/api/v1/remarks/"+bookingId+"/"+remarks,true);
	xhrRemark.onreadystatechange = function(){
		
		if(xhrRemark.readyState==4 && xhrRemark.status==200){
			window.location.reload();
		}
	};
	xhrRemark.send(null);
}