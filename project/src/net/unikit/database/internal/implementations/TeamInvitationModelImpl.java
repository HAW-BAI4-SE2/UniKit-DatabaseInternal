package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.entities.TeamInvitationModel;

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
	private Integer id;

	@Column(name = "invitee_student_number", nullable = false, length = 31)
	private String inviteeStudentNumber;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private TeamModelImpl team;

	@Column(name = "created_by_student_number", nullable = false, length = 31)
	private String createdByStudentNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, length = 19)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false, length = 19)
	private Date updatedAt;
}
