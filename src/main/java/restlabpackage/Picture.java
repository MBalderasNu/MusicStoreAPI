package restlabpackage;

import org.springframework.data.annotation.Id;

public class Picture {
	
	@Id
	public String id;
	
	public String name;
	
	public String source;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public void copy(Picture p) {

		this.setName(p.getName());
		this.setSource(p.getSource());

	}

}
