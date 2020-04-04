package com.bean;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 购物车类（所有购物车对象的类）
 * 
 * @author pc
 *
 */
public class ShopCar {
	// 商品项的集合 <商品编号，购物车商品项>
	private HashMap<Integer, ShopCarItem> items = new HashMap<Integer, ShopCarItem>();
	// 购物车商品总数量
	private int allCount;
	// 购物车商品总价格
	private int allTotal;

	public ShopCar() {
	}

	public ShopCar(HashMap<Integer, ShopCarItem> items, int allCount,
			int allTotal) {
		super();
		this.items = items;
		this.allCount = allCount;
		this.allTotal = allTotal;
	}

	public HashMap<Integer, ShopCarItem> getItems() {
		return items;
	}

	public void setItems(HashMap<Integer, ShopCarItem> items) {
		this.items = items;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public float getAllTotal() {
		return allTotal;
	}

	public void setAllTotal(int allTotal) {
		this.allTotal = allTotal;
	}

	// 添加
	public void addItem(Shoesinfo shoes, int amount) {
		// 如果存在此商品，增加数量
		if (this.items.containsKey(shoes.getShoesid())) {
			ShopCarItem item = items.get(shoes.getShoesid());
			item.setCount((item.getCount() + amount));
		} else {
			// 构造一个ShopCarItem对象
			ShopCarItem item = new ShopCarItem();
			item.setshoes(shoes);
			item.setCount(amount);
			items.put(shoes.getShoesid(), item);
		}
	}

	// 修改商品项信息的方法 
	public void updateItem(int id, int amount) {
		// 如果购物车里面有此商品项
		if (this.items.containsKey(id)) {
			// 获得该商品项
			ShopCarItem item = items.get(id);
			// 重新设置商品数量
			item.setCount(amount);
		}
	}

	// 删除商品项的方法
	public void deleteItem(int id) {
		if (this.items.containsKey(id)) {
			this.items.remove(id);
		}
	}

	// 清空
	public void clear() {
		this.items.clear();
	}

	// 计算总金额的方法
	public float getTotalPrice() {
		float sum = 0;
		// 得到值的迭代器
		Iterator<ShopCarItem> itr = this.items.values().iterator();
		while (itr.hasNext()) {
			ShopCarItem item = itr.next();
			sum += item.setTotal();
		}
		return sum;
	}

	// 计算总数量的方法
	public int getTotalAmount() {
		int sum = 0;
		// 得到值的迭代器
		Iterator<ShopCarItem> itr = this.items.values().iterator();
		while (itr.hasNext()) {
			ShopCarItem item = itr.next();
			sum += (int) item.getCount();
		}
		return sum;
	}

}
