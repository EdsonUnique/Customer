package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class testDate {
	@Test
	public void test() throws ParseException{
		  String str = "2009-02-15 09:21:35.345";
	      SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��SSS����");
	      Date date = sdf1.parse(str);//��ȡ��ʽ�е�����
	      System.out.println("ת��֮ǰ�����ڣ�"+date);
	      String newStr = sdf2.format(date); //�ı��ʽ
	      System.out.println("ת��֮������ڣ�"+newStr);
	}
}
