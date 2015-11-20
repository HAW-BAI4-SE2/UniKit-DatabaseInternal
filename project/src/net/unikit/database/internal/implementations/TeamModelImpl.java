package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.entities.MembershipRequestModel;
import net.unikit.database.internal.interfaces.entities.TeamInvitationModel;
import net.unikit.database.internal.interfaces.entities.TeamModel;
import net.unikit.database.internal.interfaces.entities.TeamRegistrationModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TEAM")
final class TeamModelImpl implements TeamModel {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer idField;

	@Column(name = "course_id", nullable = false)
	private int courseIdField;

	@Column(name = "created_by_student_number", nullable = false, length = 31)
	private String createdByStudentNumberField;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = true, length = 19)
	private Date createdAtField;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = true, length = 19)
	private Date updatedAtField;

	@OneToMany(mappedBy = "teamField")
	private List<MembershipRequestModelImpl> membershipRequestModels = new ArrayList<>();

	@OneToMany(mappedBy = "teamField")
	private List<TeamInvitationModelImpl> teamInvitationModels = new ArrayList<>();

	@OneToMany(mappedBy = "teamField")
	private List<TeamRegistrationModelImpl> teamRegistrationModels = new ArrayList<>();

	public TeamModelImpl() {
	}

	public TeamModelImpl(int courseIdField, String createdByStudentNumberField, Date createdAtField, Date updatedAtField, List<MembershipRequestModelImpl> membershipRequestModels, List<TeamInvitationModelImpl> teamInvitationModels, List<TeamRegistrationModelImpl> teamRegistrationModels) {
		this.courseIdField = courseIdField;
		this.createdByStudentNumberField = createdByStudentNumberField;
		this.createdAtField = createdAtField;
		this.updatedAtField = updatedAtField;
		this.membershipRequestModels = membershipRequestModels;
		this.teamInvitationModels = teamInvitationModels;
		this.teamRegistrationModels = teamRegistrationModels;
	}

	Integer getIdField() {
		return idField;
	}

	void setIdField(Integer idField) {
		this.idField = idField;
	}

	int getCourseIdField() {
		return courseIdField;
	}

	void setCourseIdField(int courseIdField) {
		this.courseIdField = courseIdField;
	}

	String getCreatedByStudentNumberField() {
		return createdByStudentNumberField;
	}

	void setCreatedByStudentNumberField(String createdByStudentNumberField) {
		this.createdByStudentNumberField = createdByStudentNumberField;
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

	List<MembershipRequestModelImpl> getMembershipRequestModels() {
		return membershipRequestModels;
	}

	void setMembershipRequestModels(List<MembershipRequestModelImpl> membershipRequestModels) {
		this.membershipRequestModels = membershipRequestModels;
	}

	List<TeamInvitationModelImpl> getTeamInvitationModels() {
		return teamInvitationModels;
	}

	void setTeamInvitationModels(List<TeamInvitationModelImpl> teamInvitationModels) {
		this.teamInvitationModels = teamInvitationModels;
	}

	List<TeamRegistrationModelImpl> getTeamRegistrationModels() {
		return teamRegistrationModels;
	}

	void setTeamRegistrationModels(List<TeamRegistrationModelImpl> teamRegistrationModels) {
		this.teamRegistrationModels = teamRegistrationModels;
	}

	@Transient
	public Integer getId() {
		return null;
	}

	@Transient
	public int getCourseId() {
		return 0;
	}

	@Transient
	public void setCourseId(int courseId) {

	}

	@Transient
	public String getCreatedByStudentNumber() {
		return null;
	}

	@Transient
	public void setCreatedByStudentNumber(String createdByStudentNumber) {

	}

	@Transient
	public List<MembershipRequestModel> getMembershipRequests() {
		return null;
	}

	@Transient
	public List<TeamInvitationModel> getTeamInvitations() {
		return null;
	}

	@Transient
	public List<TeamRegistrationModel> getTeamRegistrations() {
		return null;
	}

	@Transient
	public Date getCreatedAt() {
		return null;
	}

	@Transient
	public Date getUpdatedAt() {
		return null;
	}
}
