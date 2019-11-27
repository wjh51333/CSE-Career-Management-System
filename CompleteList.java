package TakeCourse;


//이수 목록
//재이수 가능 판단, 점수 계산, 필수과목수강확인, 강의추가, 강의 삭제
public class CompleteList {

	private int totalgrade;
	private int majorgrade;
	private int refinegrade;
	private int basicrefine;
	private int majorbase;
	private int enginmajor;
	
	
	public int getTotalgrade() {
		return totalgrade;
	}
	public void setTotalgrade(int totalgrade) {
		this.totalgrade = totalgrade;
	}
	public int getMajorgrade() {
		return majorgrade;
	}
	public void setMajorgrade(int majorgrade) {
		this.majorgrade = majorgrade;
	}
	public int getRefinegrade() {
		return refinegrade;
	}
	public void setRefinegrade(int refinegrade) {
		this.refinegrade = refinegrade;
	}
	public int getBasicrefine() {
		return basicrefine;
	}
	public void setBasicrefine(int basicrefine) {
		this.basicrefine = basicrefine;
	}
	public int getMajorbase() {
		return majorbase;
	}
	public void setMajorbase(int majorbase) {
		this.majorbase = majorbase;
	}
	public int getEnginmajor() {
		return enginmajor;
	}
	public void setEnginmajor(int enginmajor) {
		this.enginmajor = enginmajor;
	}
	CourseGrade c=new CourseGrade();
	public int getYearsemester() {
		return c.yearsemester;
	}
	public void setYearsemester(int yearsemester) {
		this.c.yearsemester = yearsemester;
	}
	public String getChecktake() {
		return c.checktake;
	}
	public void setChecktake(String checktake) {
		this.c.checktake = checktake;
	}
	public String getScore() {
		return c.score;
	}
	public void setScore(String score) {
		this.c.score = score;
	}
	CourseInfo i=new CourseInfo();
	public String getCoursename() {
		return i.coursename;
	}
	public void setCoursename(String coursename) {
		this.i.coursename = coursename;
	}
	public String getCoursecode() {
		return i.coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.i.coursecode = coursecode;
	}
	public String getGrade() {
		return i.grade;
	}
	public void setGrade(String grade) {
		this.i.grade = grade;
	}
	
	public void calgrade(String filename) {
		
        String filename2=filename.split(".txt")[0];
        int i,count=0;
        
        Data d=new Data();
		String [] arr=new String[150];
		for (i=0; i<150;i++)
			arr[i]=null;

        arr=d.getfile2(filename);

        d.mdfile(filename2+"공학전공.txt");
        d.mdfile(filename2+"기본소양.txt");
        d.mdfile(filename2+"교양.txt");
        d.mdfile(filename2+"전공기반.txt");
        
        for (i=0; i<150;i++)
        	if (arr[i]==null) {
        		count=i;
        		break;
        	}
		
        for(i=0; i<count; i++) {
        		if (arr[i].equals("공학전공")) {
        			d.setfile(filename2+"공학전공.txt", arr[i+4]);
        		}
        		if (arr[i].equals("기본소양")) {
        			d.setfile(filename2+"기본소양.txt", arr[i+4]);
        		}
        		if (arr[i].equals("전공기반")) {
        			d.setfile(filename2+"전공기반.txt", arr[i+4]);
        		}
        		if (arr[i].equals("교양")) {
        			d.setfile(filename2+"교양.txt", arr[i+5]);
        		}
        		if (arr[i]==null)
        			break;
        }

		enginmajor=d.getfile3(filename2+"공학전공.txt");
		majorbase=d.getfile3(filename2+"전공기반.txt");
		basicrefine=d.getfile3(filename2+"기본소양.txt");
		refinegrade=d.getfile3(filename2+"교양.txt");
		
		majorgrade=basicrefine+majorbase+enginmajor;
		totalgrade=majorgrade+refinegrade;
	
	}
}
