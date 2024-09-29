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
        face.edges.replace(1, tempEdge4); 
        face.edges.replace(2, tempEdge1);
        face.edges.replace(3, tempEdge2);
        face.edges.replace(4, tempEdge3);
        String tempCorner5 = face.corners.get(5);
        String tempCorner6 = face.corners.get(6);
        String tempCorner7 = face.corners.get(7);
        String tempCorner8 = face.corners.get(8);
        face.corners.replace(5, tempCorner8);
        face.corners.replace(6, tempCorner5);
        face.corners.replace(7, tempCorner6);
        face.corners.replace(8, tempCorner7);
    }
    //This method rotates a slice either in the normal or prime direction
    public static void rotateSlice(Face topFace, Face frontFace, Face bottomFace, Face backFace, int edgeIndex, int topCornerIndex, int bottomCornerIndex, boolean isPrimeRotation){
        //Copy and storage of all the manipulated faces occurs here
        String tempEdgeTop = topFace.edges.get(edgeIndex);
        String tempEdgeFront = frontFace.edges.get(edgeIndex);
        String tempEdgeBottom = bottomFace.edges.get(edgeIndex);
        String tempEdgeBack = backFace.edges.get(edgeIndex);

        String tempCornerTopTop = topFace.corners.get(topCornerIndex);
        String tempCornerTopBottom = topFace.corners.get(bottomCornerIndex);

        String tempCornerFrontTop = frontFace.corners.get(topCornerIndex);
        String tempCornerFrontBottom = frontFace.corners.get(bottomCornerIndex);

        String tempCornerBottomTop = bottomFace.corners.get(topCornerIndex);
        String tempCornerBottomBottom = bottomFace.corners.get(bottomCornerIndex);

        String tempCornerBackTop = backFace.corners.get(topCornerIndex);
        String tempCornerBackBottom = backFace.corners.get(bottomCornerIndex);

        //Actual rotation of the slice
        if(isPrimeRotation){
            topFace.edges.replace(edgeIndex, backFace.edges.get(edgeIndex));
            frontFace.edges.replace(edgeIndex, tempEdgeTop);
            bottomFace.edges.replace(edgeIndex, tempEdgeFront);
            backFace.edges.replace(edgeIndex, tempEdgeBottom);

            topFace.corners.replace(topCornerIndex, backFace.corners.get(topCornerIndex));
            topFace.corners.replace(bottomCornerIndex, backFace.corners.get(bottomCornerIndex));

            frontFace.corners.replace(topCornerIndex, tempCornerTopTop);
            frontFace.corners.replace(bottomCornerIndex, tempCornerTopBottom);

            bottomFace.corners.replace(topCornerIndex, tempCornerFrontTop);
            bottomFace.corners.replace(bottomCornerIndex, tempCornerFrontBottom);

            backFace.corners.replace(topCornerIndex, tempCornerBottomTop);
            backFace.corners.replace(bottomCornerIndex, tempCornerBottomBottom);

        }
        else{

            topFace.edges.replace(edgeIndex, frontFace.edges.get(edgeIndex));
            backFace.edges.replace(edgeIndex, tempEdgeTop);
            bottomFace.edges.replace(edgeIndex, tempEdgeBack);
            frontFace.edges.replace(edgeIndex, tempEdgeBottom);

            topFace.corners.replace(topCornerIndex, frontFace.corners.get(topCornerIndex));
            topFace.corners.replace(bottomCornerIndex, frontFace.corners.get(bottomCornerIndex));

            frontFace.corners.replace(topCornerIndex, tempCornerBottomTop);
            frontFace.corners.replace(bottomCornerIndex, tempCornerBottomBottom);

            bottomFace.corners.replace(topCornerIndex, tempCornerBackTop);
            bottomFace.corners.replace(bottomCornerIndex, tempCornerBackBottom);

            backFace.corners.replace(topCornerIndex, tempCornerTopTop);
            backFace.corners.replace(bottomCornerIndex, tempCornerTopBottom);

        }
    }

    //This method performs an R movement.
    public static void R(Cube cube){
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
        rotateSlice(topFace, frontFace, bottomFace, backFace, 2, 5, 6, isPrime);
    }
    
    
}
