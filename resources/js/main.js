/*function insertApptmt(){
	
	alert("in func");
		var ApptDate = document.getElementById("datepicker").value.toString();
		var ApptTime = document.getElementById("appt-time").value.toString();
		var Desc = document.getElementById("desc").value.toString();

		alert(ApptDate);
		alert(ApptTime);
		alert(Desc);
		
		$.post("http://localhost:8080/Appt",
			    {
					ApptDate: ApptDate,
			        ApptTime: ApptTime,
			        Desc: Desc
			    },
			    function(data, status){
		
			       alert(data);
			      
			    });
}*/

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
				
		    	alert(JSON.parse(data));
		    	alert(JSON.stringify(data));
		    	alert(data.length);
				
	
		    });
}
	