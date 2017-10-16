package com.restTutorial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tags {
	
	@Id
	@Column(name = "recipeId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long recipeId;
	
	@Column(name = "tagName", length = 45)
	private String tagName;
	
	public Tags(){}
	
	public Tags(Long recipeID, String tagName){
		this.recipeId = recipeID;
		this.tagName = tagName;
	}
	
	public Long getRecipeId(){ return this.recipeId; }
	public void setRecipeId(Long id) { this.recipeId = id; }
	
	public String getRecipeName() { return this.tagName; }
	public void setRecipeName(String tagName) { this.tagName = tagName; }
}
