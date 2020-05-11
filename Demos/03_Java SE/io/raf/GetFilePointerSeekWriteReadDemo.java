package io.raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * long getFilePointer():获取文件指针的位置
 * void seek(long pos): 将指针移动到指定位置。
 * @author yuyu
 *
 */
public class GetFilePointerSeekWriteReadDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		// 获取 RAF 当前的指针位置
		long pos = raf.getFilePointer();
		System.out.println(pos);
		
		// 将 int 最大值写入文件
		int imax = Integer.MAX_VALUE;
		raf.write(imax >>> 24);
		System.out.println(raf.getFilePointer()); // 返回 1, 说明指针位置是以一个字节为长度单位的。
		
		raf.write(imax >>> 16);
		raf.write(imax >>> 8);
		raf.write(imax);
		System.out.println(raf.getFilePointer()); // 返回的应该是4
		
		
		/**
		 * void writeInt(int d) 方法
		 * 直接将 int 数值的二进制数的四个字节，写入文件
		 */
		raf.writeInt(imax);
		System.out.println(raf.getFilePointer()); // 8
		
		/** 
		 * void writeLong(long l)
		 * 把 long 二进制数的8个字节，写入文件。
		 */
		long l = 123l;
		raf.writeLong(l);
		System.out.println(raf.getFilePointer());
		
		/**
		 * void writeDouble(double d)
		 * 把double 二进制数的 8 个字节，写入文件。
		 */
		double dou = 123.45;
		raf.writeDouble(dou);
		System.out.println(raf.getFilePointer());
		
		/**
		 * void seek(long pos)
		 * 将文件指针移动到指定位置
		 */
		raf.seek(0);
		System.out.println(raf.getFilePointer());
		
		int int1 = raf.readInt();
		System.out.println("int1="+int1);
		System.out.println("pos: " + raf.getFilePointer()+"\n");
		
		int int2 = raf.readInt();
		System.out.println("int2="+int2);
		System.out.println("pos: " + raf.getFilePointer()+"\n");
		
		long long1 = raf.readLong();
		System.out.println("long1=" + long1);
		System.out.println("pos: " + raf.getFilePointer()+"\n");
		
		
		double dou1 = raf.readDouble();
		System.out.println("dou1="+dou1);
		System.out.println("pos: " + raf.getFilePointer()+"\n");
		
		// 将 long 的值从 123L 改成 11111L
		
		raf.seek(8);
		raf.writeLong(11111L);
		
		raf.seek(8);
		long long2 = raf.readLong();
		System.out.println(long2);
		
		System.out.println("pos: " + raf.getFilePointer()+"\n");
		
		raf.close();

	}
}
