package jan15;

import java.util.Scanner;

public class App {
	Scanner input;
	String panel[][]= {{"admin","admin@123"},{"emp","emp@123"}};
	
	int price[],discount[],qty;
	float discountPrice;
	String product[];
	int ch;
	char uChoice;
	int flag=0,unValid=0;
	public App() 
	{
		    System.out.println("welcome my application");
		    input=new Scanner(System.in);
		    verifyAccount();
			
	}
	private void verifyAccount()
	{
		do {
		
			  	System.out.print("User Name :-");
			    String name=input.next();
			    System.out.print("Password :-");
			    String password=input.next();
			    for(int i=0;i<panel.length;i++)
			    {
			    	if(name.equals(panel[i][0])&&password.equals(panel[i][1]))
			    	{
			    		flag=1;
			    		break;
			    	}
			    }
			    if(flag==0)
			    {
			    	unValid++;
			    }
			    else
			    {
			    	unValid=3;
			    }
			   
			    if(unValid==3) {}
			    else
			    System.out.println("please enter valid authorised Person");
		}while(unValid<3);   
	   
	}
	
	private void choiceData()
	{
		if(flag>0)
		{	
			System.out.println("Enter product quantity");
			qty=input.nextInt();
			
			product=new String[qty];
			price=new int[qty];
			discount=new int[qty];
		
		do {
				System.out.println("enter 1  to add product");
				System.out.println("enter 2  to view product");
				System.out.println("enter 3 to Logout");
				System.out.println("Enter your choice ");
				ch=input.nextInt();
			   
			   switch (ch)
			   {
			   		case 1:
			   			addProduct();
					break;
					case 2:
						
						    viewProduct();
						
					break;
					case 3:
						System.out.println("Logout your App");
						System.exit(0);
					break;
		
					default:
						System.out.println("your invalid choice");
				
			   }
			   System.out.println();
			   System.out.println("Do you want to continue your task - Press Y else any key");
			   uChoice=input.next().charAt(0);
		   }while(uChoice=='Y'||uChoice=='y'); 
			
		if(!(uChoice=='y'||uChoice=='Y'))
		{
			System.out.println("Logout &   try again");
			System.exit(0);
		}
	  }
		else
		{
			System.out.println("Unauthorised Person");
		}
	} 
	   private void viewProduct() 
	   {
		   System.out.print("Product No ");
		   System.out.print("Product Name ");
		   System.out.print("Product MRP ");
		   System.out.print("Product Discount ");
		   System.out.println("Product price ");
			for(int i=0;i<qty;i++)
			{
				System.out.print((i+1)+"               ");
				System.out.print(product[i]+"             ");
				System.out.print(price[i]+"               ");
				System.out.print(discount[i] +" %"+"       ");
				discountPrice=(price[i]-((price[i]*discount[i])/100));
				System.out.print(discountPrice+"               ");
				System.out.println();
				
			}
		
	    }

		private void addProduct() 
		{
			System.out.println("Enter your data");
			input.nextLine();
			for(int i=0;i<qty;i++)
			{
				System.out.println("Product No :-  "+(i+1));
				System.out.print("Enter your product name :-  ");
				product[i]=input.nextLine();
				System.out.print("Enter product price :-  ");
				price[i]=input.nextInt();
				System.out.print("Enter product discount % :-  ");
				discount[i]=input.nextInt();
				input.nextLine();
			}
			
		}

	public static void main(String[] args) 
	   {
		  App obj=new App();
		  
		  obj.choiceData();
		
	   }
	
	
	

}
