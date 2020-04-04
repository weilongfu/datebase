package com.bean;
/**
 * 购物车商品项的类
 * @author pc
 *
 */
public class ShopCarItem {
    private Shoesinfo shoes;  //商品对象
    private int count;     //商品数量
    private float total;   //商品小计
    
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
  
//计算商品小计
	public float setTotal(){
		//小计 = 商品单价*数量
		return (float)shoes.getShoesprice()*count;
	}
	
}
