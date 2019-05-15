import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T {

	public static void main(String[] args) {
		System.out.println(String.valueOf(transformDouble(3d, 2)));
	}
	
	public static Double transformDouble(Double obj, int round) {
		BigDecimal bigDecimal = new BigDecimal(obj);
		BigDecimal newValue = bigDecimal.setScale(round, BigDecimal.ROUND_HALF_UP);
		return newValue.doubleValue();
	}

	public static float transforFloat(float flvalue, int round) {
		BigDecimal bigDecimal = new BigDecimal(Float.toString(flvalue));
		BigDecimal value = bigDecimal.setScale(round, BigDecimal.ROUND_DOWN);
		return value.floatValue();
	}

	public static String getDatePoor(Date endDate, Date nowDate) {
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		long nm = 1000 * 60;
		long ns = 1000;
		// �������ʱ��ĺ���ʱ�����
		long diff = endDate.getTime() - nowDate.getTime();
		// ����������
		long day = diff / nd;
		// ��������Сʱ
		long hour = diff % nd / nh;
		// �������ٷ���
		long min = diff % nd % nh / nm;
		// ����������//������
		long sec = diff % nd % nh % nm / ns;
		return day + "��" + hour + "Сʱ" + min + "����" + sec + "��";
	}

	private static List<List<String>> getArrayNumbers(String number) {
		if (number == null || number.length() <= 0) {
			return null;
		}

		String[] array1 = number.split("\\|");
		if (array1 == null || array1.length <= 0) {
			return null;
		}

		List<List<String>> array = new ArrayList<>();
		for (int i = 0; i < array1.length; i++) {
			String value = array1[i];
			if (value != null && value.trim().length() > 0) {
				List<String> data = new ArrayList<>();
				String[] array2 = value.split(",");
				for (int j = 0; j < array2.length; j++) {
					data.add(array2[j]);
				}
				array.add(data);
			}
		}
		return array;
	}

	public static void renxuanCompound() {
		// List<List<String>> number = getArrayNumbers(value);
		String[] number = { "12345", "12345", "12345", "12345", "12345" };

		List<Integer> list = new ArrayList<>();
		for (String str : number) {
			list.add(str.length());
		}

		List<String> resultList = new ArrayList<>();
		List<Integer> tmpList = new ArrayList<>();
		combine(0, 4, list, resultList, tmpList);
		int sum = 0;
		int tmp;
		for (String str : resultList) {
			System.out.println("str:" + str);
			tmp = 1;
			for (String num : str.split(",")) {
				tmp *= Integer.parseInt(num.trim());
			}
			sum += tmp;
		}
	}

	private static void combine(int index, int k, List<Integer> list, List<String> resultList, List<Integer> tmpList) {
		Integer tmp;
		if (k == 1) {
			for (int i = index; i < list.size(); i++) {
				tmp = list.get(i);
				tmpList.add(tmp);
				resultList.add(joinI(tmpList, ","));
				tmpList.remove(tmp);
			}
		} else if (k > 1) {
			for (int i = index; i <= list.size() - k; i++) {
				tmp = list.get(i);
				tmpList.add(tmp);
				combine(i + 1, k - 1, list, resultList, tmpList); // �������ƣ��ڲ�ѭ������Ȼ�ų��Ѿ�ѡ���Ԫ��
				tmpList.remove(tmp);
			}
		}
	}

	private static String joinI(List<Integer> strs, String tag) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < strs.size(); i++) {
			sb.append(strs.get(i).toString());
			if (i < strs.size() - 1) {
				sb.append(tag);
			}
		}
		return sb.toString();
	}

}
