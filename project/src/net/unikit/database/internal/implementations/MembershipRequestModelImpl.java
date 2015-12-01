package net.unikit.database.internal.implementations;

import net.unikit.database.implementations.AbstractModelImpl;
import net.unikit.database.internal.interfaces.entities.MembershipRequestModel;
import net.unikit.database.internal.interfaces.entities.TeamModel;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "MEMBERSHIP_REQUEST", uniqueConstraints = @UniqueConstraint(columnNames = {
		"applicant_student_number", "team_id" }) )
final class MembershipRequestModelImpl extends AbstractModelImpl<Integer> implements MembershipRequestModel {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer idField;

	@Column(name = "applicant_student_number", nullable = false, length = 31)
	private String applicantStudentNumberField;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private TeamModelImpl teamField;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = true, length = 19)
	private Date createdAtField;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = true, length = 19)
	private Date updatedAtField;

	public MembershipRequestModelImpl() {
	}

	public MembershipRequestModelImpl(String applicantStudentNumberField, TeamModelImpl teamField, Date createdAtField, Date updatedAtField) {
		this.applicantStudentNumberField = applicantStudentNumberField;
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

	String getApplicantStudentNumberField() {
		return applicantStudentNumberField;
	}

	void setApplicantStudentNumberField(String applicantStudentNumberField) {
		this.applicantStudentNumberField = applicantStudentNumberField;
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
	public String getApplicantStudentNumber() {
		return getApplicantStudentNumberField();
	}

	@Transient
	public void setApplicantStudentNumber(String applicantStudentNumber) {
		setApplicantStudentNumberField(applicantStudentNumber);
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
