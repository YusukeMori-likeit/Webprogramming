package common;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

public class Common {
	public static Date convertDate(String str) {
        try {

            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdFormat.parse(str);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
        }
		return null;
	}

	public static String convertMD5(String str) {
		//ハッシュを生成したい元の文字列
		String source = str;
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		//標準出力
		System.out.println(result);

		return result;
	}


}
