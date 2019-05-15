import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class M {
	private static String gps = "118.278195:25.438854999999997,118.27806666666666:25.439285,118.27806833333334:25.439285,118.27803:25.439513333333334,118.27829333333332:25.44044666666667,118.27877833333332:25.440835,118.27873999999998:25.440775,118.27828833333334:25.44042833333333,118.27817833333332:25.440379999999998,118.27804666666667:25.44011666666667,118.27796666666667:25.439180000000004,118.27816333333334:25.438779999999998,118.27828166666669:25.43862,118.27834166666668:25.43857666666667,118.278815:25.438175,118.27890833333335:25.43804,118.27894833333333:25.438066666666668,118.27888499999999:25.43808,118.27854166666665:25.43851666666667,118.27822666666667:25.438901666666666,118.27807833333333:25.439048333333336,118.27809833333335:25.43903833333333,118.27809833333335:25.439028333333333,";
	private static String[] gpsArray = gps.split(",");
	private static int count = gpsArray.length;

	public static void main(String[] args) {
		Pattern mPattern = Pattern.compile(".*[=|?|？|\\\\|*|&|^|,|@|!|].*");
		Matcher m = mPattern.matcher("\\");
		System.out.println(bonus(16660000l, 20000000l, 135000l, 0, 1));
		System.out.println(bonus2(16660000l, 20000000l, 135000l, 0, 1));
		System.out.println(bonus(17000000000l, 20000000000l, 135000l, 0, 1));
		System.out.println(bonus2(17000000000l, 20000000000l, 135000l, 0, 1));
		
		System.out.println("[5,5,5,5],[5,5,5,5],[5,5,5,5]".replace("\\[", ""));
	}

	public static float bonus2(long minBonus, long maxBonus, long userRebate, long baseRebate, int model) {
		BigDecimal min = new BigDecimal(minBonus);
		BigDecimal max = new BigDecimal(maxBonus);
		BigDecimal rebate = new BigDecimal(userRebate);
		BigDecimal unit = new BigDecimal(model);
		BigDecimal divisor = new BigDecimal(150000);
		BigDecimal two = new BigDecimal(2);
		BigDecimal balanceUnit = new BigDecimal(1000000);
		BigDecimal floatd = new BigDecimal(1.0f);
		int round = BigDecimal.ROUND_DOWN;
		int num = 4;
		// return
		// min.add(max.subtract(min).divide(divisor).multiply(rebate)).divide(unit).divide(two).divide(balanceUnit).floatValue();
		return min.add(max.subtract(min).multiply(floatd).divide(divisor, num, round).multiply(rebate)).divide(unit, num, round).divide(two, num, round).divide(balanceUnit, num).floatValue();
	}

	public static float bonus(long minBonus, long maxBonus, long userRebate, long baseRebate, int model) {
		int unit = 1;
		float bonus = minBonus + ((maxBonus - minBonus) * 1.0f / 150000) * userRebate;
		float money = ((bonus * 1f / unit) / 2) / 1000000;
		return transforFloat(money, 4);
	}

	public static float transforFloat(float flvalue, int round) {
		BigDecimal bigDecimal = new BigDecimal(Float.toString(flvalue));
		BigDecimal value = bigDecimal.setScale(round, BigDecimal.ROUND_HALF_EVEN);
		return value.floatValue();
	}

	public static float floatToString(long flvalue) {
		BigDecimal bigDecimal = new BigDecimal(Long.toString(flvalue));
		BigDecimal value = bigDecimal.divide(new BigDecimal(1000000), 4, BigDecimal.ROUND_UP);
		return value.floatValue();
	}

	private static String parseFloat(long fvalue) {
		String str = String.valueOf(fvalue);
		if (str.indexOf("E") > -1) {
			Long res = Long.parseLong(str);
			String value = new BigDecimal(res.toString()).toString();
			return value;
		}
		return str;
	}

	public static String getCity(String city) {
		int start = city.indexOf(";");
		if (start >= 0) {
			city = city.substring(0, start);
		}

		start = city.indexOf("自治区");
		if (start < 0) {
			start = city.indexOf("省");
			if (start >= 0) {
				start += 1;
				city = city.substring(start);
			}
		} else if (start >= 0) {
			start += 3;
			city = city.substring(start);
		}

		int end = city.indexOf("市");
		if (end >= 0) {
			city = city.substring(0, end);
		}
		return city;
	}
}
