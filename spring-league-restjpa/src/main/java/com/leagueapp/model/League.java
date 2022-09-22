package com.leagueapp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class League {
private String name;
@Id
@GeneratedValue(generator = "league_gen", strategy = GenerationType.AUTO)
@SequenceGenerator(name="league_gen",sequenceName = "league_seq")
private Integer leagueId;
private String country;
@Column(name="duration")
private int durationInMonths;
@OneToOne
@JoinColumn(name="board_id")
private Board board;
private String leagueImg;

@OneToOne
@JoinColumn(name="league_id")
private Set<Fixures> fixures;

@ManyToMany
@JoinColumn(name="sports_id")
private Sports sports;

@Override
public String toString() {
	return "League [name=" + name + ", leagueId=" + leagueId + ", country=" + country + ", durationInMonths="
			+ durationInMonths + ", board=" + board + ", leagueImg=" + leagueImg + "]";
}

}
