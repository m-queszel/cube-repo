import java.util.HashMap;

public class Face {

    private final char center;
    public HashMap<Integer, String> edges;
    public HashMap<Integer, String> corners;


    public Face(char centerIn){
        this.center = centerIn;
        this.edges = new HashMap<>();
        this.corners = new HashMap<>();
        edges.put(1, "" + centerIn + 1);
        edges.put(2, "" + centerIn + 2);
        edges.put(3, "" + centerIn + 3);
        edges.put(4, "" + centerIn + 4);
        corners.put(5, "" + centerIn + 5);
        corners.put(6, "" + centerIn + 6);
        corners.put(7, "" + centerIn + 7);
        corners.put(8, "" + centerIn + 8);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Face Center: ").append(center).append("\n");
        sb.append("Edges: ");
        for (int i = 1; i <= 4; i++) {
            sb.append(edges.get(i)).append(" ");
        }
        sb.append("\nCorners: ");
        for (int i = 5; i <= 8; i++) {
            sb.append(corners.get(i)).append(" ");
        }
        return sb.toString();
    }



}
