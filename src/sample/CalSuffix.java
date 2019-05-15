package sample;

public class CalSuffix {
	private MyIntStack stack;
	private String input;

	public CalSuffix(String input) {
		this.input = input;
		stack = new MyIntStack(input.length());

	}

	public int doCalc() {
		int num1, num2, result;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= '0' && c <= '9') {
				stack.push((int) (c - '0'));// ��������֣�ֱ��ѹ��ջ��
			} else {
				num2 = stack.pop();// ע���ȳ�����Ϊ�ڶ���������
				num1 = stack.pop();
				switch (c) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				default:
					result = 0;
					break;
				}// end switch

				stack.push(result);
			} // end else
		} // end for
		result = stack.pop();
		return result;
	}

	public static void main(String[] args) {
		// ��׺���ʽ��1*(2+3)-5/(2+3) = 4
		// ��׺���ʽ��123+*123+/-
		CalSuffix cs = new CalSuffix("123+*523+/-");
		System.out.println(cs.doCalc()); // 4
	}

}
