package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.entities.TeamModel;

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
	private Integer id;

	@Column(name = "course_id", nullable = false)
	private int courseId;

	@Column(name = "created_by_student_number", nullable = false, length = 31)
	private String createdByStudentNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, length = 19)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false, length = 19)
	private Date updatedAt;

	@OneToMany(mappedBy = "teamField")
	private List<MembershipRequestModelImpl> membershipRequestModels = new ArrayList<>();

	@OneToMany(mappedBy = "teamField")
	private List<TeamInvitationModelImpl> teamInvitationModels = new ArrayList<>();

	@OneToMany(mappedBy = "teamField")
	private List<TeamRegistrationModelImpl> teamRegistrationModels = new ArrayList<>();
}
