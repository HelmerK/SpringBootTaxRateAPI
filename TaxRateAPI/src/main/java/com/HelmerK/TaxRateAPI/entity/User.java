package com.HelmerK.TaxRateAPI.entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * User is an entity class representing a user record in the user table. This
 * class provides mapping and persistence for the user data in the database and
 * includes associated properties, constructors, and methods for accessing and
 * manipulating the user data.
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")
@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
@NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_id")
	private Integer userId;
	@Basic(optional = false)
	@Column(name = "username")
	private String username;
	@Basic(optional = false)
	@Column(name = "password")
	private String password;
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Role roleId;

	/**
	 * Initializes a new instance of the User class.
	 */
	public User() {
	}

	/**
	 * Initializes a new instance of the User class with the specified user ID.
	 *
	 * @param userId The unique identifier for the user.
	 */
	public User(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Initializes a new instance of the User class with the specified user ID,
	 * username, and password.
	 *
	 * @param userId   The unique identifier for the user.
	 * @param username The username of the user.
	 * @param password The password of the user.
	 */
	public User(Integer userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	/**
	 * Gets the user's unique identifier.
	 *
	 * @return The unique identifier for the user.
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the user's unique identifier.
	 *
	 * @param userId The unique identifier for the user.
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user's username.
	 *
	 * @return The username of the user.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the user's username.
	 *
	 * @param username The username of the user.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the user's password.
	 *
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the user's password.
	 *
	 * @param password The password of the user.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the user's role.
	 *
	 * @return The role associated with the user.
	 */
	public Role getRoleId() {
		return roleId;
	}

	/**
	 * Sets the user's role.
	 *
	 * @param roleId The role to associate with the user.
	 */
	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	/**
	 * Calculates the hash code for the User object using the userId.
	 *
	 * @return An integer representing the hash code.
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userId != null ? userId.hashCode() : 0);
		return hash;
	}

	/**
	 * Compares this User object to the specified object for equality. The
	 * comparison is based on the userID.
	 *
	 * @param object The object to compare this User with.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.userId == null && other.userId != null)
				|| (this.userId != null && !this.userId.equals(other.userId))) {
			return false;
		}
		return true;
	}

	/**
	 * Returns a string representation of the User object.
	 *
	 * @return A string that includes the userID.
	 */
	@Override
	public String toString() {
		return "models.User[ userId=" + userId + " ]";
	}

}
