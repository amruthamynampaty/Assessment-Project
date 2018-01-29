
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
		    	alert(data.length);
		    });
}
	