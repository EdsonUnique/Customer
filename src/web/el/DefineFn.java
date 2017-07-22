package web.el;

import java.util.Date;

public class DefineFn {

	public static String getString(String str,Integer length){
		
		if(str.length()>=length){
			str=str.substring(0, length)+"......";
		}else{
			return str;
		}
		
		return str;
		
	}
	
	
}
