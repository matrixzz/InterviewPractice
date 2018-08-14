public class BestTimeStock {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, sell = 0, prevBuy = Integer.MIN_VALUE, prevSell = 0;
        for(int i : prices) {
            prevBuy = buy;
            buy = Math.max(prevBuy, prevSell - i);
            System.out.println("buy: " + buy);
            prevSell = sell;
            sell = Math.max(prevSell, prevBuy + i);
            System.out.println("sell: " + sell);
        }

        return sell;
    }
}
