
function insertApptmt(){
	
	 var x = document.getElementById("appt-time").value;
	    var arr = x.split(":");
	    var hr = arr[0];
	    if(hr > 17 ) {
	        alert("Enter Time between 8am - 5pm!");
	    	return false;
	    }
	        
	        if(hr < 8 ) {
	        alert("Enter Time between 8am - 5pm!");
	        return false;
	        }
	
	var ApptDat = document.getElementById("datepicker").value.toString();
	var ApptTim = document.getElementById("appt-time").value.toString();
	var Descr = document.getElementById("desc").value.toString();
	
	$.post("http://localhost:8080/Appt",
		    {
				ApptDate: ApptDat,
				ApptTime: ApptTim,
		        Desc: Descr
		    },
		    function(data, status){
		    		alert(data);
		 
		    });
}
	
	
function search(){
	var wildcard = document.getElementById("search").value.toString();

	$.post("http://localhost:8080/getAppt",
    {
		wildcard: wildcard
		    },
		  function(data, status){
		    	//alert(JSON.stringify(data));
		    	var prop;
		    	  var propCount = 0;

		    	  for (prop in data) {
		    	    propCount++;
		    	  }
		    	  //alert(propCount);
		    	 // var obj = JSON.parse(data);
		    	  //alert(data[0].apptDate);
		    	  
		    	   //var body = document.getElementsByTagName('body')[0];
		    	  /*  var tbl = document.createElement('table');
		    	    tbl.style.width = '100%';
		    	    tbl.setAttribute('border', '1');
		    	    var tbdy = document.createElement('tbody');
		    	    var tr = document.createElement('tr');
		    	    var td00 = document.createElement('td');
		    	    td00.appendChild(document.createTextNode('Appointment Date'));
		    	    var td01 = document.createElement('td');
		    	    td01.appendChild(document.createTextNode('Appointment Time'))
		    	    var td02 = document.createElement('td');
		    	    td02.appendChild(document.createTextNode('Appointment Description'))
		    	    tbdy.appendChild(tr);
		    	    for(var i=0;i<propCount;i++){
		    	    	 var tr1 = document.createElement('tr');
				    	    var td1 = document.createElement('td');
				    	    td1.appendChild(document.createTextNode(data[i].apptDate));
				    	    var td2 = document.createElement('td');
				    	    td2.appendChild(document.createTextNode(data[i].apptTime))
				    	    var td3 = document.createElement('td');
				    	    td3.appendChild(document.createTextNode(data[i].desc))
				    	    tbdy.appendChild(tr1); 
		    	    }
		    	    tbl.appendChild(tbdy);
		    	    document.body.appendChild(tbl)	*/
		    	  
		    	  if (document.contains(document.getElementById("tab"))) {
		              document.getElementById("tab").remove();
		  }
		    	  var body = document.body,
		          tbl  = document.createElement('table');
		      tbl.style.width  = '200px';
		      tbl.style.border = '2px solid black';
		      tbl.style.top = '100px';
		      tbl.style.paddingTop="50px";
		      tbl.setAttribute("id", "tab");

		      var tr = tbl.insertRow();
		      var td = tr.insertCell();
              td.appendChild(document.createTextNode('Appointment Date'));
              td.style.border = '1px solid black';
              var td = tr.insertCell();
              td.appendChild(document.createTextNode('Appointment Time'));
              td.style.border = '1px solid black';
              var td = tr.insertCell();
              td.appendChild(document.createTextNode('Description'));
              td.style.border = '1px solid black';
          
		      for(var i = 0; i < propCount; i++){
		          var tr = tbl.insertRow();
		                  var td = tr.insertCell();
		                  td.appendChild(document.createTextNode(data[i].apptDate));
		                  td.style.border = '1px solid black';
		                  var td1 = tr.insertCell();
		                  td1.appendChild(document.createTextNode(data[i].apptTime));
		                  td1.style.border = '1px solid black';
		                  var td2 = tr.insertCell();
		                  td2.appendChild(document.createTextNode(data[i].desc));
		                  td2.style.border = '1px solid black';
		                  
		      }
		      body.appendChild(tbl);
		      tbl.style.paddingTop="50px";
		    });
}
	