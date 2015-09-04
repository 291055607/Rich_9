package com.whut.richer.main;

import java.util.Scanner;

import com.whut.richer.bean.Ground;
import com.whut.richer.bean.Player;
import com.whut.richer.map.Map;
import com.whut.richer.util.Control;
import com.whut.richer.util.Operation;

/*
 * ��������
 */
public class Test {
	private static int member;	//�������
	private static String[] names ={"","Ǯ����","������","��С��","�𱴱�"};//�������
	private static char[] symbols = {'Q','A','S','J'};//����ڵ�ͼ�ϵı�ʶ
	private static Player[] players;//��ǰ���
	private static Scanner input = new Scanner(System.in);
	private static int step;	//������Ĳ���
	private static boolean flag;	//�жϵ�ǰ�Ƿ�������ǰ���
	private static int tiao=0;	//���������˶�����
	public static void main(String[] args) {	
		init();
		new Map();
//		Map.printMap(Map.map);
		Map.map.get(1).setBomb(true);
		Map.map.get(1).setSymbol('@');
		Map.map.get(2).setBomb(true);
		Map.map.get(2).setSymbol('@');
		Map.map.get(3).setBomb(true);
		Map.map.get(3).setSymbol('@');
		Map.map.get(4).setBomb(true);
		Map.map.get(4).setSymbol('@');
		Map.map.get(5).setBomb(true);
		Map.map.get(5).setSymbol('@');
		Map.map.get(6).setBomb(true);
		Map.map.get(6).setSymbol('@');
		do{
			for(int i=0;i<member;i++){
				ing(i);
//				if(flag){
//					i=i+tiao;
//					flag=false;
//					tiao=0;
//				}
			}
		}while(true);
	}
	
	/*
	 * ��ʼ����Ϸ
	 */
	public static void init(){
	
		System.out.print("��ѡ��2-4λ���ظ���ң�"
				+ "�����ż��ɣ�1.Ǯ���ˣ�2.��������3.��С����4.�𱴱���:");
		
		String m = input.nextLine();
		member = m.length();
		
		players = new Player[member];
		if(member<2||member>4){
			System.out.println("�����������ԡ�");
			init();
			return;
		}
		System.out.print("������ҳ�ʼ�ʽ𣬷�Χ1000~50000��Ĭ��10000��:");
		String money = input.nextLine();
		for(int i=0; i<member; i++){
			players[i] = new Player();
			int id = Integer.parseInt(m.charAt(i)+"");
			players[i].setName(names[id]);		
			players[i].setSymbol(symbols[id-1]);
			if(money.trim().length()!=0){
				players[i].setCash(Integer.parseInt(money));
			}
		}
	}
	
	/*
	 * ��Ϸ����
	 */
	public static void ing(int i){
		//��ӡ��ͼ
		Map.printMap(Map.map);
		//��ǰ����Ƿ�����
		int stayBout = players[i].getStayBout();
		if(stayBout!=0){
//			flag=true;
//			tiao+=1;
			players[i].setStayBout(--stayBout);		
			System.out.println(players[i].getName()+"�������غ�,��������"+players[i].getStayBout()+"�غ�");
//			ing(++i);
			return;
		}
		//ָ���������ָ��
		System.out.print(players[i].getName()+">:");
		//��ȡ����̨һ��
		String[] orders = input.nextLine().split(" ");
		String order = orders[0];
		if(orders.length>1){
			step = Integer.parseInt(orders[1].trim());			
		}
		if("sell".equalsIgnoreCase(order)){
			exist_step(i);
			Control.sell(step, players[i]);
			ing(i);
			return;
		}else if("block".equalsIgnoreCase(order)){
			exist_step(i);
			Control.block(step, players[i]);
			ing(i);
			return;
		}else if("bomb".equalsIgnoreCase(order)){
			exist_step(i);
			Control.bomb(step, players[i]);
			ing(i);
			return;
		}else if("robot".equalsIgnoreCase(order)){
			Control.robot(players[i]);
			ing(i);
			return;
		}else if("query".equalsIgnoreCase(order)){
			Control.query(players[i]);
			ing(i);
			return;
		}else if("help".equalsIgnoreCase(order)){
			Control.help();
			ing(i);
			return;
		}else if("quit".equalsIgnoreCase(order)){
			Control.quit();
		}else if("roll".equalsIgnoreCase(order)){
			do_roll(i);
		}else{
				System.out.println("�����ʽ�д���������Help�����ѯ����������.");
				ing(i);
				return;
		}
		for(int j=0;j<member;j++){
			int cur_position = players[j].getPosition();
			Ground cur_ground = Map.map.get(cur_position);
			cur_ground.setSymbol(players[j].getSymbol());
		}		
	}
	
