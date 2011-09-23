package grails.plugin.extproc

import java.util.Arrays;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * 
 * @author hennito (henne.lohse@gmail.com)
 * 
 * serviceReturn - a true value indicates failure of the service, 
 * returnCode    - return code of the invoked process
 * consoleLog	 - merged stdout and stderr of the process
 * zippedDir	 - the working directory of the process zipped 
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
class ExternalProcessResult {
	int returnCode = 0
	List<String> consoleLog = []
	byte[] zippedDir = null

	String serviceReturn = null

	@Override
	public String toString() {
		return "ExternalProcessResult [serviceReturn=" + serviceReturn + ", returnCode=" + returnCode + ", consoleLog=" + consoleLog + ", zippedDir=" + (zippedDir!=null?zippedDir.size():"null") + "]";
	}	
}
