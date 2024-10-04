package src;
public class Movement  {

//THESE ALGORITHMS ARE WRITTEN PRESUMING WE ARE HOLDING THE CUBE SUCH THAT RED IS FACING YOU WITH GREEN ON RIGHT.

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
    public static void rotateVerticalSlice(Face topFace, Face frontFace, Face bottomFace, Face backFace, int edgeIndex, int topCornerIndex, int bottomCornerIndex, boolean isPrimeRotation, boolean isOnRightSideOfCube){
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
            if(isOnRightSideOfCube){
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
                bottomFace.edges.put(edgeIndex, backFace.edges.get(edgeIndex - 2));
                backFace.edges.put(edgeIndex - 2, tempEdgeTop);
            

                topFace.corners.put(topCornerIndex, frontFace.corners.get(topCornerIndex));
                topFace.corners.put(bottomCornerIndex, frontFace.corners.get(bottomCornerIndex));
            
                frontFace.corners.put(topCornerIndex, bottomFace.corners.get(topCornerIndex));
                frontFace.corners.put(bottomCornerIndex, bottomFace.corners.get(bottomCornerIndex));
            
                bottomFace.corners.put(topCornerIndex, backFace.corners.get(topCornerIndex - 2));
                bottomFace.corners.put(bottomCornerIndex, backFace.corners.get(bottomCornerIndex - 2));
            
                backFace.corners.put(topCornerIndex - 2, tempCornerTopTop);
                backFace.corners.put(bottomCornerIndex - 2, tempCornerTopBottom);
            }
        }

