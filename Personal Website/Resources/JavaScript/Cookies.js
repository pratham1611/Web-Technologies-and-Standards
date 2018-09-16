document.addEventListener("DOMContentLoaded", DisplayVisits);  
  function DisplayVisits() 
 {    
      var numVisits = GetCookie("numVisits"); 
	  var oldURL = document.referrer; //gets old url
	  //alert(oldURL)
      if (numVisits=="") 
	  {
		  
		  numVisits = 1; // the value for the new cookie 
		  alert("This is your first visit.");
		  //alert("You have visited this page " + numVisits + " times.");
		   
		//alert("Hello World old")
	  }
      else if(oldURL=="")
	  {
		  numVisits = parseInt(numVisits) + 1; 
		  alert("You have visited this website " + numVisits + " times.");
		//alert("Hello World new")
	  }
  // Set the cookie to expire 365 days from now 
      var today = new Date(); 
      today.setTime(today.getTime() + 365 /*days*/ * 24 /*hours*/ * 60 /*minutes*/ * 60 /*seconds*/ * 1000 /*milliseconds*/); 
      SetCookie("numVisits", numVisits, today); 
  }	
  
  function GetCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
  }
  
  function SetCookie(cname,cvalue,exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}