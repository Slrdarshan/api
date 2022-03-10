package CommanApitestingProject;

public class Pojo_Library {

	public String createdBy;
	public String projectName;
	public String projectId;
	public String status;
	public int teamSize;
	
	
	public Pojo_Library(String createdBy, String projectName, String projectId, String status, int teamSize) {
	
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.projectId = projectId;
		this.status = status;
		this.teamSize = teamSize;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getTeamSize() {
		return teamSize;
	}


	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	
	
	
	
	
}
