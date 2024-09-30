
public class CubeDriver{
    public static void main(String[] args){

        Cube cube = new Cube();

        Algorithms.performSequence("RUR'U'RUR'U'RUR'U'RUR'U'RUR'U'RUR'U'", cube);
        System.out.println("This is the cube after UR operation:\n---------------------");
        for(int i = 0; i < 6; i++){
            System.out.println(cube.getFace(i) + "\n");
        }
        
    } 
}