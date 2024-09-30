public class Algorithms {

/*
 * THESE ALGORITHMS ARE WRITTEN PRESUMING WE ARE HOLDING THE CUBE SUCH THAT RED IS FACING YOU.
 */


    //This method rotates a face 90 degrees clockwise
    private static void rotateFaceClockwise(Face face){
        String tempEdge1 = face.edges.get(1);
        String tempEdge2 = face.edges.get(2);
        String tempEdge3 = face.edges.get(3);
        String tempEdge4 = face.edges.get(4);
        face.edges.put(1, tempEdge4); 
        face.edges.put(2, tempEdge1);
        face.edges.put(3, tempEdge2);
        face.edges.put(4, tempEdge3);
        String tempCorner5 = face.corners.get(5);
        String tempCorner6 = face.corners.get(6);
        String tempCorner7 = face.corners.get(7);
        String tempCorner8 = face.corners.get(8);
        face.corners.put(5, tempCorner8);
        face.corners.put(6, tempCorner5);
        face.corners.put(7, tempCorner6);
        face.corners.put(8, tempCorner7);
    }
    //This method rotates a face 90 degrees counter clockwise
    private static void rotateFaceCounterClockwise(Face face){
        String tempEdge1 = face.edges.get(1);
        String tempEdge2 = face.edges.get(2);
        String tempEdge3 = face.edges.get(3);
        String tempEdge4 = face.edges.get(4);
        face.edges.put(1, tempEdge2); 
        face.edges.put(2, tempEdge3);
        face.edges.put(3, tempEdge4);
        face.edges.put(4, tempEdge1);
        String tempCorner5 = face.corners.get(5);
        String tempCorner6 = face.corners.get(6);
        String tempCorner7 = face.corners.get(7);
        String tempCorner8 = face.corners.get(8);
        face.corners.put(5, tempCorner6);
        face.corners.put(6, tempCorner7);
        face.corners.put(7, tempCorner8);
        face.corners.put(8, tempCorner5);
    }
    //This method rotates a slice either in the normal or prime vertical direction
    public static void rotateVerticalSlice(Face topFace, Face frontFace, Face bottomFace, Face backFace, int edgeIndex, int topCornerIndex, int bottomCornerIndex, boolean isPrimeRotation){
        //Copy and storage of all the manipulated faces occurs here
        String tempEdgeTop = topFace.edges.get(edgeIndex);
        String tempEdgeFront = frontFace.edges.get(edgeIndex);
        String tempEdgeBottom = bottomFace.edges.get(edgeIndex);
        String tempCornerTopTop = topFace.corners.get(topCornerIndex);
        String tempCornerTopBottom = topFace.corners.get(bottomCornerIndex);
        String tempCornerFrontTop = frontFace.corners.get(topCornerIndex);
        String tempCornerFrontBottom = frontFace.corners.get(bottomCornerIndex);
        String tempCornerBottomTop = bottomFace.corners.get(topCornerIndex);
        String tempCornerBottomBottom = bottomFace.corners.get(bottomCornerIndex);

        //Actual rotation of the slice
        if(isPrimeRotation){  
            topFace.edges.put(edgeIndex, backFace.edges.get(edgeIndex + 2));
            frontFace.edges.put(edgeIndex, tempEdgeTop);
            bottomFace.edges.put(edgeIndex, tempEdgeFront);
            backFace.edges.put(edgeIndex + 2, tempEdgeBottom);

            topFace.corners.put(topCornerIndex, backFace.corners.get(topCornerIndex + 2));
            topFace.corners.put(bottomCornerIndex, backFace.corners.get(bottomCornerIndex + 2));

            frontFace.corners.put(topCornerIndex, tempCornerTopTop);
            frontFace.corners.put(bottomCornerIndex, tempCornerTopBottom);

            bottomFace.corners.put(topCornerIndex, tempCornerFrontTop);
            bottomFace.corners.put(bottomCornerIndex, tempCornerFrontBottom);

            backFace.corners.put(bottomCornerIndex + 2, tempCornerBottomBottom);
            backFace.corners.put(topCornerIndex + 2,tempCornerBottomTop);

        }
        else{
            topFace.edges.put(edgeIndex, frontFace.edges.get(edgeIndex));
            frontFace.edges.put(edgeIndex, bottomFace.edges.get(edgeIndex));
            bottomFace.edges.put(edgeIndex, backFace.edges.get(edgeIndex + 2));
            backFace.edges.put(edgeIndex + 2, tempEdgeTop);
        

            topFace.corners.put(topCornerIndex, frontFace.corners.get(topCornerIndex));
            topFace.corners.put(bottomCornerIndex, frontFace.corners.get(bottomCornerIndex));
        
            frontFace.corners.put(topCornerIndex, bottomFace.corners.get(topCornerIndex));
            frontFace.corners.put(bottomCornerIndex, bottomFace.corners.get(bottomCornerIndex));
        
            bottomFace.corners.put(topCornerIndex, backFace.corners.get(topCornerIndex + 2));
            bottomFace.corners.put(bottomCornerIndex, backFace.corners.get(bottomCornerIndex + 2));
        
            backFace.corners.put(topCornerIndex + 2, tempCornerTopTop);
            backFace.corners.put(bottomCornerIndex + 2, tempCornerTopBottom);
        }
    }
    //This method rotates a slice either in the normal or prime horizontal direction
    public static void rotateHorizontalSlice(Face leftFace, Face rightFace, Face backFace, Face frontFace, int edgeIndex, int topRightCornerIndex, int topLeftCornerIndex, boolean isPrimeRotation){
        //Store all corners and edges into temporary varaibles
        String tempEdgeFront = frontFace.edges.get(edgeIndex);
        String tempEdgeLeft = leftFace.edges.get(edgeIndex);
        String tempEdgeBack = backFace.edges.get(edgeIndex);
        String tempEdgeRight = rightFace.edges.get(edgeIndex);
        String tempCornerFrontTopRight = frontFace.corners.get(topRightCornerIndex);
        String tempCornerFrontTopLeft = frontFace.corners.get(topLeftCornerIndex);
        String tempCornerLeftTopRight = leftFace.corners.get(topRightCornerIndex);
        String tempCornerLeftTopleft = leftFace.corners.get(topLeftCornerIndex);
        String tempCornerRightTopRight = rightFace.corners.get(topRightCornerIndex);
        String tempCornerRightTopLeft = rightFace.corners.get(topLeftCornerIndex);
        String tempCornerBackTopRight = backFace.corners.get(topRightCornerIndex);
        String tempCornerBackTopleft = backFace.corners.get(topLeftCornerIndex);
        //Rotation counter-clockwise
        if(isPrimeRotation){
            frontFace.edges.put(edgeIndex, leftFace.edges.get(edgeIndex));
            rightFace.edges.put(edgeIndex, tempEdgeFront);
            backFace.edges.put(edgeIndex, tempEdgeRight);
            leftFace.edges.put(edgeIndex, tempEdgeBack);
            frontFace.corners.put(topRightCornerIndex, tempCornerLeftTopRight);
            frontFace.corners.put(topLeftCornerIndex,  tempCornerLeftTopleft);
            rightFace.corners.put(topRightCornerIndex, tempCornerFrontTopRight);
            rightFace.corners.put(topLeftCornerIndex, tempCornerFrontTopLeft);
            backFace.corners.put(topRightCornerIndex, tempCornerRightTopRight);
            backFace.corners.put(topLeftCornerIndex, tempCornerRightTopLeft);
            leftFace.corners.put(topRightCornerIndex, tempCornerBackTopRight);
            leftFace.corners.put(topLeftCornerIndex, tempCornerBackTopleft);
        }
        //Rotation clockwise
        else{
            leftFace.edges.put(edgeIndex, frontFace.edges.get(edgeIndex));
            backFace.edges.put(edgeIndex, tempEdgeLeft);
            rightFace.edges.put(edgeIndex, tempEdgeBack);
            frontFace.edges.put(edgeIndex, tempEdgeRight);
            frontFace.corners.put(topRightCornerIndex, tempCornerRightTopRight);
            frontFace.corners.put(topLeftCornerIndex, tempCornerRightTopLeft);
            leftFace.corners.put(topRightCornerIndex, tempCornerFrontTopRight);
            leftFace.corners.put(topLeftCornerIndex, tempCornerFrontTopLeft);
            backFace.corners.put(topRightCornerIndex, tempCornerLeftTopRight);
            backFace.corners.put(topLeftCornerIndex, tempCornerLeftTopleft);
            rightFace.corners.put(topRightCornerIndex, tempCornerBackTopRight);
            rightFace.corners.put(topLeftCornerIndex, tempCornerBackTopleft);
        }
    }
    //This method performs an R movement.
    public static void normalR(Cube cube){
        //Not necessary, but I am assigning variables here to better visualize what's happening.
        Face rightFace = cube.getGreenFace();
        Face topFace = cube.getYellowFace();
        Face frontFace = cube.getRedFace();
        Face backFace = cube.getOrangeFace();
        Face bottomFace = cube.getWhiteFace();
        //Note: This is an R move, so we set isPrime to false.
        boolean isPrime = false;
        //First, we rotate then face
        rotateFaceClockwise(rightFace);
        //Call rotateSlice method to rotate the whole slice
        rotateVerticalSlice(topFace, frontFace, bottomFace, backFace, 2, 5, 6, isPrime);
    }
    //This method performs an R' movement
    public static void primeR(Cube cube){
        
        //Not necessary, but I am assigning variables here to better visualize what's happening.
        Face rightFace = cube.getGreenFace();
        Face topFace = cube.getYellowFace();
        Face frontFace = cube.getRedFace();
        Face backFace = cube.getOrangeFace();
        Face bottomFace = cube.getWhiteFace();
        //Note: This is an R move, so we set isPrime to true.
        boolean isPrime = true;
        //First, we rotate the face in the corresponding direction
        rotateFaceCounterClockwise(rightFace);
        //Call rotateSlice method to rotate the slice.
        rotateVerticalSlice(topFace, frontFace, bottomFace, backFace, 2, 5, 6, isPrime);
    }
    //This method performs a U movement
    public static void normalU(Cube cube){
        rotateFaceClockwise(cube.getYellowFace());
        rotateHorizontalSlice(cube.getBlueFace(), cube.getGreenFace(), cube.getOrangeFace(), cube.getRedFace(), 1, 5, 8, false);
    }
    //This method performs a U' movement
    public static void primeU(Cube cube){
        rotateFaceCounterClockwise(cube.getYellowFace());
        rotateHorizontalSlice(cube.getBlueFace(), cube.getGreenFace(), cube.getOrangeFace(), cube.getRedFace(), 1, 5, 8, true);
    }

    
    //This method performs a series of moves
    public static void performSequence(String sequenceIn, Cube cube){
        char[] sequence = sequenceIn.toCharArray();
        int index = 0;
        //Navigate through the sequence
        while(index < sequenceIn.length()){
            //assume that the operation is not prime
            boolean isPrime = false;
            char operation = sequence[index];
            //check if next index is prime- if it is, set prime to true and skip over index
            if(index + 1 < sequenceIn.length() && sequence[index + 1] == '\''){
                isPrime = true;
                index++;
            }
            switch(operation){
                case 'R':
                    if(isPrime){
                        primeR(cube);
                    }
                    else{
                        normalR(cube);
                    }
                    break;
                case 'U':
                    if(isPrime){
                        primeU(cube);
                    }
                    else{
                        normalU(cube);
                    }
                    break;
                default:
                    System.out.println("Invalid operation: " + operation);
            }
            // Debug output to check the current state of the cube
            System.out.println("After operation " + operation + (isPrime ? "'" : "") + ":");
            // Add a method to print the state of the cube
            cube.printState();


            index++;
        }
    }

    
    
    
}
