package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.entities.TeamInvitationModel;
import net.unikit.database.internal.interfaces.entities.TeamModel;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TEAM_INVITATION", uniqueConstraints = @UniqueConstraint(columnNames = {
		"invitee_student_number", "team_id" }) )
final class TeamInvitationModelImpl implements TeamInvitationModel {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer idField;

	@Column(name = "invitee_student_number", nullable = false, length = 31)
	private String inviteeStudentNumberField;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private TeamModelImpl teamField;

	@Column(name = "created_by_student_number", nullable = false, length = 31)
	private String createdByStudentNumberField;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = true, length = 19)
	private Date createdAtField;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = true, length = 19)
	private Date updatedAtField;

	public TeamInvitationModelImpl() {
	}

	public TeamInvitationModelImpl(String inviteeStudentNumberField, TeamModelImpl teamField, String createdByStudentNumberField, Date createdAtField, Date updatedAtField) {
		this.inviteeStudentNumberField = inviteeStudentNumberField;
		this.teamField = teamField;
		this.createdByStudentNumberField = createdByStudentNumberField;
		this.createdAtField = createdAtField;
		this.updatedAtField = updatedAtField;
	}

	Integer getIdField() {
		return idField;
	}

	void setIdField(Integer idField) {
		this.idField = idField;
	}

	String getInviteeStudentNumberField() {
		return inviteeStudentNumberField;
	}

	void setInviteeStudentNumberField(String inviteeStudentNumberField) {
		this.inviteeStudentNumberField = inviteeStudentNumberField;
	}

	TeamModelImpl getTeamField() {
		return teamField;
	}

	void setTeamField(TeamModelImpl teamField) {
		this.teamField = teamField;
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

	@Transient
	public Integer getId() {
		return getIdField();
	}

	@Transient
	public String getInviteeStudentNumber() {
		return getInviteeStudentNumberField();
	}

	@Transient
	public void setInviteeStudentNumber(String inviteeStudentNumber) {
		setInviteeStudentNumberField(inviteeStudentNumber);
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
	public String getCreatedByStudentNumber() {
		return getCreatedByStudentNumberField();
	}

	@Transient
	public void setCreatedByStudentNumber(String createdByStudentNumber) {
		setCreatedByStudentNumberField(createdByStudentNumber);
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
