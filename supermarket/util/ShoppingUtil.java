package week4.supermarket.util;

import week4.supermarket.impl.*;
import week4.supermarket.interfaces.Category;
import week4.supermarket.interfaces.Customer;
import week4.supermarket.interfaces.Merchandise;
import week4.supermarket.interfaces.SuperMarket;

import java.util.Scanner;

public class ShoppingUtil {

    private static final Scanner in = new Scanner(System.in);

    public static Scanner input() {
        return in;
    }

    public static void output(Object obj) {
        System.out.println(String.valueOf(obj));
    }


    public static SuperMarket createSuperMarket() {
        int merchandisePerCategory = 10;
        Merchandise[] all = new Merchandise[Category.values().length * merchandisePerCategory];

        for (Category category : Category.values()) {
            for (int i = 0; i < merchandisePerCategory; i++) {

                double soldPrice = Math.random() * (category.getHigherPrice() - category.getLowerPrice())
                    + category.getLowerPrice();

                double purchasePrice = soldPrice * 0.7;

                all[category.ordinal() * merchandisePerCategory + i] = new SimpleMerchandise(
                    category.name() + i, soldPrice, purchasePrice, 200, category
                );
            }
        }

        SimpleSuperMarket superMarket = new SimpleSuperMarket(all);
        output("请输入超市的名字：");
        String s = input().next();
        if (s.trim().length() > 0) {
            superMarket.setName(s.trim());
        }
        return superMarket;
    }

    public static Customer createCustomer(boolean auto) {
        if (auto) {
            String custId = "CUST" + (int) (Math.random() * 10000);
//            Category shouldBuy = getRandomCategory();
            Category shouldBuy = chooseCategory1();//键盘输入Category
            if (Math.random() < 0.5) {
                return new SuiYuanCustomer(custId, shouldBuy);
            } else {
                ThinkAndBuyCustomer ret = new ThinkAndBuyCustomer(custId, shouldBuy);
                ret.setCard(getRandomVIPCard());
                return ret;
            }
        }
        // TODO 思考题：允许输入一个类名，使用Class.forName(类名)，获得这个类的Class实例，
        //  然后调用newInstance方法，创建这个类的实例
        return null;

    }

//    public static Category getRandomCategory() {
////        System.out.println(Category.values());
////        System.out.println(Category.values().length);
//
//        return Category.values()[(int) (Math.random() * 1000) % Category.values().length];
//    }

    /**
     * 没有用覆盖，需要修改的地方有
     * 本类第55行
     * AbsCustomer第8行，第75行
     * 对于覆盖的理解不是很透彻，蓝过
     *
     * @return
     */
    public static Category chooseCategory1() {
//        System.out.println(Category.values());
//        System.out.println(Category.values().length);
        output("请输入购买物品，编号为0~5");
//        output((int) (Math.random() * 1000) % Category.values().length);
        int a = input().nextInt();
//        return Category.values()[(int) (Math.random() * 1000) % Category.values().length];
        return Category.values()[(int) a];
//        return Category.values()[3];
    }

    public static VIPCard getRandomVIPCard() {
        return VIPCard.values()[(int) (Math.random() * 1000) % VIPCard.values().length];
    }


}
