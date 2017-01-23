package com.itszt.freethinker;
/**
 *	company: http://www.itszt.com ( or http://itszt.losoon.com)
 *	author: freethinker
 *	email: 1942623403@qq.com
 *			2012-1-28
 */

public class TestThread {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	//静态方法，不能直接使用非静态成员变量，不能直接调用非静态方法
	//new User(); jre中的类载入器沿着classpath路径找到User类并把该类载入内存，而后，根据类创建对象
	// int i;
	// Thread t1= null;
	// public TestThread(){
	// t1 = new MyThread();
	// }
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		for(int i = 0;i<1024; i++){
//			Thread.sleep(200);
//		}
		Thread t1 = new MyThread();
		t1.start();
		MyThreadTemp temp = new MyThreadTemp();
		Thread t2 = new Thread(temp);
		t2.start();
		Thread t3 = new Thread(temp);
		t3.start();
		
	}
}
//定义线程的两种方式，继承Thread,实现runable
class MyThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 1024; i++) {
			System.out.println(Thread.currentThread().getName()+"  "+i);
			try {
				Thread.sleep(1000);
//				if(i==400){
//					break;
//				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class MyThreadTemp implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 1024; i++) {
			System.out.println(Thread.currentThread().getName()+"  "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
