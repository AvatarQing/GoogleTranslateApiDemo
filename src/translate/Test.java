package translate;

import http.WebRequest;

public class Test {

	public static void main(String[] args) {
		exec("How old are you", "英语", "日语");

		exec("How old are you", "英语", "中文繁体");

		exec("你多大年纪了", "中文简体", "英语");

		exec("你多大年紀了", "中文繁体", "日语");
	}

	/**
	 * 测试用的
	 */
	public static void exec(String a, String b, String c) {
		String html = Google.translate(a, b, c);
		if (html == null) {
			System.out.println("翻译失败");
		}
		System.out.println("【返回数据】");
		System.out.println(html);

		// 解析翻译的结果.看个人需要了
		{// 字符串函数解析 .也可以用json-lib
			String s = WebRequest.mid(html, "[[[", "]]");
			String[] ss = s.split(",");
			System.out.println("【翻译结果】");
			for (int i = 0; i < ss.length; i++) {
				s = ss[i].substring(1, ss[i].length() - 1);
				System.out.println(s);
			}
		}
	}

}
