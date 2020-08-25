package definitions;

import cucumber.api.java.en.And;

import java.lang.reflect.Array;
import java.util.*;

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
        System.out.println(num1 / num2); //result is an integer
        System.out.println(num1 / num3); //result it a float
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
        } else {
            System.out.println("This url is missing");
        }
    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num >= 0) {
            System.out.println("Number is positive: " + num);
        } else {
            System.out.println("Number is negative: " + num);
        }
    }

    @And("I print {int} th day of week")
    public void iPrintThDayOfWeek(int day) {
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("We use Earth days");
        }
    }

    @And("I print {string} day of the week")
    public void iPrintDayOfTheWeek(String day) {
        String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int enteredDay = Integer.parseInt(day) - 1;
        System.out.println(daysOfWeek[enteredDay]);
    }

    @And("I print every {int} day of week")
    public void iPrintEveryDayOfWeek(int every) {
        String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int i = 1;
        for (String day : daysOfWeek) {
            if (i % every == 0) {
                System.out.println(day);
            }
            i++;
        }

        System.out.println("----");

        for (int j = 1; j <= daysOfWeek.length; j++) {
            if (j % every == 0) {
                System.out.println(daysOfWeek[j - 1]);
            }
        }
    }

    @And("I work with arrays")
    public void iWorkWithArrays() {
        String[] fruits = {"kiwi", "apple", "orange"};
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        for (int i = 0; i < fruits.length; i++) {
            System.out.print(fruits[i] + " ");
        }

        System.out.println("\n----");

        List<Integer> listOfNums = new ArrayList<>();
        listOfNums.add(1);
        listOfNums.add(2);
        listOfNums.add(3);
        for (int i : listOfNums) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < listOfNums.size(); i++) {
            System.out.print(listOfNums.get(i) + " ");
        }
    }

    @And("I work with maps")
    public void iWorkWithMaps() {
        Map<String, String> user = new HashMap<>();
        user.put("username", "jdoe");
        user.put("email", "noemail@noemail.example.com");
        user.put("password", "1234");
        System.out.println(user);

        Map<String, String> admin = new LinkedHashMap<>();
        admin.put("username", "jdoe");
        admin.put("email", "noemail@noemail.example.com");
        admin.put("password", "1234");
        System.out.println(admin);

        System.out.println(user.get("username"));

        for (String key : admin.keySet()) {
            System.out.println(key + ": " + admin.get(key));
        }
    }

    @And("I do homework for {int}th day")
    public void iDoHomeworkForThDay(int day) {
        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");
        System.out.println(info);

        String reverseFirst = info.get("middleName");
        String reverseMiddle = info.get("firstName");
        Map<String, String> reversedInfo = new LinkedHashMap<>();
        reversedInfo.put("firstName", reverseFirst);
        reversedInfo.put("middleName", reverseMiddle);
        System.out.println(reversedInfo);
        System.out.println("----");

        //classwork
        swap(10, 5);
        System.out.println(info);
        swapMap(info);
    }

    //swap
    void swap(int a, int b) {
        System.out.println("Swap Method! Before:");
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("After:");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    //swapMap
    void swapMap(Map<String, String> info) {
        String temp = info.get("firstName");
        info.put("firstName", info.get("middleName"));
        info.put("middleName", temp);
        System.out.println(info);
    }

    @And("I do homework for seventh day")
    public void iDoHomeworkForSeventhDay() {
        //swap 3rd and 5th array element
        int[] nums = {5, 2, 9, 7, 3};
        System.out.print("\n" + Arrays.toString(nums));
        swapArray(nums, 2, 4);

        //accepts integer number and returns
        divisibleInt(3);
        divisibleInt(4);
        divisibleInt(12);
        divisibleInt(15);
        divisibleInt(0); //would clarify the expectation

        System.out.println("----");

        isDivBy3and4(3);
    }

    //swap 2 array elements
    void swapArray(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        System.out.println("\n" + Arrays.toString(arr));
    }

    //accepts integer number and returns
    void divisibleInt(int a) {
        if (a % 3 == 0 && a % 4 == 0) {
            System.out.println("divisible by 3 and 4");
        } else if (a % 3 == 0) {
            System.out.println("divisible by 3");
        } else if (a % 4 == 0) {
            System.out.println("divisible by 4");
        } else {
            System.out.println("Provided integer is not divided by 3 or 4");
        }
    }

    //classwork for above
    String isDivBy3and4(int num) {

        return "";
    }

    @And("I write a function that prints all numbers from {int} up to n")
    public void iWriteAFunctionThatPrintsAllNumbersFromUpToN(int arg0) {
        printAllNumbers(5);
        System.out.println();
        printAllNumbers(10);
    }

    void printAllNumbers(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print(i + " ");
        }
    }

    @And("I write a function that supports also negative numbers")
    public void iWriteAFunctionThatSupportsAlsoNegativeNumbers() {
        System.out.println();
        printNegativeNumbersToo(-5);
        System.out.println();
        printNegativeNumbersToo(-10);
    }

    void printNegativeNumbersToo(int n) {
        for (int i = 0; i >= n; i--) {
            System.out.print(i + " ");
        }
    }

    @And("I write a function that prints all integer array")
    public void iWriteAFunctionThatPrintsAllIntegerArray() {
        System.out.println();
        int[] test = {1, 2, 3};
        printIntegerArray(test);

    }

    void printIntegerArray(int[] num) {
        for (int n : num) {
            System.out.print(n + " ");
        }
    }

    @And("I write a function that prints all even numbers from integer array")
    public void iWriteAFunctionThatPrintsAllEvenNumbersFromIntegerArray() {
        System.out.println();
        int[] evenNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printEvenNumbersInArray(evenNumbers);
    }

    void printEvenNumbersInArray(int[] num) {
        System.out.print("Even numbers: ");
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                System.out.print(num[i] + " ");
            }
        }

    }

    @And("I write a function that checks if array is empty")
    public void iWriteAFunctionThatChecksIfArrayIsEmpty() {
        System.out.println();
        String[] strings = {"Test", "One", "Two"};
        String[] strings2 = {};

        isArrayEmpty(strings);
        isArrayEmpty(strings2);
    }

    void isArrayEmpty(String[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty!");
        }
    }

    @And("I write a function for FizzBuzz challenge")
    public void iWriteAFunctionForFizzBuzzChallenge() {
        System.out.println();
        fizzBuzz(20);
    }

    void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
    }

    @And("I write a function that checks if array contains another element")
    public void iWriteAFunctionThatChecksIfArrayContainsAnotherElement() {
        System.out.println();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 100, 4000, 12};
        System.out.println(checkElementInArray(arr, 12));
        System.out.println(checkElementInArray(arr, 10));
    }

    boolean checkElementInArray(int[] arr, int n) {
        for (int i : arr) {
            if (i == n) return true;
        }
        return false;
    }
}
