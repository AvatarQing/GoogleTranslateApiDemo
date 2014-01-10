package translate;

import java.util.HashMap;
import java.util.Map;


import http.NameValue;
import http.WebRequest;

public class Google {

	/**
	 * Key -> Value
	 * ����     -> ���ʱ�ʾ
	 */
	private static final Map<String,String> LANGUAGE = new HashMap<String,String>();
	
	static {
		LANGUAGE.put("������������", "sq");
		LANGUAGE.put("��������", "ar");
		LANGUAGE.put("�����ݽ���", "az");
		LANGUAGE.put("��������", "ga");
		LANGUAGE.put("��ɳ������", "et");
		LANGUAGE.put("��˹����", "eu");
		LANGUAGE.put("�׶���˹��", "be");
		LANGUAGE.put("����������", "bg");
		LANGUAGE.put("������", "is");
		LANGUAGE.put("������", "pl");
		LANGUAGE.put("��˹��", "fa");
		LANGUAGE.put("������", "af");
		LANGUAGE.put("�ϷǺ�����", "af");
		LANGUAGE.put("������", "da");
		LANGUAGE.put("����", "de");
		LANGUAGE.put("����", "ru");
		LANGUAGE.put("����", "fr");
		LANGUAGE.put("���ɱ���", "tl");
		LANGUAGE.put("������", "fi");
		LANGUAGE.put("��³������", "ka");
		LANGUAGE.put("�ż�������", "gu");
		LANGUAGE.put("���ؿ���¶���", "ht");
		LANGUAGE.put("����", "ko");
		LANGUAGE.put("������", "nl");
		LANGUAGE.put("����������", "gl");
		LANGUAGE.put("��̩��������", "ca");
		LANGUAGE.put("�ݿ���", "cs");
		LANGUAGE.put("���ɴ���", "kn");
		LANGUAGE.put("���޵�����", "hr");
		LANGUAGE.put("������", "la");
		LANGUAGE.put("����ά����", "lv");
		LANGUAGE.put("������", "lo");
		LANGUAGE.put("��������", "lt");
		LANGUAGE.put("����������", "ro");
		LANGUAGE.put("�������", "mt");
		LANGUAGE.put("������", "ms");
		LANGUAGE.put("�������", "mk");
		LANGUAGE.put("�ϼ�����", "bn");
		LANGUAGE.put("Ų����", "no");
		LANGUAGE.put("��������", "pt");
		LANGUAGE.put("����", "ja");
		LANGUAGE.put("�����", "sv");
		LANGUAGE.put("����ά����", "sr");
		LANGUAGE.put("������", "eo");
		LANGUAGE.put("˹�工����", "sk");
		LANGUAGE.put("˹����������", "sl");
		LANGUAGE.put("˹��ϣ����", "sw");
		LANGUAGE.put("̩¬����", "te");
		LANGUAGE.put("̩�׶���", "ta");
		LANGUAGE.put("̩��", "th");
		LANGUAGE.put("��������", "tr");
		LANGUAGE.put("����ʿ��", "cy");
		LANGUAGE.put("�ڶ�����", "ur");
		LANGUAGE.put("�ڿ�����", "uk");
		LANGUAGE.put("ϣ������", "iw");
		LANGUAGE.put("ϣ����", "el");
		LANGUAGE.put("��������", "es");
		LANGUAGE.put("��������", "hu");
		LANGUAGE.put("����������", "hy");
		LANGUAGE.put("�������", "it");
		LANGUAGE.put("�������", "yi");
		LANGUAGE.put("ӡ����", "hi");
		LANGUAGE.put("ӡ����", "id");
		LANGUAGE.put("Ӣ��", "en");
		LANGUAGE.put("Խ����", "vi");
		LANGUAGE.put("���ķ���", "zh-TW");
		LANGUAGE.put("���ļ���", "zh-CN");

	}
	/**
	 * GET �ȸ跭��
	 * @param value ��������ַ���
	 * @param src Դ����
	 * @param target Ŀ������
	 * @return ������JSON�ַ���
	 */
	public static String translate(String value, String src, String target) {
		src = LANGUAGE.get(src);
		target = LANGUAGE.get(target);
		if(src == null || target == null){
			return null;
		}
		NameValue form = new NameValue();
		form.add("client", "t");
		form.add("hl", src);
		form.add("ie", "UTF-8");
		form.add("multires", 1);
		form.add("oe", "UTF-8");
		form.add("otf", 1);
		form.add("prev", "conf");
		form.add("psl", src);
		form.add("ptl", src);
		form.add("sc", 1);
		form.add("sl", src);
		form.add("ssel", 3);
		form.add("text", WebRequest.encode(value, "UTF-8"));
		form.add("tl", target);
		form.add("tsel", 6);

		return WebRequest.get("http://translate.google.cn/translate_a/t?"
				+ form.toString(), "UTF-8");
	}
}
