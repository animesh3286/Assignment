package com.cov.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private long deptno;
	private String deptName;

	@OneToMany(mappedBy = "Department", fetch = FetchType.LAZY)

	private List<Employee> employee = new ArrayList<>();

	public Department() {
		super();
	}

	public Department(int deptno, String deptName) {
		super();
		this.deptno = deptno;
		this.deptName = deptName;
	}

	public long getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptName=" + deptName + "]";
	}

	public static Department save(Department department) {
		return null;
	}

	public static Optional<Department> findById(int id) {
		return null;
	}

	public static void deleteById(int id) {

	}

	public String getId() {
		return null;
	}

	public int getId(Object id) {
		return 0;
	}
}