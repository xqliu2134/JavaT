package sample;

public class InfixToSuffix {
	private MyCharStack s1;// ���������ջ
	private MyCharStack s2;// ����洢���ջ
	private String input;

	// Ĭ�Ϲ��췽��������Ϊ�������׺���ʽ
	public InfixToSuffix(String in) {
		input = in;
		s1 = new MyCharStack(input.length());
		s2 = new MyCharStack(input.length());
	}

	// ��׺���ʽת��Ϊ��׺���ʽ��������洢��ջ�з��أ�������ʾ����׺���ʽ
	public MyCharStack doTrans() {
		for (int j = 0; j < input.length(); j++) {
			System.out.print("s1ջԪ��Ϊ��");
			s1.displayStack();
			System.out.print("s2ջԪ��Ϊ��");
			s2.displayStack();
			char ch = input.charAt(j);
			System.out.println("��ǰ�������ַ�:" + ch);
			switch (ch) {
			case '+':
			case '-':
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '(':
				s1.push(ch);// �����ǰ�ַ���'(',������ջ
				break;
			case ')':
				gotParen(ch);
				break;
			default:
				// 1�������ǰ�������ַ��ǲ���������ֱ��ѹ��s2
				// 2��
				s2.push(ch);
				break;
			}// end switch
		} // end for

		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		return s2;
	}

	public void gotOper(char opThis, int prec1) {
		while (!s1.isEmpty()) {
			char opTop = s1.pop();
			if (opTop == '(') {// ���ջ����'(',ֱ�ӽ�������ѹ��s1
				s1.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop == '+' || opTop == '-') {
					prec2 = 1;
				} else {
					prec2 = 2;
				}
				if (prec2 < prec1) {// �����ǰ�������s1ջ����������ȼ��ߣ��������ѹ��s1
					s1.push(opTop);
					break;
				} else {// �����ǰ�������ջ���������ͬ����С�����ȼ�����ô��S1ջ���������������ѹ�뵽S2��
						// ����Ҫ�ٴ��ٴ�ת��whileѭ������ s1 ���µ�ջ���������Ƚϣ�
					s2.push(opTop);
				}
			}

		} // end while
			// ���s1Ϊ�գ���ֱ�ӽ���ǰ�����������ѹ��s1
		s1.push(opThis);
	}

	// ��ǰ�ַ��� ')' ʱ�����ջ����'(',����һ�����Ŷ������������ε���s1ջ�����ַ���ѹ��s2��ֱ������'('
	public void gotParen(char ch) {
		while (!s1.isEmpty()) {
			char chx = s1.pop();
			if (chx == '(') {
				break;
			} else {
				s2.push(chx);
			}
		}
	}

	public static void main(String[] args) {
		String str = "465+123/89+21-56+(565+1)*9";
		InfixToSuffix in = new InfixToSuffix(str);
		MyCharStack my = in.doTrans();
		my.displayStack();
	}
}
