package com.bridgelabz.workshop2;
import java.util.Scanner;

public class Main {

	  FoodManager foodManager = FoodManager.getInstance();
	  OrderStore orderStore = OrderStore.getInstance();
	  static Scanner sc = new Scanner(System.in);
	//  FoodManager foodManager = new FoodManager();
	  public static void main(String[] args) {

		  Main main = new Main();
		  main.showUserOption();
	  }

	void showUserOption() {
		System.out.println("enter 1 to update the food items ");
		int choice = 0;
		while (choice != 15) {
			System.out.println("1. Show food item :: 2. Update food item :: 3. add food item 4. remove foodItem "
					+ " 5 . place the order 10. 6. Show veg item 7.Show Non veg item 8. print All order"
					+ " 9. print all Waiting order  10. print all Deliverd orders 11. print all Prepared order 12. print all Cancelled "
					+ "13. Cancelled an order  14. update order status 15 . exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1 :
				foodManager.printMenu();
				break;
			case 2 :
				updateFoodItems();
				break;
			case 3 :
				foodManager.addFoodItem();
				break;
			case 4 :
				foodManager.removeFoodItem();
				break;
			case 5 :
				placeTheOrder();
				break;
			case 6 :
				foodManager.printAllVegItems();
				break;
			case 7 :
				foodManager.printAllNonVegitems();
				break;
			case 8 :
				orderStore.printAllOrders();
				break;
			case 9 :
				orderStore.printAllWaitingOrder();
				break;
			case 10 :
				orderStore.printAllDeliveredOrder();
				break;
			case 11 :
				orderStore.printAllPreparedOrder();
				break;
			case 12 :
				orderStore.printAllCancelledOrder();
				break;
			case 13 :
				orderStore.cancelOrder();
				break;
			case 14 :
				orderStore.updateOrderStatus();
				break;
			case 15 :
				break;
			default :
				System.out.println(" Press correct input");
				break;
			}


		}

	}

	private void updateFoodItems() {
		System.out.println(" Enter the Food Item to be Update ");
	    String Item = sc.next();
	    FoodItem foodItem = foodManager.getFoodItem(Item);
	    System.out.println(foodItem);
	    int parameter = 0;
        while (parameter != 5) {
            System.out.println("Enter 1-Taste \n 2-Prep Time, \n 3-name, \n 4-category");
            parameter = sc.nextInt();
            switch (parameter) {
                case 1:
                    updateTaste(foodItem);
                    break;
                case 2:
                    updatePrepTime(foodItem);
                    break;
                case 3:
                    updateName(foodItem);
                    break;
                case 4:
                    updateCategory(foodItem);
                    break;
                default :
    				System.out.println(" make coorect choice");
    				break;
            }
            System.out.println(foodItem);
        }
    }

	private void updateTaste(FoodItem foodItem) {
		System.out.println( "To change taste ");
		System.out.println("press 1 for oily");
    	System.out.println(" enter 2 for spicy");
    	System.out.println("enter 3 for crunchy");
    	System.out.println("enter 4 for lightsugary");
    	int taste = sc.nextInt();
    	switch (taste) {
    	case 1 :
    		foodItem.taste = FoodItem.Taste.spicy;
    		break;
    	case 2 :
    		foodItem.taste = FoodItem.Taste.salty;
    		break;
    	case 3 :
    		foodItem.taste = FoodItem.Taste.crunchy;
    		break;
    	case 4 :
    		foodItem.taste = FoodItem.Taste.lightsugary;
    		break;
    		default :
    			System.out.println(" Please enter correct input");
    	}
    	foodManager.add(foodItem);
	}

	private void updatePrepTime(FoodItem foodItem) {
        System.out.println("Enter the time ");
        foodItem.preparationTime = sc.nextByte();
        foodManager.add(foodItem);
        System.out.println(foodItem);
    }

    private void updateName(FoodItem foodItem) {
        System.out.println("Enter the name ");
        foodItem.name = sc.nextLine();
        foodManager.add(foodItem);
        System.out.println(foodItem);
    }

    private void updateCategory(FoodItem foodItem) {
        System.out.println("Choose from below ");
        System.out.println("1- MAINCOURSE 2-STARTERS 3-JUICES 4-DESSERT");
        int category = sc.nextInt();
        switch (category) {
            case 1:
            	foodItem.category = FoodItem.Category.MainCourse;
            	break;
            case 2:
            	foodItem.category = FoodItem.Category.Starters;
                break;
            case 3:
            	foodItem.category = FoodItem.Category.Juices;
                break;
            case 4:
            	foodItem.category = FoodItem.Category.Dessert;
            default:
                System.out.println("Enter right Category.");
        }

        foodManager.add(foodItem);
        System.out.println(foodItem);
        }

    public void placeTheOrder() {

	  	Order order = new Order();
        System.out.println("Enter the Order id");
        order.setOrderId(sc.nextInt());
        System.out.println(" Please enter your name ");
        order.setPersonName(sc.next());
        System.out.println(" Please enter the dilevery address ");
        order.setDeliveryAddress(sc.next());
        System.out.println("Enter the payment method\n1.COD 2.CREDIT_CARD 3.DEBIT_CARD 4.NET_BANKING 5.UPI 6.WALLET");
        int payment = sc.nextInt();
		switch (payment) {
			case 1:
				order.setPaymentMethod(Order.PaymentMethod.COD);
				break;
			case 2:
				order.setPaymentMethod(Order.PaymentMethod.CREDIT_CARD);
				break;
			case 3:
				order.setPaymentMethod(Order.PaymentMethod.Debit_Card);
				break;
			case 4:
				order.setPaymentMethod(Order.PaymentMethod.NET_BANKING);
				break;
			case 5:
				order.setPaymentMethod(Order.PaymentMethod.UPI);
				break;
			case 6:
				order.setPaymentMethod(Order.PaymentMethod.WALLET);
				break;
		}

    	System.out.println("we have this much to order:: ");
        foodManager.printMenu();
        String itemName = " ";
        while(!itemName.equals("quit")) {
        	System.out.println("enter what you want to buy");
        	 itemName = sc.next();
        	if(!itemName.equals("quit"))  {
        		order.foodCart.add(foodManager.getFoodItem(itemName));
                System.out.println("Enter the quantity");
                order.setQuantity(sc.nextInt());
                order.map.put(foodManager.getFoodItem(itemName), order.getQuantity());
        	}
        }
        System.out.println("your order list is " + order.map);
        order.setOrderTime(java.time.LocalTime.now());
        System.out.println("Order time is " +order.getOrderTime());
        orderStore.add(order);
    	calculateTotalPrice(order) ;
    }

    public void calculateTotalPrice(Order order) {

    	int  totalPrice = 0;
    	totalPrice = order.map.entrySet().stream().map(entry ->(int) (entry.getKey().price * entry.getValue()))
    			.reduce(0,(total, item)-> total + item);
        System.out.println("Your Bill is = " +totalPrice);

    }


}




			

