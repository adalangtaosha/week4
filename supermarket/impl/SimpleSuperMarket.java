package week4.supermarket.impl;

import week4.supermarket.interfaces.Category;
import week4.supermarket.interfaces.Merchandise;
import week4.supermarket.interfaces.SuperMarket;

import static week4.supermarket.util.ShoppingUtil.output;

public class SimpleSuperMarket implements SuperMarket {

    private String name = "无名";

    private Merchandise[] all;
    private int[] allCount;//每一种商品的数量

    private double totalMoneyEarn;//营业额

    private int customerCount;

    public SimpleSuperMarket(Merchandise[] all) {
        this.all = all;
        allCount = new int[all.length];
        for (int i = 0; i < all.length; i++) {
            allCount[i] = all[i].getCount();
        }
    }

    @Override
    public Merchandise[] getAllMerchandise() {
        return all;
    }

    /**
     * 随机的返回某个品类下的一种商品
     * @param category
     * @return
     */
    @Override
    public Merchandise[] getRandomMerchandiseOfCategory(Category category) {
        Merchandise[] ret = new Merchandise[5];//5种商品的信息
        int pos = 0;
        for (Merchandise m : all) {
            if (m.getCategory() == category && Math.random() > 0.5 && pos < ret.length - 1) {
                ret[pos] = m;
                pos++;
            }
        }
        return ret;
    }

    @Override
    public void addEarnedMoney(double moneyEarn) {
        customerCount++;//完成一单，计数+1
        this.totalMoneyEarn += moneyEarn;//营业额+
    }

    @Override
    public void dailyReport() {
        output("营业额为：" + totalMoneyEarn);
        output("商品售出情况如下：");
        for (int i = 0; i < all.length; i++) {
            if (allCount[i] != all[i].getCount()) {
                System.out.println(all[i].getCategory().name()
                    + "\t" + all[i].getName() + "\t" + (allCount[i] - all[i].getCount()));
            }
        }


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
