public class Cube{
    private Face[] faces;
    public Cube(){
        faces = new Face[6];
        faces [0] = new Face('w');
        faces [1] = new Face('r');
        faces [2] = new Face('g');
        faces [3] = new Face('o');
        faces [4] = new Face('b');
        faces [5] = new Face ('y');
    }

    public void printState() {
        System.out.println("Yellow Face: " + this.getYellowFace());
        System.out.println("Red Face: " + this.getRedFace());
        System.out.println("Green Face: " + this.getGreenFace());
        System.out.println("Orange Face: " + this.getOrangeFace());
        System.out.println("White Face: " + this.getWhiteFace());
    }

    public Face getFace(int index){
        return faces[index];
    }

    public Face getRedFace(){
        return faces[1];
    }

    public Face getWhiteFace(){
        return faces[0];
    }

    public Face getGreenFace(){
        return faces[2];
    }

    public Face getOrangeFace(){
        return faces[3];
    }

    public Face getBlueFace(){
        return faces[4];
    }

    public Face getYellowFace(){
        return faces[5];
    }
}