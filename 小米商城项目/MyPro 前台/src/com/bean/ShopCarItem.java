package com.bean;
/**
 * ���ﳵ��Ʒ�����
 * @author pc
 *
 */
public class ShopCarItem {
    private Shoesinfo shoes;  //��Ʒ����
    private int count;     //��Ʒ����
    private float total;   //��ƷС��
    
  public ShopCarItem() {
}

public ShopCarItem(Shoesinfo shoes, int count, float total) {
	super();
	this.shoes = shoes;
	this.count = count;
	this.total = total;
}

public Shoesinfo getshoes() {
	return shoes;
}

public void setshoes(Shoesinfo book) {
	this.shoes = book;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public float getTotal() {
	return (float)shoes.getShoesprice()*count;
}

public void setTotal(float total) {
	this.total = total;
}
  
//������ƷС��
	public float setTotal(){
		//С�� = ��Ʒ����*����
		return (float)shoes.getShoesprice()*count;
	}
	
}
