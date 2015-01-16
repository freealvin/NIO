package org.oscar.demos;


import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/*
* NBTest
* 1.0.0
* 2015��1��16��17:41:50
* Copyright 2015, �� ��
* All rights reserved.
* �� ��
*/

public class NBTest {
	public NBTest(){}
	public void startServer() throws Exception
	{
		int channels = 0;
		int nKeys = 0;
		int currentSelector = 0;
		
		Selector selector = Selector.open();
		
		//����Channel���󶨵�9000�˿�
		ServerSocketChannel ssc= ServerSocketChannel.open();
		InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 9000);
		ssc.socket().bind(address);
		
		
		//ʹ�÷�������ʽ
		ssc.configureBlocking(false);
		
		//��Selectorע��Channel�Լ����Ǹ���Ȥ���¼�
		SelectionKey s = ssc.register(selector, SelectionKey.OP_ACCEPT);
		printKeyInfo(s);
		
		while(true)
		{
			System.out.println("NBTest:Starting test");
			
			nKeys = selector.select();
			if(nKeys>0)
			{
				System.out.println("NBTest�� Number of keys afer ");
			}
			
		}
		
	}
	private void printKeyInfo(SelectionKey sk) {
		// TODO Auto-generated method stub
		String s = new String();
		
		s = "Att: " + (sk.attachment() == null ? "no" : "yes");
		 s += ", Read: " + sk.isReadable();
		 s += ", Acpt: " + sk.isAcceptable();
		 s += ", Cnct: " + sk.isConnectable();
		 s += ", Wrt: " + sk.isWritable();
		 s += ", Valid: " + sk.isValid();
		 s += ", Ops: " + sk.interestOps();
		 System.out.println(s);
	}
}
