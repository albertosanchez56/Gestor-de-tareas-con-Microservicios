package com.usuario.service2.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "users")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Username is required")
	@Column(nullable = false, unique = true)
	private String username;

	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank(message = "Password is required")
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Instant createdAt;

	// Constructor vacío necesario para JPA
	public Usuario() {
	}

	// Constructor con todos los campos, excepto id y createdAt
	public Usuario(String username, String email, String passwordHash) {
		this.username = username;
		this.email = email;
		this.passwordHash = passwordHash;
	}

	// Getters y Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	// Otros métodos como equals(), hashCode(), toString() (opcional)
}
