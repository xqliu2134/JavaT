import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Trun {
	public static void main(String[] args) {
		SortedMap<Object, Object> parameters = new TreeMap();
		parameters.put("appid", "wxd930ea5d5a258f4f");
		parameters.put("mch_id", "10000100");
		parameters.put("device_info", "1000");
		parameters.put("body", "test");
		parameters.put("nonce_str", "ibuaiVcKdpRxkhJA");
		System.out.println(createSign(parameters));
		
	}

	private static String createSign(SortedMap<Object, Object> parameters) {
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();// 所有参与传参的参数按照accsii排序（升序）
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=192006250b4c09247ec02edce69f6a2d");// 微信secret key
		String sign = md5(sb.toString()).toUpperCase();
		return sign;
	}

	public static String md5(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			byte[] bytes = md5.digest(str.getBytes("utf-8"));
			String result = "";
			for (byte b : bytes) {
				String temp = Integer.toHexString(b & 0xff);
				if (temp.length() == 1) {
					temp = "0" + temp;
				}
				result += temp;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
