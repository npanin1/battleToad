public class Page{
    public int sem;
    public final Line[] marks = new Line[50];
    int cnt = 0;
    public Page(){
        for(int i = 0; i < 50; i++){
            marks[i] = new Line();
        }
    }
    public void add(String dist, int mark){
        this.marks[cnt].mark = mark;
        this.marks[cnt].subj = dist;
        cnt++;
    }
}
