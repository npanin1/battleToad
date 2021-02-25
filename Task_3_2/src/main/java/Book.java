public class Book {
    private int currSem;
    private static final int PAGES = 100;
    private final Page[] pages = new Page[PAGES];
    private final String name;
    private final int group;
    private int qWork;
    private boolean isRed = true;

    /***
     * Book itself
     * @param name students name
     * @param group his group
     * @param currSem semester
     */
    public Book(String name, int group, int currSem) {
        if(name == null)
            throw new NullPointerException("No name");
        if(!(group < 100000 && group > 9999))
            throw new NullPointerException("Invalid group number");
        if(currSem > PAGES)
            throw new NullPointerException("Invalid semester number");

        this.name = name;
        this.currSem = currSem;
        this.group = group;
        for (int i = 1; i < PAGES; i++) {
            this.pages[i] = new Page();
            this.pages[i].sem = i;
        }
    }

    /***
     * add a new line to the page of semester in the book
     * @param subj subject
     * @param sem itself
     * @param mark mark 0 or 1 - got credit or not, 2-5 if mark is differentiated
     */
    public void insertSubj(String subj, int sem, int mark) {
        if(subj == null)
            throw new NullPointerException("No name");
        if(sem > PAGES)
            throw new NullPointerException("Invalid semester number");
        if(!(mark > -1 && mark < 6))
            throw new NullPointerException("Invalid mark");

        if(mark == 3 || mark == 0)
            isRed = false;
        this.pages[sem].add(subj, mark);
    }

    public void insertQualifWorkMark(int mark){
        if(!(mark > -1 && mark < 6))
            throw new NullPointerException("Invalid mark");

        if(mark != 5)
            isRed = false;
        qWork = mark;
    }
    /***
     * returns an average mark based on differentialized marks
     * @return an average mark
     */
    public double average() {
        double sum = 0;
        int count = 0;
        for(int semes = 1; semes < PAGES; semes++){
            for(int i = 0; i < pages[semes].cnt; i++){
                if(pages[semes].marks[i].mark >= 2){
                    sum += pages[semes].marks[i].mark;
                    count++;
                }
            }
        }
        if(count == 0)
            return -1;
        return sum / count;
    }

    /***
     * if the student going to get a red diploma
     * @return yes or not
     */
    public boolean isRed(){
        double res = this.average();
        if(res < 4.75)
            return false;
        return isRed;
    }

    /***
     * will the student get increased scholarship or not
     * @return bool
     */
    public boolean isHighPensia(){
        int chance = 1;
        for(int i = 0; i < this.pages[currSem].cnt; i++){
            if(chance < 0)
                return false;
            if(this.pages[currSem].marks[i].mark != 5)
                chance--;
        }
        return this.isRed();
    }

    public int getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public int getqWork() {
        return qWork;
    }


    private class Page{
        public int sem;
        private static final int LINES = 50;
        public final Line[] marks = new Line[LINES];
        int cnt = 0;
        public Page(){
            for(int i = 0; i < LINES; i++){
                marks[i] = new Line();
            }
        }
        public void add(String dist, int mark){
            if(dist == null)
                throw new NullPointerException("No name");
            if(!(mark > -1 && mark < 6))
                throw new NullPointerException("Invalid mark");

            this.marks[cnt].mark = mark;
            this.marks[cnt].subj = dist;
            cnt++;
        }
    }

    public class Line{
        public String subj;
        public int mark;
    }

}
