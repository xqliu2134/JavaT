package sample.cp;

import java.util.ArrayList;
import java.util.List;

public class CpData {
	private static List<String> mData = new ArrayList<>();
	private MapData[] mapDatas = new MapData[35];
	private MapData[] rearDatas = new MapData[12];
	static {
		mData.add("02,18,23,27,30,05,10");
		mData.add("01,11,19,26,35,11,12");
		mData.add("04,10,15,20,24,07,11");
		mData.add("11,15,16,20,29,04,08");
		mData.add("04,15,16,20,35,03,12");
		mData.add("10,16,22,26,27,07,11");
		mData.add("06,10,16,29,33,05,11");
		mData.add("03,04,10,16,32,04,09");
		mData.add("02,08,14,15,35,10,12");
		mData.add("01,04,16,19,33,03,12");
		mData.add("03,06,10,12,31,01,02");
		mData.add("02,06,07,12,15,06,12");
		mData.add("04,10,13,28,33,11,12");
		mData.add("12,19,20,22,28,02,06");
		mData.add("01,12,18,26,35,05,12");
		mData.add("05,11,16,18,27,07,12");
		mData.add("06,16,26,33,35,04,08");
		mData.add("03,09,21,28,30,01,12");
		mData.add("01,03,05,07,18,08,09");
		mData.add("08,12,15,27,30,01,02");
		mData.add("01,02,04,16,24,07,09");
		mData.add("01,04,07,11,30,07,08");
		mData.add("03,08,21,26,33,04,05");
		mData.add("07,09,13,14,33,02,04");
		mData.add("01,04,18,24,28,02,03");
		mData.add("06,22,28,29,33,02,07");
		mData.add("16,18,24,25,27,02,07");
		mData.add("10,12,15,17,19,02,03");
		mData.add("06,13,16,19,29,03,07");
	};

	public String calceMax(int mode) {
		for (int i = 1; i <= 35; i++) {
			if (i < 10) {
				mapDatas[i - 1] = new MapData("0" + i, 0);
			} else {
				mapDatas[i - 1] = new MapData("" + i, 0);
			}
		}

		for (String data : mData) {
			String[] array = getSplitArray(data);
			for (int i = 0; i < 5; i++) {
				String str = array[i];
				for (int j = 0; j < mapDatas.length; j++) {
					MapData mapdata = mapDatas[j];
					if (str.equals(mapdata.getValue())) {
						mapdata.setCount(mapdata.getCount() + 1);
					}
				}
			}
		}
		MapData temp = null;
		for (int i = 0; i < mapDatas.length; i++) {
			for (int j = 0; j < mapDatas.length - i - 1; j++) {
				if (mapDatas[j + 1].getCount() > mapDatas[j].getCount()) {
					temp = mapDatas[j];
					mapDatas[j] = mapDatas[j + 1];
					mapDatas[j + 1] = temp;
				}
			}
		}
		StringBuilder sb = new StringBuilder("");
		if (mode == 0) {
			for (int i = 0; i < 5; i++) {
				MapData data = mapDatas[i];
				sb.append(data.getValue() + "(" + data.getCount() + ")");
				sb.append(",");
			}
		} else if (mode == 1) {
			for (int i = 0; i < mapDatas.length; i++) {
				MapData data = mapDatas[i];
				if (data.getCount() == 0) {
					sb.append(data.getValue() + "(" + data.getCount() + ")");
					sb.append(",");
				}
			}
		} else if (mode == 2) {
			for (int i = 0; i < 10; i++) {
				MapData data = mapDatas[mapDatas.length - 1 - i];
				sb.append(data.getValue() + "(" + data.getCount() + ")");
				sb.append(",");
			}
		}
		return sb.toString();
	}

	public String calceRear(int mode) {
		for (int i = 1; i <= 12; i++) {
			if (i < 10) {
				rearDatas[i - 1] = new MapData("0" + i, 0);
			} else {
				rearDatas[i - 1] = new MapData("" + i, 0);
			}
		}

		for (String data : mData) {
			String[] array = getSplitArray(data);
			for (int i = 5; i < 7; i++) {
				String str = array[i];
				for (int j = 0; j < rearDatas.length; j++) {
					MapData mapdata = rearDatas[j];
					if (str.equals(mapdata.getValue())) {
						mapdata.setCount(mapdata.getCount() + 1);
					}
				}
			}
		}
		MapData temp = null;
		for (int i = 0; i < rearDatas.length; i++) {
			for (int j = 0; j < rearDatas.length - i - 1; j++) {
				if (rearDatas[j + 1].getCount() > rearDatas[j].getCount()) {
					temp = rearDatas[j];
					rearDatas[j] = rearDatas[j + 1];
					rearDatas[j + 1] = temp;
				}
			}
		}

		StringBuilder sb = new StringBuilder("");
		if (mode == 0) {
			for (int i = 0; i < 5; i++) {
				MapData data = rearDatas[i];
				sb.append(data.getValue() + "(" + data.getCount() + ")");
				sb.append(",");
			}
		} else if (mode == 1) {
			for (int i = 0; i < rearDatas.length; i++) {
				MapData data = rearDatas[i];
				if (data.getCount() == 0) {
					sb.append(data.getValue() + "(" + data.getCount() + ")");
					sb.append(",");
				}
			}
		} else if (mode == 2) {
			for (int i = 0; i < 12; i++) {
				MapData data = rearDatas[rearDatas.length - i - 1];
				sb.append(data.getValue() + "(" + data.getCount() + ")");
				sb.append(",");
			}
		}
		return sb.toString();
	}

	private String[] getSplitArray(String data) {
		return data.split(",");
	}

	public static class MapData {
		private String value;
		private int count;

		public MapData(String value, int count) {
			this.value = value;
			this.count = count;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
	}
}
