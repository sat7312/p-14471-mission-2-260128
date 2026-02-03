import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc = new Scanner(System.in);
    private List<WiseSaying> ws = new ArrayList<>();
    private int lastId = 0;
    private int lastWiseSayingIndex = -1;

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();

            } else if (cmd.equals("목록")) {
                actionList();

            } else if (cmd.startsWith("삭제?id=")) {
                actionDelete(cmd);

            } else if (cmd.startsWith("수정?id=")) {
                actionModify(cmd);
            }
        }
    }

    private void actionModify(String cmd) {
        int id = Integer.parseInt(cmd.substring(6));
        WiseSaying wise = findObject(id);

        if (wise == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println("명언(기존) : " + wise.getContent());
            System.out.print("명언 : ");
            wise.setContent(sc.nextLine());

            System.out.println("작가(기존) : " + wise.getAuthor());
            System.out.print("작가 : ");
            wise.setAuthor(sc.nextLine());
        }
    }

    private void actionDelete(String cmd) {
        int id = Integer.parseInt(cmd.substring(6));
        WiseSaying wise = findObject(id);

        if (wise == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println(id + "번 명언이 삭제되었습니다.");
            delete(wise);
        }
    }
    private void delete(WiseSaying wise) {
        ws.remove(wise);
        lastWiseSayingIndex--;
    }

    private WiseSaying findObject(int id) {
        for (WiseSaying w : ws) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------");

        List<WiseSaying> wiseSayingList = findList();

        for (WiseSaying wise : wiseSayingList) {
            System.out.println(wise.getId() + " / " + wise.getAuthor() + " / " + wise.getContent());
        }
    }

    private List<WiseSaying> findList() {
        List<WiseSaying> wiseSayingList = new ArrayList<>();

        for (int i = ws.size() - 1; i >= 0; i--) {
            if (ws.get(i).getContent() != null && ws.get(i).getAuthor() != null) {
                wiseSayingList.add(ws.get(i));
            }
        }

        return wiseSayingList;
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        write(content, author);

        System.out.println((lastId) + "번 명언이 등록되었습니다.");
    }

    private void write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(content, author, ++lastId);
        lastWiseSayingIndex++;

        ws.add(wiseSaying);
    }
}
