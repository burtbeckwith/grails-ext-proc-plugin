package grails.plugin.extproc

import java.util.Arrays;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * Input provided to to the external Process
 * @author hennite (henne.lohse@gmail.com)
 *
 * user          - 
 * token         - the external process may be configured to allow access only if a valid token is passed
 * parameters    - a list of parameters that are passed to the external process
 * env           - a map of key=value pairs that are merged into the environment of the process
 * zippedWorkDir - byte array representing the zip compressed work dir for the process 
 */

@XmlAccessorType(XmlAccessType.FIELD)
class ExternalProcessInput {
	String user
	String token
	List<String> parameters = []
	Map<String,String> env = [:]
	
	byte[] zippedWorkDir

	@Override
	public String toString() {
		return "ExternalProcessInput [user=" + user + ", token=" + token + ", parameters=" + parameters + ", zippedWorkDir=" + (zippedWorkDir!= null?zippedWorkDir.size():"null") + "]";
	}
}
