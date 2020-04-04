package com.bean;

import java.util.HashMap;
import java.util.Iterator;

/**
 * ���ﳵ�ࣨ���й��ﳵ������ࣩ
 * 
 * @author pc
 *
 */
public class ShopCar {
	// ��Ʒ��ļ��� <��Ʒ��ţ����ﳵ��Ʒ��>
	private HashMap<Integer, ShopCarItem> items = new HashMap<Integer, ShopCarItem>();
	// ���ﳵ��Ʒ������
	private int allCount;
	// ���ﳵ��Ʒ�ܼ۸�
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

	// ���
	public void addItem(Shoesinfo shoes, int amount) {
		// ������ڴ���Ʒ����������
		if (this.items.containsKey(shoes.getShoesid())) {
			ShopCarItem item = items.get(shoes.getShoesid());
			item.setCount((item.getCount() + amount));
		} else {
			// ����һ��ShopCarItem����
			ShopCarItem item = new ShopCarItem();
			item.setshoes(shoes);
			item.setCount(amount);
			items.put(shoes.getShoesid(), item);
		}
	}

	// �޸���Ʒ����Ϣ�ķ��� 
	public void updateItem(int id, int amount) {
		// ������ﳵ�����д���Ʒ��
		if (this.items.containsKey(id)) {
			// ��ø���Ʒ��
			ShopCarItem item = items.get(id);
			// ����������Ʒ����
			item.setCount(amount);
		}
	}

	// ɾ����Ʒ��ķ���
	public void deleteItem(int id) {
		if (this.items.containsKey(id)) {
			this.items.remove(id);
		}
	}

	// ���
	public void clear() {
		this.items.clear();
	}

	// �����ܽ��ķ���
	public float getTotalPrice() {
		float sum = 0;
		// �õ�ֵ�ĵ�����
		Iterator<ShopCarItem> itr = this.items.values().iterator();
		while (itr.hasNext()) {
			ShopCarItem item = itr.next();
			sum += item.setTotal();
		}
		return sum;
	}

	// �����������ķ���
	public int getTotalAmount() {
		int sum = 0;
		// �õ�ֵ�ĵ�����
		Iterator<ShopCarItem> itr = this.items.values().iterator();
		while (itr.hasNext()) {
			ShopCarItem item = itr.next();
			sum += (int) item.getCount();
		}
		return sum;
	}

}
