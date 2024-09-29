
public class CubeDriver{
    public static void main(String[] args){
        System.out.println("This is the cube before an R operation:\n---------------------");
        Cube cube = new Cube();
        for(int i = 0; i < 6; i++){
            System.out.println(cube.getFace(i) + "\n");
        }
        System.out.println("This is the cube after an R rotation:\n----------------------");
        Algorithms.R(cube);

        for(int i = 0; i < 6; i++){
            System.out.println(cube.getFace(i) + "\n");
        }

    } 
}