	public static void do_roll(int i){
		//����Roll��������һ��1~6�������
		int n = Control.roll();
		//��ʾ���ӵ���ֵ
		System.out.println("���ӵĵ�����"+n);
		n = Operation.exist_block(n, players[i]);
		//��ȡ��ǰ��ҵ�ǰλ��			
		int current = players[i].getPosition();
		//��ȡ���Ŀ��λ�õı�ʶ
		Ground aim_ground = Map.map.get(n+current);	
		//����ߵ�Ŀ��λ��
		players[i].setPosition(n+current);
		if(aim_ground.isBomb()){
//			flag=true;
//			tiao+=1;
			players[i].setStayBout(3);
			players[i].setPosition(14);
			aim_ground.setSymbol(aim_ground.getPreSymbol());
			aim_ground.setBomb(false);
			System.out.println("���Ҳȵ�ը��,��ҽԺ��Ϣ3��");
//			ing(++i);			
			return;
		}
		if(aim_ground.isJail()){
			players[i].setStayBout(2);
			System.out.println("��ץ�����2��");
			return;
		}
		if(aim_ground.isGiftHouse()){
			System.out.println("��ӭ������Ʒ�ݣ���ѡ��һ����ϲ������Ʒ��");
			System.out.println("ͨ��������ѡ����Ʒ:1.����2.��������3.����");
			System.out.println("ֻ�ܺ�ѡ��һ����Ʒ��ѡ����Զ��˳���Ʒ�ݣ��������Ҳ�˳����͵������˴λ��ᣩ");
			String choose = input.nextLine();
			try{
				int c = Integer.parseInt(choose.trim());
				if(c==1){
					players[i].setCash(players[i].getCash()+2000);
				}else if(c==2){
					players[i].setPoint(players[i].getPoint()+200);
				}else if(c==3){
					players[i].setMammon(players[i].getMammon()+5);
				}else{
					System.out.println("�������,�����ʸ�");
					return;
				}
			}catch(Exception e){
				System.out.println("�������,�����ʸ�");
				return;
			}
		}
		if(aim_ground.isTool()){
			
			System.out.println("��ӭ���ٵ����ݣ���ѡ��������Ҫ�ĵ���.");
			if(players[i].getPoint()<50){
				System.out.println("���ĵ������㣬�Զ��˳�");
				return;
			}			
			System.out.println("ͨ��������ߵı��ѡ����ߣ�ÿλ���������ӵ��10������");
			System.out.println("1.·�� 50��2.�������� 50��3.ը�� 50");
			System.out.println("�����ʽ����� ����������:1 2");
			System.out.println("��F���˳������ݡ�");
			if(players[i].getBlockNum()+players[i].getBombNum()+players[i].getRobotNum()<10){
				String in = input.nextLine();
			}else{
				System.out.println("���ĵ��������������Զ��˳�");
				return;
			}			
		}
		//�޸����Ŀ�ĵصı�ʶ
		aim_ground.setSymbol(players[i].getSymbol());
		//����ҵ�ǰλ�øĻ�֮ǰ��״̬
		Ground cur_ground = Map.map.get(current);
		cur_ground.setSymbol(cur_ground.getPreSymbol());
	}
	
	//�ж����������ʽ
	public static void exist_step(int i){
		if(step==0){
			System.out.println("�����ʽ�д���������Ϊ0,������Help�����ѯ����������.");
			ing(i);
			return;
		}
	}
}