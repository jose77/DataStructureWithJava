package structures.app.linear.unixPrinter;

public class Job {
	String owner;
	int id;
	String file;
	public Job(String ownername,int jobId,String filename){
		owner=ownername;
		id=jobId;
		file=filename;
	}
	public String toString(){
		return owner+" "+id+" "+file;
	}
	public boolean equals(Object other){
		if((other instanceof Job)&& (other !=null)){
			Job another=(Job)other;
			return (id==another.id);
		}
		return false;
	}
}

class OwnerJob extends Job{
	OwnerJob(String ownername,int jobId,String filename){
		super(ownername,jobId,filename);
	}
	public boolean equals(Object other){
		if((other!=null)&&(other instanceof Job)){
			Job another=(Job)other;
			return (owner.equals(another.owner));
		}
		return false;
	}
}

class IdOwnerJob extends Job{
	IdOwnerJob(String ownername,int jobId,String filename){
		super(ownername,jobId,filename);
	}
	public boolean equals(Object other){
		if((other!=null)&&(other instanceof Job)){
			Job another=(Job) other;
			return (id==another.id)&&(owner.equals(another.owner));
		}
		return false;
	}
}
