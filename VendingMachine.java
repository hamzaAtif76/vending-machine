import java.util.Scanner;
public class VendingMachine {

    public static void main(String[] args)
    {
        int[] columns = new int[]{1,2,3,4};
        char[] rows = new char[]{'A','B','C','D','E','F','G','H'};
        String[] rowDrinks = new String[]{"Coca-Cola","Coke-Zero","Pepsi","Diet-Pepsi","Fanta","Monster","Canada-Dry","Water"};
        Double[] rowDrinkPrices = new Double[]{3.5,3.5,3.5,3.5,3.5,4.0,3.5,2.0};
        int[] drinksCountByCell = new int[]{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};  

        while (true)
        {
            System.out.println("Greetings,what kind of drink would you like?");

            Scanner scanner = new Scanner(System.in);
            
            String selectedDrink = scanner.nextLine();

            char selectedRow = selectedDrink.charAt(0);
            int indexOfSelectedRow = 0;
            char selectedColumnInChar = selectedDrink.charAt(1);
            int selectedColumn = Integer.parseInt(String.valueOf(selectedColumnInChar));
            boolean rowExists = false;

            for (int i = 0; i< rows.length; i++)
            {
                if (selectedRow == rows[i])
                {
                    rowExists = true;
                    indexOfSelectedRow = i;
                    break;
                }
            }

            boolean columnExists = false;

            for (int i = 0; i < columns.length; i++)
            {
                if (selectedColumn == columns[i])
                {
                    columnExists = true;
                    break;
                }
            }

            if (rowExists == false || columnExists == false)
            {
                System.out.println("Invalid Input");
            }
            else
            {
                int indexOfSelectedDrinkCount = (indexOfSelectedRow*4) + (selectedColumn - 1);

                if (drinksCountByCell[indexOfSelectedDrinkCount] < 1)
                {
                    System.out.println("Sorry we are out of the drink you selected");
                }
                else
                {
                    Double priceOfSelectedDrink = rowDrinkPrices[indexOfSelectedRow];

                    String selectedDrinkName = rowDrinks[indexOfSelectedRow];
                    
                    System.out.println("You have selected " + selectedDrinkName + ". It will cost $" + priceOfSelectedDrink + ".");

                    System.out.println("Please confirm to buy:");
                    System.out.println("1. Agree to buy");
                    System.out.println("2. Reject to buy");

                    int selectedOption = scanner.nextInt();
                    scanner.nextLine();

                    boolean selectedOptionInBoolean = selectedOption == 1;

                    if (selectedOptionInBoolean)
                    {
                        System.out.println("Please enter your card number and 3 digit CVV seperated by a comma");
                        
                        String userDebitInformation = scanner.nextLine();
                        
                        String[] userDebitInformationSplit = userDebitInformation.split(",");
                        
                        String cardNumber = userDebitInformationSplit[0];
                        String cardCVV = userDebitInformationSplit[1];
                        
                        if(cardNumber == null || cardCVV == null)
                        {
                            System.out.println("Sorry, incorrect payment information");
                        }
                        else
                        {
                            drinksCountByCell[indexOfSelectedDrinkCount] = drinksCountByCell[indexOfSelectedDrinkCount] -1;
                            
                            System.out.println("Thank you for purchasing your drink from us. Have a good day.");
                        }
                    }
                }
            }

            
        }
    }
}