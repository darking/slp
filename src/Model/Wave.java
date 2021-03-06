package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Wave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_wave;
	
	private String wave;
	
	@ManyToOne
	//@Column(name = "id_course")
	private Course course;
	
	@OneToMany (mappedBy="wave", cascade=CascadeType.ALL)
	List<Wave_Date> waveDate;
	
	@OneToMany(mappedBy="wave", cascade=CascadeType.ALL)
	private List<Active_Session> sessions;

	public int getId_wave() {
		return id_wave;
	}

	public void setId_wave(int id_wave) {
		this.id_wave = id_wave;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Wave_Date> getWaveDate() {
		return waveDate;
	}

	public void setWaveDate(List<Wave_Date> waveDate) {
		this.waveDate = waveDate;
	}

	public List<Active_Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Active_Session> sessions) {
		this.sessions = sessions;
	}

}