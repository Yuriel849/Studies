package dto;

public class MemberDTO {
	private String name;
	private String title;
	private int salary;
	
	public MemberDTO() {}
	
	public MemberDTO(String name, String title, int salary) {
		super();
		this.name = name;
		this.title = title;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", title=" + title + ", salary=" + salary + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}