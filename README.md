免费调用谷歌翻译接口示例

翻译接口：
http://translate.google.cn/translate_a/t?……

结合java.net.HttpURLConnection发送http get请求来获取翻译结果，结果返回的是JSON数组，对结果需要手动解析。

由于Google屏蔽程序请求谷歌翻译服务，所以我们需要设置"user-agent"来模拟浏览器进行操作。详见源码。