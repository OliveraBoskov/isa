package entity;

import static javax.persistence.CascadeType.ALL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FRIEND_INVITATION")
public class FriendInvitation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FRIEND_INVITATION_ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "ACCEPTED", unique = false, nullable = false)
	private boolean accepted;
	
	@OneToOne(cascade = { ALL }, fetch = FetchType.EAGER)
	private User user;
	
	@OneToOne(cascade = { ALL }, fetch = FetchType.EAGER)
	private Reservation reservation;

	public FriendInvitation() {
	}
	
	public FriendInvitation(boolean accepted, User user, Reservation reservation) {
		super();
		this.accepted = accepted;
		this.user = user;
		this.reservation = reservation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}
