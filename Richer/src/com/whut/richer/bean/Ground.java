package com.whut.richer.bean;

/*
 * ��������״̬
 */
public class Ground {
	private int position;	//���ص�λ��
	private char symbol;	//�ڿ���̨��ʾ�ı�ʶ
	private boolean bomb;	//��λ���Ƿ���ը��
	private boolean block;	//��λ���Ƿ���·��
	private House house;	//��λ���Ƿ��з���
	private Mine mine;		//��λ���Ƿ��п��
	private boolean tool;	//��λ���Ƿ��е�����
	private boolean hospital;//��λ���Ƿ���ҽԺ
	private boolean jail;	//��λ���Ƿ��м���
	private boolean giftHouse;	//��λ���Ƿ�����Ʒ��
	private boolean magicHouse;	//��λ���Ƿ���ħ����
	
	public Ground(){
		this.symbol = '0';
		this.bomb = false;
		this.block = false;
		this.house = null;
		this.mine = null;
		this.tool = false;
		this.hospital = false;
		this.jail = false;
		this.giftHouse = false;
		this.magicHouse = false;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public boolean isBomb() {
		return bomb;
	}
	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}
	public boolean isBlock() {
		return block;
	}
	public void setBlock(boolean block) {
		this.block = block;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public Mine getMine() {
		return mine;
	}
	public void setMine(Mine mine) {
		this.mine = mine;
	}
	public boolean isTool() {
		return tool;
	}
	public void setTool(boolean tool) {
		this.tool = tool;
	}
	public boolean isHospital() {
		return hospital;
	}
	public void setHospital(boolean hospital) {
		this.hospital = hospital;
	}
	public boolean isJail() {
		return jail;
	}
	public void setJail(boolean jail) {
		this.jail = jail;
	}
	public boolean isGiftHouse() {
		return giftHouse;
	}
	public void setGiftHouse(boolean giftHouse) {
		this.giftHouse = giftHouse;
	}

	public boolean isMagicHouse() {
		return magicHouse;
	}

	public void setMagicHouse(boolean magicHouse) {
		this.magicHouse = magicHouse;
	}
}