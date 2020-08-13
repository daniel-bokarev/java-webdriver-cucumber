package definitions;

import cucumber.api.java.en.And;

import java.lang.reflect.Array;

public class JavaStepDefs {
    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @And("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println(str1.toUpperCase() + " and " + str2.toUpperCase());
        System.out.println("Length of " + str2 + " is " + str1.length());
        System.out.println("Does " + str1 + " match " + str2 + "? " + str1.equals(str2));
        System.out.println("Does " + str1 + " match " + str2 + "? " + str1.equalsIgnoreCase(str2));
        System.out.println(str1.contains(str2));
    }

    @And("I do homework for day {int}")
    public void iDoHomeworkForDay(int day) {
        //Numbers exercises
        int num1 = 13;
        int num2 = 10;
        float num3 = 10.0f;
        System.out.println(num1/num2); //result is an integer
        System.out.println(num1/num3); //result it a float
        var sum = num1 + num2;
        var difference = num1 - num2;
        var quotient = num1 / num2;
        var product = num1 * num2;
        System.out.println("Sum is " + sum);
        System.out.println("Difference is " + difference);
        System.out.println("Quotient is " + quotient);
        System.out.println("Product is " + product);

        //Boolean exercises
        var favoriteColor = "Red";
        var notFavoriteColor = "Mustard";
        System.out.println(favoriteColor.equals(notFavoriteColor));

        //Array exercises
        String[] groceryList = {"fruit", "meat", "juice", "milk"};
        System.out.println(groceryList); //memory storage
        for (String item : groceryList) {
            System.out.println(item + " ");
        }
        System.out.println(groceryList[0]);
    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String url) {
        if (url.equals("google")) {
            System.out.println("https://www.google.com");
        }
        else {
            System.out.println("This url is missing");
        }
    }
}
