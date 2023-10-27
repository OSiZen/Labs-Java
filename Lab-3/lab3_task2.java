public class lab3_task2 {
    public static void main(String[] args) {
        Interval[] obj = {
            new Interval(1, 7, true, true),
            new Interval(5, 9, false, false),
            new Interval(1, 4, true, true),
            new Interval(4, 8, true, true)
        };
        System.out.print("\n");
        for (int i = 0; i < obj.length - 1; i++) {
            System.out.println("Iнтервали: " + print(obj[i]) + " та " + print(obj[i + 1]));
            Interval un = obj[i].union(obj[i + 1]);
            if (un != null) {
                print("Об'єднання", un);
            } else {
                System.out.println("Об'єднання: неможливо");
            }
            Interval intxn = obj[i].intersection(obj[i + 1]);
            if (intxn != null) {
                print("Перетин", intxn);
            } else {
                System.out.println("Перетин: неможливо");
            }
            System.out.println("Вiдстань мiж найвiддаленiшими кiнцями: " + obj[i].distance(obj[i + 1]));
            System.out.print("\n");
        }
    }

    private static String print(Interval interval) {
        return (interval.includeLeft() ? "[" : "(") + (interval.getLeft() + ", " + interval.getRight()) + (interval.includeRight() ? "]" : ")");
    }

    private static void print(String title, Interval interval) {
        System.out.print(title + ": ");
        System.out.print(interval.includeLeft() ? "[" : "(");
        System.out.print(interval.getLeft() + ", " + interval.getRight());
        System.out.print(interval.includeRight() ? "]" : ")");
        System.out.print("\n");
    }
}

class Interval {
    private int left;
    private int right;
    private boolean includeLeft;
    private boolean includeRight;

    public Interval(int left, int right, boolean includeLeft, boolean includeRight) {
        this.left = left;
        this.right = right;
        this.includeLeft = includeLeft;
        this.includeRight = includeRight;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public boolean includeLeft() {
        return includeLeft;
    }

    public boolean includeRight() {
        return includeRight;
    }

    public Interval union(Interval other) {
        if (this.right < other.left || other.right < this.left) {
            return null;
        }
        boolean a = (this.left < other.left) ? this.includeLeft : other.includeLeft;
        boolean b = (this.right < other.right) ? other.includeRight : this.includeRight;
        return new Interval(Math.min(this.left, other.left), Math.max(this.right, other.right), a, b);
    }

    public Interval intersection(Interval other) {
        if (this.right < other.left || other.right < this.left) {
            return null;
        }
        boolean a = (this.left < other.left) ? other.includeLeft : this.includeLeft;
        boolean b = (this.right < other.right) ? this.includeRight : other.includeRight;
        return new Interval(Math.max(this.left, other.left), Math.min(this.right, other.right), a, b);
    }

    public int distance(Interval other) {
        return Math.max(Math.abs(this.left - other.left), Math.abs(this.right - other.right));
    }
}