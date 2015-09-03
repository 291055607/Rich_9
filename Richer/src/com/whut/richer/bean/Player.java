package com.whut.richer.bean;

import java.util.ArrayList;
import java.util.List;


/*
 *����������ҵ����ԺͲ������� 
 */
public class Player {
	private int position;	//��ҵ�ǰλ��
	private char id;	//��ҵ�ͼID��ʶ
	private String name;		//�������
	private int cash;	//����ֽ���
	private int point;	//��ҹ���������õĵ���
	private int stayBout;	//��ҽԺ��������ͣ���غ���
	private boolean mammon;	//����״̬
	private List<House> property = new ArrayList<House>();	//��ҷ���
	
	public Player(){
		cash=10000;
		point=0;
		stayBout=0;
		position=0;
		mammon=false;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getStayBout() {
		return stayBout;
	}
	public void setStayBout(int stayBout) {
		this.stayBout = stayBout;
	}
	public boolean isMammon() {
		return mammon;
	}
	public void setMammon(boolean mammon) {
		this.mammon = mammon;
	}
	public List<House> getProperty() {
		return property;
	}
	public void setProperty(List<House> property) {
		this.property = property;
	}
	
}
