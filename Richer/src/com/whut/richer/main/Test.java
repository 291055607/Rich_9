package com.whut.richer.main;

import java.util.Scanner;

import com.whut.richer.bean.Ground;
import com.whut.richer.bean.Player;
import com.whut.richer.map.Map;
import com.whut.richer.util.Control;

public class Test {
	private static int member;	//�������
	private static String[] names ={"","Ǯ����","������","��С��","�𱴱�"};
	private static char[] ids = {'Q','A','S','J'};
	private static Player[] players;
	public static void main(String[] args) {	
		init();
		new Map();
		Map.printMap(Map.map);
		do{
			ing();
		}while(true);
	}
	
	/*
	 * ��ʼ����Ϸ
	 */
	public static void init(){
		System.out.print("��ѡ��2-4λ���ظ���ң������ż��ɣ�1.Ǯ���ˣ�2.��������3.��С����4.�𱴱���:");
		Scanner input = new Scanner(System.in);
		String m = input.nextLine();
		member = m.length();
		
		players = new Player[member];
		if(member<2||member>4){
			System.out.println("�����������ԡ�");
			init();
		}
		System.out.print("������ҳ�ʼ�ʽ𣬷�Χ1000~50000��Ĭ��10000��:");
		String money = input.nextLine();
		if(money.trim().length()==0){
			for(int i=0;i<member;i++){
				players[i] = new Player();
				int id = Integer.parseInt(m.charAt(i)+"");
				players[i].setName(names[id]);		
				players[i].setId(ids[id-1]);
			}
		}else{
			for(int i=0;i<member;i++){
				players[i] = new Player();
				int id = Integer.parseInt(m.charAt(i)+"");
				players[i].setName(names[id]);	
				players[i].setCash(Integer.parseInt(money));
				players[i].setId(ids[id-1]);
			}
		}
	}
	
	public static void ing(){
		for(int i=0;i<member;i++){
			System.out.print(players[i].getName()+">:");
			Scanner input = new Scanner(System.in);
			String order = input.nextLine();
			if(order.equals("Roll")){
				int n = Control.roll();
				System.out.println("���ӵĵ�����"+n);
				int current = players[i].getPosition();
				players[i].setPosition(n+current);
				Ground ground = Map.map.get(n+current);
				ground.setSymbol(players[i].getId());
				Map.printMap(Map.map);
			}
		}
	}
}
