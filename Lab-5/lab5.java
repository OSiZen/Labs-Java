import java.util.ArrayList;
import java.util.List;

public class lab5 {
    public static void main(String[] args) {
        TVProgram[] obj = {
            new TVProgram("Новий канал", "Х/ф \"13 друзiв Оушена\"", "2023-10-27", "14:20"),
            new TVProgram("2+2", "Х/ф \"П'ятий елемент\"", "2023-10-27", "15:55"),
            new TVProgram("Новий канал", "Х/ф \"13 друзiв Оушена\"", "2023-10-27", "16:50"),
            new TVProgram("Новий канал", "Х/ф \"Не впiймали - не злодiй\"", "2023-10-27", "19:00"),
            new TVProgram("Пiксель", "М/с \"Морськi пригоди Сантьяго\"", "2023-10-27", "20:30"),
            new TVProgram("Пiксель", "М/с \"Космiчний старт\"", "2023-10-27", "21:30"),
            new TVProgram("НТН", "Речдок", "2023-10-27", "23:00"),
            new TVProgram("Пiксель", "М/с \"Свинячi iсторiї\"", "2023-10-27", "23:45"),
            new TVProgram("Новий канал", "Х/ф \"Привиди Марса\", 1 ч", "2023-10-27", "23:50")
        };
        TVProgram.ProgramInfo info = new TVProgram().new ProgramInfo();
        for (TVProgram p : obj) {
            info.add(p);
        }
        info.show();
    }
}

class TVProgram {
    private String channel;
    private String program;
    private String date;
    private String time;

    public TVProgram() { }

    public TVProgram(String channel, String program, String date, String time) {
        this.channel = channel;
        this.program = program;
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChannelName() {
        return channel;
    }

    public void setChannelName(String channel) {
        this.channel = channel;
    }

    public String getProgramName() {
        return program;
    }

    public void setProgramName(String program) {
        this.program = program;
    }

    class ProgramInfo {
        private List<TVProgram> programs;

        public ProgramInfo() {
            programs = new ArrayList<>();
        }

        public void add(TVProgram program) {
            programs.add(program);
        }

        public void show() {
            System.out.println("\nСписок каналiв та телепрограм:\n");
            System.out.println("Дата         | Час    | Канал         | Телепрограма");
            System.out.println("----------------------------------------------------------------------");
            for (TVProgram p : programs) {
                String fmDate = String.format("%-12s", p.getDate());
                String fmTime = String.format("%-6s", p.getTime());
                String fmChannel = String.format("%-13s", p.getChannelName());
                String fmProgram = String.format("%-15s", p.getProgramName());
                System.out.println(fmDate + " | " + fmTime + " | " + fmChannel + " | " + fmProgram);
            }
            System.out.print("\n");
        }
    }
}