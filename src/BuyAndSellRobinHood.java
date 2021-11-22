import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BuyAndSellRobinHood {


///*price share buy/sell
//['150', '5', 'buy'], # Order A
//['190', '1', 'sell'], # Order B
//['200', '1', 'sell'], # Order C
//['100', '9', 'buy'], # Order D
//['140', '8', 'sell'], # Order E 5
//['210', '4', 'buy'], # Order F 3 + 1
//
//output: 9;
//*/
////100, 140, 150,
////rule l: buy
//    private class Node {
//        public int price;
//        public int share;
//        public Node(int price, int share) {
//            this.price = price;
//            this.share = share;
//        }
//    }
//    private class BuyNodeComparator implements Comparator<Node> {
//        @Override
//        public int compare(Node a, Node b) {
//            return b.price - a.price;
//        }
//    }
//    private class SellNodeComparator implements Comparator < Node > {
//        @Override
//        public int compare(Node a, Node b) {
//            return a.price - b.price;
//        }
//    }
//        int order_book(String[][] orders) {
//            if (orders == null || orders.length == 0 || orders[0].length == 0) {
//                return 0;
//            }
//            int res = 0;
//            PriorityQueue<Node> buypq = new PriorityQueue<Node>(new BuyNodeComparator());
//            PriorityQueue<Node> sellpq = new PriorityQueue<Node>(new SellNodeComparator());
//            for (int i = 0; i < orders.length; i++) {
//                int price = Integer.parseInt(orders[i][0]);
//                int share = Integer.parseInt(orders[i][1]);
//                if (orders[i][2].equals("buy")) {
//                    Node buynode = new Node(price, share);
//                    while (!sellpq.isEmpty() && sellpq.peek().price <= buynode.price && buynode.share > 0) {
//                        Node sellnode = sellpq.poll();
//                        if (sellnode.share > buynode.share) {
//                            res += buynode.share;
//                            sellnode.share = sellnode.share - buynode.share;
//                            sellpq.offer(sellnode);
//                            buynode.share=0;
//
//                        }
//                        else {
//                            res += sellnode.share;
//                            buynode.share -=sellnode.share;
//
//                        }
//                    }
//                    if (buynode.share > 0) {
//
//                        buypq.offer(buynode);
//                    }
//                    // if sell order
//                } else {
//                    Node sellnode=new Node(price, share);
//                    while(!buypq.isEmpty() && buypq.peek().price >= sellnode.price && sellnode.share > 0) {
//                        Node buynode = buypq.poll();
//                        if (buynode.share > sellnode.share) {
//
//                            res += sellnode.share;
//                            buynode.share = buynode.share - sellnode.share;
//                            buypq.offer(buynode);
//                            sellnode.share = 0;
//
//                        } else {
//                            res += buynode.share;
//                            sellnode.share -= buynode.share;
//
//                        }
//                    }
//                    if (sellnode.share > 0) {
//                        sellpq.offer(sellnode);
//                    }
//
//                    }
//
//
//                }
//            return res;
//
//            }

    public static void main(String[] args) {
        String[][] orders = {
                {"150", "5", "buy"},
                {"190", "1", "sell"},
                {"200", "1", "sell"},
                {"100", "9", "buy"},
                {"140", "8", "sell"},
                {"210", "4", "buy"}};
        BuyAndSellRobinHood buySellOrders = new BuyAndSellRobinHood();
        System.out.println(buySellOrders.order_book(orders));
    }

    // we create two running PQs, buy order can be a max heap and sell order can be min heap
    // so you are always maximizing profit for users
    // O(Nlog(N)) time where N number of rows in our matrix and since we are using PQ to sort | O(N) space since we are storing in PQ

    public int order_book(String[][] orders) {
        if (orders == null || orders.length == 0 || orders[0].length == 0) {
            return 0;
        }
        int result = 0;
        // max heap
        PriorityQueue<Order> buyPQ = new PriorityQueue<Order>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.price - o1.price;
            }
        });
        // min heap
        PriorityQueue<Order> sellPQ = new PriorityQueue<Order>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.price - o2.price;
            }
        });
        for (int i = 0; i < orders.length; i++) {
            int price = Integer.parseInt(orders[i][0]);
            int share = Integer.parseInt(orders[i][1]);
			/*
			A "buy" order can be executed if there is a corresponding "sell" order with a price that is less than or equal to the price of the "buy" order.
			 */
            if (orders[i][2].equals("buy")) {
                Order buyOrder = new Order(price, share);
                while (!sellPQ.isEmpty() && sellPQ.peek().price <= buyOrder.price && buyOrder.share > 0) {
                    Order sellOrder = sellPQ.poll();
                    if (sellOrder.share > buyOrder.share) {
                        result += buyOrder.share;
                        sellOrder.share = sellOrder.share - buyOrder.share;
                        sellPQ.offer(sellOrder);
                        buyOrder.share = 0;
                    } else {
                        // sellnode.share <= buynode.share;
                        result += sellOrder.share;
                        buyOrder.share -= sellOrder.share;
                    }
                }
                if (buyOrder.share > 0) {
                    buyPQ.offer(buyOrder);
                }
            } else {
				/*
				A "sell" order can be executed if there is a corresponding "buy" order with a price that is greater than or equal to the price of the "sell" order.
				 */
                // “SELL” buy price >= sell price;
                Order sellOrder = new Order(price, share);
                while (!buyPQ.isEmpty() && buyPQ.peek().price >= sellOrder.price && sellOrder.share > 0) {
                    Order buyOrder = buyPQ.poll();
                    if (buyOrder.share > sellOrder.share) {
                        result += sellOrder.share;
                        buyOrder.share = buyOrder.share - sellOrder.share;
                        buyPQ.offer(buyOrder);
                        sellOrder.share = 0;
                    } else {
                        // buynode.share >= sellnode.share;
                        result += buyOrder.share;
                        sellOrder.share -= buyOrder.share;
                    }
                }
                if (sellOrder.share > 0) {
                    sellPQ.offer(sellOrder);
                }
            }
            System.out.println("buyPQ(maxHeap):::" + buyPQ);
            System.out.println("sellPQ(minHeap):::" + sellPQ);
            System.out.println("result:::" + result);
        }
        return result;
    }

    private class Order {
        public int price;
        public int share;

        public Order(int price, int share) {
            this.price = price;
            this.share = share;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "price=" + price +
                    ", share=" + share +
                    '}';
        }
    }



}
