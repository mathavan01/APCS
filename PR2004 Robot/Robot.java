public class Robot
{
    private int[] hall;
    private int pos;
    private boolean facingRight;
    public Robot(int[] hall, int pos){
        this.hall = hall;
        this.pos = pos;
        facingRight = true;
    }
    public boolean forwardMoveBlocked(){
        if (facingRight && pos == hall.length){
            return true;
        } else if (!facingRight && pos == 0){
            return true;
        } else {
            return false;
        }
    }
    public void move(){
        if (hall[pos] > 0){
            hall[pos] = hall[pos] - 1;
        } else if (!this.forwardMoveBlocked() && facingRight){
            pos++;
        } else if (!this.forwardMoveBlocked() && !facingRight){
            pos--;
        } else {
            facingRight = !facingRight;
        }
    }
    public int clearHall(){
        int numMoves = 0;
        while (!this.hallIsClear()){
            this.move();
            numMoves++;
        }
        return numMoves;
    }
    public boolean hallIsClear(){
        for (int i : hall){
            if (i > 0){
                return false;
            }
        }
        return true;
    }
}
