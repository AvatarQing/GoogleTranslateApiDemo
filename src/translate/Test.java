package translate;

import http.WebRequest;

public class Test {

	public static void main(String[] args) {
		exec("How old are you", "Ӣ��", "����");

		exec("How old are you", "Ӣ��", "���ķ���");

		exec("���������", "���ļ���", "Ӣ��");

		exec("������o��", "���ķ���", "����");
	}

	/**
	 * �����õ�
	 */
	public static void exec(String a, String b, String c) {
		String html = Google.translate(a, b, c);
		if (html == null) {
			System.out.println("����ʧ��");
		}
		System.out.println("���������ݡ�");
		System.out.println(html);

		// ��������Ľ��.��������Ҫ��
		{// �ַ����������� .Ҳ������json-lib
			String s = WebRequest.mid(html, "[[[", "]]");
			String[] ss = s.split(",");
			System.out.println("����������");
			for (int i = 0; i < ss.length; i++) {
				s = ss[i].substring(1, ss[i].length() - 1);
				System.out.println(s);
			}
		}
	}

}
