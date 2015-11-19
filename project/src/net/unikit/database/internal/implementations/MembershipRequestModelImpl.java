package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.MembershipRequestModel;

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
@Table(name = "MEMBERSHIP_REQUEST", uniqueConstraints = @UniqueConstraint(columnNames = {
		"applicant_student_number", "team_id" }) )
public class MembershipRequestModelImpl implements MembershipRequestModel {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "applicant_student_number", nullable = false, length = 31)
	private String applicantStudentNumber;

	@Column(name = "team_id", nullable = false)
	private int teamId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, length = 19)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false, length = 19)
	private Date updatedAt;
}
