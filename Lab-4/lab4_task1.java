public class lab4_task1 {
    public static void main(String[] args) {
        Piano[] obj = {
            new Piano(2, 1),
            new Piano(0, 1),
            new Piano(3, 2),
            new Piano(7, 0),
            new Piano(2, 1),
            new Piano(0, 0),
            new Piano(3, 2)
        };
        System.out.print("\n");
        System.out.println(obj[0].settings());
        System.out.println(obj[0].play());
        System.out.print(obj[0]);
        for (int i = 1; i < obj.length; i++) {
            if (obj[0].equals(obj[i])) {
                System.out.print(obj[i]);
            }
        }
        System.out.print("\n");  
    }
}

class Button {
    private int numBtn;

    Button(int numBtn) {
        this.numBtn = numBtn;
    }

    public String pressBtn() {
        return "Натиснуто на клавiшу пiд номером " + numBtn;
    }

    public int hashCode() {
        if (numBtn > 0) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return this.pressBtn() + "\n";
    }
}

class Pedal extends Button {
    private int numPdl;

    Pedal(int numBtn, int numPdl) {
        super(numBtn);
        this.numPdl = numPdl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (obj.hashCode() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (numPdl == 1) {
            return super.toString() + "Натиснуто на лiву педаль\n";
        } else if (numPdl == 2) {
            return super.toString() + "Натиснуто на праву педаль\n";
        } else {
            return super.toString();
        }
    }
}

class Piano extends Pedal {
    Piano(int numBtn, int numPdl) {
        super(numBtn, numPdl);
    }

    public String settings() {
        return "Пiанiно налаштовано";
    }

    public String play() {
        return "Розпочинаємо грати";
    }
}