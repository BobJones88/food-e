package com.restTutorial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@Column(name = "recipeID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long recipeID;
	
	
	@Column(name = "userID")
	private Long userID;
	
	@Column(name = "reviewName", length = 45)
	private String reviewName;
	
	@Column(name = "reviewText", length = 45)
	private String reviewText;
	
	public Review(){}
	
	public Review(Long recipeID, String reviewName){
		this.recipeID = recipeID;
		this.reviewName = reviewName;
	}
	
	public Long getRecipeID(){ return this.recipeID; }
	public void setRecipeID(Long id) { this.recipeID = id; }
	
	public String getReviewName() { return this.reviewName; }
	public void setReviewName(String tagName) { this.reviewName = tagName; }
	
	public Long getUserID(){ return this.userID; }
	public void setUserID(Long userID) { this.userID = userID; }
	
	public String getReviewText() { return this.reviewText; }
	public void setReviewText(String reviewText) { this.reviewText = reviewText; }
}
