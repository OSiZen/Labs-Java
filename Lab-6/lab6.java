public class lab6 {
    public static void main(String[] args) {
        Engineer[] obj = {
            new Engineer(1),
            new Engineer(2),
            new Engineer(3)
        };
        System.out.print("\n");
        for (Engineer e : obj) {
            System.out.println(e.work());
        }
        System.out.println(new Manager().work());
        System.out.print("\n");
    }
}

interface Employee {
    String work();
}

class Engineer implements Employee {
    private int id;

    protected Engineer() {}

    public Engineer(int id) {
        this.id = id;
    }

    public String work() {
        return "Iнженер №" + id + " працює над проєктом";
    }
}

class Manager extends Engineer {
    @Override
    public String work() {
        return "Керiвник керує командою iнженерiв";
    }
}