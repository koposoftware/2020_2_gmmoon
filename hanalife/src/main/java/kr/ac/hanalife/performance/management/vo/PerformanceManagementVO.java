package kr.ac.hanalife.performance.management.vo;


public class PerformanceManagementVO {
	
	private int empno;
	private String date;
	private double shortContract;
	private double longContract;
	private double numberOfTermination;
	private double avg;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getShortContract() {
		return shortContract;
	}
	public void setShortContract(double shortContract) {
		this.shortContract = shortContract;
	}
	public double getLongContract() {
		return longContract;
	}
	public void setLongContract(double longContract) {
		this.longContract = longContract;
	}
	public double getNumberOfTermination() {
		return numberOfTermination;
	}
	public void setNumberOfTermination(double numberOfTermination) {
		this.numberOfTermination = numberOfTermination;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	

}
