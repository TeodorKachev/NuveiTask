package com.github.api.models;

public class CreateRepositoryModel {

	private String name;
	private String description;
	private String homepage;
	private boolean isPrivate;
	private boolean isTemplate;
	private boolean hasIssues;
	private boolean hasProjects;
	private boolean hasWiki;
	private boolean hasDiscussions;
	private int teamID;
	private boolean autoInit;
	private String gitignoreTemplate;
	private String licenseTemplate;
	private boolean allowSquashMerge;
	private boolean allowMergeCommit;
	private boolean allowRebaseMerge;
	private boolean allowAutoMerge;
	private boolean deleteBranchOnMerge;
	private String squashMergeCommitTitle;
	private String squashMergeCommitMessage;
	private String mergeCommitTitle;
	private String mergeCommitMessage;
	private boolean hasDownloads;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public boolean isTemplate() {
		return isTemplate;
	}

	public void setTemplate(boolean isTemplate) {
		this.isTemplate = isTemplate;
	}

	public boolean isHasIssues() {
		return hasIssues;
	}

	public void setHasIssues(boolean hasIssues) {
		this.hasIssues = hasIssues;
	}

	public boolean isHasProjects() {
		return hasProjects;
	}

	public void setHasProjects(boolean hasProjects) {
		this.hasProjects = hasProjects;
	}

	public boolean isHasWiki() {
		return hasWiki;
	}

	public void setHasWiki(boolean hasWiki) {
		this.hasWiki = hasWiki;
	}

	public boolean isHasDiscussions() {
		return hasDiscussions;
	}

	public void setHasDiscussions(boolean hasDiscussions) {
		this.hasDiscussions = hasDiscussions;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public boolean isAutoInit() {
		return autoInit;
	}

	public void setAutoInit(boolean autoInit) {
		this.autoInit = autoInit;
	}

	public String getGitignoreTemplate() {
		return gitignoreTemplate;
	}

	public void setGitignoreTemplate(String gitignoreTemplate) {
		this.gitignoreTemplate = gitignoreTemplate;
	}

	public String getLicenseTemplate() {
		return licenseTemplate;
	}

	public void setLicenseTemplate(String licenseTemplate) {
		this.licenseTemplate = licenseTemplate;
	}

	public boolean isAllowSquashMerge() {
		return allowSquashMerge;
	}

	public void setAllowSquashMerge(boolean allowSquashMerge) {
		this.allowSquashMerge = allowSquashMerge;
	}

	public boolean isAllowMergeCommit() {
		return allowMergeCommit;
	}

	public void setAllowMergeCommit(boolean allowMergeCommit) {
		this.allowMergeCommit = allowMergeCommit;
	}

	public boolean isAllowRebaseMerge() {
		return allowRebaseMerge;
	}

	public void setAllowRebaseMerge(boolean allowRebaseMerge) {
		this.allowRebaseMerge = allowRebaseMerge;
	}

	public boolean isAllowAutoMerge() {
		return allowAutoMerge;
	}

	public void setAllowAutoMerge(boolean allowAutoMerge) {
		this.allowAutoMerge = allowAutoMerge;
	}

	public boolean isDeleteBranchOnMerge() {
		return deleteBranchOnMerge;
	}

	public void setDeleteBranchOnMerge(boolean deleteBranchOnMerge) {
		this.deleteBranchOnMerge = deleteBranchOnMerge;
	}

	public String getSquashMergeCommitTitle() {
		return squashMergeCommitTitle;
	}

	public void setSquashMergeCommitTitle(String squashMergeCommitTitle) {
		this.squashMergeCommitTitle = squashMergeCommitTitle;
	}

	public String getSquashMergeCommitMessage() {
		return squashMergeCommitMessage;
	}

	public void setSquashMergeCommitMessage(String squashMergeCommitMessage) {
		this.squashMergeCommitMessage = squashMergeCommitMessage;
	}

	public String getMergeCommitTitle() {
		return mergeCommitTitle;
	}

	public void setMergeCommitTitle(String mergeCommitTitle) {
		this.mergeCommitTitle = mergeCommitTitle;
	}

	public String getMergeCommitMessage() {
		return mergeCommitMessage;
	}

	public void setMergeCommitMessage(String mergeCommitMessage) {
		this.mergeCommitMessage = mergeCommitMessage;
	}

	public boolean isHasDownloads() {
		return hasDownloads;
	}

	public void setHasDownloads(boolean hasDownloads) {
		this.hasDownloads = hasDownloads;
	}
}