        else{
            if(isOnRightSideOfCube){
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
            else{
                topFace.edges.put(edgeIndex, backFace.edges.get(edgeIndex - 2));
                frontFace.edges.put(edgeIndex, tempEdgeTop);
                bottomFace.edges.put(edgeIndex, tempEdgeFront);
                backFace.edges.put(edgeIndex - 2, tempEdgeBottom);

                topFace.corners.put(topCornerIndex, backFace.corners.get(topCornerIndex - 2));
                topFace.corners.put(bottomCornerIndex, backFace.corners.get(bottomCornerIndex - 2));

                frontFace.corners.put(topCornerIndex, tempCornerTopTop);
                frontFace.corners.put(bottomCornerIndex, tempCornerTopBottom);

                bottomFace.corners.put(topCornerIndex, tempCornerFrontTop);
                bottomFace.corners.put(bottomCornerIndex, tempCornerFrontBottom);

                backFace.corners.put(bottomCornerIndex - 2, tempCornerBottomBottom);
                backFace.corners.put(topCornerIndex - 2,tempCornerBottomTop);

            }
        }
    }
    //This method rotates a slice either in the normal or prime horizontal direction
    public static void rotateHorizontalSlice(Face leftFace, Face rightFace, Face backFace, Face frontFace, int edgeIndex, int rightCornerIndex, int leftCornerIndex, boolean isPrimeRotation, boolean isOnTopSideOfCube){
        //Store all corners and edges into temporary varaibles
        String tempEdgeFront = frontFace.edges.get(edgeIndex);
        String tempEdgeLeft = leftFace.edges.get(edgeIndex);
        String tempEdgeBack = backFace.edges.get(edgeIndex);
        String tempEdgeRight = rightFace.edges.get(edgeIndex);
        String tempCornerFrontRight = frontFace.corners.get(rightCornerIndex);
        String tempCornerFrontLeft = frontFace.corners.get(leftCornerIndex);
        String tempCornerLeftRight = leftFace.corners.get(rightCornerIndex);
        String tempCornerLeftleft = leftFace.corners.get(leftCornerIndex);
        String tempCornerRightRight = rightFace.corners.get(rightCornerIndex);
        String tempCornerRightLeft = rightFace.corners.get(leftCornerIndex);
        String tempCornerBackRight = backFace.corners.get(rightCornerIndex);
        String tempCornerBackleft = backFace.corners.get(leftCornerIndex);
        //Rotation counter-clockwise
        if(isPrimeRotation){
            if(isOnTopSideOfCube){
                frontFace.edges.put(edgeIndex, leftFace.edges.get(edgeIndex));
                rightFace.edges.put(edgeIndex, tempEdgeFront);
                backFace.edges.put(edgeIndex, tempEdgeRight);
                leftFace.edges.put(edgeIndex, tempEdgeBack);
                frontFace.corners.put(rightCornerIndex, tempCornerLeftRight);
                frontFace.corners.put(leftCornerIndex,  tempCornerLeftleft);
                rightFace.corners.put(rightCornerIndex, tempCornerFrontRight);
                rightFace.corners.put(leftCornerIndex, tempCornerFrontLeft);
                backFace.corners.put(rightCornerIndex, tempCornerRightRight);
                backFace.corners.put(leftCornerIndex, tempCornerRightLeft);
                leftFace.corners.put(rightCornerIndex, tempCornerBackRight);
                leftFace.corners.put(leftCornerIndex, tempCornerBackleft);
            }
            else{
                leftFace.edges.put(edgeIndex, frontFace.edges.get(edgeIndex));
                backFace.edges.put(edgeIndex, tempEdgeLeft);
                rightFace.edges.put(edgeIndex, tempEdgeBack);
                frontFace.edges.put(edgeIndex, tempEdgeRight);
                frontFace.corners.put(rightCornerIndex, tempCornerRightRight);
                frontFace.corners.put(leftCornerIndex, tempCornerRightLeft);
                leftFace.corners.put(rightCornerIndex, tempCornerFrontRight);
                leftFace.corners.put(leftCornerIndex, tempCornerFrontLeft);
                backFace.corners.put(rightCornerIndex, tempCornerLeftRight);
                backFace.corners.put(leftCornerIndex, tempCornerLeftleft);
                rightFace.corners.put(rightCornerIndex, tempCornerBackRight);
                rightFace.corners.put(leftCornerIndex, tempCornerBackleft);
            }
        }
        //Rotation clockwise
        else{
            if(isOnTopSideOfCube){
                leftFace.edges.put(edgeIndex, frontFace.edges.get(edgeIndex));
                backFace.edges.put(edgeIndex, tempEdgeLeft);
                rightFace.edges.put(edgeIndex, tempEdgeBack);
                frontFace.edges.put(edgeIndex, tempEdgeRight);
                frontFace.corners.put(rightCornerIndex, tempCornerRightRight);
                frontFace.corners.put(leftCornerIndex, tempCornerRightLeft);
                leftFace.corners.put(rightCornerIndex, tempCornerFrontRight);
                leftFace.corners.put(leftCornerIndex, tempCornerFrontLeft);
                backFace.corners.put(rightCornerIndex, tempCornerLeftRight);
                backFace.corners.put(leftCornerIndex, tempCornerLeftleft);
                rightFace.corners.put(rightCornerIndex, tempCornerBackRight);
                rightFace.corners.put(leftCornerIndex, tempCornerBackleft);
            }
            else{
                frontFace.edges.put(edgeIndex, leftFace.edges.get(edgeIndex));
                rightFace.edges.put(edgeIndex, tempEdgeFront);
                backFace.edges.put(edgeIndex, tempEdgeRight);
                leftFace.edges.put(edgeIndex, tempEdgeBack);
                frontFace.corners.put(rightCornerIndex, tempCornerLeftRight);
                frontFace.corners.put(leftCornerIndex,  tempCornerLeftleft);
                rightFace.corners.put(rightCornerIndex, tempCornerFrontRight);
                rightFace.corners.put(leftCornerIndex, tempCornerFrontLeft);
                backFace.corners.put(rightCornerIndex, tempCornerRightRight);
                backFace.corners.put(leftCornerIndex, tempCornerRightLeft);
                leftFace.corners.put(rightCornerIndex, tempCornerBackRight);
                leftFace.corners.put(leftCornerIndex, tempCornerBackleft);
            }
        }
    }
    //This method rotates a slice in the coronal plane
    public static void rotateCoronalSlice(Face leftFace, Face rightFace, Face topFace, Face bottomFace, int edgeIndex, int rightCornerIndex, int leftCornerIndex, boolean isPrimeRotation, boolean isOnFrontSideOfCube){
        //Set different temporary values depending on whether we are rotate farther or closer coronal side.
        if(isOnFrontSideOfCube){
            String tempEdgeTop = topFace.edges.get(edgeIndex);
            String tempEdgeRight = rightFace.edges.get(edgeIndex + 1);
            String tempEdgeBottom = bottomFace.edges.get(edgeIndex - 2);
            String tempEdgeLeft = leftFace.edges.get(edgeIndex - 1);
            String tempCornerTopRight = topFace.corners.get(rightCornerIndex);
            String tempCornerTopLeft = topFace.corners.get(leftCornerIndex);
            String tempCornerBottomRight = bottomFace.corners.get(rightCornerIndex - 1);
            String tempCornerBottomLeft = bottomFace.corners.get(leftCornerIndex + 1);
            String tempCornerRightTop = rightFace.corners.get(rightCornerIndex + 2);
            String tempCornerRightBottom = rightFace.corners.get(leftCornerIndex);
            String tempCornerLeftTop = leftFace.corners.get(rightCornerIndex - 1);
            String tempCornerLeftBottom = leftFace.corners.get(leftCornerIndex - 1);
            //Front side prime rotation
            if(isPrimeRotation){
                topFace.edges.put(edgeIndex, rightFace.edges.get(edgeIndex + 1));
                leftFace.edges.put(edgeIndex - 1, tempEdgeTop);
                bottomFace.edges.put(edgeIndex - 2, tempEdgeLeft);
                rightFace.edges.put(edgeIndex + 1, tempEdgeBottom);
                topFace.corners.put(rightCornerIndex, rightFace.corners.get(rightCornerIndex + 1));
                topFace.corners.put(leftCornerIndex, tempCornerRightTop);
                leftFace.corners.put(rightCornerIndex - 1, tempCornerTopRight);
                leftFace.corners.put(leftCornerIndex - 1, tempCornerTopLeft);
                bottomFace.corners.put(rightCornerIndex - 1, tempCornerLeftBottom);
                bottomFace.corners.put(leftCornerIndex + 1, tempCornerLeftTop);
                rightFace.corners.put(rightCornerIndex + 2, tempCornerBottomRight);
                rightFace.corners.put(leftCornerIndex, tempCornerBottomLeft);
        
            }
            //Front side normal rotation
            else{
                topFace.edges.put(edgeIndex, leftFace.edges.get(edgeIndex - 1));
                rightFace.edges.put(edgeIndex + 1, tempEdgeTop);
                bottomFace.edges.put(edgeIndex - 2, tempEdgeRight);
                leftFace.edges.put(edgeIndex - 1, tempEdgeBottom);
                topFace.corners.put(rightCornerIndex, leftFace.corners.get(rightCornerIndex - 1));
                topFace.corners.put(leftCornerIndex, tempCornerLeftBottom);
                rightFace.corners.put(rightCornerIndex + 1, tempCornerTopRight);
                rightFace.corners.put(leftCornerIndex + 1, tempCornerTopLeft);
                bottomFace.corners.put(rightCornerIndex - 1, tempCornerRightTop);
                bottomFace.corners.put(leftCornerIndex + 1, tempCornerRightBottom);
                leftFace.corners.put(rightCornerIndex - 1, tempCornerBottomLeft);
                leftFace.corners.put(leftCornerIndex - 1, tempCornerBottomRight);
            }
        }
        else{
            String tempEdgeTop = topFace.edges.get(edgeIndex);
            String tempEdgeRight = rightFace.edges.get(edgeIndex + 1);
            String tempEdgeBottom = bottomFace.edges.get(edgeIndex + 2);
            String tempEdgeLeft = leftFace.edges.get(edgeIndex + 3);
            String tempCornerTopRight = topFace.corners.get(rightCornerIndex);
            String tempCornerTopLeft = topFace.corners.get(leftCornerIndex);
            String tempCornerBottomRight = bottomFace.corners.get(rightCornerIndex + 1);
            String tempCornerBottomLeft = bottomFace.corners.get(leftCornerIndex - 1);
            String tempCornerRightTop = rightFace.corners.get(rightCornerIndex);
            String tempCornerRightBottom = rightFace.corners.get(leftCornerIndex - 2);
            String tempCornerLeftTop = leftFace.corners.get(rightCornerIndex + 3);
            String tempCornerLeftBottom = leftFace.corners.get(leftCornerIndex - 1);
            //Back side prime rotation
            if(isPrimeRotation){
                topFace.edges.put(edgeIndex, leftFace.edges.get(edgeIndex + 3));
                rightFace.edges.put(edgeIndex + 1, tempEdgeTop);
                bottomFace.edges.put(edgeIndex + 2, tempEdgeRight);
                leftFace.edges.put(edgeIndex + 3, tempEdgeBottom);
                topFace.corners.put(rightCornerIndex, leftFace.corners.get(rightCornerIndex + 3));
                topFace.corners.put(leftCornerIndex, tempCornerLeftBottom);
                rightFace.corners.put(rightCornerIndex + 1, tempCornerTopRight);
                rightFace.corners.put(leftCornerIndex - 3, tempCornerTopLeft);
                bottomFace.corners.put(rightCornerIndex + 1, tempCornerRightTop);
                bottomFace.corners.put(leftCornerIndex - 1, tempCornerRightBottom);
                leftFace.corners.put(rightCornerIndex + 3, tempCornerBottomLeft);
                leftFace.corners.put(leftCornerIndex - 1, tempCornerBottomRight);
            }
            //Back side normal rotation
            else{
                topFace.edges.put(edgeIndex, rightFace.edges.get(edgeIndex + 1));
                leftFace.edges.put(edgeIndex + 3, tempEdgeTop);
                bottomFace.edges.put(edgeIndex + 2, tempEdgeLeft);
                rightFace.edges.put(edgeIndex + 1, tempEdgeBottom);
                topFace.corners.put(rightCornerIndex, rightFace.corners.get(rightCornerIndex + 1));
                topFace.corners.put(leftCornerIndex, tempCornerRightTop);
                leftFace.corners.put(rightCornerIndex + 3, tempCornerTopRight);
                leftFace.corners.put(leftCornerIndex - 1, tempCornerTopLeft);
                bottomFace.corners.put(rightCornerIndex + 1, tempCornerLeftBottom);
                bottomFace.corners.put(leftCornerIndex - 1, tempCornerLeftTop);
                rightFace.corners.put(rightCornerIndex, tempCornerBottomRight);
                rightFace.corners.put(leftCornerIndex - 2, tempCornerBottomLeft);
            }
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
        rotateVerticalSlice(topFace, frontFace, bottomFace, backFace, 2, 5, 6, isPrime, true);
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
        rotateVerticalSlice(topFace, frontFace, bottomFace, backFace, 2, 5, 6, isPrime, true);
    }
    //This method performs a U movement
    public static void normalU(Cube cube){
        rotateFaceClockwise(cube.getYellowFace());
        rotateHorizontalSlice(cube.getBlueFace(), cube.getGreenFace(), cube.getOrangeFace(), cube.getRedFace(), 1, 5, 8, false, true);
    }
    //This method performs a U' movement
    public static void primeU(Cube cube){
        rotateFaceCounterClockwise(cube.getYellowFace());
        rotateHorizontalSlice(cube.getBlueFace(), cube.getGreenFace(), cube.getOrangeFace(), cube.getRedFace(), 1, 5, 8, true, true);
    }
    //This method performs an L movement
    public static void normalL(Cube cube){
        rotateFaceClockwise(cube.getBlueFace());
        rotateVerticalSlice(cube.getYellowFace(), cube.getRedFace(), cube.getWhiteFace(), cube.getOrangeFace(), 4, 8, 7, false, false);
    }
    //This method performs an L' movement
    public static void primeL(Cube cube){
        rotateFaceCounterClockwise(cube.getBlueFace());
        rotateVerticalSlice(cube.getYellowFace(), cube.getRedFace(), cube.getWhiteFace(), cube.getOrangeFace(), 4, 8, 7, true, false);
    }
    //This method performs a D movement
    public static void normalD(Cube cube){
        rotateFaceClockwise(cube.getWhiteFace());
        rotateHorizontalSlice(cube.getBlueFace(), cube.getGreenFace(), cube.getOrangeFace(), cube.getRedFace(), 3, 6, 7, false, false);
    }
    //This method performs a D' movement
    public static void primeD(Cube cube){
        rotateFaceCounterClockwise(cube.getWhiteFace());
        rotateHorizontalSlice(cube.getBlueFace(), cube.getGreenFace(), cube.getOrangeFace(), cube.getRedFace(), 3, 6, 7, true, false);
    }
    //This method performs an F movement
    public static void normalF(Cube cube){
        rotateFaceClockwise(cube.getRedFace());
        rotateCoronalSlice(cube.getBlueFace(), cube.getGreenFace(), cube.getYellowFace(), cube.getWhiteFace(), 3, 6, 7, false, true);

    }
    //This method performs an F' movement
    public static void primeF(Cube cube){
        rotateFaceCounterClockwise(cube.getRedFace());
        rotateCoronalSlice(cube.getBlueFace(), cube.getGreenFace(), cube.getYellowFace(), cube.getWhiteFace(), 3, 6, 7, true, true);
    }
    //This method performs a B movement
    public static void normalB(Cube cube){
        rotateFaceClockwise(cube.getOrangeFace());
        rotateCoronalSlice(cube.getBlueFace(), cube.getGreenFace(), cube.getYellowFace(), cube.getWhiteFace(), 1, 5, 8, false, false);
    }
    public static void primeB(Cube cube){
        rotateFaceCounterClockwise(cube.getOrangeFace());
        rotateCoronalSlice(cube.getBlueFace(), cube.getGreenFace(), cube.getYellowFace(), cube.getWhiteFace(), 1, 5, 8, true, false);
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
                case 'L':
                    if(isPrime){
                        primeL(cube);
                    }
                    else{
                        normalL(cube);
                    }
                    break;
                case 'D':
                    if(isPrime){
                        primeD(cube);
                    }
                    else{
                        normalD(cube);
                    }
                    break;
                case 'F':
                    if(isPrime){
                        primeF(cube);
                    }
                    else{
                        normalF(cube);
                    }
                    break;
                case 'B':
                    if(isPrime){
                        primeB(cube);
                    }
                    else{
                        normalB(cube);
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
