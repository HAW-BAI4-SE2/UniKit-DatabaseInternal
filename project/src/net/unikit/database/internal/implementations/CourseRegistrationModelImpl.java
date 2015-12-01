package net.unikit.database.internal.implementations;

import net.unikit.database.implementations.AbstractModelImpl;
import net.unikit.database.internal.interfaces.entities.CourseRegistrationModel;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "COURSE_REGISTRATION", uniqueConstraints = @UniqueConstraint(columnNames = {
		"student_number", "course_id" }) )
final class CourseRegistrationModelImpl extends AbstractModelImpl<Integer> implements CourseRegistrationModel {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer idField;

	@Column(name = "student_number", nullable = false, length = 31)
	private String studentNumberField;

	@Column(name = "course_id", nullable = false)
	private int courseIdField;

	@Column(name = "currently_assigned_to_team", nullable = false)
	private boolean currentlyAssignedToTeamField;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = true, length = 19)
	private Date createdAtField;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = true, length = 19)
	private Date updatedAtField;

	public CourseRegistrationModelImpl() {
	}

	public CourseRegistrationModelImpl(String studentNumberField, int courseIdField, boolean currentlyAssignedToTeamField, Date createdAtField, Date updatedAtField) {
		this.studentNumberField = studentNumberField;
		this.courseIdField = courseIdField;
		this.currentlyAssignedToTeamField = currentlyAssignedToTeamField;
		this.createdAtField = createdAtField;
		this.updatedAtField = updatedAtField;
	}

	Integer getIdField() {
		return idField;
	}

	void setIdField(Integer idField) {
		this.idField = idField;
	}

	String getStudentNumberField() {
		return studentNumberField;
	}

	void setStudentNumberField(String studentNumberField) {
		this.studentNumberField = studentNumberField;
	}

	int getCourseIdField() {
		return courseIdField;
	}

	void setCourseIdField(int courseIdField) {
		this.courseIdField = courseIdField;
	}

	boolean isCurrentlyAssignedToTeamField() {
		return currentlyAssignedToTeamField;
	}

	void setCurrentlyAssignedToTeamField(boolean currentlyAssignedToTeamField) {
		this.currentlyAssignedToTeamField = currentlyAssignedToTeamField;
	}

	Date getCreatedAtField() {
		return createdAtField;
	}

	void setCreatedAtField(Date createdAtField) {
		this.createdAtField = createdAtField;
	}

	Date getUpdatedAtField() {
		return updatedAtField;
	}

	void setUpdatedAtField(Date updatedAtField) {
		this.updatedAtField = updatedAtField;
	}

	@Transient
	public Integer getId() {
		return getIdField();
	}

	@Transient
	public String getStudentNumber() {
		return getStudentNumberField();
	}

	@Transient
	public void setStudentNumber(String studentNumber) {
		setStudentNumberField(studentNumber);
	}

	@Transient
	public int getCourseId() {
		return getCourseIdField();
	}

	@Transient
	public void setCourseId(int courseId) {
		setCourseIdField(courseId);
	}

	@Transient
	public boolean isCurrentlyAssignedToTeam() {
		return isCurrentlyAssignedToTeamField();
	}

	@Transient
	public void setCurrentlyAssignedToTeam(boolean currentlyAssignedToTeam) {
		setCurrentlyAssignedToTeamField(currentlyAssignedToTeam);
	}

	@Transient
	public Date getCreatedAt() {
		return getCreatedAtField();
	}

	@Transient
	public Date getUpdatedAt() {
		return getUpdatedAtField();
	}
}
