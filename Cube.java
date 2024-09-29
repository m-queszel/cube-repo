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