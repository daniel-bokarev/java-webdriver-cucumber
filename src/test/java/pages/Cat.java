package pages;

public class Cat {

    private String name;

    public String getName() {
        return "<" + name + ">";
    }

    public void setName(String name) {
        if (name.equals("Charlie")) {
            throw new RuntimeException("Not acceptable name! " + name);
        }
        this.name = name;
    }

    public Cat(String name) {
        this.name = name;
    }

    public void walk() {
        System.out.println(classAndName() + " is walking!");
    }

    public void sleep() {
        System.out.println(classAndName() + " is sleeping!");
    }

    public void speak() {
        System.out.println(classAndName() + " is meowing!");
    }

    public void eat(String what) {
        System.out.println(classAndName() + " is eating " + what);
    }

    private String classAndName() {
        String[] arr = getClass().toString().split("\\.");
        return arr[arr.length - 1] + " " + getName();
    }
}
