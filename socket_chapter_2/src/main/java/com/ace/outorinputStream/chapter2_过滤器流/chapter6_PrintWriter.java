package com.ace.outorinputStream.chapter2_过滤器流;

import java.io.File;

/**
 * 
 * 
 * @ClassName: chapter6_PrintWriter
 * 
 * @Description: PrintWriter 是字符类型的打印输出流，它继承于Writer。
 * 
 * 
 *               API: PrintWriter(OutputStream out) PrintWriter(OutputStream
 *               out, boolean autoFlush) PrintWriter(Writer wr)
 *               PrintWriter(Writer wr, boolean autoFlush) PrintWriter(File
 *               file) PrintWriter(File file, String csn) PrintWriter(String
 *               fileName) PrintWriter(String fileName, String csn) PrintWriter
 *               append(char c) PrintWriter append(CharSequence csq, int start,
 *               int end) PrintWriter append(CharSequence csq) boolean
 *               checkError() void close() void flush() PrintWriter
 *               format(Locale l, String format, Object... args) PrintWriter
 *               format(String format, Object... args) void print(float fnum)
 *               void print(double dnum) void print(String str) void
 *               print(Object obj) void print(char ch) void print(char[]
 *               charArray) void print(long lnum) void print(int inum) void
 *               print(boolean bool) PrintWriter printf(Locale l, String format,
 *               Object... args) PrintWriter printf(String format, Object...
 *               args) void println() void println(float f) void println(int i)
 *               void println(long l) void println(Object obj) void
 *               println(char[] chars) void println(String str) void
 *               println(char c) void println(double d) void println(boolean b)
 *               void write(char[] buf, int offset, int count) void write(int
 *               oneChar) void write(char[] buf) void write(String str, int
 *               offset, int count) void write(String str)
 * 
 * @author: admin
 * 
 * @date: 2019年6月21日 上午9:57:28
 */
public class chapter6_PrintWriter {

	private static char[] arr = { '1', '2', 'd', 'v' };

	public final static String pathName = "D:\\TeamFile\\5.txt";

	private static void PrintWriter() throws Exception {
		File file = new File(pathName);
		java.io.PrintWriter out = new java.io.PrintWriter(file);
		out.write(arr);
		out.close();

	}

//	void     println()
	private static void PrintWriterPrintln() throws Exception {

		File file = new File(pathName);
		java.io.PrintWriter out = new java.io.PrintWriter(file);
		out.println(Boolean.FALSE);
		out.println(Boolean.TRUE);
		out.close();
	}

	public static void main(String[] args) {

		try {
//			PrintWriter();
			PrintWriterPrintln();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
