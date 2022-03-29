import java.lang.Math;

class GameOfLife {


    public int[][] initialState;

    public int n;

    public GameOfLife(int[][] initialState) {
        this.initialState = initialState;
    }

    public GameOfLife(int n) {
        this.n = n;
        this.initialState = new int[n][n];
    }

    public void printState (){
        int width;
        int height;
        if (n == 0) {
            width = initialState.length;
            height = initialState[0].length;
            StdDraw.setXscale(-1,width+1);
            StdDraw.setYscale(-1,height+1);
            StdDraw.setPenRadius(20.0/1000);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if( initialState[x][y] == 1){
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.filledCircle(x,y,0.5);
                    }


                }
            }
        } else {
            width = n;
            height = n;
            double random_double = Math.random();
            StdDraw.setXscale(-1,width+1);
            StdDraw.setYscale(-1,height+1);
            StdDraw.setPenRadius(20.0/1000);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    int rand = (int) (random_double*2+1);
                    initialState[i][j]=rand;
                }

            }
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if( initialState[x][y] == 1){
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.filledCircle(x,y,0.5);
                    }


                }
            }
        }


    }

    public void setAliveCell(int x, int y){
        initialState[x][y] = 1;

    }

    public void setDeadCell(int x, int y){
        initialState[x][y] = 0;

    }

    // Fix for index out of bounds array
    private int isAlive(int x, int y){
        if (x < 0 || x >= initialState.length){
            return 0;
        }
        if (y < 0 || y>= initialState[0].length){
            return 0;
        }
        return this.initialState[x][y];
    }

    private int countAliveNeighbours(int x, int y){
        int counter = 0;
        counter += isAlive(x-1,y+1);
        counter += isAlive(x,y+1);
        counter += isAlive(x+1,y+1);

        counter += isAlive(x-1,y);
        counter += isAlive(x+1,y);

        counter += isAlive(x-1,y-1);
        counter += isAlive(x,y-1);
        counter += isAlive(x+1,y-1);

        return counter;
    }

    public void nextState(){
        int width = initialState.length;
        int height = initialState[0].length;
        int[][] newState= new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int aliveNeighbours = countAliveNeighbours(x,y);

                //Applying rules for the alive cells
                if (initialState[x][y] == 1) {
                    if (aliveNeighbours < 2) {
                        newState[x][y] = 0;

                    } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        newState[x][y] = initialState[x][y];
                    } else {
                        newState[x][y] = 0;
                    }
                }
                    //Applying rules for the dead cells
                else{
                    if(aliveNeighbours == 3){
                        newState[x][y] = 1;

                    }
                }

                //updating to next state - i.e. initialState becomes newState


            }
        }
        this.initialState = newState;
    }

}