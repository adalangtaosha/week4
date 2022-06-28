package week4.supermarket.interfaces;

public interface SuperMarket {

    Merchandise[] getAllMerchandise();

    Merchandise[] getRandomMerchandiseOfCategory(Category category);//

    void addEarnedMoney(double earnedMoney);//营业额

    void dailyReport();//打印日报

}
