package poc.serpro.poc_serpro_interface.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Question implements Serializable {
	
	private static final long serialVersionUID = 8456537635254421137L;

	private String question;

	private String published_at;

	private String url;
	
	@JsonIgnore
	private List<Choice> choices;

	public String getQuestion() {
		return question;
	}

	public String getPublished_at() {
		return published_at;
	}
	
	public void setPublished_at(String published_at) {
		this.published_at = published_at;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public List<Choice> getChoices() {
		return choices;
	}
	
	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Question: " + this.question);
		sb.append("URL: " + this.url);
		return sb.toString();
	}
}