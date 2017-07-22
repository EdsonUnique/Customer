function date(){
	makeYear();
	makeMonth();
	makeDay();
}


function makeYear(){
	
	var year=document.getElementById("year");
	
	for(var i=1901;i<=new Date().getFullYear();i++){
		var option=document.createElement("option");
		
		option.value=i;
		option.innerText=i;
		
		year.appendChild(option);
	}
	
	
}

function makeMonth(){
	
	var month=document.getElementById("month");
	
	for(var i=2;i<=12;i++){
		var option=document.createElement("option");
		
		if(i<10){
			option.value='0'+i;
			option.innerText='0'+i;	
		}else{
			option.value=i;
			option.innerText=i;
		}
		
		month.appendChild(option);
	}
	
	
}

function makeDay(){
	
	var day=document.getElementById("day");
	
	for(var i=2;i<=31;i++){
		var option=document.createElement("option");
		
		if(i<10){
			option.value='0'+i;
			option.innerText='0'+i;	
		}else{
			option.value=i;
			option.innerText=i;
		}
		
		day.appendChild(option);
	}
	
	
}

function getDataString(){
	getDate();
	getPreference();
	return false;
}

function getDate(){
	
	var year=document.getElementById("year");
	var month=document.getElementById("month");
	var day=document.getElementById("day");
	
	var date=year.value+"-"+month.value+"-"+day.value;
	
	var input=document.createElement("input");
	input.type="hidden";
	input.name="birthday";
	input.value=date;
	
	document.getElementById("form").appendChild(input);
	
	
}

function getPreference(){
	
	var pres=document.getElementsByName("pre");
	var preferences="";
	
	for(var i=0;i<pres.length;i++){
		if(pres[i].checked==true){
			preferences+=pres[i].value+",";
		}
	}
	
	preferences=preferences.substr(0,preferences.length-1);
	
	var input=document.createElement("input");
	input.type="hidden";
	input.name="preferences";
	input.value=preferences;
	
	document.getElementById("form").appendChild(input);
}














