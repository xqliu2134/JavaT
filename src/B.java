import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
		try {
			Date date = format.parse("2019-1-26");
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -1);

			System.out.println(format.format(calendar.getTime()));

			String str = "%E4%BD%A0%E5%A5%BD123abc";
			System.out.println(URLDecoder.decode(str, "utf-8"));
			isOneDay(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean isOneDay(Date creatime) {
		Date nowDate = new Date();
		long time = nowDate.getTime() - creatime.getTime();
		long day = (time) / (24 * 60 * 60 * 1000);
		System.out.println("day:" + day);
		return day >= 1;
	}

}
