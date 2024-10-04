package src;

public class CubeDriver{
    public static void main(String[] args){

        Cube cube = new Cube();
    
        System.out.println("This is the cube before scramble:\n---------------------");
        for(int i = 0; i < 6; i++){
            System.out.println(cube.getFace(i) + "\n");
        }
        Scramble.scrambleCube(cube);
        System.out.println("This is the cube after scramble:\n---------------------");
        for(int i = 0; i < 6; i++){
            System.out.println(cube.getFace(i) + "\n");
        }

       
    } 
}