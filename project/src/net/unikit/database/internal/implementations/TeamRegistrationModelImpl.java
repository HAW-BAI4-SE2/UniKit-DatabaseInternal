package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.entities.TeamRegistrationModel;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TEAM_REGISTRATION", uniqueConstraints = @UniqueConstraint(columnNames = {
		"student_number", "team_id" }) )
final class TeamRegistrationModelImpl implements TeamRegistrationModel {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "student_number", nullable = false, length = 31)
	private String studentNumber;

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
