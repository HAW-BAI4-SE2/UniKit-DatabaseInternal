package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.entities.MembershipRequestModel;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "MEMBERSHIP_REQUEST", uniqueConstraints = @UniqueConstraint(columnNames = {
		"applicant_student_number", "team_id" }) )
final class MembershipRequestModelImpl implements MembershipRequestModel {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "applicant_student_number", nullable = false, length = 31)
	private String applicantStudentNumber;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private TeamModelImpl team;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, length = 19)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false, length = 19)
	private Date updatedAt;
}
