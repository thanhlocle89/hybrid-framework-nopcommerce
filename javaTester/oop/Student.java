package oop;

public class Student {
	private int studentIdentifyNumber;
	private String studentName;
	private float pointTheory,pointExecution;
	
	protected Student(int studentIdentifyNumber, String studentName, float pointTheory, float pointExecution) {
		this.studentIdentifyNumber = studentIdentifyNumber;
		this.studentName = studentName;
		this.pointTheory = pointTheory;
		this.pointExecution = pointExecution;
	}
	
	protected void setStudentIdentifyNumber(int studentIdentifyNumber) {
		this.studentIdentifyNumber = studentIdentifyNumber;
	}
	
	protected int getStudentIdentifyNumber() {
		return studentIdentifyNumber;
	}
	
	protected void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	protected String getStudentName() {
		return studentName;
	}
	
	protected void setPointTheory(float pointTheory) {
		this.pointTheory = pointTheory;
	}
	
	protected float getPointTheory() {
		return pointTheory;
	}
	
	protected void setPointExecution(float pointExecution) {
		this.pointExecution = pointExecution;
	}
	
	protected float getPointExecution() {
		return pointExecution;
	}
	
	protected float averagePoint(float pointTheory, float pointExecution) {
		return (this.pointTheory+2*this.pointExecution)/3;
	}
	
	protected float getAveragePoint() {
		return averagePoint(pointTheory, pointExecution);
	}
	protected void showStudentInformation() {
		System.out.println("Ma Sinh Vien: " + getStudentIdentifyNumber());
		System.out.println("Ten Sinh Vien: " + getStudentName());
		System.out.println("Diem trung binh: " + getAveragePoint());
	}
	public static void main(String[] args) {
		Student sv1 = new Student(1234, "Nguyen Van A", 6.7f, 7.5f);
		sv1.showStudentInformation();
		Student sv2 = new Student(4321, "Nguyen Van B", 5.0f, 7.5f);
		sv2.showStudentInformation();
		Student sv3 = new Student(1243, "Nguyen Van C", 8.0f, 9.5f);
		sv3.showStudentInformation();
	}

}
