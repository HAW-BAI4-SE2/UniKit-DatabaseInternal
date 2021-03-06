package net.unikit.database.internal.implementations;

import net.unikit.database.implementations.AbstractModelImpl;
import net.unikit.database.internal.interfaces.entities.TeamModel;
import net.unikit.database.internal.interfaces.entities.TeamRegistrationModel;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TEAM_REGISTRATION", uniqueConstraints = @UniqueConstraint(columnNames = {
		"student_number", "team_id" }) )
final class TeamRegistrationModelImpl extends AbstractModelImpl<Integer> implements TeamRegistrationModel {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer idField;

	@Column(name = "student_number", nullable = false, length = 31)
	private String studentNumberField;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private TeamModelImpl teamField;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = true, length = 19)
	private Date createdAtField;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = true, length = 19)
	private Date updatedAtField;

	public TeamRegistrationModelImpl() {
	}

	public TeamRegistrationModelImpl(String studentNumberField, TeamModelImpl teamField, Date createdAtField, Date updatedAtField) {
		this.studentNumberField = studentNumberField;
		this.teamField = teamField;
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

	TeamModelImpl getTeamField() {
		return teamField;
	}

	void setTeamField(TeamModelImpl teamField) {
		this.teamField = teamField;
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
	public TeamModel getTeam() {
		return getTeamField();
	}

	@Transient
	public void setTeam(TeamModel team) {
		setTeamField((TeamModelImpl) team);
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
