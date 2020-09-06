package definitions;

import cucumber.api.java.en.And;
import org.apache.commons.lang3.tuple.Pair;

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

        int[] arr = {1, 2, 3};
        int[] arr2 = {};
        int[] arr3 = null;
        System.out.println(isArrayEmptyBoolean(arr));
        System.out.println(isArrayEmptyBoolean(arr2));
        System.out.println(isArrayEmptyBoolean(arr3));
    }

    // O(1)
    void isArrayEmpty(String[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty!");
        }
    }

    // O(1)
    boolean isArrayEmptyBoolean(int[] arr) {
        System.out.println("Is array empty?: ");
        // (arr != null && arr.length > 0) false/true
        if (arr == null || arr.length == 0) {
            return true;
        }
        return false;
    }

    @And("I write a function for FizzBuzz challenge")
    public void iWriteAFunctionForFizzBuzzChallenge() {
        System.out.println();
        fizzBuzz(20);
    }

    // O(n)
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
        Integer[] arrI = {1, 2, 3, 4, 5, 6, 7, 8, 100, 4000, 12};
        String[] arrS = {"kiwi", "apple", "orange"};
        System.out.println(checkElementInArray(arrI, 12));
        System.out.println(checkElementInArray(arrI, 10));
        System.out.println(checkElementInArray(arrS, "apple"));
        System.out.println(checkElementInArray(arrS, "banana"));

    }

    // O(n)
    boolean checkElementInArray(Object[] arr, Object n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(n)) return true;
        }
        return false;
    }

    @And("I write a function that reverses string")
    public void iWriteAFunctionThatReversesString() {
        String str = "Mountain View";
        reverseString(str);
        System.out.println(reverseStringReturn(str));
    }

    // O(n)
    void reverseString(String str) {
        System.out.println("Reverse " + str);
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }

    // O(n)
    String reverseStringReturn(String str) {
        System.out.println("Return reversed " + str);
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }
        return reversed;
    }

    @And("I do homework for part a")
    public void iDoHomeworkForPartA() {
//        User inputs two numbers which are divided by 5.
//        If a number is in a range of 1..10 - print it saying it is in the range of 1 from 10.
//        If a number is in the range of 10..20 - print it saying it's in the range of 10..20.
        printRangeOfNumbers(100, 10);
    }

    void printRangeOfNumbers(int x, int y) {
        int dividedX = x / 5;
        int dividedY = y / 5;
        int[] arr = {dividedX, dividedY};

        System.out.println("Result: ");

    }

    @And("I write a java program to add {int} numbers and it will print addition")
    public void iWriteAJavaProgramToAddNumbersAndItWillPrintAddition(int arg0) {
        printAddition(3, 0);
    }

    void printAddition(int x, int y) {
        int z = x + y;
        System.out.println(x + " + " + y + " = " + z);
    }

    @And("I reverse every third character of a string")
    public void iReverseEveryThirdCharacterOfAString() {
//        (Example: "WebDriver" => "vDW")
        String str = "Daniel";

        System.out.println(str.length());

//        for (int i = str.length() - 1; i >= 0; i--) {
//            System.out.print(str.charAt(i));
//            if (i % 2 == 0) {
//                System.out.println(str.charAt(i));
//            }

    }

//    String reverseEveryThirdChar (String str) {
//
//    }

    @And("I speak like Yoda - reverse words in a sentence")
    public void iSpeakLikeYodaReverseWordsInASentence() {
//        (Example: "I am Automation Engineer" => "Engineer Automation am I") (hint - method .split(" "))
        String[] arr = {"I", "am", "Automation", "Engineer"};
        for (String string : arr) {
            System.out.println(string + " ");

        }
    }

    @And("I write a function to find the largest element in an array and test it")
    public void iWriteAFunctionToFindTheLargestElementInAnArrayAndTestIt() {
        System.out.println();
        int[] arrI = {1, 2, 3, 4, 5, 6, 7, 8, 100, 4000, 12};
        int[] arrN = {-3, -4, -5, -6, -7, -8, -100, -4000, -12};
        System.out.println(maxNumber(arrI));
        System.out.println(maxNumber(arrN));
    }

    // O(n)
    int maxNumber(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    @And("I write a function that reverses string without extra string variable")
    public void iWriteAFunctionThatReversesStringWithoutExtraStringVariable() {
        System.out.println(getReversedNoVar("Hello"));
    }

    String getReversedNoVar(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            str += str.charAt(i);
        }
        return str.substring(str.length() / 2);
    }

    @And("I sort an array")
    public void iSortAnArray() {
        int[] arr = {5, 8, 7, 5, 1};
        System.out.println(Arrays.toString(sort(arr)));
    }

    // O(n2)
    int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    @And("I sort an array order by desc")
    public void iSortAnArrayOrderByDesc() {
        int[] arr = {5, 8, 7, 5, 1, 10, 0};
        System.out.println(Arrays.toString(sortByDesc(arr)));
    }

    // O(n2)
    int[] sortByDesc(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    @And("I write a function that find {int} max numbers in an array")
    public void iWriteAFunctionThatFindMaxNumbersInAnArray(int arg0) {
        System.out.println("2 max numbers: ");
        int[] arr = {5, 8, 7, 5, 1, 10, 0};
        System.out.println(getMaxNums(arr));
    }

    Object getMaxNums(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int maxNum = arr[0];
        int maxNum2 = arr[1];
        String maxNumsString = String.valueOf(maxNum) + " and " + String.valueOf(maxNum2);
        System.out.println(Arrays.toString(arr));
        return maxNumsString;
    }

    @And("I write a function that finds if array contains duplicates")
    public void iWriteAFunctionThatFindsIfArrayContainsDuplicates() {
        System.out.println("\n" + "Array contains duplicates: ");
        int[] arr = {5, 8, 7, 5, 1, 10, 0};
        System.out.println(containsDuplicates(arr));

    }

    boolean containsDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i] + " is duplicated");
                    return true;
                }
            }
        }
        return false;
    }

    @And("I write a function that finds if word is palindrome")
    public void iWriteAFunctionThatFindsIfWordIsPalindrome() {


    }

    @And("I write a function that counts number of each character in a string")
    public void iWriteAFunctionThatCountsNumberOfEachCharacterInAString() {
        System.out.println("\n" + "Count characters in a string: ");
        String str = "Daniel Test";
        System.out.println(countChar(str));
    }

    int countChar(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }

}
