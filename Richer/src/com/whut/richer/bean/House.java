package com.whut.richer.bean;

/*
 * ��������������Ϣ
 */
public class House {
	
	private int play_id;	//ӵ�и÷��������
	private int toll;		//��·��
	private int price;		//��������ļ۸�(������������)������������
	private int update_price;	//���������۸�
	
	public int getPlay_id() {
		return play_id;
	}
	public void setPlay_id(int play_id) {
		this.play_id = play_id;
	}
	public int getToll() {
		return toll;
	}
	public void setToll(int toll) {
		this.toll = toll;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUpdate_price() {
		return update_price;
	}
	public void setUpdate_price(int update_price) {
		this.update_price = update_price;
	}
	
}
