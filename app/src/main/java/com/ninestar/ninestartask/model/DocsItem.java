package com.ninestar.ninestartask.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "nda_items")
public class DocsItem implements Serializable {

	@SerializedName("score")
	private double score;

	@SerializedName("journal")
	private String journal;

	@SerializedName("article_type")
	private String articleType;

	@SerializedName("title_display")
	private String titleDisplay;

	@SerializedName("author_display")
	private List<String> authorDisplay;

	@SerializedName("publication_date")
	private String publicationDate;

	@SerializedName("eissn")
	private String eissn;

	@PrimaryKey
	@SerializedName("id")
	private String id;

	@SerializedName("abstract")
	private List<String> jsonMemberAbstract;

	public double getScore(){
		return score;
	}

	public String getJournal(){
		return journal;
	}

	public String getArticleType(){
		return articleType;
	}

	public String getTitleDisplay(){
		return titleDisplay;
	}

	public List<String> getAuthorDisplay(){
		return authorDisplay;
	}

	public String getPublicationDate(){
		return publicationDate;
	}

	public String getEissn(){
		return eissn;
	}

	public String getId(){
		return id;
	}

	public List<String> getJsonMemberAbstract(){
		return jsonMemberAbstract;
	}
}