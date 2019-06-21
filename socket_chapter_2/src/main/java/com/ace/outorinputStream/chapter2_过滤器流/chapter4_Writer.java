package com.ace.outorinputStream.chapter2_过滤器流;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * 
 * 
 * @ClassName: chapter4_Writer
 * 
 * @Description: TODO OutputStreamWriter 是
 *               Writer的重要具体子类，将接受字符，再根据指定的编码方式装换成字节，并写入底层输出流， public
 *               OutputStreamWriter(OutputStream out,String encoding)
 *               将“字节输出流”转换成“字符输出流”。它继承于Writer。 是字节流通向字符流的桥梁：它使用指定的 charset
 *               读写字节并将其解码为字符。 API: writer(),getEncoding()...
 * 
 */
public class chapter4_Writer {

	public final static String pathName = "D:\\TeamFile\\4.txt";

	public static void outputStreamWriter() throws Exception {

		Writer writer = new OutputStreamWriter(new FileOutputStream(pathName), "UTF-8");
		String str = "OutputStreamWriter 是 Writer的重要具体子类，将接受字符，再根据指定的编码方式装换成字节，并写入底层输出流.";
		writer.write(str);
		writer.close();
	}

	public static void main(String[] args) throws Exception {
		outputStreamWriter();
	}

}
