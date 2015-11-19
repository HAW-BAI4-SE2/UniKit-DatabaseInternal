package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.TeamRegistrationModel;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TEAM_REGISTRATION", uniqueConstraints = @UniqueConstraint(columnNames = {
		"student_number", "team_id" }) )
public class TeamRegistrationModelImpl implements TeamRegistrationModel {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "student_number", nullable = false, length = 31)
	private String studentNumber;

	@Column(name = "team_id", nullable = false)
	private int teamId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, length = 19)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false, length = 19)
	private Date updatedAt;
}
